package com.example.enviodatos;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void listadoOnClick(View view){
		startActivity(new Intent(this, ListadoActivity.class));
		
		
	}

	public void EnviarOnClik(View view) {
		Thread nt = new Thread() {
			@Override
			public void run() {
				final EditText nombre = (EditText) findViewById(R.id.et_nombre);
				final EditText apellido = (EditText) findViewById(R.id.et_apellido);
				final EditText edad = (EditText) findViewById(R.id.et_edad);


				final String res;
				res= enviarGet(nombre.getText().toString(), apellido
						.getText().toString(), edad.getText().toString());

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(MainActivity.this,"Registrado",
								Toast.LENGTH_LONG).show();
						nombre.setText("");
						apellido.setText("");
						edad.setText("");
					}
				});
			}
		};
		nt.start();
	}


	public String enviarGet(String nombre, String apellido, String edad) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpResponse response = null;
		String parametros = "?nombre=" + nombre + "&apellido=" + apellido
				+ "&edad=" + edad;



		HttpGet httpget = new HttpGet(
				"http://192.168.0.7:8080/Android/PutData.php" + parametros);
		try {
			response = httpClient.execute(httpget, localContext);
		} catch (Exception e) {
		}
		return response.toString();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
