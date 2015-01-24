package com.androidinsettegiorni_cap2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentExample extends Fragment {

	private static final String position_label = "pos";

	private TextView textView;

	public static Fragment newInstance(int position) {

		FragmentExample f = new FragmentExample();

		Bundle b = new Bundle();
		b.putInt(position_label, position);

		f.setArguments(b);

		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.text_pager_element, container, false);
		textView = (TextView) view.findViewById(R.id.text_pager);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

		Bundle b = getArguments();

		textView.setText("" + b.getInt(position_label, -1));

	}
}
