package com.androidinsettegiorni_cap2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidinsettegiorni_cap2.R;

public class ButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.button_activity);

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(getApplicationContext(), R.string.button_example, Toast.LENGTH_LONG).show();

			}
		});

	}

	/**
	 * Callback che viene eseguita quando si fa click sull'imageButton. In
	 * particolare, il nome della callback deve essere uguale a quello definito
	 * come valore dell'attributo android:onclick dell'elemento.
	 */
	public void imageclick(View v) {

		Toast.makeText(getApplicationContext(), R.string.image_button_example, Toast.LENGTH_LONG).show();

	}
}
