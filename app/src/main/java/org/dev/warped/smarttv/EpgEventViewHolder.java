package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 26.07.2016.
 */
public class EpgEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final EpgEventListFragment.OnEpgEventListFragmentInteractionListener mListener;
    private final TextView mTextViewEpgEventTitle;
    private final TextView mTextViewEpgEventStartTime;
    private final TextView mTextViewEpgEventEndTime;
    private final ProgressBar mProgressBarEventDuration;
    private final TextView mTextViewEpgEventDescription;

    private EpgEvent mEpgEvent;

    public EpgEventViewHolder(View v, EpgEventListFragment.OnEpgEventListFragmentInteractionListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewEpgEventTitle = (TextView) v.findViewById(R.id.textViewEpgEventTitle);
        mTextViewEpgEventStartTime = (TextView) v.findViewById(R.id.textViewEpgEventStartTime);
        mTextViewEpgEventEndTime = (TextView) v.findViewById(R.id.textViewEpgEventEndTime);
        mProgressBarEventDuration = (ProgressBar) v.findViewById(R.id.progressBarEpgEventDuration);
        mTextViewEpgEventDescription = (TextView) v.findViewById(R.id.textViewEpgEventDescription);
    }

    public void bindEpgEvent(EpgEvent epgEvent) {
        mEpgEvent = epgEvent;

        mTextViewEpgEventTitle.setText(epgEvent.getTitle());
        mTextViewEpgEventStartTime.setText(epgEvent.getStartTime());
        mTextViewEpgEventEndTime.setText(epgEvent.getEndTime());
        mProgressBarEventDuration.setProgress(epgEvent.calcProgress());
        mTextViewEpgEventDescription.setText(epgEvent.getDescriptionExtended());
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: show details for epg event \"%s\".", mEpgEvent.getTitle());
        // TODO: implement
    }
}
