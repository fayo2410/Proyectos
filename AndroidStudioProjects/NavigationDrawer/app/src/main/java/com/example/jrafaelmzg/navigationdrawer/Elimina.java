package com.example.jrafaelmzg.navigationdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Familiar;

public class Elimina extends AppCompatActivity {

    EditText id, nom, corr, cel;
    com.github.clans.fab.FloatingActionButton eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimina2);


        eliminar = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.fabeliminar);


        id = (EditText)findViewById(R.id.idno);
        nom   = (EditText) findViewById(R.id.NCompleto);
        cel   = (EditText) findViewById(R.id.Celular);
        corr = (EditText) findViewById(R.id.CorreoElectronico);


        //TRAER LOS DATOS CON BUNDLE Y CON SETTEXT
        Intent i = getIntent();
        Bundle b = i.getExtras();
        int idnum = b.getInt("_id");
        String ncompleto = b.getString("nombreFamiliar");
        String celu =b.getString("celularFamiliar");
        String corre = b.getString("correoFamiliar");
        id.setText(idnum+"");
        nom.setText(ncompleto);
        cel.setText(celu);
        corr.setText(corre);


        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });

    }

    public void abrir (){
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
        //finish();
    }

    public void eliminar(){
        String s1=id.getText().toString();
        int n1= Integer.parseInt(s1);
        if (Familiar.eliminarFamiliar(this, n1)) {
            id.setText("");
            nom.setText("");
            cel.setText("");
            corr.setText("");
            //com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Dialog.show(this, "Se ha eliminado");
            Toast.makeText(this, "El Contacto se ha Eliminado",Toast.LENGTH_LONG).show();
            abrir();
        }else
            com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Dialog.show(this, "Error al eliminar");

    }
    public void onBackPressed(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}
