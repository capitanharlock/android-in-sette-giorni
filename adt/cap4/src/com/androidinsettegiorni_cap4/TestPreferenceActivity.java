package com.androidinsettegiorni_cap4;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class TestPreferenceActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.pref);
	}

}
