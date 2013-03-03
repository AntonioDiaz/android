package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FormFragment extends Fragment {

	
	
	public interface FormListener {
		public void pushOk(String text);
		public void pushCancel(String text);
		public void pushText(String text);
	}
	
	private FormListener formListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof FormListener) {
			Log.d("zasentodalaboca", "tomatoma");
			formListener = (FormListener)activity;
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View vista = inflater.inflate(R.layout.activity_fragment, container, false);
		
		final EditText editText = (EditText)vista.findViewById(R.id.my_textview);
		Button button = (Button)vista.findViewById(R.id.button_ok);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("zasentodalaboca", "editText.getText()" + editText.getText());
				formListener.pushOk(editText.getText().toString());
			}
		});
		button = (Button)vista.findViewById(R.id.button_cancel);
		button = (Button)vista.findViewById(R.id.button_test);
		return vista;
	}
	
	
}
