package com.androidinsettegiorni_cap5.task;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.androidinsettegiorni_cap5.R;
import com.androidinsettegiorni_cap5.model.Ip;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NetworkAsynckTask extends AsyncTask<Void, Void, Ip> {
	private ObjectMapper mapper;
	private Context mContext;

	private TextView ipView, providerView, ispView, locationView;

	public NetworkAsynckTask(Context c, TextView ip, TextView provider, TextView isp, TextView location) {
		this.mapper = new ObjectMapper();
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.mContext = c;

		ipView = ip;
		providerView = provider;
		ispView = isp;
		locationView = location;
	}

	@Override
	protected void onPreExecute() {

		ipView.setText(mContext.getString(R.string.ip) + mContext.getString(R.string.loading));
		providerView.setText(mContext.getString(R.string.provider) + mContext.getString(R.string.loading));
		ispView.setText(mContext.getString(R.string.isp) + mContext.getString(R.string.loading));
		locationView.setText(mContext.getString(R.string.location) + mContext.getString(R.string.loading));

		ConnectivityManager connManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {

		} else {
			cancel(true);
		}

		super.onPreExecute();
	}

	@Override
	protected Ip doInBackground(Void... params) {

		Ip currentIp = null;
		HttpURLConnection urlConnection = null;

		try {
			URL url = new URL(this.mContext.getString(R.string.endpoint));
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.connect();
			int statusCode = urlConnection.getResponseCode();
			if (statusCode == 200) {
				InputStream in = new BufferedInputStream(urlConnection.getInputStream());
				currentIp = mapper.readValue(in, Ip.class);
			} else {
				cancel(true);
				Toast.makeText(mContext, mContext.getString(R.string.error) + " " + statusCode, Toast.LENGTH_SHORT).show();
			}

		} catch (IOException e) {

			e.printStackTrace();
			cancel(true);

		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();

		}
		return currentIp;
	}

	@Override
	protected void onPostExecute(Ip result) {

		ipView.setText(mContext.getString(R.string.ip) + result.getIp());
		providerView.setText(mContext.getString(R.string.provider) + result.getHostname());
		ispView.setText(mContext.getString(R.string.isp) + result.getIsp());
		locationView.setText(mContext.getString(R.string.location) + result.getLocation());

		super.onPostExecute(result);
	}

	@Override
	protected void onCancelled() {

		ipView.setText(mContext.getString(R.string.ip) + " " + mContext.getString(R.string.error));
		providerView.setText(mContext.getString(R.string.provider) + " " + mContext.getString(R.string.error));
		ispView.setText(mContext.getString(R.string.isp) + " " + mContext.getString(R.string.error));
		locationView.setText(mContext.getString(R.string.location) + " " + mContext.getString(R.string.error));
		super.onCancelled();
	}
}
