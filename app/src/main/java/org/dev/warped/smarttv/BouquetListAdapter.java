package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.warped.smarttv.BouquetListFragment.OnBouquetListFragmentInteractionListener;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Bouquet} and makes a call to the
 * specified {@link OnBouquetListFragmentInteractionListener}.
 */
public class BouquetListAdapter extends RecyclerView.Adapter<BouquetViewHolder> {

    private final OnBouquetListFragmentInteractionListener m_Listener;
    private ArrayList<Bouquet> m_Bouquets;

    public BouquetListAdapter(OnBouquetListFragmentInteractionListener listener) {
        m_Bouquets = new ArrayList<>();
        m_Listener = listener;
    }

    public BouquetListAdapter(ArrayList<Bouquet> bouquets, OnBouquetListFragmentInteractionListener listener) {
        m_Bouquets = bouquets;
        m_Listener = listener;
    }

    @Override
    public BouquetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bouquet_list_item, parent, false);
        return new BouquetViewHolder(view, m_Listener);
    }

    @Override
    public void onBindViewHolder(final BouquetViewHolder holder, int position) {
        Timber.d("onBindViewHolder: bouquet \"%s\" at position %d.",
                m_Bouquets.get(position).getName(), position);
        holder.bindBouquet(m_Bouquets.get(position));
    }

    @Override
    public int getItemCount() {
        return m_Bouquets.size();
    }

    public void setBouquets(ArrayList<Bouquet> bouquets) {
        m_Bouquets = bouquets;
        notifyDataSetChanged();
    }
}
