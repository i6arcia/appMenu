package com.igarcia.menu;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Begin extends Activity {
	
	private String[] titulos;
	private DrawerLayout drawer;
	private ListView list;
	private ArrayList<Item_object> itms;
	private TypedArray icons;
	NavigationAdapter navAdapter;
	
	Button btnSalir;
	//DrawerLayout drawerLayout;
	//ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.begin);
		
		drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		list = (ListView) findViewById(R.id.list_view);
		
		View header = getLayoutInflater().inflate(R.layout.encabezado, null);
		list.addHeaderView(header);
		icons = getResources().obtainTypedArray(R.array.ic_panel);
		titulos = getResources().getStringArray(R.array.panel);
		itms = new ArrayList<Item_object>();
		
		itms.add(new Item_object(titulos[0], icons.getResourceId(0, -1)));
		itms.add(new Item_object(titulos[1], icons.getResourceId(1, -1)));
		itms.add(new Item_object(titulos[2], icons.getResourceId(2, -1)));
		itms.add(new Item_object(titulos[3], icons.getResourceId(3, -1)));
		
		navAdapter = new NavigationAdapter(this, itms);
		list.setAdapter(navAdapter);
		
		/*Resources res = this.getResources();
		String[] opciones = res.getStringArray(R.array.panel);
		
		listView = (ListView)findViewById(R.id.list_view);
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				android.R.id.text1, opciones));*/
		
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
		
		btnSalir = (Button)findViewById(R.id.btnSalir);
		btnSalir.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences conf1 = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
				SharedPreferences.Editor edit = conf1.edit();
				edit.putString("Nombre", "");
				edit.commit();
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	
	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (drawerLayout.isDrawerOpen(listView)) {
				drawerLayout.closeDrawers();
			} else {
				drawerLayout.openDrawer(listView);
			}
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/
}
