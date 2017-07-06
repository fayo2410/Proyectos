package com.example.jrafaelmzg.ejemplosqlite1;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.ID;
public class MainActivity extends AppCompatActivity {
    Button in, con, del;
    TextView datos;
    EditText Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conexionsqlite conector = new conexionsqlite(this, "Tareas", null, 1);
        final SQLiteDatabase basedeDatos = conector.getWritableDatabase();

        in = (Button) findViewById(R.id.button);//insertar
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues nuevoregistro = new ContentValues();
                nuevoregistro.put("Nombre", "Rafael");
                nuevoregistro.put("Telefono", "2288540600");
                basedeDatos.insert("Alumnos", null, nuevoregistro);
                Toast.makeText(MainActivity.this, "Insertado", Toast.LENGTH_SHORT).show();
            }
        });


        con = (Button) findViewById(R.id.button2);//consultar
        datos = (TextView) findViewById(R.id.textView);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.setText(null);
                Cursor c = basedeDatos.rawQuery("SELECT * FROM Alumnos", null);
                if (c.moveToFirst()) {
                    do {
                        String res = c.getString(0);
                        String res2 = c.getString(1);
                        String res3 = c.getString(2);
                        datos.append("ID: " + res + "" + "- Nombre: " + res2 + "" + "- Telefono: " + res3 + "\n");
                    } while (c.moveToNext());
                }
            }
        });



        del = (Button) findViewById(R.id.button3);//eliminar
        Id = (EditText) findViewById(R.id.editText);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato = Id.getText().toString();
                basedeDatos.delete("Alumnos","ID="+dato,null);
                Toast.makeText(MainActivity.this, "Eliminado", Toast.LENGTH_SHORT).show();
                datos.setText(null);
            }
        });
    }
}
