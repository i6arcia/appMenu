package com.igarcia.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public static final String USUARIO = "MyPreferencesFile";
	static String Nombre;
	EditText editNombre;
	Button btn;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editNombre = (EditText)findViewById(R.id.editNombre);
        btn = (Button) findViewById(R.id.btnIngresar);
        
        SharedPreferences conf = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String nombre = conf.getString("Nombre", "");
        
        if (!nombre.equals("")){
        	Intent i = new Intent(getApplicationContext(), Begin.class);
        	startActivity(i);
        	finish();
        }
        
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(editNombre.getText().toString().equals("")){
					Toast.makeText(getApplicationContext(), "Ingresa Usiario", Toast.LENGTH_SHORT).show();
				}else{
					SharedPreferences conf1 = getSharedPreferences("Usuario",Context.MODE_PRIVATE);
					SharedPreferences.Editor edit = conf1.edit();
					edit.putString("Nombre", editNombre.getText().toString());
					edit.commit();
					Intent i = new Intent(getApplicationContext(), Begin.class);
					startActivity(i);
					finish();
				}
				//ingresar((Button) v);
			}
		});
    }
	public void ingresar (Button view){
		Toast.makeText(getApplicationContext(), 
				"Inicio", Toast.LENGTH_LONG).show();
		Intent i = new Intent(getBaseContext(), Begin.class);
		startActivity(i);
	}
}



