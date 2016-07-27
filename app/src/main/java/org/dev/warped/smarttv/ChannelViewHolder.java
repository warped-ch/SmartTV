package org.dev.warped.smarttv;

import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
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
    private final ImageButton mImageButtonZap;
    private final TextView mTextViewEpgEventTitle;
    private final ImageButton mImageButtonTrailer;
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
        mImageButtonZap = (ImageButton) v.findViewById(R.id.imageButtonZap);
        mImageButtonZap.setOnClickListener(this);
        mTextViewEpgEventTitle = (TextView) v.findViewById(R.id.textViewEpgEventTitle);
        mImageButtonTrailer = (ImageButton) v.findViewById(R.id.imageButtonTrailer);
        mTextViewEpgEventStartTime = (TextView) v.findViewById(R.id.textViewEpgEventStartTime);
        mTextViewEpgEventEndTime = (TextView) v.findViewById(R.id.textViewEpgEventEndTime);
        mProgressBarEpgEventDuration = (ProgressBar) v.findViewById(R.id.progressBarEpgEventDuration);
        mTextViewEpgEventDescription = (TextView) v.findViewById(R.id.textViewEpgEventDescription);
    }

    public void bindChannel(Channel channel) {
        mChannel = channel;

        mImageViewPicon.setImageResource(PiconManager.getPiconResourceId(channel.getName()));
        mTextViewChannelName.setText(channel.getName());
        if(!channel.getEpgEvents().isEmpty()) {
            EpgEvent epgEvent = channel.getEpgEvents().get(0);
            mTextViewEpgEventTitle.setText(epgEvent.getTitle());
            if (epgEvent.getDescriptionExtended().toLowerCase().contains("imdb")) {
                mImageButtonTrailer.getDrawable().setColorFilter(mImageButtonTrailer.getResources().getColor(R.color.colorCyanAccent700), PorterDuff.Mode.SRC_ATOP);
                mImageButtonTrailer.setOnClickListener(this);
            } else {
                mImageButtonTrailer.getDrawable().setColorFilter(mImageButtonTrailer.getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
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
        } else {
            Timber.d("onClick: clicked channel \"%s\".", mChannel.getName());
            mListener.onClick(mChannel);
        }
    }
}
