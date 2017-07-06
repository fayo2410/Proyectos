package com.example.win10pro.inventariook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Segunda extends AppCompatActivity {
    String []arreglo;
    ListView lista;
    protected Object mActionMode;
    public int selected=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        cargar();
        lista=(ListView)findViewById(R.id.Lista);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode!=null){
                    return false;
                }
                selected=position;
                mActionMode = Segunda.this.startActionMode(amc);
                view.setSelected(true);
                return true;
            }
        });
    }

    public void cargar(){

        BaseHelper baseHelper = new BaseHelper(this, "DEMODB",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db!=null){
            Cursor c = db.rawQuery("select * from Personas", null);
            int cantidad = c.getCount();
            int i=0;
            arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do {
                    String linea = c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getInt(3);

                    arreglo[i]=linea;
                    i++;

                }while (c.moveToNext());
            }
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arreglo);
            ListView lista = (ListView)findViewById(R.id.Lista);
            lista.setAdapter(adapter);
        }
    }
    private ActionMode.Callback amc = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_segunda,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
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
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode=null;
            selected=-1;
        }
    };

    private void Borrar(){
        BaseHelper baseHelper = new BaseHelper(this, "DEMODB",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        int id = Integer.parseInt(arreglo[selected].split(" ")[0]);
        if (db!=null){
            long res = db.delete("Personas","Id="+id,null);
            if (res>0){
                Toast.makeText(this,"Registro eliminado",Toast.LENGTH_SHORT).show();
                cargar();
            }
        }
    }
}
