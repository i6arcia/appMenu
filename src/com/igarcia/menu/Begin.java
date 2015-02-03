package com.igarcia.menu;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Begin extends Activity {
	
	private DrawerLayout drawer;
	private ListView list;
	
	private String[] titulos;
	private ArrayList <Item_objct> itms;
	private TypedArray icons;
	NavigationAdapter navAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);
		
		drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		list = (ListView) findViewById(R.id.list_view);
		
		View header = getLayoutInflater().inflate(R.layout.header, null);
		list.addHeaderView(header);
		icons = getResources().obtainTypedArray(R.array.panel_ic);
		titulos = getResources().getStringArray(R.array.panel_options);
		itms = new ArrayList<Item_objct>();
		
		itms.add(new Item_objct(titulos[0], icons.getResourceId(0, -1)));
		itms.add(new Item_objct(titulos[1], icons.getResourceId(1, -1)));
		itms.add(new Item_objct(titulos[2], icons.getResourceId(2, -1)));
		itms.add(new Item_objct(titulos[3], icons.getResourceId(3, -1)));
		
		navAdapter = new NavigationAdapter(this, itms);
		list.setAdapter(navAdapter);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		/*list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(Begin.this, "Item:",
						Toast.LENGTH_SHORT).show();
				drawerLayout.closeDrawers();
			}
		});*/
		
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		
		SharedPreferences conf = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
		String nombre = conf.getString("Nombre", "");
		Toast.makeText(getApplicationContext(), "Bienvenido "+ nombre, Toast.LENGTH_LONG).show();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (drawer.isDrawerOpen(list)) {
				drawer.closeDrawers();
			} else {
				drawer.openDrawer(list);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/
}
