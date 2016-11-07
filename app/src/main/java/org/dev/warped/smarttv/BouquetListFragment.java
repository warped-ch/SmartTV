package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import org.dev.warped.smarttv.events.LoadBouquetsEvent;
import org.dev.warped.smarttv.events.LoadBouquetsEventDone;
import org.dev.warped.smarttv.events.LoadBouquetsEventError;
import org.dev.warped.smarttv.events.ReceiverClientChangedEvent;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * A fragment representing a list of Bouquet items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnBouquetListFragmentInteractionListener}
 * interface.
 */
public class BouquetListFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener {

    private static final String STATE_BOUQUETS = "state-bouquets";
    private static final String STATE_POSITIONINDEX = "state-positionindex";
    private static final String STATE_POSITIONOFFSET = "state-positionoffset";

    private SwipeRefreshLayout mSwipeRefresh;
    private OnBouquetListFragmentInteractionListener mListener;
    private BouquetListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BouquetListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Bouquet> bouquets = new ArrayList<>();
        if (savedInstanceState != null) {
            bouquets = savedInstanceState.getParcelableArrayList(STATE_BOUQUETS);
        }
        mAdapter = new BouquetListAdapter(bouquets, mListener);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bouquet_list, container, false);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshBouquetList);
        mSwipeRefresh.setColorSchemeResources(R.color.accent);
        mSwipeRefresh.setProgressBackgroundColorSchemeResource(R.color.grey900);
        mSwipeRefresh.setOnRefreshListener(this);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewBouquets);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        if (savedInstanceState != null) {
            int positionIndex = savedInstanceState.getInt(STATE_POSITIONINDEX, 0);
            int positionOffset = savedInstanceState.getInt(STATE_POSITIONOFFSET, 0);
            mLayoutManager.scrollToPositionWithOffset(positionIndex, positionOffset);
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.bouquets));

        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        try {
            menu.findItem(R.id.action_refresh).setVisible(true);
        } catch (NullPointerException e) {
            Timber.e("onPrepareOptionsMenu: menu item action_refresh is null.");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnBouquetListFragmentInteractionListener) {
            mListener = (OnBouquetListFragmentInteractionListener) activity;
        } else {
            Timber.e("onAttach: %s must implement OnBouquetListFragmentInteractionListener.", activity.toString());
            throw new RuntimeException(activity.toString()
                    + " must implement OnBouquetListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mSwipeRefresh = null;
        mAdapter = null;
        mListener = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
        BusProvider.getBus().post(new LoadBouquetsEvent());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList(STATE_BOUQUETS, mAdapter.getBouquets());

        if (mLayoutManager != null && mRecyclerView != null) {
            int positionIndex = mLayoutManager.findFirstVisibleItemPosition();
            View view = mRecyclerView.getChildAt(positionIndex);
            int positionOffset = (view != null) ? (view.getTop() - mRecyclerView.getPaddingTop()) : 0;
            outState.putInt(STATE_POSITIONINDEX, positionIndex);
            outState.putInt(STATE_POSITIONOFFSET, positionOffset);
        }
    }

    @Subscribe
    public void onLoadBouquetsEventDone(LoadBouquetsEventDone event) {
        mAdapter.setBouquets(event.getBouquets());
        mSwipeRefresh.setRefreshing(false);
    }

    @Subscribe
    public void onLoadBouquetsEventError(LoadBouquetsEventError event) {
        mSwipeRefresh.setRefreshing(false);
        SnackBarFactory.showSnackBar(this, R.string.snackbar_load_bouquets_failed);
    }

    @Subscribe
    public void onReceiverClientChangedEvent(ReceiverClientChangedEvent event) {
        onRefresh();
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
    public interface OnBouquetListFragmentInteractionListener {
        void onShowBouquet(Bouquet bouquet);
    }
}
