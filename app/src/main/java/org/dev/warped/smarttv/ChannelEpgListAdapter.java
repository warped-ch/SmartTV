package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.warped.smarttv.ChannelEpgListFragment.OnChannelEpgListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ChannelEpg} and makes a call to the
 * specified {@link OnChannelEpgListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
class ChannelEpgListAdapter extends RecyclerView.Adapter<ChannelEpgViewHolder> {

    private final OnChannelEpgClickedListener mListener;
    private List<ChannelEpg> mChannels;

    public ChannelEpgListAdapter(OnChannelEpgClickedListener listener) {
        mListener = listener;
        mChannels = new ArrayList<>();
    }

    @Override
    public ChannelEpgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channel_epg_list_item, parent, false);
        return new ChannelEpgViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ChannelEpgViewHolder holder, int position) {
        Timber.d("onBindViewHolder: channel \"%s\" at position %d.",
                mChannels.get(position).getName(), position);
        holder.bindChannel(mChannels.get(position));
    }

    @Override
    public int getItemCount() {
        return mChannels.size();
    }

    public void setChannels(List<ChannelEpg> channelsEpg) {
        mChannels = channelsEpg;
        notifyDataSetChanged();
    }
}
