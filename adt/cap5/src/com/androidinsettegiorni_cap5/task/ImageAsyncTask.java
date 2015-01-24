package com.androidinsettegiorni_cap5.task;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidinsettegiorni_cap5.R;

public class ImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

	private ImageView mImageView;
	private Context mContext;

	public ImageAsyncTask(Context c, ImageView image) {

		this.mImageView = image;
		this.mContext = c;
	}

	@Override
	protected Bitmap doInBackground(String... imageUrl) {
		Bitmap bitmap = null;
		HttpURLConnection urlConnection = null;

		try {
			URL url = new URL(imageUrl[0]);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.connect();
			int statusCode = urlConnection.getResponseCode();
			if (statusCode == 200) {
				InputStream in = new BufferedInputStream(urlConnection.getInputStream());
				bitmap = decodeBitmap(in);
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
		return bitmap;

	}

	@Override
	protected void onPostExecute(Bitmap imageBitmap) {

		mImageView.setImageBitmap(imageBitmap);

		super.onPostExecute(imageBitmap);
	}

	private Bitmap decodeBitmap(InputStream is) {

		return BitmapFactory.decodeStream(is);

	}

}
