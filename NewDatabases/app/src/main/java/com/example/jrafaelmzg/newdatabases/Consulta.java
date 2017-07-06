package com.example.jrafaelmzg.newdatabases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Consulta extends AppCompatActivity {

    String [] arreglo;
    ListView lista;
    protected Object mActionMode;
    public int selectedItem=-1;
    EditText edtBuscar;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        edtBuscar=(EditText)findViewById(R.id.edtFl);
        consulta();
        lista = (ListView)findViewById(R.id.Listconsulta);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode!=null){
                    return false;
                }
                selectedItem = position;
                mActionMode = Consulta.this.startActionMode(amc);
                view.setSelected(true);
                return true;
            }
        });
    }
    public void  consulta(){
        DBAdapter.DataBaseHelper dataBaseHelper=new DBAdapter.DataBaseHelper(this);
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        if (db!=null){
            Cursor c = db.rawQuery("select * from lugares ", null);
            int cantidad = c.getCount();
            int i=0;
            arreglo = new String[cantidad];
            if (c.moveToFirst()){
                do{
                    String linea = c.getString(0) + " " + c.getString(1) + " " + c.getString(2) + " "
                            + c.getString(3) + " " +c.getString(4)+ " " + c.getString(5);
                    arreglo[i] = linea;
                    i++;
                }while (c.moveToNext());
            }
            //ArrayAdapter<String>
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arreglo);
            //ListView
            lista = (ListView)findViewById(R.id.Listconsulta);
            lista.setAdapter(adapter);

            edtBuscar.addTextChangedListener(new TextWatcher() {
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

                    String itemValue = (String) lista.getItemAtPosition(posicion);
                    //Toast.makeText(this, lista.getItemAtPosition(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private android.view.ActionMode.Callback amc = new android.view.ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_consulta,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_borrar:
                    Borrar();
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


    private void Borrar(){
        DBAdapter.DataBaseHelper dataBaseHelper=new DBAdapter.DataBaseHelper(this);
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        int rowId=Integer.parseInt(arreglo[selectedItem].split(" ")[0]);
        if (db!=null){
            //db.delete("lugares", "id="+rowId,null);
            long res = db.delete("lugares", "_id="+rowId,null);
            if (res>0){
                Toast.makeText(this,"Registro Eliminado",Toast.LENGTH_SHORT).show();
                consulta();
            }
        }
    }
}
