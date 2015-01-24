package com.androidinsettegiorni_cap4;

import android.provider.BaseColumns;

/**
 * Helper che definisce le constanti utili per la gestione del Db.
 */

interface DbSchema {

	String DB_NAME = "cap4.db";

	String TBL_ITEMS = "items";

	String COL_ID = BaseColumns._ID;
	String COL_ITEM_NAME = "item_name";
	String COL_BORROWER = "borrower";

	String DDL_CREATE_TBL_ITEMS = "CREATE TABLE items (" + "_id           INTEGER  PRIMARY KEY AUTOINCREMENT, \n" + "item_name     TEXT,\n" + "borrower      TEXT \n" + ")";

	String DDL_DROP_TBL_ITEMS = "DROP TABLE IF EXISTS items";

	String DML_WHERE_ID_CLAUSE = "_id = ?";

	String DEFAULT_TBL_ITEMS_SORT_ORDER = "name ASC";

}