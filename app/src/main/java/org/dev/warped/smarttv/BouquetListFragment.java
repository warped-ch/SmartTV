package org.dev.warped.smarttv;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnBouquetListFragmentInteractionListener}
 * interface.
 */
public class BouquetListFragment extends Fragment {

    private static final String ARG_BOUQUET_LIST = "bouquet-list";

    private OnBouquetListFragmentInteractionListener m_Listener;
    private BouquetListAdapter m_Adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BouquetListFragment() {
    }

    public static BouquetListFragment newInstance(ArrayList<Bouquet> bouquets) {
        BouquetListFragment fragment = new BouquetListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_BOUQUET_LIST, bouquets);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            ArrayList<Bouquet> bouquetList = getArguments().getParcelableArrayList(ARG_BOUQUET_LIST);
            m_Adapter = new BouquetListAdapter(bouquetList, m_Listener);
        } else
        {
            m_Adapter =  new BouquetListAdapter(m_Listener);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bouquet_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(m_Adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBouquetListFragmentInteractionListener) {
            m_Listener = (OnBouquetListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBouquetListFragmentInteractionListener");
        }
        m_Listener.onRefreshBouquets();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        m_Adapter = null;
        m_Listener = null;
    }

    public void setBouquets(ArrayList<Bouquet> bouquets) {
        m_Adapter.setBouquets(bouquets);
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
        void onRefreshBouquets();
    }
}
