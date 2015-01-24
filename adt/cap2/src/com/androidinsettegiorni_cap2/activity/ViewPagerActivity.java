package com.androidinsettegiorni_cap2.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.androidinsettegiorni_cap2.FragmentExample;
import com.androidinsettegiorni_cap2.R;

public class ViewPagerActivity extends FragmentActivity {

	static final int NUM_ITEMS = 10;

	MyAdapter mAdapter;

	ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pager_activity);

		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);

		mPager.setAdapter(mAdapter);

		Button button = (Button) findViewById(R.id.goto_first);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPager.setCurrentItem(0);
			}
		});
		button = (Button) findViewById(R.id.goto_last);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPager.setCurrentItem(NUM_ITEMS - 1);
			}
		});
	}

	public static class MyAdapter extends FragmentStatePagerAdapter {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

		@Override
		public Fragment getItem(int position) {
			return FragmentExample.newInstance(position);
		}

	}

}
