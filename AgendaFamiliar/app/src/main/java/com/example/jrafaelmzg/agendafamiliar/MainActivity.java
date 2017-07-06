package com.example.jrafaelmzg.agendafamiliar;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos.Familiar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listaFamiliares;
    Button agrega;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaFamiliares = (ListView)findViewById(R.id.familiar_listafamilares);
        CargarFamiliares();

        agrega = (Button)findViewById(R.id.btnAgregar);
        agrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrir(v);
            }
        });
    }
    Familiar familares[] = null;
    ArrayList<String>mostrarFamiliar = new ArrayList<String>();
    public void CargarFamiliares(){
        familares = Familiar.getAllFamiliares(this);
        if (familares != null){
            for (Familiar familiar : familares){
                mostrarFamiliar.add(familiar.nombreCompleto + "(" + familiar.parentesco + ")\n"
                        + familiar.numeroCelular + "\n" + familiar.correoElectronico);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mostrarFamiliar);
        listaFamiliares.setAdapter(adapter);
        listaFamiliares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MostrarFamiliarDetalle(position);
            }
        });
    }
    public void MostrarFamiliarDetalle(int p){
        Bundle b = new Bundle();
        b.putInt("_id", familares[p]._id);
        b.putString("nombreFamiliar",familares[p].nombreCompleto);
        b.putString("parentescoFamiliar",familares[p].parentesco);
        b.putString("correoFamiliar",familares[p].correoElectronico);
        b.putString("celularFamiliar",familares[p].numeroCelular);
        Intent i = new Intent(MainActivity.this, Actualizar.class);
        i.putExtras(b);
        startActivity(i);
        //finish();

    }
    public void abrir (View v){
        Intent a = new Intent(this, Agregar.class);
            startActivity(a);
            finish();
    }
}













