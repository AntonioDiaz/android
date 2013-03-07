package com.example.shrib_app;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends Activity {

	private Context context;
	private DataBaseHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);
		context = this;
		Button button;
		button = (Button) findViewById(R.id.cancel_preferences);
		button.setOnClickListener(setOnClickCancel());
		button = (Button) findViewById(R.id.accept_preferences);
		button.setOnClickListener(setOnClickAccept());
		/** Inicialize DB. */
		db = new DataBaseHelper(getApplication());
		Cursor cursor = doQuery();
		String notepadRef = "";
		while (cursor.moveToNext()) {
			if (cursor.getString(1).equals("notepad_id")) {
				notepadRef = cursor.getString(2);
			}
		}
		cursor.close();
		EditText editText = (EditText) findViewById(R.id.notepad_id);
		editText.setText(notepadRef);
	}

	private Cursor doQuery() {
		return (db.getReadableDatabase().rawQuery("SELECT _id, name, value FROM preferences ORDER BY _id", null));
	}

	private OnClickListener setOnClickCancel() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, MainActivity.class));
			}
		};
	}

	private OnClickListener setOnClickAccept() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText editText = (EditText) findViewById(R.id.notepad_id);
				ContentValues cv = new ContentValues();
				cv.put(DataBaseHelper.VALUE, editText.getText().toString());
				db.getWritableDatabase().update("preferences", cv, DataBaseHelper.NAME + "=?", new String[] { "notepad_id" });
				Toast.makeText(context, R.string.msg_update_ok,Toast.LENGTH_SHORT).show();
				startActivity(new Intent(context, MainActivity.class));
			}
		};
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		db.close();
	}
}
