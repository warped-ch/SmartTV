package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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
    private DeviceListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public DeviceListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Device> devices = new ArrayList<>();
        mAdapter = new DeviceListAdapter(devices, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device_list, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.devices);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.getMenu().findItem(R.id.action_refresh).setVisible(false);
        toolbar.getMenu().findItem(R.id.action_close).setVisible(true);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (R.id.action_close == item.getItemId()) {
                    Timber.d("onMenuItemClick: item \"%s\" selected.", getResources().getString(R.string.close));
                    dismiss();
                    return true;
                }
                return false;
            }
        });

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewDevices);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
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
