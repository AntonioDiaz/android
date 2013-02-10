package com.example.mislistas;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ComplexList extends ListActivity {

	
	
	String testValues[] = new String[]{"URJC", "UC3M", "UPM"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.easy_list);
		
		
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, testValues);
		ListView listView = (ListView) findViewById(android.R.id.list);
		listView.setAdapter(arrayAdapter);
		
		//new Adaptador (this);
		
		
		//ListView listView = (ListView) findViewById(R.id.lvstrings);

		
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this, "Hola " + testValues[position], Toast.LENGTH_SHORT).show();
	}
	
	static class Adaptador extends BaseAdapter {

		private Context myContext;
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
}
