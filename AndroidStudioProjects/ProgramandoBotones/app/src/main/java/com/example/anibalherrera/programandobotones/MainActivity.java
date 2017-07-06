package com.example.anibalherrera.programandobotones;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
Button b1,b2,b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String s= new String();
        switch (v.getId()){
            case R.id.button1:
                s="Boton 1";
                break;

            case R.id.button2:
                s="Boton 2";
                break;

            case R.id.button3:
                s="Boton 3";
                break;
        }
        Toast.makeText(this," Mensaje de " + s, Toast.LENGTH_LONG).show();



    }
}
