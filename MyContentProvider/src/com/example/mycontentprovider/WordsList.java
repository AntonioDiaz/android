package com.example.mycontentprovider;

import android.app.ListActivity;
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
		String[] myProjection = { UserDictionary.Words._ID, UserDictionary.Words.WORD, UserDictionary.Words.LOCALE };
		String mySelectionClause = null;
		String[] mySelectionArgs = null;
		String mySortOrder = null;
		cursor = getContentResolver().query( UserDictionary.Words.CONTENT_URI, myProjection, mySelectionClause, mySelectionArgs, mySortOrder);
		TextView textView = (TextView)findViewById(R.id.title_words);
		textView.setText(textView.getText() + "-" + cursor.getCount());		
		String[] mWordsList = { UserDictionary.Words._ID, UserDictionary.Words.WORD, UserDictionary.Words.LOCALE }; 
		int[] mIdItems = {R.id.word_id, R.id.word_text, R.id.word_locale};		
		ListAdapter mCursorAdapter = new SimpleCursorAdapter(this, R.layout.my_item, cursor, mWordsList, mIdItems);
		setListAdapter(mCursorAdapter);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		int index = cursor.getColumnIndex(UserDictionary.Words._ID);
		Toast.makeText(this, cursor.getString(index) , Toast.LENGTH_SHORT).show();
	}

}
