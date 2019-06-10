package org.dev.warped.smarttv;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.dev.warped.smarttv.BouquetListFragment.OnBouquetListFragmentInteractionListener;

import timber.log.Timber;

public class BouquetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final BouquetListFragment.OnBouquetListFragmentInteractionListener mListener;
    private final TextView mTextViewTitle;

    private Bouquet mBouquet;

    public BouquetViewHolder(View v, OnBouquetListFragmentInteractionListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewTitle = v.findViewById(R.id.textViewBouquetTitle);
    }

    public void bindBouquet(Bouquet bouquet) {
        mBouquet = bouquet;

        mTextViewTitle.setText(bouquet.getName());
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: show details for bouquet \"%s\".", mBouquet.getName());
        mListener.onShowBouquet(mBouquet);
    }
}
