package com.androidinsettegiorni_cap4;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * La classe Contract è utilizzata per definire costanti pubbliche, come il nome
 * dei campi, per aiutare le altre applicazioni ad accedere ai dati del content
 * provider.
 */
public final class LentItemsContract {

	/**
	 * Authority del provider.
	 */
	public static final String AUTHORITY =

	"com.androidinsettegiorni.contentprovider.lentitems";

	/**
	 * Content URI per authority.
	 */
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

	/**
	 * Vincolo di selezione per query basate su ID
	 */
	public static final String SELECTION_ID_BASED = BaseColumns._ID + " = ? ";

	/**
	 * Costanti per la tabella Items.
	 */
	public static final class Items implements BaseColumns {

		/**
		 * Content URI della tabella.
		 */
		public static final Uri CONTENT_URI = Uri.withAppendedPath(LentItemsContract.CONTENT_URI, "items");
		/**
		 * Mime type della directory degli item,
		 */
		public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.androidinsettegiorni.lentitems_items";
		/**
		 * Mime type del singolo elemento.
		 */
		public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd.com.androidinsettegiorni.lentitems_items";

		/**
		 * Nome dell'elemento.
		 */
		public static final String NAME = "item_name";
		/**
		 * The borrower of the item.
		 */
		public static final String BORROWER = "borrower";

		/**
		 * Proiezione di tutte le colonne della tabella.
		 */
		public static final String[] PROJECTION_ALL = { _ID, NAME, BORROWER };

		/**
		 * Ordinmaneto di default (per nome) degli elementi.
		 */
		public static final String SORT_ORDER_DEFAULT = NAME + " ASC";

		/**
		 * Oridnamneto degli elementi per ID
		 */
		public static final String SORT_ORDER_ID = _ID + " ASC";

	}

}
