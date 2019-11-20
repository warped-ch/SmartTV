package org.dev.warped.smarttv;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import timber.log.Timber;

public class DeviceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final OnDeviceClickListener mListener;
    private final TextView mTextViewTitle;

    private Device mDevice;

    public DeviceViewHolder(View v, OnDeviceClickListener listener) {
        super(v);

        mListener = listener;

        // Define click listener for the ViewHolder's View.
        v.setOnClickListener(this);

        mTextViewTitle = v.findViewById(R.id.textViewDeviceTitle);
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
