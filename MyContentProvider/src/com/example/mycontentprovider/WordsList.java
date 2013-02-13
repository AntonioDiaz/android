package com.example.mycontentprovider;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class WordsList extends ListActivity {

	private Cursor cursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.words);
		
		// Defines an object to contain the new values to insert
		ContentValues mNewValues = new ContentValues();

		/*
		 * Sets the values of each column and inserts the word. The arguments to the "put"
		 * method are "column name" and "value"
		 */
		mNewValues.put(UserDictionary.Words.APP_ID, "example.user");
		mNewValues.put(UserDictionary.Words.LOCALE, "en_US");
		mNewValues.put(UserDictionary.Words.WORD, "insert");
		mNewValues.put(UserDictionary.Words.FREQUENCY, "100");

		getContentResolver().insert(UserDictionary.Words.CONTENT_URI, mNewValues);
		
		
		String[] myProjection = { UserDictionary.Words._ID, UserDictionary.Words.WORD, UserDictionary.Words.LOCALE };
		String mySelectionClause = null;
		String[] mySelectionArgs = null;
		String mySortOrder = UserDictionary.Words._ID + " asc ";
		cursor = getContentResolver().query( UserDictionary.Words.CONTENT_URI, myProjection, mySelectionClause, mySelectionArgs, mySortOrder);
		String[] mWordsList = { UserDictionary.Words._ID, UserDictionary.Words.WORD, UserDictionary.Words.LOCALE }; 
		int[] mIdItems = {R.id.word_id, R.id.word_text, R.id.word_locale};		
		ListAdapter mCursorAdapter = new SimpleCursorAdapter(this, R.layout.my_item, cursor, mWordsList, mIdItems);
		setListAdapter(mCursorAdapter);
		
		
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		TextView textView = (TextView)findViewById(R.id.title_words);
		textView.setText(textView.getText() + "-" + cursor.getCount());		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		int index = cursor.getColumnIndex(UserDictionary.Words._ID);
		Toast.makeText(this, cursor.getString(index) , Toast.LENGTH_SHORT).show();
	}

}
