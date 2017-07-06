package com.example.jrafaelmzg.registroestacionamiento;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sem ,carre ;
    EditText no,nombre,grupo,vehiculo;
    Button agregar,consultar, eliminar;
    EditText txtsem, txtcarre ;
    String []items;
    String []items2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sem = (Spinner)findViewById(R.id.spsemestre);
        txtsem=(EditText)findViewById(R.id.txtvsem);//GUARDA EL DATO DEL SPINNER
        carre = (Spinner)findViewById(R.id.spcarrera);
        txtcarre= (EditText)findViewById(R.id.txtcarre);
        items = getResources().getStringArray(R.array.Semestre);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sem.setAdapter(adapter);
        items2 = getResources().getStringArray(R.array.Carrera);
        final ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,items2);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carre.setAdapter(adapter1);

        //Metodo para saber cual item se ha seleccionado
        carre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtcarre.setText(items2[position]);
                //Toast.makeText(getApplicationContext(),items[position],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtsem.setText(items[position]);
                //Toast.makeText(getApplicationContext(),items[position],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
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
                db.insertContact(no.getText().toString(),nombre.getText().toString(),grupo.getText().toString(),
                        txtsem.getText().toString(),txtcarre.getText().toString(), vehiculo.getText().toString());
                Toast.makeText(MainActivity.this , "Registro exitoso",Toast.LENGTH_SHORT).show();
                no.setText("");
                nombre.setText("");
                grupo.setText("");
                sem.setAdapter(adapter);
                carre.setAdapter(adapter1);
                vehiculo.setText("");
                db.close();
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
                        displayContact2(c);
                    }while(c.moveToNext());
                }
                db.close();
            }
        });

        eliminar = (Button)findViewById(R.id.button3);
        eliminar.setOnClickListener(new View.OnClickListener() {
            DBAdapter db=new DBAdapter(MainActivity.this);
            @Override
            public void onClick(View v) {
                db.open();
                db.deleteContact(Integer.parseInt(no.getText().toString()));
                db.close();
                no.setText("");
                Toast.makeText(MainActivity.this,"Reg Eliminado",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void displayContact2(Cursor c){
        Toast.makeText(this,
                "id: "+ c.getString(0)+ "\n"
                        + "Nombre: " + c.getString(1)+ "\n"
                        + "Grupo: " + c.getString(2)+"\n"
                        + "Semestre: " + c.getString(3)+"\n"
                        + "Carrera: " + c.getString(4)+"\n"
                        + "Vehiculo: " + c.getString(5)
                , Toast.LENGTH_LONG) .show();
    }
}
