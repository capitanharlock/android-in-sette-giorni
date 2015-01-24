package com.androidinsettegiorni_cap3.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.androidinsettegiorni_cap3.R;

public class NetworkChangeBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		ConnectivityManager networkConnectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		final NetworkInfo networkInfo = networkConnectivity.getActiveNetworkInfo();

		if (networkInfo != null) {
			if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
				Toast.makeText(context, R.string.isconnected, Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(context, R.string.noconnected, Toast.LENGTH_LONG).show();
			}
		}

	}

}
