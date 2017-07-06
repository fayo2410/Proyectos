package com.example.jrafaelmzg.miestacionamiento;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.AppCompatSpinner;

public class MainActivity extends AppCompatActivity {
    DBAdapter db = new DBAdapter(this);
    Spinner sem ,carre ;
    EditText no,nombre,grupo,vehiculo;
    Button agregar,consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sem = (Spinner)findViewById(R.id.spsemestre);
        carre = (Spinner)findViewById(R.id.spcarrera);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.Semestre, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource
                (this, R.array.Carrera, android.R.layout.simple_spinner_item);
        sem.setAdapter(adapter);
        carre.setAdapter(adapter2);

        no = (EditText)findViewById(R.id.txtno);
        nombre =(EditText)findViewById(R.id.txtnombre);
        grupo= (EditText)findViewById(R.id.txtgrupo);
        vehiculo = (EditText)findViewById(R.id.txtvehiculo);

        agregar = (Button)findViewById(R.id.btnadd);
        agregar.setOnClickListener(new View.OnClickListener() {
            DBAdapter db = new DBAdapter(MainActivity.this);
            @Override
            public void onClick(View v) {
                db.open();
                db.insertContact(no.getText().toString(),nombre.getText().toString(),
                        grupo.getText().toString(),sem.toString(), carre.toString(),
                        vehiculo.getText().toString());

                Toast.makeText(MainActivity.this , "Registro exitoso",Toast.LENGTH_LONG).show();
            }
        });

        consultar = (Button)findViewById(R.id.btnconsultar);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBAdapter db= new DBAdapter(MainActivity.this);
                db.open();
                Cursor c=db.getAllContacts();
                if(c.moveToFirst())
                {
                    do
                    {
                        displayContact(c);
                    }while(c.moveToNext());
                }
                db.close();
            }
        });
    }
    public void displayContact(Cursor c){
        Toast.makeText(MainActivity.this,
                "no: "+ c.getString(0)+ "\n" + "Nombre: " + c.getString(1)+ "\n" + "Grupo: "+ c.getString(2)+"\n"+ "Semestre: "+ c.getString(3)
                        +"\n"+ "Carrera: "+ c.getString(4)+"\n"+ "Vehiculo: "+ c.getString(5), Toast.LENGTH_LONG).show();
    }

}
