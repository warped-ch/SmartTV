package org.dev.warped.smarttv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * {@link RecyclerView.Adapter} that can display a {@link EpgEvent} and makes a call to the
 * specified {@link OnEpgEventClickedListener}.
 */
class EpgEventListAdapter extends RecyclerView.Adapter<EpgEventViewHolder> {

    private final OnEpgEventClickedListener mListener;
    private ArrayList<EpgEvent> mEpgEvents;

    public EpgEventListAdapter(ArrayList<EpgEvent> epgEvents, OnEpgEventClickedListener listener) {
        mEpgEvents = epgEvents;
        mListener = listener;
    }

    @Override
    public EpgEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.epgevent_list_item, parent, false);
        return new EpgEventViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final EpgEventViewHolder holder, int position) {
        Timber.d("onBindViewHolder: epg event \"%s\" at position %d.",
                mEpgEvents.get(position).getTitle(), position);
        holder.bindEpgEvent(mEpgEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEpgEvents.size();
    }

    public ArrayList<EpgEvent> getEpgEvents() {
        return mEpgEvents;
    }

    public void setEpgEvents(ArrayList<EpgEvent> epgEvents) {
        mEpgEvents = epgEvents;
        notifyDataSetChanged();
    }
}
