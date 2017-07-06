package com.example.jrafaelmzg.acttelefonos;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    Button agregar,consulta,eliminar,actualizar,buscar, limpiar;
    EditText id,marca,modelo,tamaño,descripcion;
    TextView tbdato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conexion con = new conexion(this, "TEL",null,1);
        final SQLiteDatabase bd = con.getWritableDatabase();

        id = (EditText)findViewById(R.id.txtid);
        marca = (EditText)findViewById(R.id.txtmarca);
        modelo = (EditText)findViewById(R.id.txtmodelo);
        tamaño = (EditText)findViewById(R.id.txttamaño);
        descripcion = (EditText)findViewById(R.id.txtdescripcion);
        agregar = (Button)findViewById(R.id.btnagregar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues newreg = new ContentValues();
                newreg.put("Id",id.getText().toString());
                newreg.put("Marca",marca.getText().toString());
                newreg.put("Modelo",modelo.getText().toString());
                newreg.put("Tamaño",tamaño.getText().toString());
                newreg.put("Descripcion",descripcion.getText().toString());
                bd.insert("Telefonos", null,newreg);
                limpiar();
                Toast.makeText(MainActivity.this,"Reg insertado",Toast.LENGTH_SHORT).show();
                Consulta();
            }
        });

        consulta = (Button)findViewById(R.id.btnconsul);
        tbdato = (TextView)findViewById(R.id.txviwconsul);
        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbdato.setText(null);
                Consulta();
            }
        });

        actualizar = (Button)findViewById(R.id.btnactualizar);
        id = (EditText)findViewById(R.id.txtid);
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actualizar();
            }
        });
        eliminar = (Button)findViewById(R.id.btneliminar);
        id =(EditText)findViewById(R.id.txtid);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String del = id.getText().toString();
                bd.delete("Telefonos","id= "+del,null);
                Toast.makeText(MainActivity.this,"Reg Eliminado",Toast.LENGTH_SHORT).show();
                tbdato.setText(null);
                limpiar();
                Consulta();
            }
        });

        buscar = (Button)findViewById(R.id.btnbuscar);
        id = (EditText)findViewById(R.id.txtid);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buscar = id.getText().toString();
                String [] datos;
                datos=buscar_reg(buscar);
                id.setText(datos[0]);
                marca.setText(datos[1]);
                modelo.setText(datos[2]);
                tamaño.setText(datos[3]);
                descripcion.setText(datos[4]);
            }
        });

        limpiar=(Button)findViewById(R.id.btnlimpiar);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
                tbdato.setText(null);
            }
        });

    }


    public String [] buscar_reg(String buscar){
        String[] datos= new String[5];
        conexion con = new conexion(this, "TEL",null,1);
        final SQLiteDatabase bd = con.getWritableDatabase();
        String q = "SELECT * FROM Telefonos WHERE id ='"+buscar+"'";
        Cursor registros = bd.rawQuery(q, null);
        if(registros.moveToFirst()){
            for(int i = 0 ; i<5;i++){
                datos[i]= registros.getString(i);
            }
            Toast.makeText(MainActivity.this,"Registro encontrado : " +buscar,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"No se encontró a " +buscar,Toast.LENGTH_SHORT).show();
        }
        return datos;
    }

    public void Consulta (){
        conexion con = new conexion(this, "TEL",null,1);
        final SQLiteDatabase bd = con.getWritableDatabase();
        tbdato.setText(null);
        Cursor c = bd.rawQuery("SELECT * FROM Telefonos", null);
        if (c.moveToFirst()) {
            do {
                String res = c.getString(0);
                String res2 = c.getString(1);
                String res3 = c.getString(2);
                String res4 = c.getString(3);
                String res5 = c.getString(4);
                tbdato.append("Id: " + res + "\nMarca:"+res2+"\nModelo:" +res3+"\nTamaño:"+res4+"\nDescripcion:"+res5+"\n");
            } while (c.moveToNext());
        }
    }

    public void Actualizar(){//Metodo para actualizar
        conexion con = new conexion(this, "TEL",null,1);
        final SQLiteDatabase bd = con.getWritableDatabase();
        tbdato.setText(null);
        String Id = id.getText().toString();
        String Marca = marca.getText().toString();
        String Modelo = modelo.getText().toString();
        String Tamaño = tamaño.getText().toString();
        String Descripcion = descripcion.getText().toString();
        ContentValues newreg = new ContentValues();
        newreg.put("Id",Id);
        newreg.put("Marca",Marca);
        newreg.put("Modelo",Modelo);
        newreg.put("Tamaño",Tamaño);
        newreg.put("Descripcion",Descripcion);
        bd.update("Telefonos",newreg,"Id="+Id,null);
        Consulta();
        limpiar();
        Toast.makeText(MainActivity.this,"Reg Modificado",Toast.LENGTH_SHORT).show();
    }

    public void limpiar(){
        id.setText(null);
        marca.setText(null);
        modelo.setText(null);
        tamaño.setText(null);
        descripcion.setText(null);
    }
}
