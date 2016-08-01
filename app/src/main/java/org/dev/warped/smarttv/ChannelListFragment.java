package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.LoadEpgNowEvent;
import org.dev.warped.smarttv.events.LoadEpgNowEventDone;
import org.dev.warped.smarttv.events.LoadEpgNowEventError;
import org.dev.warped.smarttv.events.ZapEvent;
import org.dev.warped.smarttv.events.ZapEventDone;
import org.dev.warped.smarttv.events.ZapEventError;

import java.util.ArrayList;

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
    private static final String STATE_CHANNELS = "state-channels";
    private static final String STATE_POSITIONINDEX = "state-positionindex";
    private static final String STATE_POSITIONOFFSET = "state-positionoffset";

    private SwipeRefreshLayout mSwipeRefresh;
    private Bouquet mBouquet;
    private ChannelListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
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

        ArrayList<Channel> channels = new ArrayList<>();
        if (savedInstanceState != null) {
            channels = savedInstanceState.getParcelableArrayList(STATE_CHANNELS);
        }
        mAdapter = new ChannelListAdapter(channels, this);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel_list, container, false);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshChannelList);
        mSwipeRefresh.setColorSchemeResources(R.color.colorCyanAccent700);
        mSwipeRefresh.setOnRefreshListener(this);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewChannelList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        if (savedInstanceState != null) {
            int positionIndex = savedInstanceState.getInt(STATE_POSITIONINDEX, 0);
            int positionOffset = savedInstanceState.getInt(STATE_POSITIONOFFSET, 0);
            mLayoutManager.scrollToPositionWithOffset(positionIndex, positionOffset);
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        if(null != mBouquet) {
            ((MainActivity) getActivity()).setActionBarTitle(mBouquet.getName());
        } else {
            ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.bouquet));
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
                Timber.d("onOptionsItemSelected: item \"%s\" selected.", getResources().getString(R.string.refresh));
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList(STATE_CHANNELS, mAdapter.getChannels());

        if(mLayoutManager != null && mLayoutManager instanceof LinearLayoutManager && mRecyclerView != null){
            int positionIndex = mLayoutManager.findFirstVisibleItemPosition();
            View view = mRecyclerView.getChildAt(positionIndex);
            int positionOffset = (view != null) ? (view.getTop() - mRecyclerView.getPaddingTop()) : 0;
            outState.putInt(STATE_POSITIONINDEX, positionIndex);
            outState.putInt(STATE_POSITIONOFFSET, positionOffset);
        }
    }

    @Override
    public void onClick(Channel channel) {
        mListener.onShowChannel(channel);
    }

    @Override
    public void onClickIMDb(Channel channel) {
        if (!channel.getEpgEvents().isEmpty()) {
            EpgEvent epgEvent = channel.getEpgEvents().get(0);
            Timber.d("onClickIMDb: \"%s\".", epgEvent.getTitle());
            IntentFactory.createIMDbFindIntent(getActivity(), getView(), epgEvent);
        } else {
            Timber.w("onClickTrailer: no epg events available for channel \"%s\".", channel.getName());
        }
    }

    @Override
    public void onClickTrailer(Channel channel) {
        if (!channel.getEpgEvents().isEmpty()) {
            EpgEvent epgEvent = channel.getEpgEvents().get(0);
            Timber.d("onClickTrailer: \"%s\".", epgEvent.getTitle());
            IntentFactory.createYouTubeQueryIntent(getActivity(), getView(), epgEvent);
        } else {
            Timber.w("onClickTrailer: no epg events available for channel \"%s\".", channel.getName());
        }
    }

    @Override
    public void onClickZap(Channel channel) {
        Timber.d("onClickZap: \"%s\".", channel.getName());
        BusProvider.getBus().post(new ZapEvent(channel));
    }


    @Subscribe
    public void onLoadEpgNowEventDone(LoadEpgNowEventDone event) {
        mAdapter.setChannels(event.getChannels());
        mSwipeRefresh.setRefreshing(false);
    }

    @Subscribe
    public void onLoadEpgNowEventError(LoadEpgNowEventError event) {
        mAdapter.setChannels(new ArrayList<Channel>());
        mSwipeRefresh.setRefreshing(false);
        SnackBarFactory.showSnackBar(this, R.string.snackbar_load_channels_failed);
    }

    @Subscribe
    public void onZapEventDone(ZapEventDone event) {
        if (!event.getSuccess()) {
            Timber.d("OnZapDone: zap was not successful.");
            SnackBarFactory.showSnackBar(this, R.string.snackbar_zap_failed);
        }
    }

    @Subscribe
    public void onZapEventError(ZapEventError event) {
        SnackBarFactory.showSnackBar(this, R.string.snackbar_zap_failed);
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
