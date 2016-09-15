package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import timber.log.Timber;


/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnDeviceDiscoveryFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DeviceDiscoveryFragment extends DialogFragment implements DeviceDiscoveryCallback, OnDeviceClickListener {

    private DeviceDiscovery mDeviceDiscovery;
    private OnDeviceDiscoveryFragmentInteractionListener mListener;
    private DeviceListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public DeviceDiscoveryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Device> devices = new ArrayList<>();
        mAdapter = new DeviceListAdapter(devices, this);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device_discovery, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewDevices);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        try {
            menu.findItem(R.id.action_refresh).setVisible(false);
        } catch (NullPointerException e) {
            Timber.e("onPrepareOptionsMenu: menu item action_refresh is null.");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnDeviceDiscoveryFragmentInteractionListener) {
            mListener = (OnDeviceDiscoveryFragmentInteractionListener) activity;
        } else {
            Timber.e("onAttach: %s must implement OnDeviceDiscoveryFragmentInteractionListener.", activity.toString());
            throw new RuntimeException(activity.toString()
                    + " must implement OnDeviceDiscoveryFragmentInteractionListener");
        }

        mDeviceDiscovery = new DeviceDiscovery(this, activity);
    }

    @Override
    public void onPause() {
        if (mDeviceDiscovery != null) {
            mDeviceDiscovery.stopDiscovery();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDeviceDiscovery != null) {
            mDeviceDiscovery.startDiscovery();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mDeviceDiscovery = null;
        mListener = null;
        mAdapter = null;
        mListener = null;
    }

    @Override
    public void onDeviceDiscovered(Device device) {
        Timber.d("onDeviceDiscovered: receiverType=%s, address=%s", device.getReceiverType(), device.getAddress());
        mAdapter.setDevices(mDeviceDiscovery.getDevices());
    }

    @Override
    public void onClick(Device device) {
        if (SharedPreferencesManager.getReceiverAddress(PreferenceManager.getDefaultSharedPreferences(getActivity())) != device.getAddress()) {
            Timber.d("onClick: %s, set receiver address in shared preferences", device.getAddress());
            SharedPreferencesManager.setReceiverAddress(PreferenceManager.getDefaultSharedPreferences(getActivity()), device.getAddress());
        }

        if (SharedPreferencesManager.getReceiverType(PreferenceManager.getDefaultSharedPreferences(getActivity())) != device.getReceiverType()) {
            Timber.d("onClick: %s, set receiver type in shared preferences", device.getReceiverType());
            SharedPreferencesManager.setReceiverType(PreferenceManager.getDefaultSharedPreferences(getActivity()), device.getReceiverType());
        }
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
    public interface OnDeviceDiscoveryFragmentInteractionListener {
    }
}
