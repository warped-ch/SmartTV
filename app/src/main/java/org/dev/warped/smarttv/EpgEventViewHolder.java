package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 26.07.2016.
 */
public class EpgEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final EpgEventListFragment.OnEpgEventListFragmentInteractionListener mListener;
    private final TextView mTextViewTitle;

    private EpgEvent mEpgEvent;

    public EpgEventViewHolder(View v, EpgEventListFragment.OnEpgEventListFragmentInteractionListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewTitle = (TextView) v.findViewById(R.id.textViewEpgEventTitle);
    }

    public void bindEpgEvent(EpgEvent epgEvent) {
        mEpgEvent = epgEvent;

        mTextViewTitle.setText(epgEvent.getTitle());
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: show details for epg event \"%s\".", mEpgEvent.getTitle());
        // TODO: implement
    }
}
