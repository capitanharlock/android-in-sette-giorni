package com.androidinsettegiorni_cap4;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import com.androidinsettegiorni_cap4.LentItemsContract.Items;

/**
 * The actual provider class for the lentitems provider. Clients do not use it
 * directly. Nor do they see it.
 */
public class LentItemsProvider extends ContentProvider {

	// Costanti
	private static final int ITEM_LIST = 1;
	private static final int ITEM_ID = 2;

	private static final UriMatcher URI_MATCHER;

	// setup UriMatcher
	static {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		URI_MATCHER.addURI(LentItemsContract.AUTHORITY, "items", ITEM_LIST);
		URI_MATCHER.addURI(LentItemsContract.AUTHORITY, "items/#", ITEM_ID);
	}

	private LentItemsOpenHelper mHelper = null;

	/**
	 * Inizializza il provider. Il sistema ANdroid chiama questo metodo
	 * immediatamente dopo aver creato il content provider. Il provider non è
	 * creato finché non è invocato un oggetto Content Resolver che prova ad
	 * accedere a esso.
	 */
	@Override
	public boolean onCreate() {
		mHelper = new LentItemsOpenHelper(getContext());
		return false;
	}

	/**
	 * Callback per la gestione delle query del content provider
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

		SQLiteDatabase db = mHelper.getReadableDatabase();
		SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

		switch (URI_MATCHER.match(uri)) {
		case ITEM_LIST:
			builder.setTables(DbSchema.TBL_ITEMS);
			if (TextUtils.isEmpty(sortOrder)) {
				sortOrder = Items.SORT_ORDER_DEFAULT;
			}
			break;
		case ITEM_ID:
			builder.setTables(DbSchema.TBL_ITEMS);
			// limite la query all'elemento passato come parametro
			builder.appendWhere(Items._ID + " = " + uri.getLastPathSegment());
			break;

		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}

		Cursor cursor = builder.query(db, projection, selection, selectionArgs, null, null, sortOrder);

		// notifica i listener per ogni possibile cambiamento
		cursor.setNotificationUri(getContext().getContentResolver(), uri);

		return cursor;
	}

	/**
	 * Callback per operazion di insert degli elementi
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {

		SQLiteDatabase db = mHelper.getWritableDatabase();
		if (URI_MATCHER.match(uri) == ITEM_LIST) {
			long id = db.insert(DbSchema.TBL_ITEMS, null, values);

			Uri retUri = ContentUris.withAppendedId(uri, id);

			// Notifica eventuali cambiamenti
			getContext().getContentResolver().notifyChange(retUri, null);

			return retUri;
		}

		throw new SQLException("Problema inserimento -> uri: " + uri);
	}

	/**
	 * Utile per operazioni di update degli elelemtni
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

		SQLiteDatabase db = mHelper.getWritableDatabase();
		int updateCount = 0;

		switch (URI_MATCHER.match(uri)) {
		case ITEM_LIST:
			updateCount = db.update(DbSchema.TBL_ITEMS, values, selection, selectionArgs);
			break;
		case ITEM_ID:
			String idStr = uri.getLastPathSegment();
			String where = Items._ID + " = " + idStr;
			if (!TextUtils.isEmpty(selection)) {
				where += " AND " + selection;
			}
			updateCount = db.update(DbSchema.TBL_ITEMS, values, where, selectionArgs);
			break;
		default:
			// Operazione non supportata
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}

		// Notifica eventuali cambiamenti
		if (updateCount > 0) {
			getContext().getContentResolver().notifyChange(uri, null);
		}

		return updateCount;

	}

	/**
	 * Callback per operazioni di delete sugli elementi
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		SQLiteDatabase db = mHelper.getWritableDatabase();
		int delCount = 0;

		switch (URI_MATCHER.match(uri)) {
		case ITEM_LIST:
			delCount = db.delete(DbSchema.TBL_ITEMS, selection, selectionArgs);
			break;
		case ITEM_ID:
			String idStr = uri.getLastPathSegment();
			String where = Items._ID + " = " + idStr;
			if (!TextUtils.isEmpty(selection)) {
				where += " AND " + selection;
			}
			delCount = db.delete(DbSchema.TBL_ITEMS, where, selectionArgs);
			break;
		default:
			// Operazione non supportata
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}

		// Notifica eventuali cambiamenti
		if (delCount > 0) {
			getContext().getContentResolver().notifyChange(uri, null);
		}

		return delCount;
	}

	@Override
	public String getType(Uri uri) {

		switch (URI_MATCHER.match(uri)) {
		case ITEM_LIST:
			return Items.CONTENT_TYPE;
		case ITEM_ID:
			return Items.CONTENT_ITEM_TYPE;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}

	}
}
