/*
 *
 *  Copyright (C) Roberto Calvo Palomino
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/. 
 *
 *  Author : Roberto Calvo Palomino <rocapal at gmail dot com>
 *
 */

package com.mypackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {

	private Button btList;
	private Button btAdvList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setupWidgets();
	}

	/** Inicializa los eventos de los botones. */
	private void setupWidgets() {
		btList = (Button) findViewById(R.id.btList);
		btList.setOnClickListener(getOnClickDoSomething(1));
		btAdvList = (Button) findViewById(R.id.btAdvlist);
		btAdvList.setOnClickListener(getOnClickDoSomething(2));
	}

	/**
	 * Este método lanza una nueva actividad dependiendo del parámetro
	 * @param myListId
	 */
	private void goLayout(final Integer myListId) {
		Intent i = null;
		if (myListId == 1) {
			i = new Intent(this, SimpleList.class);
		 } 
		 if (myListId == 2) {
			 i = new Intent(this, AdvanceList.class);
		 }
		if (i != null) {
			startActivity(i);
		}
	}

	/**
	 * Este método devuelve un listener que ejecutará el método goLayout con el valor 'layoutId' que le pasemos
	 * @param list
	 * @return
	 */
	private View.OnClickListener getOnClickDoSomething(final Integer list) {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				goLayout(list);
			}
		};
	}
}