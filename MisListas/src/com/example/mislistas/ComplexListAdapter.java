package com.example.mislistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ComplexListAdapter extends BaseAdapter {

	private String values[];
	Context context;
	
	public ComplexListAdapter(Context myContext, String[] myValues) {
		context = myContext;
		values = myValues;
	}
	
	
	@Override
	public int getCount() {
		return values.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		View view;
		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.my_item, null);
		} else {
			view = convertView;
		}
		TextView title = (TextView)view.findViewById(R.id.title);
		title.setText(values[position]);
		return view;
	}

}
