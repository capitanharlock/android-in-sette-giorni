package com.androidinsettegiorni_cap5;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class ImageUrlService extends Service {

	String cardImageUrl[] = { "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg", "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search/card.jpg", "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue/card.jpg", "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole/card.jpg", "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose/card.jpg" };

	String currentImageToShow = null;
	// ID Messaggio
	public static final int MSG_URL_ID = 278;

	/*
	 * Handler per gestire la coda di messaggi
	 */

	class MessageHandlerReceiver extends Handler {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_URL_ID:

				int imageCode = msg.arg1;

				currentImageToShow = cardImageUrl[imageCode % cardImageUrl.length];

				System.out.println("CODE " + imageCode + " URL " + currentImageToShow);

				Message messageToActivity = new Message();
				messageToActivity.what = MainActivity.URL_ID;
				messageToActivity.obj = currentImageToShow;

				try {
					msg.replyTo.send(messageToActivity);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			default:
				break;
			}
			super.handleMessage(msg);
		}

	}

	final Messenger mMessanger = new Messenger(new MessageHandlerReceiver());

	public ImageUrlService() {
	}

	@Override
	public IBinder onBind(Intent intent) {

		return mMessanger.getBinder();
	}

}
