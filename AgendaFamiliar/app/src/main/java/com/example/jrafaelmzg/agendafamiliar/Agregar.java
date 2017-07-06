package com.example.jrafaelmzg.agendafamiliar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Familiar;

public class Agregar extends AppCompatActivity {

    EditText etNombre, etParentesco, etCelular, etCorreo;
    Button btnAgregar, btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        etNombre=(EditText)findViewById(R.id.textCompleto);
        etParentesco=(EditText)findViewById(R.id.textParentesco);
        etCelular=(EditText)findViewById(R.id.textCelular);
        etCorreo=(EditText)findViewById(R.id.textCorreo);

        btnAgregar=(Button)findViewById(R.id.btnAgregar);
        btnRegresar=(Button)findViewById(R.id.btnRegresar);


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar(v);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Agregar.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    public void agregar (View v){
        String nombreCompleto, parentesco, correElectronico, numeroCelular;
        nombreCompleto=etNombre.getText().toString();
        parentesco=etParentesco.getText().toString();
        correElectronico=etCorreo.getText().toString();
        numeroCelular=etCelular.getText().toString();
        Familiar familiar = new Familiar(nombreCompleto, parentesco, correElectronico,numeroCelular);
        if (Familiar.insertarFamiliar(this, familiar)>0){
            etNombre.setText("");
            etParentesco.setText("");
            etCorreo.setText("");
            etCelular.setText("");
            com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Dialog.show(this,"Se ha insertado");
        }else
            com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Dialog.show(this, "Error al insertar");
    }
    @Override
    public void onBackPressed(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
