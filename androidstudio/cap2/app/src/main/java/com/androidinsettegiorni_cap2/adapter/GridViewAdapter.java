package com.androidinsettegiorni_cap2.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidinsettegiorni_cap2.R;

public class GridViewAdapter extends ArrayAdapter<String> {

	public GridViewAdapter(Context context, String[] objects) {
		super(context, R.layout.gridview_item, objects);
	}

	public GridViewAdapter(Context context, int layout, List<String> objects) {

		super(context, layout, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {

			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			convertView = (LinearLayout) inflater.inflate(R.layout.gridview_item, parent, false);

		}

		String s = getItem(position);

		TextView text = (TextView) convertView.findViewById(R.id.text_grid);

		text.setText(s);
		return convertView;
	}
}
