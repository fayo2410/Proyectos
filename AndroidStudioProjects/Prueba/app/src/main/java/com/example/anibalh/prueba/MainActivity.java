package com.example.anibalh.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button acep,acep2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acep=(Button)findViewById(R.id.button1);
        acep2=(Button)findViewById(R.id.button2);
        acep.setText("Mensaje 1");
        acep2.setText("Mensaje 2");

        acep.setOnClickListener(this);
        acep2.setOnClickListener(this);

    }

    public void onClick(View v){
        if(v.getId()==R.id.button1)
            Toast.makeText(MainActivity.this,"Mensaje del boton 1" , Toast.LENGTH_LONG).show();
        else if (v.getId()==R.id.button2)

            Toast.makeText(MainActivity.this,"Mensaje del boton 2" , Toast.LENGTH_LONG).show();
    }
}
