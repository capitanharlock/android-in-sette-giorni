package com.androidinsettegiorni_cap2;

import android.app.Activity;

public class ElementoGrafico {

	private String name;

	private Class<? extends Activity> activity;

	public ElementoGrafico(String name, Class<? extends Activity> activity) {

		this.name = name;
		this.activity = activity;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<? extends Activity> getActivity() {
		return activity;
	}

	public void setActivity(Class<? extends Activity> activity) {
		this.activity = activity;
	}

}
