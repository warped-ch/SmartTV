package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
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

import org.dev.warped.smarttv.events.EpgEventsLoadedEvent;
import org.dev.warped.smarttv.events.LoadEpgEventsEvent;
import org.dev.warped.smarttv.events.LoadEpgEventsErrorEvent;

import timber.log.Timber;

/**
 * A fragment representing a list of EpgEvent items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnEpgEventListFragmentInteractionListener}
 * interface.
 */
public class EpgEventListFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener {

    private static final String ARG_CHANNEL = "arg-channel";

    private SwipeRefreshLayout mSwipeRefresh;
    private Channel mChannel;
    private EpgEventListAdapter mAdapter;
    private OnEpgEventListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EpgEventListFragment() {
    }

    @SuppressWarnings("unused")
    public static EpgEventListFragment newInstance(Channel channel) {
        EpgEventListFragment fragment = new EpgEventListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CHANNEL, channel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mChannel = getArguments().getParcelable(ARG_CHANNEL);
        }

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_epgevent_list, container, false);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshEpgEventList);
        mSwipeRefresh.setColorSchemeResources(R.color.colorCyanAccent700);
        mSwipeRefresh.setOnRefreshListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewEpgEventList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter = new EpgEventListAdapter(mListener);
        recyclerView.setAdapter(mAdapter);

        if(null != mChannel) {
            ((MainActivity) getActivity()).setActionBarTitle(mChannel.getName());
        } else {
            ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.action_bar_title_epgevents));
        }

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnEpgEventListFragmentInteractionListener) {
            mListener = (OnEpgEventListFragmentInteractionListener) activity;
        } else {
            Timber.e("onAttach: %s must implement OnEpgEventListFragmentInteractionListener.", activity.toString());
            throw new RuntimeException(activity.toString()
                    + " must implement OnEpgEventListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mSwipeRefresh = null;
        mChannel = null;
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
        BusProvider.getBus().post(new LoadEpgEventsEvent(mChannel));
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void OnEpgEventsLoaded(EpgEventsLoadedEvent event) {
        mAdapter.setEpgEvents(event.getEpgEvents());
        mSwipeRefresh.setRefreshing(false);
    }

    @Subscribe
    @SuppressWarnings("unused")
    public void onLoadEpgEventsError(LoadEpgEventsErrorEvent event) {
        mSwipeRefresh.setRefreshing(false);
        showSnackBar(R.string.snackbar_load_epg_events_failed);
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
    public interface OnEpgEventListFragmentInteractionListener {
    }
}