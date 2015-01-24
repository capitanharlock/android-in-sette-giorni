package com.androidinsettegiorni_cap1;

import android.app.Activity;
import android.os.Bundle;

public class ExampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Inizializza l'activity e aggiuge la UI
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example);

	}

	/*
	 * Chiamato dopo la callback di OnCreate, è utilizzato per ricostruire lo
	 * stato della UI
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// Ricostruisce la UI da una precedente istanza (savedInstanceState). Lo
		// stesso bundle
		// è passato anche alla callback onCreate
		// La callback onRestoreInstanceState è chiamata se l'Activity è stata
		// uccisa dal sistema
		// dopo che era visibile
		super.onRestoreInstanceState(savedInstanceState);

	}

	/*
	 * Callback chiamata prima del ciclo bisibile ell'Activity
	 */
	@Override
	protected void onRestart() {
		// Sono precaricati tutti i cambiamenti di UI e di logica prima che
		// l'Activity diventi visibile dopo il ritorno dal background.
		super.onRestart();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
}
