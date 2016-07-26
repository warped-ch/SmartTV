package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dev.warped.smarttv.EpgEventListFragment.OnEpgEventListFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * {@link RecyclerView.Adapter} that can display a {@link EpgEvent} and makes a call to the
 * specified {@link OnEpgEventListFragmentInteractionListener}.
 */
public class EpgEventListAdapter extends RecyclerView.Adapter<EpgEventViewHolder> {

    private final OnEpgEventListFragmentInteractionListener mListener;
    private List<EpgEvent> mEpgEvents;

    public EpgEventListAdapter(OnEpgEventListFragmentInteractionListener listener) {
        mListener = listener;
        mEpgEvents = new ArrayList<>();
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

    public void setEpgEvents(List<EpgEvent> epgEvents) {
        mEpgEvents = epgEvents;
        notifyDataSetChanged();
    }
}
