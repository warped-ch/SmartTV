package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 15.09.2016.
 */
class DeviceListAdapter extends RecyclerView.Adapter<DeviceViewHolder> {

    private final OnDeviceClickListener mListener;
    private ArrayList<Device> mDevices;

    public DeviceListAdapter(ArrayList<Device> devices, OnDeviceClickListener listener) {
        mDevices = devices;
        mListener = listener;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_list_item, parent, false);
        return new DeviceViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final DeviceViewHolder holder, int position) {
        Timber.d("onBindViewHolder: device \"%s\" at position %d.", mDevices.get(position).getName(), position);
        holder.bindDevice(mDevices.get(position));
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    public void addDevices(Device device) {
        mDevices.add(device);
        notifyDataSetChanged();
    }

    public ArrayList<Device> getDevices() {
        return mDevices;
    }

    public void setDevices(ArrayList<Device> devices) {
        mDevices = devices;
        notifyDataSetChanged();
    }
}