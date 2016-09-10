package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import java.net.InetAddress;

import timber.log.Timber;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnDeviceDiscoveryFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DeviceDiscoveryFragment extends Fragment implements DeviceDiscoveryCallback {

    private DeviceDiscovery mDeviceDiscovery;
    private OnDeviceDiscoveryFragmentInteractionListener mListener;

    public DeviceDiscoveryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device_discovery, container, false);

        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.device_discovery));

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
    }

    @Override
    public void onReceiverDiscovered(ReceiverClient.EReceiverType receiverType, InetAddress address) {
        Timber.d("onReceiverDiscovered: receiverType=%s, address=%s",receiverType.toString(), address);

        if (SharedPreferencesManager.getReceiverAddress(PreferenceManager.getDefaultSharedPreferences(getActivity())) != address) {
            Timber.d("onReceiverDiscovered: %s, set receiver address in shared preferences", address);
            SharedPreferencesManager.setReceiverAddress(PreferenceManager.getDefaultSharedPreferences(getActivity()), address);
        }

        if (SharedPreferencesManager.getReceiverType(PreferenceManager.getDefaultSharedPreferences(getActivity())) != receiverType) {
            Timber.d("onReceiverDiscovered: %s, set receiver type in shared preferences", receiverType);
            SharedPreferencesManager.setReceiverType(PreferenceManager.getDefaultSharedPreferences(getActivity()), receiverType);
        }

        mListener.onDeviceDiscoveryFinished();
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
        void onDeviceDiscoveryFinished();
    }
}
