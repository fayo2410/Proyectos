package com.example.invent.doscosasyayjala;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;


public class BaseHelper extends SQLiteOpenHelper {
    String tabla="CREATE TABLE dbtabla(Id INTEGER PRIMARY KEY AUTOINCREMENT, CBARRAS INTEGER, NOMBRE TEXT, COSTO INTEGER, RESPONSABLE TEXT, UBICACION TEXT, DESCRIPCION TEXT, OBSERVACIONES TEXT)";
    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
