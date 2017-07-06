package com.example.anibalherrera.programandounboton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensaje1(View v){
        Button b1= (Button)findViewById(R.id.button1);
        Toast.makeText(MainActivity.this,"Mensaje del boton 1" , Toast.LENGTH_LONG).show();

    }

    public void mensaje2(View v){
        Button b2= (Button)findViewById(R.id.button2);
        Toast.makeText(MainActivity.this, "Mensaje del boton 2", Toast.LENGTH_LONG).show();;

    }

}

