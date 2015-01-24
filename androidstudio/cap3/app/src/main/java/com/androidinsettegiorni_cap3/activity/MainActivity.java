package com.androidinsettegiorni_cap3.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.androidinsettegiorni_cap3.R;
import com.androidinsettegiorni_cap3.dialog.DialogFragmentEmpty;
import com.androidinsettegiorni_cap3.dialog.DialogFragmentText;
import com.androidinsettegiorni_cap3.fragment.ButtonSwitchFragment;
import com.androidinsettegiorni_cap3.fragment.EmptyFragment;
import com.androidinsettegiorni_cap3.fragment.LabelListFragment;
import com.androidinsettegiorni_cap3.model.DummyGenerator;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		FragmentManager manager = getFragmentManager();

		// tabhost
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();

		// viewpager
		final ViewPager pager = (ViewPager) findViewById(R.id.pager);

		final MyAdapter1 adapter = new MyAdapter1(manager, this, tabHost, pager);
		// pager.setAdapter(adapter);

		// tab size from screen size
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int tabWidth = metrics.widthPixels / 3;
		int tabHeight = metrics.widthPixels / 7;

		for (int i = 0; i < 3; i++) {
			TabSpec spec = tabHost.newTabSpec("tab" + i);
			spec.setIndicator(getTabView(tabWidth, tabHeight, "TAB" + i));
			adapter.addTab(spec, "tab" + i);
		}

	}

	private TextView getTabView(int width, int height, String title) {
		TextView view = new TextView(this);
		view.setMinimumWidth(width);
		view.setMinimumHeight(height);
		view.setGravity(Gravity.CENTER);
		view.setBackgroundResource(R.drawable.tab_indicator_holo);
		view.setText(title);
		return view;
	}

	private class MyAdapter1 extends FragmentPagerAdapter implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

		private final Context context;
		private final TabHost tabHost;
		private final ViewPager pager;
		private final ArrayList<String> tabs = new ArrayList<String>();

		// dummy contents class
		class DummyTabFactory implements TabHost.TabContentFactory {
			private final Context context;

			public DummyTabFactory(Context context) {
				this.context = context;
			}

			public View createTabContent(String tag) {
				View v = new View(context);
				v.setMinimumWidth(0);
				v.setMinimumHeight(0);
				return v;
			}
		}

		public MyAdapter1(FragmentManager fm, Context context, TabHost tabHost, ViewPager pager) {
			super(fm);
			this.context = context;
			this.tabHost = tabHost;
			this.pager = pager;
			this.tabHost.setOnTabChangedListener(this);
			this.pager.setAdapter(this);
			this.pager.setOnPageChangeListener(this);
		}

		public void addTab(TabHost.TabSpec tabSpec, String content) {
			tabSpec.setContent(new DummyTabFactory(this.context));
			tabs.add(content);
			tabHost.addTab(tabSpec);
			notifyDataSetChanged();
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0)
				return new ButtonSwitchFragment();
			else if (position == 1)
				return new LabelListFragment(DummyGenerator.getLabelList());
			else
				return new EmptyFragment(Color.WHITE);
		}

		@Override
		public int getCount() {
			return 3;
		}

		public void onPageScrollStateChanged(int state) {
			;
		}

		public void onPageScrolled(int position, float positionOffset, int positionOggsetPixesl) {
			;
		}

		public void onPageSelected(int position) {
			TabWidget widget = tabHost.getTabWidget();

			int oldFocus = widget.getDescendantFocusability();
			widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

			tabHost.setCurrentTab(position);

			widget.setDescendantFocusability(oldFocus);
		}

		public void onTabChanged(String tabId) {
			int position = tabHost.getCurrentTab();

			pager.setCurrentItem(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.menu_search:
			String s = item.getTitle().toString();
			DialogFragmentText dialog = DialogFragmentText.newInstance(s);

			dialog.show(getFragmentManager(), null);

			break;

		case R.id.menu_send:

			DialogFragmentEmpty empty = DialogFragmentEmpty.newInstance();
			FragmentTransaction ft = getFragmentManager().beginTransaction();

			empty.show(ft, DialogFragmentEmpty.TAG);

			break;

		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == DetailActivity.CODE) {

			Toast.makeText(this, R.string.activity_result_ok, Toast.LENGTH_LONG).show();

		}

		super.onActivityResult(requestCode, resultCode, data);
	}
}