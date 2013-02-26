package com.example.multitareaandroid;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MyService extends Service {

	public int contador;
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("zasentodalaboca", "onCreate de myService");
		initService();
	}
	
	private void initService() {
		HacerArgo myHandler = new HacerArgo();
		myHandler.sendMessageDelayed(new Message(), 3000);
		MainActivity.MY_TEXT.setText("contador " + contador);		
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("zasentodalaboca", "onDelete de myService");
	}
	
	
	private class HacerArgo extends Handler {
		@Override
		public void handleMessage(Message msg) {
			contador += 3;
			initService();
		}
	}
	
}

