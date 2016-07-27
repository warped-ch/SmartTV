package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.EpgNowLoadedEvent;
import org.dev.warped.smarttv.events.LoadEpgNowErrorEvent;
import org.dev.warped.smarttv.events.LoadEpgNowEvent;
import org.dev.warped.smarttv.events.ZapDoneEvent;
import org.dev.warped.smarttv.events.ZapErrorEvent;
import org.dev.warped.smarttv.events.ZapEvent;

import timber.log.Timber;

/**
 * A fragment representing a list of Channel items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnChannelListFragmentInteractionListener}
 * interface.
 */
public class ChannelListFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener,
        OnChannelClickedListener {

    private static final String ARG_BOUQUET = "arg-bouquet";

    private SwipeRefreshLayout mSwipeRefresh;
    private Bouquet mBouquet;
    private ChannelListAdapter mAdapter;
    private OnChannelListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ChannelListFragment() {
    }

    public static ChannelListFragment newInstance(Bouquet bouquet) {
        ChannelListFragment fragment = new ChannelListFragment();
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

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel_list, container, false);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshChannelList);
        mSwipeRefresh.setColorSchemeResources(R.color.colorCyanAccent700);
        mSwipeRefresh.setOnRefreshListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewChannelList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter = new ChannelListAdapter(this);
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
        if (activity instanceof OnChannelListFragmentInteractionListener) {
            mListener = (OnChannelListFragmentInteractionListener) activity;
        } else {
            Timber.e("onAttach: %s must implement OnChannelListFragmentInteractionListener.", activity.toString());
            throw new RuntimeException(activity.toString()
                    + " must implement OnChannelListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mSwipeRefresh = null;
        mBouquet = null;
        mAdapter = null;
        mListener = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_refresh:
                Timber.d("onOptionsItemSelected: item \"%s\" selected.", getResources().getString(R.string.action_refresh));
                onRefresh();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        BusProvider.getBus().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        BusProvider.getBus().register(this);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        BusProvider.getBus().post(new LoadEpgNowEvent(mBouquet));
    }

    @Override
    public void onClickTrailer(Channel channel) {
        if (!channel.getEpgEvents().isEmpty()) {
            EpgEvent epgEvent = channel.getEpgEvents().get(0);
            Timber.d("onClickTrailer: \"%s\".", epgEvent.getTitle());

            PackageManager packageManager = getActivity().getPackageManager();
            try {
                packageManager.getPackageInfo(getResources().getString(R.string.package_name_youtube), PackageManager.GET_ACTIVITIES);
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.google.android.youtube");
                intent.putExtra("query", epgEvent.getTitle() + " trailer");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } catch (PackageManager.NameNotFoundException e) {
                Timber.w("onClickTrailer: YouTube not available.");
                showSnackBar(R.string.snackbar_youtube_app_not_available);
            }
        } else {
            Timber.w("onClickTrailer: no epg events available for channel \"%s\".", channel.getName());
        }
    }

    @Override
    public void onClickZap(Channel channel) {
        Timber.d("onClickZap: \"%s\".", channel.getName());
        BusProvider.getBus().post(new ZapEvent(channel));
    }

    @Override
    public void onClick(Channel channel) {
        mListener.onShowChannel(channel);
    }

    @Subscribe
    public void OnEpgNowLoaded(EpgNowLoadedEvent event) {
        mAdapter.setChannels(event.getChannels());
        mSwipeRefresh.setRefreshing(false);
    }

    @Subscribe
    public void onLoadEpgNowError(LoadEpgNowErrorEvent event) {
        mSwipeRefresh.setRefreshing(false);
        showSnackBar(R.string.snackbar_load_channels_failed);
    }

    @Subscribe
    public void OnZapDone(ZapDoneEvent event) {
        if (!event.getSuccess()) {
            Timber.d("OnZapDone: zap was not successful.");
            showSnackBar(R.string.snackbar_zap_failed);
        }
    }

    @Subscribe
    public void onZapError(ZapErrorEvent event) {
        showSnackBar(R.string.snackbar_zap_failed);
    }

    private void showSnackBar(@StringRes int resId) {
        View v = getView();
        if (null != v) {
            Snackbar snackbar = Snackbar.make(v, resId, Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            Timber.w("showSnackBar: view is null.");
        }
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
