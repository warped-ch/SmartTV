package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class ChannelEpgViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ChannelEpgListFragment.OnChannelEpgListFragmentInteractionListener mListener;
    private final ImageView mImageViewPicon;
    private final TextView mTextViewChannelName;
    private final TextView mTextViewEventTitle;
    private final TextView mTextViewEventDescription;

    private ChannelEpg mChannelEpg;

    public ChannelEpgViewHolder(View v, ChannelEpgListFragment.OnChannelEpgListFragmentInteractionListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mImageViewPicon = (ImageView) v.findViewById(R.id.imageViewPicon);
        mTextViewChannelName = (TextView) v.findViewById(R.id.textViewChannelTitle);
        mTextViewEventTitle = (TextView) v.findViewById(R.id.textViewEventTitle);
        mTextViewEventDescription = (TextView) v.findViewById(R.id.textViewEventDescription);
    }

    public void bindChannel(ChannelEpg channelEpg) {
        mChannelEpg = channelEpg;

        mImageViewPicon.setImageResource(PiconResourceManager.getPiconResourceId(channelEpg.getName()));
        mTextViewChannelName.setText(channelEpg.getName());
        EpgEvent event = channelEpg.getEpgEvents().get(0);
        if(null != event) {
            mTextViewEventTitle.setText(event.getTitle());
            mTextViewEventDescription.setText(event.getDescriptionExtended());
        } else {
            Timber.d("bindChannel: event for channel\"%s\" is null.", channelEpg.getName());
        }
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: show details for channel \"%s\".", mChannelEpg.getName());
        mListener.onShowChannel(mChannelEpg);
    }
}
