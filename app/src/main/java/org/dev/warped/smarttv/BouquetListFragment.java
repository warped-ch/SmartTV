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

import org.dev.warped.smarttv.events.BouquetsLoadedEvent;
import org.dev.warped.smarttv.events.LoadBouquetsErrorEvent;
import org.dev.warped.smarttv.events.LoadBouquetsEvent;

import timber.log.Timber;

/**
 * A fragment representing a list of Bouquet items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnBouquetListFragmentInteractionListener}
 * interface.
 */
public class BouquetListFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefresh;
    private OnBouquetListFragmentInteractionListener mListener;
    private BouquetListAdapter mAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BouquetListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bouquet_list, container, false);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshBouquetList);
        mSwipeRefresh.setColorSchemeResources(R.color.colorCyanAccent700);
        mSwipeRefresh.setOnRefreshListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewBouquets);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter =  new BouquetListAdapter(mListener);
        recyclerView.setAdapter(mAdapter);

        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.action_bar_title_bouquets));

        return view;
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
        BusProvider.getBus().post(new LoadBouquetsEvent());
    }

    @Subscribe
    public void onBouquetsLoaded(BouquetsLoadedEvent event) {
        mAdapter.setBouquets(event.getBouquets());
        mSwipeRefresh.setRefreshing(false);
    }

    @Subscribe
    public void onLoadBouquetsError(LoadBouquetsErrorEvent event) {
        mSwipeRefresh.setRefreshing(false);
        SnackBarCreator.showSnackBar(getView(), R.string.snackbar_load_bouquets_failed);
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
