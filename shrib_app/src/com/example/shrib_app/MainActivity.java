package com.example.shrib_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final String TAG = "shrib_app";
	
	private Context context;

	public static DataBaseHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(MainActivity.TAG, MainActivity.TAG + " - onCreate - MainActivity");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		Button button;
		button = (Button)findViewById(R.id.preferences);
		button.setOnClickListener(listenerPreferences());
		button = (Button)findViewById(R.id.share);
		button.setOnClickListener(listenerShare());
		button = (Button)findViewById(R.id.save);
		button.setOnClickListener(listenerSave());
		/** Inicialize DB. */
		db = new DataBaseHelper(getApplication());
		Cursor cursor = doQuery();
		String notepadId = "";
		while (cursor.moveToNext()) {
			if (cursor.getString(1).equals("notepad_id")) {
				notepadId = cursor.getString(2);
			}
		}
		cursor.close();
		TextView textView = (TextView)findViewById(R.id.TextViewURL);
		textView.setText(textView.getText().toString() + notepadId);
		
	}

	private OnClickListener listenerPreferences() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, PreferencesActivity.class));
			}
		};
	}
	
	private Cursor doQuery() {
		return (db.getReadableDatabase().rawQuery("SELECT _id, name, value FROM preferences ORDER BY _id", null));
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		db.close();
	}
	
	private OnClickListener listenerShare() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "not impmemented, yet", Toast.LENGTH_SHORT).show();
			}
		};
	}
	private OnClickListener listenerSave() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "not impmemented, yet", Toast.LENGTH_SHORT).show();
			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
