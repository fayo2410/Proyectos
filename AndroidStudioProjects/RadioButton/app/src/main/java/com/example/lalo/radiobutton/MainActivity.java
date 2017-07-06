package com.example.lalo.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button aceptar;
    RadioButton mas,fem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aceptar=(Button)findViewById(R.id.buttonAceptar);
        mas=(RadioButton)findViewById(R.id.radioButtonMasculino);
        fem=(RadioButton)findViewById(R.id.radioButtonFemenino);
        aceptar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(mas.isChecked()==true)
                Toast.makeText(MainActivity.this,"Seleccionó Masculino", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this,"Seleccionó Femenino", Toast.LENGTH_SHORT).show();
        }
    });
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"Check Masculino", Toast.LENGTH_LONG).show();

            }
        });
        fem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Check Femenino", Toast.LENGTH_LONG).show();

            }
        });


    }
}

