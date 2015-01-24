package com.androidinsettegiorni_cap2;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidinsettegiorni_cap2.activity.ButtonActivity;
import com.androidinsettegiorni_cap2.activity.GridViewActivity;
import com.androidinsettegiorni_cap2.activity.ImageViewActivity;
import com.androidinsettegiorni_cap2.activity.TextActivity;
import com.androidinsettegiorni_cap2.activity.VideoViewActivity;
import com.androidinsettegiorni_cap2.activity.ViewPagerActivity;
import com.androidinsettegiorni_cap2.adapter.ElementAdapter;

public class Cap2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cap2);

		/*
		 * Impostiamo le diverse informazioni dell' Action Bar
		 */

		ActionBar bar = getActionBar();
		bar.setTitle(R.string.action_bar_name);
		bar.setSubtitle(R.string.action_bar_subtitle);
		bar.setDisplayUseLogoEnabled(true);
		bar.setDisplayShowTitleEnabled(true);

		// Impostazione background dell'action bar
		Resources r = getResources();
		Drawable drawableBackground = r.getDrawable(R.drawable.ab_stacked_solid_112);
		bar.setBackgroundDrawable(drawableBackground);

		/*
		 * ListView
		 */

		final ListView list = (ListView) findViewById(R.id.list_element);

		ElementAdapter adapter = new ElementAdapter(this, R.layout.element_list, creazioneElementi());

		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				ElementoGrafico itemSelected = (ElementoGrafico) list.getItemAtPosition(position);
				startActivity(new Intent(Cap2.this, itemSelected.getActivity()));

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cap2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private ArrayList<ElementoGrafico> creazioneElementi() {

		ArrayList<ElementoGrafico> listElement = new ArrayList<ElementoGrafico>();

		ElementoGrafico i3 = new ElementoGrafico("ImageView", ImageViewActivity.class);
		ElementoGrafico i4 = new ElementoGrafico("Text Layout", TextActivity.class);
		ElementoGrafico i5 = new ElementoGrafico("Button Layout", ButtonActivity.class);
		ElementoGrafico i6 = new ElementoGrafico("GridView", GridViewActivity.class);
		ElementoGrafico i7 = new ElementoGrafico("VideoView", VideoViewActivity.class);
		ElementoGrafico i8 = new ElementoGrafico("ViewPager", ViewPagerActivity.class);

		listElement.add(i3);
		listElement.add(i4);
		listElement.add(i5);
		listElement.add(i6);
		listElement.add(i7);
		listElement.add(i8);
		return listElement;
	}
}
