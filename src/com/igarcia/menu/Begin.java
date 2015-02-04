package com.igarcia.menu;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView <?> arg0, View arg1, int position,
					long id) {
				mostrarFragmento(position);
			}
		});
		mostrarFragmento(1);
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
	
	private void mostrarFragmento(int position){
		Fragment fragment = null;
		switch (position){
		case 1:
			fragment = new FrameExample();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			SharedPreferences conf1 = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
			SharedPreferences.Editor edit = conf1.edit();
			edit.putString("Nombre", "");
			edit.commit();
			Intent i = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(i);
			finish();
			break;
		}
		if (fragment != null){
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			list.setItemChecked(position, true);
			list.setSelection(position);
			
			setTitle(titulos[position-1]);
			drawer.closeDrawer(list);
		}else{
			Log.e("Error", "Al mostrar el fragmento "+ position);
		}
	}
}
