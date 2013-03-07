package com.example.shrib_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

	private static final int SCHEMA = 1;
	private static final String DATABASE_NAME = "shrib_notepad.db";
	public static final String NAME = "name";
	public static final String VALUE = "value";
	private static final String CREATE_PREFERENCES = "CREATE TABLE preferences (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, value TEXT)";

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			db.beginTransaction();
			/** sould create the tables needed. */
			db.execSQL(CREATE_PREFERENCES);
			ContentValues cv = new ContentValues();
			cv.put(NAME, "notepad_id");
			cv.put(VALUE, "BrCnW5IL");
			db.insert("preferences", NAME, cv);
			db.setTransactionSuccessful();
			Log.d(MainActivity.TAG, MainActivity.TAG + " - onCreate");
		} catch (Exception e) {
			Log.e(MainActivity.TAG, MainActivity.TAG + " - error en el onCreate");
		} finally {
			db.endTransaction();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		throw new RuntimeException("CONDEMOR, How do we get here?");
	}

	public String selectIdNotepad() {

		return null;
	}

}
