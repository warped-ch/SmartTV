package org.dev.warped.smarttv;

import android.graphics.PorterDuff;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class ChannelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnChannelClickedListener mListener;
    private final ImageView mImageViewPicon;
    private final TextView mTextViewChannelName;
    private final AppCompatImageButton mImageButtonZap;
    private final TextView mTextViewEpgEventTitle;
    private final AppCompatImageButton mImageButtonTrailer;
    private final TextView mTextViewIMDbLink;
    private final TextView mTextViewEpgEventStartTime;
    private final TextView mTextViewEpgEventEndTime;
    private final ProgressBar mProgressBarEpgEventDuration;
    private final TextView mTextViewEpgEventDescription;

    private Channel mChannel;

    public ChannelViewHolder(View v, OnChannelClickedListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mImageViewPicon = (ImageView) v.findViewById(R.id.imageViewPicon);
        mTextViewChannelName = (TextView) v.findViewById(R.id.textViewChannelTitle);
        mImageButtonZap = (AppCompatImageButton) v.findViewById(R.id.imageButtonZap);
        mImageButtonZap.setOnClickListener(this);
        mTextViewEpgEventTitle = (TextView) v.findViewById(R.id.textViewEpgEventTitle);
        mImageButtonTrailer = (AppCompatImageButton) v.findViewById(R.id.imageButtonTrailer);
        mTextViewIMDbLink = (TextView) v.findViewById(R.id.textViewIMDbLink);
        mTextViewEpgEventStartTime = (TextView) v.findViewById(R.id.textViewEpgEventStartTime);
        mTextViewEpgEventEndTime = (TextView) v.findViewById(R.id.textViewEpgEventEndTime);
        mProgressBarEpgEventDuration = (ProgressBar) v.findViewById(R.id.progressBarEpgEventDuration);
        mTextViewEpgEventDescription = (TextView) v.findViewById(R.id.textViewEpgEventDescription);
    }

    public void bindChannel(Channel channel) {
        mChannel = channel;

        mImageViewPicon.setImageResource(PiconManager.getPiconResourceId(channel.getName()));
        // TODO: should not be necessary since app:srcCompat="@drawable/ic_play_circle_filled" is defined in xml?
        mImageButtonZap.setImageResource(R.drawable.ic_play_circle_filled);
        mTextViewChannelName.setText(channel.getName());
        if(!channel.getEpgEvents().isEmpty()) {
            EpgEvent epgEvent = channel.getEpgEvents().get(0);
            mTextViewEpgEventTitle.setText(epgEvent.getTitle());
            // TODO: no image displayed on API 19, should not be necessary since defined in xml: app:srcCompat="@drawable/ic_movie"?
            mImageButtonTrailer.setImageResource(R.drawable.ic_movie);
            if (epgEvent.getDescriptionExtended().toLowerCase().contains("imdb")) {
                mImageButtonTrailer.setColorFilter(mImageButtonTrailer.getResources().getColor(R.color.colorCyanAccent700), PorterDuff.Mode.SRC_ATOP);
                mImageButtonTrailer.setOnClickListener(this);

                mTextViewIMDbLink.setText(RegExParser.getIMDbRating(epgEvent.getDescriptionExtended(), mTextViewIMDbLink.getResources().getString(R.string.imdb)));
                mTextViewIMDbLink.setTextColor(mTextViewIMDbLink.getResources().getColor(R.color.colorCyanAccent700));
                mTextViewIMDbLink.setOnClickListener(this);
            } else {
                mImageButtonTrailer.setColorFilter(mImageButtonTrailer.getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);

                mTextViewIMDbLink.setText(mTextViewIMDbLink.getResources().getString(R.string.imdb));
                mTextViewIMDbLink.setTextColor(mTextViewIMDbLink.getResources().getColor(R.color.colorBlack));
            }
            mTextViewEpgEventStartTime.setText(epgEvent.getStartTime());
            mTextViewEpgEventEndTime.setText(epgEvent.getEndTime());
            mProgressBarEpgEventDuration.setProgress(epgEvent.calcProgress());
            mTextViewEpgEventDescription.setText(epgEvent.getDescriptionExtended());
        } else {
            Timber.d("bindChannel: epg event list for channel \"%s\" is empty.", channel.getName());
        }
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: adapter position %d", getAdapterPosition());

        if (v.getId() == mImageButtonZap.getId()) {
            Timber.d("onClick: zap button clicked for channel \"%s\"", mChannel.getName());
            mListener.onClickZap(mChannel);
        } else if (v.getId() == mImageButtonTrailer.getId()) {
            Timber.d("onClick: trailer button clicked for channel \"%s\"", mChannel.getName());
            mListener.onClickTrailer(mChannel);
        } else if (v.getId() == mTextViewIMDbLink.getId()) {
            Timber.d("onClick: IMDb link clicked for channel \"%s\"", mChannel.getName());
            mListener.onClickIMDb(mChannel);
        } else {
            Timber.d("onClick: clicked channel \"%s\".", mChannel.getName());
            mListener.onClick(mChannel);
        }
    }
}
