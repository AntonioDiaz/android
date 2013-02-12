package com.example.mycontentprovider;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button myButton = (Button)findViewById(R.id.button_diccionary);
		myButton.setOnClickListener(myOnClickListener(this, WordsList.class));
		myButton = (Button)findViewById(R.id.button_contacts);
		myButton.setOnClickListener(myOnClickListener(this, ContactsList.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private View.OnClickListener myOnClickListener(final Context context, final Class<? extends Activity> myActivity){
		return new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (context, myActivity);
				startActivity(intent);
			}
		};
	}
}
