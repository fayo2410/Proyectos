package com.example.jrafaelmzg.acttelefonos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JRafaelMzG on 18/02/2017.
 */

public class conexion extends SQLiteOpenHelper{
    public conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE 'Telefonos'('Id'INTEGER PRIMARY KEY,'Marca'TEXT,'Modelo'TEXT,'Tamaño'TEXT,'Descripcion'TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Telefonos");
        db.execSQL("CREATE TABLE 'Telefonos'('Id'INTEGER PRIMARY KEY,'Marca'TEXT,'Modelo'TEXT,'Tamaño'TEXT,'Descripcion'TEXT)");
    }
}
