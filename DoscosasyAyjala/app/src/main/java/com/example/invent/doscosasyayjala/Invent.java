package com.example.invent.doscosasyayjala;

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

public class Invent extends AppCompatActivity {
    EditText cod,nom,cost,res,ubi,des,obs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invent);
        cod=(EditText)findViewById(R.id.codbarras);
        nom=(EditText)findViewById(R.id.nombre);
        cost=(EditText)findViewById(R.id.costo);
        res=(EditText)findViewById(R.id.responsable);
        ubi=(EditText)findViewById(R.id.ubicacion);
        des=(EditText)findViewById(R.id.descripcion);
        obs=(EditText)findViewById(R.id.observaciones);
    }
    public void Guardar (View v){
        int codbarras = Integer.parseInt(cod.getText().toString());
        String nombre = nom.getText().toString();
        int costo = Integer.parseInt(cost.getText().toString());
        String responsable = res.getText().toString();
        String ubicacion = ubi.getText().toString();
        String descripcion = des.getText().toString();
        String observaciones = obs.getText().toString();

        BaseHelper baseHelper = new BaseHelper(this,"Baseok", null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if (db!=null){
            ContentValues newreg = new ContentValues();
            newreg.put("CBARRAS", codbarras);
            newreg.put("NOMBRE",nombre);
            newreg.put("COSTO",costo);
            newreg.put("RESPONSABLE",responsable);
            newreg.put("UBICACION",ubicacion);
            newreg.put("DESCRIPCION",descripcion);
            newreg.put("OBSERVACIONES",observaciones);
            long i = db.insert("dbtabla",null,newreg);
            if (i>0){
                Toast.makeText(this,"Registro guardado", Toast.LENGTH_SHORT).show();
                cod.setText("");
                nom.setText("");
                cost.setText("");
                res.setText("");
                ubi.setText("");
                des.setText("");
                obs.setText("");
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_invent,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_consultar){
            startActivity(new Intent(this,Consulta.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
