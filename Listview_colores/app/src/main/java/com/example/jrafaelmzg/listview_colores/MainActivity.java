package com.example.jrafaelmzg.listview_colores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colores = new String[]{"Rojo","Verde", "Azul","Verde"};

        ArrayAdapter<String>adapter;
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colores);

        ListView lv = (ListView)findViewById(R.id.lista);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Has seleccionado; " + colores[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
