package org.dev.warped.smarttv;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 11.08.2016.
 */
public class DeviceDiscovery {
    public static final String SERVICE_TYPE = "_workstation._tcp.";

    private NsdManager mNsdManager;
    private NsdManager.ResolveListener mResolveListener;
    private NsdManager.DiscoveryListener mDiscoveryListener;

    NsdServiceInfo mService;

    public DeviceDiscovery(Context context) {
        mNsdManager = (NsdManager) context.getSystemService(Context.NSD_SERVICE);
    }

    public void initialize() {
        initializeResolveListener();
    }

    public void initializeDiscoveryListener() {
        mDiscoveryListener = new NsdManager.DiscoveryListener() {

            @Override
            public void onDiscoveryStarted(String serviceType) {
                Timber.d("onDiscoveryStarted: %s", serviceType);
            }

            @Override
            public void onServiceFound(NsdServiceInfo serviceInfo) {
                Timber.d("onServiceFound: serviceInfo=%s, serviceName=%s, serviceType=%s", serviceInfo, serviceInfo.getServiceName(), serviceInfo.getServiceType());

                if (!serviceInfo.getServiceType().equals(SERVICE_TYPE)) {
                    Timber.d("onServiceFound: unknown service type: %s", serviceInfo.getServiceType());
                } else if (serviceInfo.getServiceName().contains("dm800se")) {
                    mNsdManager.resolveService(serviceInfo, mResolveListener);
                }
            }

            @Override
            public void onServiceLost(NsdServiceInfo serviceInfo) {
                Timber.w("onServiceLost: %s", serviceInfo);
                if (mService == serviceInfo) {
                    mService = null;
                }
            }

            @Override
            public void onDiscoveryStopped(String serviceType) {
                Timber.d("onDiscoveryStopped: %s", serviceType);
            }

            @Override
            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
                Timber.e("onStartDiscoveryFailed: serviceType=%s, errorCode=%d", serviceType, errorCode);
            }

            @Override
            public void onStopDiscoveryFailed(String serviceType, int errorCode) {
                Timber.e("onStopDiscoveryFailed: serviceType=%s, errorCode=%d", serviceType, errorCode);
            }
        };
    }

    public void initializeResolveListener() {
        mResolveListener = new NsdManager.ResolveListener() {

            @Override
            public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
                Timber.e("onResolveFailed: serviceInfo=%s, errorCode=%d", serviceInfo, errorCode);
            }

            @Override
            public void onServiceResolved(NsdServiceInfo serviceInfo) {
                Timber.d("onServiceResolved: serviceInfo=%s, serviceName=%s, serviceType=%s, host=%s, port=%d",
                        serviceInfo, serviceInfo.getServiceName(), serviceInfo.getServiceType(), serviceInfo.getHost(), serviceInfo.getPort());
                mService = serviceInfo;
            }
        };
    }

    public void startDiscovery() {
        stopDiscovery();  // Cancel any existing discovery request
        initializeDiscoveryListener();
        mNsdManager.discoverServices(
                SERVICE_TYPE, NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
    }

    public void stopDiscovery() {
        if (mDiscoveryListener != null) {
            try {
                mNsdManager.stopServiceDiscovery(mDiscoveryListener);
            } finally {
            }
            mDiscoveryListener = null;
        }
    }

    public void tearDown() {
        mResolveListener = null;
    }
}
