package com.example.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
		button = (Button)findViewById(R.id.button_fragment_01);
		button.setOnClickListener(createListener01());
		button = (Button)findViewById(R.id.button_fragment_02);
		button.setOnClickListener(createListenerMobil());
		button = (Button)findViewById(R.id.button_fragment_03);
		button.setOnClickListener(createListenerTablet());
		
	}
	
	
	private View.OnClickListener createListener01() {
		return new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, FragmentSimpleActivity.class));
			}
		};
	}
	
	private View.OnClickListener createListenerMobil() {
		return new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "not implemented, yet", Toast.LENGTH_SHORT).show();
			}
		};
	}
	
	private View.OnClickListener createListenerTablet() {
		return new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "not implemented, yet", Toast.LENGTH_SHORT).show();
			}
		};
	}
	
}
