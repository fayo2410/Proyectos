package com.example.win10pro.inventariook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText nombre, apellido, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
        edad=(EditText)findViewById(R.id.edad);
    }
    public void Guardardatos (View view){
        String nom = nombre.getText().toString();
        String ape = apellido.getText().toString();
        int ed = Integer.parseInt(edad.getText().toString());

        BaseHelper baseHelper = new BaseHelper(this, "DEMODB",null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if (db!=null){
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("Nombre",nom);
            registronuevo.put("Apellido",ape);
            registronuevo.put("Edad",ed);
            long i = db.insert("Personas",null,registronuevo);
            if (i>0){
                Toast.makeText(this,"Registro insertado",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_login,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id==R.id.actions_settings){
            return true;
        }

        if (id==R.id.actions_listar) {
            startActivity(new Intent(this, Segunda.class));

        }


        return super.onOptionsItemSelected(item);
    }
}
