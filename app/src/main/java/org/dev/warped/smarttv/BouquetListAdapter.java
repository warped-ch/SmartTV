package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.warped.smarttv.BouquetListFragment.OnBouquetListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Bouquet} and makes a call to the
 * specified {@link OnBouquetListFragmentInteractionListener}.
 */
public class BouquetListAdapter extends RecyclerView.Adapter<BouquetViewHolder> {

    private final OnBouquetListFragmentInteractionListener mListener;
    private List<Bouquet> mBouquets;

    public BouquetListAdapter(OnBouquetListFragmentInteractionListener listener) {
        mListener = listener;
        mBouquets = new ArrayList<>();
    }

    @Override
    public BouquetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bouquet_list_item, parent, false);
        return new BouquetViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final BouquetViewHolder holder, int position) {
        Timber.d("onBindViewHolder: bouquet \"%s\" at position %d.",
                mBouquets.get(position).getName(), position);
        holder.bindBouquet(mBouquets.get(position));
    }

    @Override
    public int getItemCount() {
        return mBouquets.size();
    }

    public void setBouquets(List<Bouquet> bouquets) {
        mBouquets = bouquets;
        notifyDataSetChanged();
    }
}
