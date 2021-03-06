package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import timber.log.Timber;


/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnDeviceListFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DeviceListFragment extends DialogFragment implements DeviceDiscoveryCallback, OnDeviceClickListener {

    private DeviceDiscovery mDeviceDiscovery;
    private OnDeviceListFragmentInteractionListener mListener;
    private DeviceListAdapter mAdapter = new DeviceListAdapter(new ArrayList<>(), this);
    private ProgressBar mProgressBar;

    public DeviceListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device_list, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.devices);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.getMenu().findItem(R.id.action_refresh).setVisible(false);
        toolbar.getMenu().findItem(R.id.action_close).setVisible(true);
        toolbar.setOnMenuItemClickListener(item -> {
            if (R.id.action_close == item.getItemId()) {
                Timber.d("onMenuItemClick: item \"%s\" selected.", getResources().getString(R.string.close));
                dismiss();
                return true;
            }
            return false;
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewDevices);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mProgressBar = view.findViewById(R.id.progressBar);

        return view;
    }

    @Override
    public void onDestroyView() {
        mProgressBar = null;
        super.onDestroyView();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnDeviceListFragmentInteractionListener) {
            mListener = (OnDeviceListFragmentInteractionListener) activity;
        } else {
            Timber.e("onAttach: %s must implement OnDeviceListFragmentInteractionListener.", activity.toString());
            throw new RuntimeException(activity.toString()
                    + " must implement OnDeviceListFragmentInteractionListener");
        }

        mDeviceDiscovery = new DeviceDiscovery(this, activity);
    }

    @Override
    public void onDetach() {
        mListener = null;
        mDeviceDiscovery = null;
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDeviceDiscovery != null) {
            mDeviceDiscovery.startDiscovery();
        }
    }

    @Override
    public void onPause() {
        if (mDeviceDiscovery != null) {
            mDeviceDiscovery.stopDiscovery();
        }
        super.onPause();
    }

    @Override
    public void onDeviceDiscovered(Device device) {
        Timber.d("onDeviceDiscovered: receiverType=%s, address=%s", device.getReceiverType(), device.getAddress());
        if (mDeviceDiscovery != null) {
            ArrayList<Device> devices = mDeviceDiscovery.getDevices();
            mProgressBar.setVisibility(devices.isEmpty() ? View.VISIBLE : View.GONE);
            mAdapter.setDevices(devices);
        }
    }

    @Override
    public void onClick(Device device) {
        SharedPreferencesManager.setReceiverAddress(PreferenceManager.getDefaultSharedPreferences(getActivity()), device.getAddress());
        SharedPreferencesManager.setReceiverType(PreferenceManager.getDefaultSharedPreferences(getActivity()), device.getReceiverType());
        dismiss();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnDeviceListFragmentInteractionListener {
    }
}
