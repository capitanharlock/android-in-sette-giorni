package com.androidinsettegiorni_cap4;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;

public class FragmentItemsList extends ListFragment implements LoaderCallbacks<Cursor> {

	private static final int LOADER_ID = 0; // ID univoco che identifica il
											// Loader
	private SimpleCursorAdapter mAdapter; // CursorAdapter per la gestione degli
											// elementi

	public interface ItemsListListener {
		void onItemClick(long id);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LoaderManager manager = getLoaderManager();

		manager.initLoader(LOADER_ID, null, this); // id, bundle, loadercallback

		// Creazione di un SimpleCursorAdapter per la gestione e la
		// visualizzazione
		// dei dati.
		mAdapter = new SimpleCursorAdapter(getActivity().getApplicationContext(), R.layout.list_item, null, new String[] { LentItemsContract.Items._ID, LentItemsContract.Items.NAME }, new int[] { R.id.idLabel, R.id.nameLabel }, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

		setListAdapter(mAdapter);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		// Testo da visualizzare se non ci sono item
		setEmptyText(getString(R.string.no_items));
	}

	// CHiamato quando è chiamato il metodo initLoader,
	// Istanzia e restituisce un nuovo loader per il determinato ID
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {

		CursorLoader cl = new CursorLoader(getActivity().getApplicationContext(), LentItemsContract.Items.CONTENT_URI, new String[] { LentItemsContract.Items._ID, LentItemsContract.Items.NAME }, null, null, LentItemsContract.Items.SORT_ORDER_ID);

		return cl;
	}

	// Callback utilizzata per notificare il risultato di un'operazione del
	// loader(insert,change,delete).
	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor c) {
		mAdapter.swapCursor(c);
	}

	// Callback notificata quando l'operazione è stata annullata.
	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		mAdapter.swapCursor(null);
	}

	// onListItemClick implementa onclick listener per la lista
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);

		ItemsListListener activity = (ItemsListListener) getActivity();
		activity.onItemClick(id);
	}

}
