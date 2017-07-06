package com.example.lalo.radiobuttontrescomparaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button aceptar;
    RadioButton ni,jo,adul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aceptar=(Button)findViewById(R.id.buttonAceptar);
        ni=(RadioButton)findViewById(R.id.radioButtonNiño);
        jo=(RadioButton)findViewById(R.id.radioButtonJoven);
        adul=(RadioButton)findViewById(R.id.radioButtonAdulto);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ni.isChecked()==true)
                    Toast.makeText(MainActivity.this, "Selecionaste NIÑO",Toast.LENGTH_LONG).show();
                if (jo.isChecked()==true)
                    Toast.makeText(MainActivity.this, "Selecionaste JOVEN",Toast.LENGTH_LONG).show();
                if (adul.isChecked()==true)
                    Toast.makeText(MainActivity.this, "Selecionaste ADULTO",Toast.LENGTH_LONG).show();
            }
        });
    }
}
