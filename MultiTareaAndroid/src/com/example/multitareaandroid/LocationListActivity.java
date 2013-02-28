package com.example.multitareaandroid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LocationListActivity extends ListActivity {

	private List <String> locations;
	
	public LocationListActivity() {
		String testValues[] = new String[] { "URJC", "UC3M", "UPM" };
		locations = new ArrayList<String>();
		locations = Arrays.asList(testValues);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_list);
		String[] array = (String[])locations.toArray();
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
		ListView listView = (ListView)findViewById(android.R.id.list);
		listView.setAdapter(arrayAdapter);
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
	}

	protected void addLocation (String newLocation) {
		//t
	}
	
}
