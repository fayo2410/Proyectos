package com.example.jrafaelmzg.agendafamiliar.com.example.agenda.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by JRafaelMzG on 01/05/2017.
 */

public class FamiliarDB {
    SQLiteDatabase db;
    public static final String TABLENAME = "FAMILIAR";
    public static final String _IDFAMILIAR = "_id";
    public static final String NOMBRE_COMPLETO = "nombreCompleto";
    public static final String PARENTESCO = "parentesco";
    public static final String CORREO_ELECTRONICO = "correoElectronico";
    public static final String NUMERO_CELULAR = "numeroCelular";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLENAME
            + "("
            + _IDFAMILIAR + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOMBRE_COMPLETO + " TEXT NOT NULL, "
            + PARENTESCO + " TEXT NOT NULL, "
            + CORREO_ELECTRONICO + " TEXT NOT NULL, "
            + NUMERO_CELULAR + " TEXT NOT NULL" +");";

    public FamiliarDB(SQLiteDatabase db){
        this.db = db;
    }

    //insertar registro
    public long insert (String nombreCompleto, String parentesco,
                        String correoElectronico, String numeroCelular ){
        ContentValues data = new ContentValues();
        data.put(NOMBRE_COMPLETO, nombreCompleto);
        data.put(PARENTESCO, parentesco);
        data.put(CORREO_ELECTRONICO, correoElectronico);
        data.put(NUMERO_CELULAR, numeroCelular);
        return db.insert(TABLENAME, null, data);
    }

    //Consultar
    public Cursor getAll(){
        return db.query(TABLENAME,null,null,null,null,null,null);
    }

    //Eliminar Registro
    public boolean delete(int _idFamiliar){
        return db.delete(TABLENAME, _IDFAMILIAR + "=" + _idFamiliar, null)>0 ;
    }

    //Actualizar Registro
    public boolean update (int _idFamiliar, String nombreCompleto, String parentesco,
                           String numeroCelular, String correoElectronico){
        ContentValues args = new ContentValues();
        args.put(NOMBRE_COMPLETO, nombreCompleto);
        args.put(PARENTESCO, parentesco);
        args.put(CORREO_ELECTRONICO, correoElectronico);
        args.put(NUMERO_CELULAR, numeroCelular);
        return db.update(TABLENAME, args, _IDFAMILIAR + "=" + _idFamiliar, null)>0;
    }
}
