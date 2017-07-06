package com.example.jrafaelmzg.agendafamiliar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Familiar;

public class Actualizar extends AppCompatActivity {
    EditText id, nom, paren,corr, cel;
    Button Elim, Actuali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        Elim = (Button)findViewById(R.id.eliminarreg);
        Actuali = (Button)findViewById(R.id.actualizareg);

        id = (EditText)findViewById(R.id.idno);
        nom   = (EditText) findViewById(R.id.NCompleto);
        paren = (EditText) findViewById(R.id.Parentesco);
        corr = (EditText) findViewById(R.id.CorreoElectronico);
        cel   = (EditText) findViewById(R.id.Celular);

        //TRAER LOS DATOS CON BUNDLE Y CON SETTEXT
        Intent i = getIntent();
        Bundle b = i.getExtras();
        int idnum = b.getInt("_id");
        String ncompleto = b.getString("nombreFamiliar");
        String parent = b.getString("parentescoFamiliar");
        String corre = b.getString("correoFamiliar");
        String celu =b.getString("celularFamiliar");
        id.setText(idnum+"");
        nom.setText(ncompleto);
        paren.setText(parent);
        corr.setText(corre);
        cel.setText(celu);


        Elim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });

        Actuali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificar();
            }
        });
    }

    public void modificar(){
        String nombreCompleto, parentesco, correElectronico, numeroCelular;
        String s1=id.getText().toString();
        int n1= Integer.parseInt(s1);
        nombreCompleto=nom.getText().toString();
        parentesco=paren.getText().toString();
        correElectronico=cel.getText().toString();
        numeroCelular=corr.getText().toString();
        Familiar familiar = new Familiar(n1,nombreCompleto, parentesco, correElectronico,numeroCelular);
        if (Familiar.actualizarFamiliar(this, familiar)){
            id.setText("");
            nom.setText("");
            paren.setText("");
            cel.setText("");
            corr.setText("");
            com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Dialog.show(this,"Se ha actualizado");
        }else
            com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Dialog.show(this, "Error al actualizar");
    }
    public void eliminar(){
        String s1=id.getText().toString();
        int n1= Integer.parseInt(s1);
        if (Familiar.eliminarFamiliar(this, n1)) {
            id.setText("");
            nom.setText("");
            paren.setText("");
            cel.setText("");
            corr.setText("");
            com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Dialog.show(this, "Se ha eliminado");
        }else
            com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Dialog.show(this, "Error al eliminar");
    }
    public void onBackPressed(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
