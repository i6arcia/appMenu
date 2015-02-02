package com.igarcia.menu;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationAdapter extends BaseAdapter {
	private Activity activity;
	ArrayList <Item_object> arrayItms;
	
	public NavigationAdapter(Activity activity, ArrayList<Item_object> arrayItems){
		super();
		this.activity = activity;
		this.arrayItms= arrayItems;
	}
	
	@Override
	public Object getItem(int position){
		return arrayItms.get(position);
	}
	public int getCount(){
		return arrayItms.size();
	}
	@Override
	public long getItemId(int position){
		return position;
	}
	
	public static class Fila{
		TextView titulo_itm;
		ImageView icono;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		Fila view;
		LayoutInflater inflator = activity.getLayoutInflater();
		if (convertView == null){
			view = new Fila();
			Item_object itm = arrayItms.get(position);
			convertView = inflator.inflate(R.layout.itm, null);
			view.titulo_itm = (TextView) convertView.findViewById(R.id.title_itm);
			view.titulo_itm.setText(itm.getTitulo());
			
			view.icono = (ImageView) convertView.findViewById(R.id.icon);
			view.icono.setImageResource(itm.getIcono());
			
			convertView.setTag(view);
		}
		else{
			view = (Fila) convertView.getTag();
		}
		return convertView;
	}
}
