package com.androidinsettegiorni_cap3.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidinsettegiorni_cap3.R;

public class EmptyFragment extends Fragment {

	public EmptyFragment() {
		super();

	}

	private int color;

	public EmptyFragment(int color) {
		this.color = color;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
		View view = inflater.inflate(R.layout.empty_fragmen, container, false);
		view.setBackgroundColor(color);

		return view;
	}
}
