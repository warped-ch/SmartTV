package org.dev.warped.smarttv;

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
    private final TextView mTextViewEventTitle;
    private final ProgressBar mProgressBarEventDuration;
    private final TextView mTextViewEventDescription;

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
        mTextViewEventTitle = (TextView) v.findViewById(R.id.textViewEventTitle);
        mProgressBarEventDuration = (ProgressBar) v.findViewById(R.id.progressBarEventDuration);
        mTextViewEventDescription = (TextView) v.findViewById(R.id.textViewEventDescription);
    }

    public void bindChannel(Channel channel) {
        mChannel = channel;

        mImageViewPicon.setImageResource(PiconManager.getPiconResourceId(channel.getName()));
        mTextViewChannelName.setText(channel.getName());
        if(!channel.getEpgEvents().isEmpty()) {
            EpgEvent event = channel.getEpgEvents().get(0);
            mTextViewEventTitle.setText(event.getTitle());
            mProgressBarEventDuration.setProgress(event.calcProgress());
            mTextViewEventDescription.setText(event.getDescriptionExtended());
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
        } else {
            Timber.d("onClick: clicked channel \"%s\".", mChannel.getName());
            mListener.onClick(mChannel);
        }
    }
}
