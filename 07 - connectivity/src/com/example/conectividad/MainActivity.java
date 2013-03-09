package com.example.conectividad;

import com.example.conectividad.notifications.INotifications;

import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ListActivity {

	public static final String MY_JSON = "http://rest.libregeosocial.org/social/layer/560/search/?search=&latitude=40.2855&longitude=-3.8222&radius=1.0&category=0&elems=20&page=1&format=JSON";
	public static final String TAG = "Connectivity";
	private static MainActivity contexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		contexto = this;
		new DownloadJson(contexto).execute(null, null, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

		public void showNotifications() {
			NotificationManager nNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			CharSequence text = "new places available";
			Notification notification = new Notification(R.drawable.ic_launcher, text, System.currentTimeMillis());
			Intent iNofification = new Intent(contexto, new ShowNotificationActivity().getClass());
			PendingIntent.getActivity(contexto, 0, iNofification, PendingIntent.FLAG_CANCEL_CURRENT);
	}

}
