package com.androidinsettegiorni_cap3.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidinsettegiorni_cap3.R;

public class DialogFragmentEmpty extends DialogFragment {

	public static final String TAG = DialogFragmentEmpty.class.getName();

	public static DialogFragmentEmpty newInstance() {

		DialogFragmentEmpty f = new DialogFragmentEmpty();

		return f;

	}

	public DialogFragmentEmpty() {
		super();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.empty_dialog, container, false);
		return v;
	}

}
