package com.androidinsettegiorni_cap5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidinsettegiorni_cap5.task.ImageAsyncTask;
import com.androidinsettegiorni_cap5.task.NetworkAsynckTask;

public class MainActivity extends Activity implements ServiceConnection {

	private TextView ipView, providerView, ispView, locationView;
	private ImageView mImageView;

	private Messenger mUrlService;

	public static final int URL_ID = 333;

	private Messenger mSelectedUrlMessenger = new Messenger(new Handler() {
		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case URL_ID:
				String url = (String) msg.obj;

				new ImageAsyncTask(MainActivity.this, mImageView).execute(url);
				break;

			default:
				break;
			}

			super.handleMessage(msg);
		}
	});
	private boolean mBound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ipView = (TextView) findViewById(R.id.current_ip);
		providerView = (TextView) findViewById(R.id.current_provider);
		ispView = (TextView) findViewById(R.id.current_isp);
		locationView = (TextView) findViewById(R.id.current_localtion);
		mImageView = (ImageView) findViewById(R.id.image);

	}

	public void calculate_ip(View v) {

		new NetworkAsynckTask(this, ipView, providerView, ispView, locationView).execute();
	}

	public void update_image(View v) {

		Message messageToService = new Message();
		messageToService.replyTo = mSelectedUrlMessenger;
		messageToService.what = ImageUrlService.MSG_URL_ID;
		messageToService.arg1 = (int) System.currentTimeMillis();

		try {
			mUrlService.send(messageToService);
		} catch (RemoteException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onServiceConnected(ComponentName arg0, IBinder arg1) {
		mBound = true;
		mUrlService = new Messenger(arg1);

	}

	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		mBound = false;
		mUrlService = null;
	}

	@Override
	protected void onStart() {
		super.onStart();
		/*
		 * Start del service
		 */
		Intent i = new Intent(this, ImageUrlService.class);
		bindService(i, this, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onStop() {
		super.onStop();
		// Disaccoppiamento dal service
		if (mBound) {
			unbindService(this);
			mBound = false;
		}
	}
}
