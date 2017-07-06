package com.example.invent.doscosasyayjala;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.attr.start;

public class Consulta extends AppCompatActivity {
    String [] arreglo;
    ListView lista;
    protected  Object mActionMode;
    public int selectedItem=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        consulta();
        lista = (ListView)findViewById(R.id.Lista);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode!=null){
                    return false;
                }
                selectedItem=position;
                mActionMode = Consulta.this.startActionMode(amc);
                view.setSelected(true);
                return true;
            }
        });
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

    public void  consulta(){
        BaseHelper baseHelper = new BaseHelper(this,"Baseok", null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if (db!=null){
            Cursor c = db.rawQuery("select * from dbtabla", null);
            int cantidad = c.getCount();
            int i=0;
            arreglo = new String[cantidad];
            if (c.moveToFirst()){
                do{
                    String linea = c.getInt(0) + " " + c.getInt(1) + " " + c.getString(2) + " " + c.getInt(3)
                            + " " + c.getString(4) + " " + c.getString(5) + " " + c.getString(6) + " " + c.getString(7);
                    arreglo[i] = linea;
                    i++;
                }while (c.moveToNext());
            }
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arreglo);
            ListView lista = (ListView)findViewById(R.id.Lista);
            lista.setAdapter(adapter);
        }
    }
    private void Borrar(){
        BaseHelper baseHelper = new BaseHelper(this,"Baseok", null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        int id=Integer.parseInt(arreglo[selectedItem].split(" ")[0]);
        if (db!=null){
            long res = db.delete("dbtabla", "Id="+id,null);
            if (res>0){
                Toast.makeText(this,"Registro Eliminado",Toast.LENGTH_SHORT).show();
                consulta();
            }
        }
    }
}
