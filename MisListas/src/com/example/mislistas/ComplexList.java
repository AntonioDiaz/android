package com.example.mislistas;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ComplexList extends ListActivity {

	
	
	String testValues[] = new String[]{"URJC", "UC3M", "UPM"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complex_list);
		BaseAdapter adapter = new ComplexListAdapter(this, testValues); 
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this, testValues[position], Toast.LENGTH_SHORT).show();
	}
}
