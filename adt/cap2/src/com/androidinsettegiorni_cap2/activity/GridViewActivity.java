package com.androidinsettegiorni_cap2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.androidinsettegiorni_cap2.R;
import com.androidinsettegiorni_cap2.adapter.GridViewAdapter;

public class GridViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.gridview_activity);

		GridView grid = (GridView) findViewById(R.id.gridView1);

		grid.setAdapter(new GridViewAdapter(this, getResources().getStringArray(R.array.grid_array)));

	}

}
