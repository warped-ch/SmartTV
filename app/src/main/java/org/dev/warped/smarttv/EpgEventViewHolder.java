package org.dev.warped.smarttv;

import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 26.07.2016.
 */
public class EpgEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnEpgEventClickedListener mListener;
    private final TextView mTextViewEpgEventTitle;
    private final AppCompatImageButton mImageButtonTrailer;
    private final TextView mTextViewIMDbLink;
    private final TextView mTextViewEpgEventStartTime;
    private final TextView mTextViewEpgEventEndTime;
    private final ProgressBar mProgressBarEpgEventDuration;
    private final TextView mTextViewEpgEventDescription;

    private EpgEvent mEpgEvent;

    public EpgEventViewHolder(View v, OnEpgEventClickedListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewEpgEventTitle = (TextView) v.findViewById(R.id.textViewEpgEventTitle);
        mImageButtonTrailer = (AppCompatImageButton) v.findViewById(R.id.imageButtonTrailer);
        VectorDrawableSupport.setTintList(mImageButtonTrailer, R.color.image_button_state_list);
        mTextViewIMDbLink = (TextView) v.findViewById(R.id.textViewIMDbLink);
        mTextViewEpgEventStartTime = (TextView) v.findViewById(R.id.textViewEpgEventStartTime);
        mTextViewEpgEventEndTime = (TextView) v.findViewById(R.id.textViewEpgEventEndTime);
        mProgressBarEpgEventDuration = (ProgressBar) v.findViewById(R.id.progressBarEpgEventDuration);
        mTextViewEpgEventDescription = (TextView) v.findViewById(R.id.textViewEpgEventDescription);
    }

    public void bindEpgEvent(EpgEvent epgEvent) {
        mEpgEvent = epgEvent;

        mTextViewEpgEventTitle.setText(epgEvent.getTitle());
        if (epgEvent.getDescriptionExtended().toLowerCase().contains("imdb")) {
            mImageButtonTrailer.setEnabled(true);
            mImageButtonTrailer.setOnClickListener(this);

            mTextViewIMDbLink.setEnabled(true);
            mTextViewIMDbLink.setText(RegExParser.getIMDbRating(epgEvent.getDescriptionExtended(), mTextViewIMDbLink.getResources().getString(R.string.imdb)));
            mTextViewIMDbLink.setOnClickListener(this);
        } else {
            mImageButtonTrailer.setEnabled(false);

            mTextViewIMDbLink.setEnabled(false);
            mTextViewIMDbLink.setText(mTextViewIMDbLink.getResources().getString(R.string.imdb));
        }
        mTextViewEpgEventStartTime.setText(epgEvent.getStartTime());
        mTextViewEpgEventEndTime.setText(epgEvent.getEndTime());
        mProgressBarEpgEventDuration.setProgress(epgEvent.calcProgress());
        mTextViewEpgEventDescription.setText(epgEvent.getDescriptionExtended());
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: adapter position %d", getAdapterPosition());

        if (v.getId() == mImageButtonTrailer.getId()) {
            Timber.d("onClick: trailer button clicked for epg event \"%s\"", mEpgEvent.getTitle());
            mListener.onClickTrailer(mEpgEvent);
        } else if (v.getId() == mTextViewIMDbLink.getId()) {
            Timber.d("onClick: IMDb link clicked for channel \"%s\"", mEpgEvent.getTitle());
            mListener.onClickIMDb(mEpgEvent);
        } else {
            Timber.d("onClick: clicked epg event \"%s\".", mEpgEvent.getTitle());
        }
    }
}
