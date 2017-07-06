package com.example.jrafaelmzg.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jrafaelmzg.navigationdrawer.com.example.directorio.DB.DBManager;
import com.example.jrafaelmzg.navigationdrawer.com.example.directorio.DB.FamiliarDB;
import com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Familiar;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;


public class Eliminar extends Fragment {

    ListView listaFamiliares;
    String [] arreglo;
    EditText filtro;
    protected Object mActionMode;
    public int selectedItem=-1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eliminar, container, false);

        listaFamiliares = (ListView)view.findViewById(R.id.listaagenda);
        filtro = (EditText)view.findViewById(R.id.textfiltro);
        CargarFamiliares();



        listaFamiliares.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode!=null){
                    return false;
                }
                selectedItem = position;
                mActionMode = getActivity().startActionMode(amc);
                view.setSelected(true);
                return true;
            }
        });

        return view;
    }
    private android.view.ActionMode.Callback amc = new android.view.ActionMode.Callback() {

        @Override
        public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_eliminar, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_borrar:
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }
        @Override
        public void onDestroyActionMode(android.view.ActionMode mode) {
            mActionMode=null;
            selectedItem=-1;
        }
    };


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
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mostrarFamiliar);
        listaFamiliares.setAdapter(adapter);


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

        Intent i = new Intent(getContext(), Elimina.class);
        i.putExtras(b);
        startActivity(i);


    }
}
