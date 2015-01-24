package com.androidinsettegiorni_cap2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;

import com.androidinsettegiorni_cap2.R;

public class VideoViewActivity extends Activity {

	private VideoView v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.video_view_activity);
		v = (VideoView) findViewById(R.id.videoView);

		v.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4");

		v.start();

	}

	@Override
	protected void onDestroy() {
		v.stopPlayback();
		super.onDestroy();
	}

}
