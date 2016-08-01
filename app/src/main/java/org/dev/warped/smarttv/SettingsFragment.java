package org.dev.warped.smarttv;

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
public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    // Accurate regex to check for an IPv4 address:
    // https://www.safaribooksonline.com/library/view/regular-expressions-cookbook/9780596802837/ch07s16.html
    private static final String RegEx_Matches_IPv4Address = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    // Accurate regex to check for an IPv6 address:s
    // https://www.safaribooksonline.com/library/view/regular-expressions-cookbook/9780596802837/ch07s17.html
    private static final String RegEx_Matches_IPv6Address = "^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$";

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        // Set preference summaries
        setPreferenceSummary(SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE);
        setPreferenceSummary(SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        ((MainActivity) getActivity()).setActionBarTitle(getResources().getString(R.string.settings));

        return view;
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
        // TODO, anwi: check for valid IPv4, IPv6 or hostname and deny otherwise?
        setPreferenceSummary(key);
    }

    private void setPreferenceSummary(String key) {
        switch (key) {
            case SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE:
                ListPreference prefReceiverType = (ListPreference) findPreference(key);
                CharSequence receiverType = prefReceiverType.getEntry();
                if (null != receiverType && 0 < receiverType.length()) {
                    prefReceiverType.setSummary(receiverType.toString());
                } else {
                    prefReceiverType.setSummary(getString(R.string.empty));
                }
                Timber.v("setPreferenceSummary: set summary for key \"%s\" to \"%s\".", SharedPreferencesManager.PREF_KEY_RECEIVER_TYPE, (null != receiverType) ? receiverType.toString() : "null");
                break;
            case SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS:
                EditTextPreference prefReceiverAddress = (EditTextPreference) findPreference(key);
                String receiverAddress = prefReceiverAddress.getText();
                if (null != receiverAddress && !receiverAddress.isEmpty()) {
                    prefReceiverAddress.setSummary(receiverAddress);
                } else {
                    prefReceiverAddress.setSummary(getString(R.string.empty));
                }
                Timber.v("setPreferenceSummary: set summary for key \"%s\" to \"%s\".", SharedPreferencesManager.PREF_KEY_RECEIVER_ADDRESS, (null != receiverAddress) ? receiverAddress : "null");
                break;
            case SharedPreferencesManager.PREF_KEY_RECEIVER_AUTO_DISCOVERY:
                // nop
                break;
            default:
                Timber.e("setPreferenceSummary: switch to default for key \"%s\".)", key);
                break;
        }
    }
}
