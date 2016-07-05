package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class ChannelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ChannelListFragment.OnChannelListFragmentInteractionListener mListener;
    private final TextView mTextViewTitle;

    private Channel mChannel;

    public ChannelViewHolder(View v, ChannelListFragment.OnChannelListFragmentInteractionListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewTitle = (TextView) v.findViewById(R.id.textViewChannelTitle);
    }

    public void bindChannel(Channel channel) {
        mChannel = channel;

        mTextViewTitle.setText(channel.getName());
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: show details for channel \"%s\".", mChannel.getName());
        mListener.onShowChannel(mChannel);
    }
}
