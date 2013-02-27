package com.example.multitareaandroid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Handler.Callback;
import android.util.Log;

public class MyService extends Service {

	public int contador;
	private boolean stopNow;
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("zasentodalaboca", "onCreate de myService");
		initService();
	}
	
	private void initService() {
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
		stopNow = true;
		MainActivity.MY_TEXT.setText("");		
		Log.d("zasentodalaboca", "onDelete de myService");
	}
	
	Handler myHandler = new Handler(new Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			contador += 3;
			if (!stopNow) {
				initService();
			}
			return true;
		}
	});
	
}

