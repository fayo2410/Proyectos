package com.example.jrafaelmzg.conexionwebserviceget;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainActivity extends AppCompatActivity {
    TextView men1,men2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void click(final View v){
        Thread tr = new Thread(){
            @Override
            public void run(){
                //men1 = (TextView)findViewById(R.id.textView2);
                //men1.setText("Antes de llamar al web service");
                Log.d("Title","Antes de llamar al web service");
                final String result = callWebServiceGet(v);

                //men2 = (TextView)findViewById(R.id.textView3);
                //men2.setText(result.toString());
                Log.d("Title","Despues de llamar al web service");
                Log.d("Title",result.toString());

                runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //lista();
                                men1 = (TextView)findViewById(R.id.textView2);
                                men1.setText("Antes de llamar al web service");
                                //Log.d("Title","Antes de llamar al web service");
                                men2 = (TextView)findViewById(R.id.textView3);
                                men2.setText(result.toString());
                            }
                });
            }
        };
        tr.start();
    }

    public String callWebServiceGet(View v){
        URL url = null;
        String linea="";
        int respuesta=0;
        StringBuilder result = null;

        try {
            url = new URL("http://10.0.2.83:8080/Aplicacionesmoviles2/Examen1/index.php/welcome/getUsers");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            respuesta = connection.getResponseCode();
            result = new StringBuilder();
            if (respuesta==HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea=reader.readLine())!=null){
                    result.append(linea);
                }
            }
        }catch (Exception e){

        }
        return result.toString();
    }
}
