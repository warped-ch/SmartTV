package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.warped.smarttv.model.E2EventList;
import org.dev.warped.smarttv.model.E2SimpleXmlResult;

import java.net.InetAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnChannelEpgListFragmentInteractionListener}
 * interface.
 */
public class ChannelEpgListFragment extends Fragment implements
        SharedPreferences.OnSharedPreferenceChangeListener,
        SwipeRefreshLayout.OnRefreshListener,
        OnChannelEpgClickedListener {

    private static final String ARG_BOUQUET = "arg-bouquet";

    private SwipeRefreshLayout mSwipeRefresh;
    private Bouquet mBouquet;
    private Enigma2Client mEnigma2Client;
    private ChannelEpgListAdapter mAdapter;
    private OnChannelEpgListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ChannelEpgListFragment() {
    }

    public static ChannelEpgListFragment newInstance(Bouquet bouquet) {
        ChannelEpgListFragment fragment = new ChannelEpgListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_BOUQUET, bouquet);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mBouquet = getArguments().getParcelable(ARG_BOUQUET);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel_epg_list, container, false);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshChannelEpgList);
        mSwipeRefresh.setColorSchemeResources(R.color.colorCyanAccent700);
        mSwipeRefresh.setOnRefreshListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewChannelEpgList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter = new ChannelEpgListAdapter(this);
        recyclerView.setAdapter(mAdapter);

        if(null != mBouquet) {
            ((MainActivity) getActivity()).setActionBarTitle(mBouquet.getName());
        } else {
            ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.action_bar_title_bouquet));
        }

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnChannelEpgListFragmentInteractionListener) {
            mListener = (OnChannelEpgListFragmentInteractionListener) activity;
        } else {
            Timber.e("onAttach: %s must implement OnChannelEpgListFragmentInteractionListener.", activity.toString());
            throw new RuntimeException(activity.toString()
                    + " must implement OnChannelEpgListFragmentInteractionListener");
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

        mSwipeRefresh = null;
        mBouquet = null;
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
        onRefresh();
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

    @Override
    public void onRefresh() {
        updateChannels();
    }

    @Override
    public void onClickZap(ChannelEpg channel) {
        Timber.d("onClickZap: \"%s\".", channel.getName());

        if (mEnigma2Client == null) {
            Timber.w("updateChannels: mEnigma2Client is null.");
            return;
        }

        final Call<E2SimpleXmlResult> call = mEnigma2Client.getApiService().getZap(channel.getReference());
        call.enqueue(new Callback<E2SimpleXmlResult>() {
            @Override
            public void onResponse(Call<E2SimpleXmlResult> call, Response<E2SimpleXmlResult> response) {
                Timber.d("updateChannels: onResponse: \"%s\".", response.body());
                // TODO: handle zap response and check if ok
            }
            @Override
            public void onFailure(Call<E2SimpleXmlResult> call, Throwable t) {
                Timber.w("updateChannels: onFailure: something went wrong.");
            }
        });
    }

    @Override
    public void onClick(ChannelEpg channel) {
        mListener.onShowChannel(channel);
    }

    protected void updateChannels() {
        if (mEnigma2Client == null) {
            Timber.w("updateChannels: mEnigma2Client is null.");
            mSwipeRefresh.setRefreshing(false);
            return;
        }
        if (mBouquet == null) {
            Timber.w("updateChannels: mBouquet is null.");
            mSwipeRefresh.setRefreshing(false);
            return;
        }

        final Call<E2EventList> call = mEnigma2Client.getApiService().getEpgNow(mBouquet.getReference());
        call.enqueue(new Callback<E2EventList>() {
            @Override
            public void onResponse(Call<E2EventList> call, Response<E2EventList> response) {
                Timber.d("updateChannels: onResponse: \"%s\".", response.body());
                mAdapter.setChannels(ChannelEpg.buildChannelEpgList(response.body().getEventList()));
                mSwipeRefresh.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<E2EventList> call, Throwable t) {
                Timber.w("updateChannels: onFailure: something went wrong.");
                mSwipeRefresh.setRefreshing(false);
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
    public interface OnChannelEpgListFragmentInteractionListener {
        void onShowChannel(ChannelEpg channel);
    }
}
