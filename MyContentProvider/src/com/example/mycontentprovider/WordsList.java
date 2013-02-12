package com.example.mycontentprovider;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.widget.TextView;

public class WordsList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words);
		String[] myProjection = { UserDictionary.Words._ID, UserDictionary.Words.WORD, UserDictionary.Words.LOCALE };
		String mySelectionClause = null;
		String[] mySelectionArgs = {""};
		String mySortOrder = null;
		Cursor cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI, myProjection, mySelectionClause, mySelectionArgs, mySortOrder);
		int index = cursor.getColumnIndex(UserDictionary.Words.WORD);
		TextView textView = (TextView)findViewById(R.id.title_words);
		textView.setText(textView.getText() + "-" + cursor.getCount());
		
	}

}
