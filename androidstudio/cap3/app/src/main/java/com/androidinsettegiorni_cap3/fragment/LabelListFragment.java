package com.androidinsettegiorni_cap3.fragment;

import java.util.ArrayList;

import android.app.ListFragment;
import android.os.Bundle;

import com.androidinsettegiorni_cap3.adapter.LabelListAdapter;
import com.androidinsettegiorni_cap3.model.Label;

public class LabelListFragment extends ListFragment {

	public LabelListFragment() {
		super();

	}

	private ArrayList<Label> list;
	private LabelListAdapter adapter;

	public LabelListFragment(ArrayList<Label> list) {
		this.list = list;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		setListAdapter(null);

		if (adapter == null) {
			adapter = new LabelListAdapter(getActivity(), list);
		}

		setListAdapter(adapter);
	}

}
