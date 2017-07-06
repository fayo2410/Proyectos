package com.example.jrafaelmzg.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Familiar;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import static com.example.jrafaelmzg.navigationdrawer.R.layout.fragment_agregar;

public class Agregar extends Fragment {

    EditText etNombre, etCelular, etCorreo;
    FloatingActionMenu Menuu;
    FloatingActionButton Agregar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(fragment_agregar, container, false);
        etNombre=(EditText)view.findViewById(R.id.textCompleto);
        etCelular=(EditText)view.findViewById(R.id.textCelular);
        etCorreo=(EditText)view.findViewById(R.id.textCorreo);
        Menuu = (FloatingActionMenu)view.findViewById(R.id.menuAgregar);
        Menuu.setClosedOnTouchOutside(true);

        Agregar = (FloatingActionButton) view.findViewById(R.id.fabguardar);
        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();
                //Toast.makeText(Agregar.this.getActivity(),"Hola voy a guardar",Toast.LENGTH_SHORT).show();
                //com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Dialog.show(Agregar.this.getActivity(), "Se ha insertado");
            }
        });

        return view;
    }


    public void agregar (){
        String nombreCompleto, numeroCelular,correElectronico;
        nombreCompleto=etNombre.getText().toString();
        numeroCelular=etCelular.getText().toString();
        correElectronico=etCorreo.getText().toString();
        Familiar familiar = new Familiar(nombreCompleto,numeroCelular, correElectronico);
        if (Familiar.insertarFamiliar(getContext(), familiar)>0){
            etNombre.setText("");
            etCorreo.setText("");
            etCelular.setText("");
            com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Dialog.show(Agregar.this.getActivity(),"Se ha insertado");
        }else
            com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Dialog.show(Agregar.this.getActivity(), "Error al insertar");
    }





}
