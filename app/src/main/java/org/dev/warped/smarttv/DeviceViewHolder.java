package org.dev.warped.smarttv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 15.09.2016.
 */
public class DeviceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnDeviceClickListener mListener;
    private final TextView mTextViewTitle;

    private Device mDevice;

    public DeviceViewHolder(View v, OnDeviceClickListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewTitle = (TextView) v.findViewById(R.id.textViewDeviceTitle);
    }

    public void bindDevice(Device device) {
        mDevice = device;

        mTextViewTitle.setText(device.getName());
    }

    @Override
    public void onClick(View v) {
        Timber.d("onClick: device \"%s\".", mDevice.getName());
        mListener.onClick(mDevice);
    }
}