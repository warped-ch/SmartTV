package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.warped.smarttv.model.E2ServiceList;

import java.net.InetAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnChannelListFragmentInteractionListener}
 * interface.
 */
public class ChannelListFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String ARG_BOUQUET_REFERENCE = "column-count";

    private String mBouquetReference;
    private Enigma2Client mEnigma2Client;
    private ChannelListAdapter mAdapter;
    private OnChannelListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ChannelListFragment() {
    }

    public static ChannelListFragment newInstance(String bouquetReference) {
        ChannelListFragment fragment = new ChannelListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_BOUQUET_REFERENCE, bouquetReference);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mBouquetReference = getArguments().getString(ARG_BOUQUET_REFERENCE);
        }

        mAdapter = new ChannelListAdapter(mListener);
        updateChannels();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnChannelListFragmentInteractionListener) {
            mListener = (OnChannelListFragmentInteractionListener) activity;
        } else {
            Timber.e("onAttach: %s must implement OnChannelListFragmentInteractionListener.", activity.toString());
            throw new RuntimeException(activity.toString()
                    + " must implement OnChannelListFragmentInteractionListener");
        }

        SharedPreferencesManager.EReceiverType receiverType = SharedPreferencesManager.getReceiverType(PreferenceManager.getDefaultSharedPreferences(activity));
        if(SharedPreferencesManager.EReceiverType.eEnigma2 == receiverType) {
            InetAddress receiverAddress = SharedPreferencesManager.getReceiverAddress(PreferenceManager.getDefaultSharedPreferences(activity));
            mEnigma2Client = new Enigma2Client(receiverAddress);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mAdapter = null;
        mListener = null;
        mEnigma2Client = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(this.getActivity()).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        PreferenceManager.getDefaultSharedPreferences(this.getActivity()).registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE:
            case SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS:
                SharedPreferencesManager.EReceiverType receiverType = SharedPreferencesManager.getReceiverType(sharedPreferences);
                if(SharedPreferencesManager.EReceiverType.eEnigma2 == receiverType) {
                    InetAddress receiverAddress = SharedPreferencesManager.getReceiverAddress(sharedPreferences);
                    mEnigma2Client = new Enigma2Client(receiverAddress);
                }
                break;
        }
    }

    protected void updateChannels() {
        if (mEnigma2Client == null) {
            Timber.w("updateChannels: mEnigma2Client is null.");
            return;
        }
        if (mBouquetReference == null) {
            Timber.w("updateChannels: mBouquetReference is null.");
            return;
        }

        final Call<E2ServiceList> call = mEnigma2Client.getApiService().getServices(mBouquetReference);
        call.enqueue(new Callback<E2ServiceList>() {
            @Override
            public void onResponse(Call<E2ServiceList> call, Response<E2ServiceList> response) {
                Timber.d("updateChannels: onResponse: \"%s\".", response.body());
                mAdapter.setChannels(Channel.buildChannelList(response.body().getServiceList()));
            }
            @Override
            public void onFailure(Call<E2ServiceList> call, Throwable t) {
                Timber.w("updateChannels: onFailure: something went wrong.");
            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnChannelListFragmentInteractionListener {
        void onShowChannel(Channel channel);
    }
}
