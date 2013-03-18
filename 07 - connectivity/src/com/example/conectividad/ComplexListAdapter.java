package com.example.conectividad;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		View view;
		NodeImage nodeImage = nodesList.get(position);
		LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = layoutInflater.inflate(R.layout.node_list, null);
		TextView title = (TextView) view.findViewById(R.id.desc_image);
		title.setText(nodeImage.getImageName());
		ImageView imageView = (ImageView) view.findViewById(R.id.image);
		Log.d(MainActivity.TAG, MainActivity.TAG + " url photo" + nodeImage.getPhotoUrl());
		Log.d(MainActivity.TAG, MainActivity.TAG + " photo" + nodeImage);
		Bitmap bitmapFromUrl = getBitmapFromUrl(nodeImage.getPhotoUrl());
		if (bitmapFromUrl!=null) {
			imageView.setImageBitmap(bitmapFromUrl);
		}
		return view;
	}

	private Bitmap getBitmapFromUrl(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(input);
			return bitmap;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
