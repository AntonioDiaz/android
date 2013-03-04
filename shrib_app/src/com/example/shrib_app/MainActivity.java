package com.example.shrib_app;

import android.os.Bundle;
import android.preference.Preference;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
	}

	private OnClickListener listenerPreferences() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, PreferencesActivity.class));
			}
		};
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
