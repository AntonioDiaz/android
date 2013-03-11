package com.example.conectividad;

import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.GpsStatus.NmeaListener;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;

public class MainActivity extends ListActivity {

	public static final String MY_JSON = "http://rest.libregeosocial.org/social/layer/560/search/?search=&latitude=40.2855&longitude=-3.8222&radius=1.0&category=0&elems=20&page=1&format=JSON";
	public static final String TAG = "Connectivity";
	private static MainActivity contexto;
	public static int NOTIFICATION_PLACES_ID = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Permisos de red en el UI Thread
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
		StrictMode.setThreadPolicy(policy);
		contexto = this;
		new DownloadJson(contexto).execute(null, null, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void showNotifications() {
		NotificationManager nNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		CharSequence text = "new places available";
		Notification notification = new Notification(R.drawable.ic_launcher, text, System.currentTimeMillis());
		Intent iNofification = new Intent(contexto, new ShowNotificationActivity().getClass());
		PendingIntent pendingIntent = PendingIntent.getActivity(contexto, 0, iNofification, PendingIntent.FLAG_CANCEL_CURRENT);
		notification.setLatestEventInfo(contexto, "Panoramio", "new pictures in this area", pendingIntent);
		nNM.notify(NOTIFICATION_PLACES_ID, notification);
	}

}
