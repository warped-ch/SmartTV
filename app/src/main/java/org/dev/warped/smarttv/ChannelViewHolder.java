package org.dev.warped.smarttv;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import timber.log.Timber;

public class ChannelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnChannelClickedListener mListener;
    private final ImageView mImageViewPicon;
    private final TextView mTextViewChannelName;
    private final AppCompatImageButton mImageButtonZap;
    private final TextView mTextViewEpgEventNowTitle;
    private final AppCompatImageButton mImageButtonTrailer;
    private final TextView mTextViewIMDbLink;
    private final TextView mTextViewEpgEventStartTime;
    private final TextView mTextViewEpgEventEndTime;
    private final ProgressBar mProgressBarEpgEventDuration;
    private final TextView mTextViewEpgEventNextTitle;

    private Channel mChannel;

    public ChannelViewHolder(View v, OnChannelClickedListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mImageViewPicon = v.findViewById(R.id.imageViewPicon);
        mTextViewChannelName = v.findViewById(R.id.textViewChannelTitle);
        mImageButtonZap = v.findViewById(R.id.imageButtonZap);
        VectorDrawableSupport.setTintList(mImageButtonZap, R.color.image_button_state_list);
        mImageButtonZap.setOnClickListener(this);
        mTextViewEpgEventNowTitle = v.findViewById(R.id.textViewEpgEventNowTitle);
        mImageButtonTrailer = v.findViewById(R.id.imageButtonTrailer);
        VectorDrawableSupport.setTintList(mImageButtonTrailer, R.color.image_button_state_list);
        mTextViewIMDbLink = v.findViewById(R.id.textViewIMDbLink);
        mTextViewEpgEventStartTime = v.findViewById(R.id.textViewEpgEventStartTime);
        mTextViewEpgEventEndTime = v.findViewById(R.id.textViewEpgEventEndTime);
        mProgressBarEpgEventDuration = v.findViewById(R.id.progressBarEpgEventDuration);
        mTextViewEpgEventNextTitle = v.findViewById(R.id.textViewEpgEventNextTitle);
    }

    public void bindChannel(Channel channel) {
        mChannel = channel;

        mImageViewPicon.setImageResource(PiconManager.getPiconResourceId(channel.getName()));
        mTextViewChannelName.setText(channel.getName());

        if (!channel.getEpgEvents().isEmpty()) {
            EpgEvent epgEventNow = channel.getEpgEvents().get(0);
            mTextViewEpgEventNowTitle.setText(epgEventNow.getTitle());
            if (epgEventNow.getDescriptionExtended().toLowerCase().contains("imdb")) {
                mImageButtonTrailer.setEnabled(true);
                mImageButtonTrailer.setOnClickListener(this);

                mTextViewIMDbLink.setEnabled(true);
                mTextViewIMDbLink.setText(RegExParser.getIMDbRating(epgEventNow.getDescriptionExtended(), mTextViewIMDbLink.getResources().getString(R.string.imdb)));
                mTextViewIMDbLink.setOnClickListener(this);
            } else {
                mImageButtonTrailer.setEnabled(false);

                mTextViewIMDbLink.setEnabled(false);
                mTextViewIMDbLink.setText(mTextViewIMDbLink.getResources().getString(R.string.imdb));
            }
            mTextViewEpgEventStartTime.setText(epgEventNow.getStartTime());
            mTextViewEpgEventEndTime.setText(epgEventNow.getEndTime());
            mProgressBarEpgEventDuration.setProgress(epgEventNow.calcProgress());
        } else {
            Timber.d("bindChannel: epg event now for channel \"%s\" is not available.", channel.getName());
        }

        if (channel.getEpgEvents().size() >= 2) {
            EpgEvent epgEventNext = channel.getEpgEvents().get(1);
            mTextViewEpgEventNextTitle.setText(epgEventNext.getTitle());
        } else {
            Timber.d("bindChannel: epg event next for channel \"%s\" is not available.", channel.getName());
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
