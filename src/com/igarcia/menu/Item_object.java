package com.igarcia.menu;

public class Item_object {
	
	private String titulo;
	private int icono;
	
	public Item_object(String title, int icon){
		this.titulo=title;
		this.icono=icon;
	}
	
	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(String title){
		this.titulo=title;
	}
	public int getIcono(){
		return icono;
	}
	public void setIcono(int icon){
		this.icono=icon;
	}
}
