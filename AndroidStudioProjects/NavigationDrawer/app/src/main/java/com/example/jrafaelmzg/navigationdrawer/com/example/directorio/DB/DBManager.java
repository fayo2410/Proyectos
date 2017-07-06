package com.example.jrafaelmzg.navigationdrawer.com.example.directorio.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos.Familiar;

/**
 * Created by JRafaelMzG on 01/05/2017.
 */

public class DBManager {
    //Base de datos
    static final String DATABASE_NAME ="myDB";
    static final int DATABASE_VERSION = 9 ;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    //Variables de contexto
    final Context context;
    public DBManager (Context ctx){
        this.context =ctx;
        DBHelper = new DatabaseHelper(context);
    }
    public DBManager open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        DBHelper.close();
    }
    private  static class DatabaseHelper extends SQLiteOpenHelper {
        @Override
        public void onCreate(SQLiteDatabase db){
            //Crea las tablas de BD
            db.execSQL(FamiliarDB.CREATE_TABLE);
        }
        @Override
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS " +FamiliarDB.TABLENAME);
            //Volver a crear
            onCreate(db);
        }
        DatabaseHelper(Context context){
            //Crea la BD
            super(context, DATABASE_NAME, null , DATABASE_VERSION);
        }
    }
    /**
     * METODO FAMILIAR
     */
    FamiliarDB familiarDB;

    public long insertarFamiliar(Familiar f){
        familiarDB = new FamiliarDB(db);
        return familiarDB.insert(f.nombreCompleto, f.numeroCelular, f.correoElectronico);
    }

    public Cursor getAllFamiliares(){
        familiarDB = new FamiliarDB(db);
        return familiarDB.getAll();
    }
    //borrar familiar por ID
    public boolean deleteFamiliar(int _idFamiliar){
        familiarDB = new FamiliarDB(db);
        return familiarDB.delete(_idFamiliar);
    }
    //actualizar familiar por DB
    public boolean updateFamiliar(Familiar newFamiliar){
        familiarDB = new FamiliarDB(db);
        return familiarDB.update(newFamiliar._id, newFamiliar.nombreCompleto,newFamiliar.numeroCelular,
                 newFamiliar.correoElectronico);
    }
}
