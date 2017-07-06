package com.example.jrafaelmzg.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Familiar;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;


public class Busqueda extends Fragment {

    ListView listaFamiliares;
    EditText filtro;

    public Busqueda(){

    }

    FloatingActionMenu floatingActionMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busqueda, container, false);
        listaFamiliares = (ListView)view.findViewById(R.id.listaagenda);
        filtro = (EditText)view.findViewById(R.id.textfiltro);
        CargarFamiliares();

        return view;
    }

    Familiar familares[] = null;
    ArrayList<String> mostrarFamiliar = new ArrayList<String>();
    //Metodo cargar lista
    public void CargarFamiliares() {
        familares = Familiar.getAllFamiliares(getContext());
        if (familares != null) {
            for (Familiar familiar : familares) {
                mostrarFamiliar.add("Nombre: " +familiar.nombreCompleto + "\n"
                        +"Número: " + familiar.numeroCelular + "\n" + "Correo: " +familiar.correoElectronico);
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mostrarFamiliar);
        listaFamiliares.setAdapter(adapter);

        filtro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                int posicion = position;

                String itemValue = (String) listaFamiliares.getItemAtPosition(posicion);
                //Toast.makeText(this, lista.getItemAtPosition(), Toast.LENGTH_LONG).show();
            }
        });


        listaFamiliares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MostrarFamiliarDetalle(position);
            }
        });
    }

    //Metodo pasar datos a la siguiente activity para ver la informacion del contacto
    public void MostrarFamiliarDetalle(int p) {
        Bundle b = new Bundle();
        b.putInt("_id", familares[p]._id);
        b.putString("nombreFamiliar", familares[p].nombreCompleto);
        b.putString("celularFamiliar", familares[p].numeroCelular);
        b.putString("correoFamiliar", familares[p].correoElectronico);

        Intent i = new Intent(getActivity(), Actualiza.class);
        i.putExtras(b);
        startActivity(i);


    }





}
