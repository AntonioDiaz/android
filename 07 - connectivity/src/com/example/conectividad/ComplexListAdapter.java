package com.example.conectividad;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ComplexListAdapter extends BaseAdapter {

	private Context context;
	private List<NodeImage> nodesList;

	public ComplexListAdapter(Context myContext, List<NodeImage> nodes) {
		context = myContext;
		nodesList = nodes;
	}
	
	@Override
	public int getCount() {
		return nodesList.size();
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
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		View view;
		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.node_list, null);
		} else {
			view = convertView;
		}
		TextView title = (TextView)view.findViewById(R.id.desc_image);
		ImageView imageView = (ImageView)view.findViewById(R.id.image);
		imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher));
		
		title.setText(nodesList.get(position).getImageName());
		//ImageView imageView = (ImageView)view.findViewById(R.id.image.);
		//imageView.setImageDrawable(view.getResources().getDrawable(values[position].getImgId()));
		return view;
	}

}
