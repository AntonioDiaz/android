package com.example.conectividad;


import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.Toast;

public class DownloadJson extends AsyncTask<Void, Void, Void> {

	public DownloadJson(MainActivity context) {
		mContext = context;
	}
	
	ProgressDialog pd;
	private MainActivity mContext;
	private String textjSon;
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pd = ProgressDialog.show(mContext, "downloading", "downloading JSON...");
	}

	@Override
	protected Void doInBackground(Void... arg0) {
		textjSon = doGetPetition(MainActivity.MY_JSON);
		Log.d(MainActivity.TAG, MainActivity.TAG + textjSon);
		return null;
	}

	private String doGetPetition (String url ) {
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = null;
			httpGet = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String str = EntityUtils.toString(entity);
			return str;
		} catch (IOException e) {
			Log.e("doGet",e.getMessage());
			return null;
		}
	}
	
	@Override
	protected void onPostExecute(Void result) {
		JSONParser jsonParser = new JSONParser(textjSon);
		List<NodeImage> parser = jsonParser.parser();
		if (pd!=null && pd.isShowing()) {
			pd.dismiss();
		}
		Toast.makeText(mContext, "jSon" + parser.size(), Toast.LENGTH_SHORT).show();
		BaseAdapter adapter = new ComplexListAdapter(mContext, parser);
		mContext.setListAdapter(adapter);
		mContext.showNotifications();
	}
	
}
