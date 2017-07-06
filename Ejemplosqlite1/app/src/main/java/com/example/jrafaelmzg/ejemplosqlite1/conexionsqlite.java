package com.example.jrafaelmzg.ejemplosqlite1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JRafaelMzG on 04/02/2017.
 */

public class conexionsqlite extends SQLiteOpenHelper {


    public conexionsqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE 'Alumnos'('Id'INTEGER PRIMARY KEY,'Nombre'TEXT,'Telefono'TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Alumnos");
        db.execSQL("CREATE TABLE 'Alumnos'('Id'INTEGER PRIMARY KEY,'Nombre'TEXT,'Telefono'TEXT)");
    }
}
