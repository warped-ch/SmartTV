package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.dev.warped.smarttv.BouquetListFragment.OnBouquetListFragmentInteractionListener;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 27.06.2016.
 */
public class BouquetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final BouquetListFragment.OnBouquetListFragmentInteractionListener m_Listener;

    private Bouquet m_Bouquet;

    private final TextView m_TextViewTitle;

    public BouquetViewHolder(View v, OnBouquetListFragmentInteractionListener listener) {
        super(v);

        m_Listener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        m_TextViewTitle = (TextView) v.findViewById(R.id.textViewBouquetTitle);
    }

    public void bindBouquet(Bouquet bouquet) {
        m_Bouquet = bouquet;

        m_TextViewTitle.setText(bouquet.getName());
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: show bouquet details for bouquet \"%s\".", m_Bouquet.getName());
        m_Listener.onShowBouquet(m_Bouquet);
    }
}
