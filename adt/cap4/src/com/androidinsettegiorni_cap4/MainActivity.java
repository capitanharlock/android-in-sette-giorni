package com.androidinsettegiorni_cap4;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidinsettegiorni_cap4.FragmentItemsList.ItemsListListener;

public class MainActivity extends FragmentActivity implements OnClickListener, ItemsListListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		ContentValues values = new ContentValues();
		values.put(LentItemsContract.Items.NAME, "Elemento ");
		getContentResolver().insert(LentItemsContract.Items.CONTENT_URI, values); // La
																					// lista
																					// è
																					// automaticamente
																					// aggiornata
																					// grazie
																					// al
																					// loader
	}

	@Override
	public void onItemClick(long id) {

		String where = LentItemsContract.SELECTION_ID_BASED;
		String[] selectionArgs = { Long.toString(id) };
		getContentResolver().delete(LentItemsContract.Items.CONTENT_URI, where, selectionArgs); // //La
																								// lista
		// loader

		Toast.makeText(this, "Rimosso " + Long.toString(id), Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_settings:
			Intent i = new Intent(this, ViewPreferences.class);
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}
}
