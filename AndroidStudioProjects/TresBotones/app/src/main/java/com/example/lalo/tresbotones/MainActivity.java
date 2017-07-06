package com.example.lalo.tresbotones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button uno, dos, tres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btuno (View v){
        uno=(Button)findViewById(R.id.buttonuno);
        uno.setText("NOMBRE");
        dos=(Button)findViewById(R.id.buttondos);
        dos.setText("APELLIDOP");
        tres=(Button)findViewById(R.id.buttontres);
        tres.setText("APELLIDOM");
    }
    public void btdos (View v){
        uno=(Button)findViewById(R.id.buttonuno);
        uno.setText("DIA");
        dos=(Button)findViewById(R.id.buttondos);
        dos.setText("MES");
        tres=(Button)findViewById(R.id.buttontres);
        tres.setText("AÑO");
    }
    public void bttres (View v){
        uno=(Button)findViewById(R.id.buttonuno);
        uno.setText("HOLA");
        dos=(Button)findViewById(R.id.buttondos);
        dos.setText("ESTO");
        tres=(Button)findViewById(R.id.buttontres);
        tres.setText("YA JALÓ");
    }

}
