package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.fragments.FormFragment.FormListener;

public class MainActivity extends FragmentActivity implements FormListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button)findViewById(R.id.button_fragment);
		button.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				showFragment();
				//hideFragment();
			}
		});
	}

	private void showFragment() {
		FragmentManager fm = getSupportFragmentManager();
		Fragment editor = fm.findFragmentByTag("editor");
		if (editor == null) {
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.container, new FormFragment(), "editor");
			ft.commit();
		}
		
	}
	
	private void hideFragment() {
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void pushOk(String text) {
		Toast.makeText(this, "se pulso Ok..." + text, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void pushCancel(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pushText(String text) {
		// TODO Auto-generated method stub
		
	}

}
