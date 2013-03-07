package com.example.shrib_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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
import android.widget.EditText;
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
		button = (Button) findViewById(R.id.preferences);
		button.setOnClickListener(listenerPreferences());
		button = (Button) findViewById(R.id.share);
		button.setOnClickListener(listenerShare());
		button = (Button) findViewById(R.id.save);
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
		TextView textView = (TextView) findViewById(R.id.TextViewURL);
		textView.setText(textView.getText().toString() + notepadId);
		loadEditor();
	}

	/** Load de text from de url. */
	private void loadEditor() {
		EditText editor = (EditText) findViewById(R.id.text_editor);
		String myUrl = ((TextView) findViewById(R.id.TextViewURL)).getText().toString();
		String txt;
		try {
			URL oracle = new URL(myUrl);
			String startTag = "<textarea ";
			String endTag = "</textarea>";
			BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
			StringBuilder result = new StringBuilder();
			String inputLine;
			int indexStart = -1;
			int line = 0;
			int lineStart = 0;
			int lineEnd = 0;
			while ((inputLine = in.readLine()) != null) {
				if (indexStart == -1) {
					indexStart = inputLine.indexOf(startTag);
					lineStart = line;
				}
				if (inputLine.indexOf(endTag) != -1) {
					lineEnd = line;
				}
				line++;
			}
			line = 0;
			in = new BufferedReader(new InputStreamReader(oracle.openStream()));
			int desde = 0;
			int hasta = 0;
			while ((inputLine = in.readLine()) != null) {
				if (line >= lineStart && line <= lineEnd) {
					desde = 0;
					hasta = inputLine.length();
					if (line == lineStart) {
						desde = inputLine.indexOf(">") + 1;
					}
					if (line == lineEnd) {
						hasta = inputLine.lastIndexOf(endTag);
					}

					result.append(inputLine.substring(desde, hasta));
				}
				line++;
			}
			txt = result.toString();
			in.close();
		} catch (Exception e) {
			txt = e.toString();
			//txt = e.getMessage();
		}
		editor.setText(txt);
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
