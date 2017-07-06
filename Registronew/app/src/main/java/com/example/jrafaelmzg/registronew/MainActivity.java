package com.example.jrafaelmzg.registronew;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBAdapater db = new DBAdapater(this);
    /*Spinner sem ,carre ;
    EditText no,nombre,grupo,vehiculo;*/
    Button agregar,consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db.open();
        /*sem = (Spinner)findViewById(R.id.spsemestre);
        carre = (Spinner)findViewById(R.id.spcarrera);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.Semestre, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource
                (this, R.array.Carrera, android.R.layout.simple_spinner_item);

        sem.setAdapter(adapter);
        carre.setAdapter(adapter2);

        no = (EditText)findViewById(R.id.txtno);
        nombre =(EditText)findViewById(R.id.txtnombre);
        grupo= (EditText)findViewById(R.id.txtgrupo);
        vehiculo = (EditText)findViewById(R.id.txtvehiculo);*/


        consultar = (Button) findViewById(R.id.btnconsultar);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor c = db.getContact(1);
                if (c.moveToFirst()) {
                    do {
                        displayContact(c);
                    } while (c.moveToNext());
                }
                db.close();
            }
        });
    }

        public void displayContact(Cursor c){


            Toast.makeText(MainActivity.this, "id: "+ c.getInt(0)+ "\n"+ "Nombre: " + c.getString(1)+ "\n"+ "Correo: "+ c.getString(2),Toast.LENGTH_LONG).show();

                /*Toast.makeText(MainActivity.this,
                        "no: "+ c.getString(0)+ "\n" + "Nombre: " + c.getString(1)+ "\n" + "Grupo: "+ c.getString(2)+ "Semestre: "+ c.getString(3)
                                + "Carrera: "+ c.getString(4)+ "Vehiculo: "+ c.getString(5), Toast.LENGTH_LONG).show();*/
        }


}
