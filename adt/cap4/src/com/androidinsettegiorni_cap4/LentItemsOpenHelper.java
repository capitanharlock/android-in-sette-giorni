package com.androidinsettegiorni_cap4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * The SQLiteOpenhelper per la gestione del DB.
 * 
 */
class LentItemsOpenHelper extends SQLiteOpenHelper {

	private static final String NAME = DbSchema.DB_NAME;
	private static final int VERSION = 1;

	public LentItemsOpenHelper(Context context) {
		super(context, NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DbSchema.DDL_CREATE_TBL_ITEMS);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Solo per test.
		db.execSQL(DbSchema.DDL_DROP_TBL_ITEMS);

		onCreate(db);
	}

}
