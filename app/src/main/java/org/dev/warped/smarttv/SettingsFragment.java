package org.dev.warped.smarttv;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import timber.log.Timber;


/**
 * A simple {@link PreferenceFragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

    public static final String PREF_KEY_RECEIVER_TYPE = "pref_key_receiver_type";
    public static final String PREF_KEY_RECEIVER_HOST_IP = "pref_key_receiver_host_ip";

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        // Set preference summaries
        setPreferenceSummary(PREF_KEY_RECEIVER_TYPE);
        setPreferenceSummary(PREF_KEY_RECEIVER_HOST_IP);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        setPreferenceSummary(key);
    }

    private void setPreferenceSummary(String key) {
        switch (key) {
            case PREF_KEY_RECEIVER_TYPE:
                ListPreference prefReceiverType = (ListPreference) findPreference(key);
                CharSequence receiverType = prefReceiverType.getEntry();
                if (null != receiverType && 0 < receiverType.length()) {
                    prefReceiverType.setSummary(receiverType.toString());
                } else {
                    prefReceiverType.setSummary(getString(R.string.pref_summary_empty));
                }
                break;
            case PREF_KEY_RECEIVER_HOST_IP:
                EditTextPreference prefHostIP = (EditTextPreference) findPreference(key);
                String hostIP = prefHostIP.getText();
                if (null != hostIP && !hostIP.isEmpty()) {
                    prefHostIP.setSummary(hostIP);
                } else {
                    prefHostIP.setSummary(getString(R.string.pref_summary_empty));
                }
                break;
            default:
                Timber.w("setPreferenceSummary: switch to default for key \"%s\")", key);
                break;
        }
    }
}
