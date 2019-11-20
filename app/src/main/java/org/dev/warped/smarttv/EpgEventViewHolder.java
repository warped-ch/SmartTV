package org.dev.warped.smarttv;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import timber.log.Timber;

public class EpgEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnEpgEventClickedListener mListener;
    private final TextView mTextViewEpgEventNowTitle;
    private final AppCompatImageButton mImageButtonTrailer;
    private final TextView mTextViewIMDbLink;
    private final TextView mTextViewEpgEventStartTime;
    private final TextView mTextViewEpgEventEndTime;
    private final ProgressBar mProgressBarEpgEventDuration;
    private final TextView mTextViewEpgEventNowDescription;

    private EpgEvent mEpgEvent;

    public EpgEventViewHolder(View v, OnEpgEventClickedListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewEpgEventNowTitle = v.findViewById(R.id.textViewEpgEventNowTitle);
        mImageButtonTrailer = v.findViewById(R.id.imageButtonTrailer);
        VectorDrawableSupport.setTintList(mImageButtonTrailer, R.color.image_button_state_list);
        mTextViewIMDbLink = v.findViewById(R.id.textViewIMDbLink);
        mTextViewEpgEventStartTime = v.findViewById(R.id.textViewEpgEventStartTime);
        mTextViewEpgEventEndTime = v.findViewById(R.id.textViewEpgEventEndTime);
        mProgressBarEpgEventDuration = v.findViewById(R.id.progressBarEpgEventDuration);
        mTextViewEpgEventNowDescription = v.findViewById(R.id.textViewEpgEventNowDescription);
    }

    public void bindEpgEvent(EpgEvent epgEvent) {
        mEpgEvent = epgEvent;

        mTextViewEpgEventNowTitle.setText(epgEvent.getTitle());
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
        mTextViewEpgEventNowDescription.setText(epgEvent.getDescriptionExtended());
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
