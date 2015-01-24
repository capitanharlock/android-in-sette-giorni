package com.androidinsettegiorni_cap3.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class DialogFragmentText extends DialogFragment {

	public static String KEY = "VALUE";

	public static DialogFragmentText newInstance(String text) {

		DialogFragmentText f = new DialogFragmentText();

		Bundle b = new Bundle();
		b.putString(KEY, text);

		f.setArguments(b);

		return f;

	}

	public DialogFragmentText() {
		super();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		String message = getArguments().getString(KEY);

		builder.setMessage(message);
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();

			}
		});

		return builder.create();
	}
}
