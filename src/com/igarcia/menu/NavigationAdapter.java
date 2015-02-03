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
	ArrayList<Item_objct> arrayItms;
	
	public NavigationAdapter (Activity act, ArrayList<Item_objct> list){
		super();
		this.activity= act;
		this.arrayItms = list;
	}
	
	@Override
	public Object getItem (int position){
		return arrayItms.get(position);
	}
	public int getCount(){
		return arrayItms.size();
	}
	public long getItemId (int position){
		return position;
	}
	public static class Fila{
		TextView titulo_itm;
		ImageView icono;
	}
	public View getView (int position, View convertView, ViewGroup parent){
		Fila view;
		LayoutInflater inflator = activity.getLayoutInflater();
		if(convertView == null){
			view = new Fila();
			Item_objct itm = arrayItms.get(position);
			convertView = inflator.inflate(R.layout.itm, null);
			view.titulo_itm = (TextView) convertView.findViewById(R.id.pan_descrip);
			view.titulo_itm.setText(itm.getTitulo());
			view.icono = (ImageView) convertView.findViewById(R.id.pan_icon);
			view.icono.setImageResource(itm.getIcono());
			convertView.setTag(view);
		}else{
			view = (Fila) convertView.getTag();
		}
		return convertView;
	}
}
