package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.warped.smarttv.ChannelListFragment.OnChannelListFragmentInteractionListener;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Channel} and makes a call to the
 * specified {@link OnChannelListFragmentInteractionListener}.
 */
class ChannelListAdapter extends RecyclerView.Adapter<ChannelViewHolder> {

    private final OnChannelClickedListener mListener;
    private ArrayList<Channel> mChannels;

    public ChannelListAdapter(ArrayList<Channel> channels, OnChannelClickedListener listener) {
        mChannels = channels;
        mListener = listener;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channel_list_item, parent, false);
        return new ChannelViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ChannelViewHolder holder, int position) {
        Timber.d("onBindViewHolder: channel \"%s\" at position %d.",
                mChannels.get(position).getName(), position);
        holder.bindChannel(mChannels.get(position));
    }

    @Override
    public int getItemCount() {
        return mChannels.size();
    }

    public ArrayList<Channel> getChannels() {
        return mChannels;
    }

    public void setChannels(ArrayList<Channel> channels) {
        mChannels = channels;
        notifyDataSetChanged();
    }
}
