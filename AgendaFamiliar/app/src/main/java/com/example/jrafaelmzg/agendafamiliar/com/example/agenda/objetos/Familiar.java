package com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos;

import android.content.Context;
import android.database.Cursor;

import com.example.jrafaelmzg.agendafamiliar.com.example.agenda.DB.DBManager;

/**
 * Created by JRafaelMzG on 01/05/2017.
 */

public class Familiar {
    public int _id;
    public String nombreCompleto;
    public String parentesco;
    public String correoElectronico;
    public String numeroCelular;
    public Familiar (String nombreCompleto, String parentesco,
                     String correoElectronico, String numeroCelular){
        this.nombreCompleto = nombreCompleto;
        this.parentesco = parentesco;
        this.correoElectronico = correoElectronico;
        this.numeroCelular = numeroCelular;
    }
    public Familiar(int id, String nombreCompleto, String parentesco,
                    String correoElectronico, String numeroCelular ){
        this._id = id;
        this.nombreCompleto = nombreCompleto;
        this.parentesco = parentesco;
        this.correoElectronico = correoElectronico;
        this.numeroCelular = numeroCelular;
    }
    public static long insertarFamiliar(Context context, Familiar f){
        DBManager db = new DBManager(context);
        db.open();
        //Trabajar con db
        long _idFamiliarAgregado = db.insertarFamiliar(f);
        db.close();
        return _idFamiliarAgregado;
    }
    public static Familiar[] getAllFamiliares(Context context){
        Familiar [] misFamiliares = null;
        DBManager db = new DBManager(context);
        db.open();
        Cursor f = db.getAllFamiliares();
        if (f.moveToFirst()){
            misFamiliares = new Familiar[f.getCount()];//Crear posiciones para el arreglo
            int i = 0;
            do{
                misFamiliares[i] = new Familiar(f.getInt(0), f.getString(1),
                        f.getString(2), f.getString(3), f.getString(4));
                i++;
            }while (f.moveToNext());
        }
        db.close();
        return misFamiliares;
    }
    public static boolean eliminarFamiliar(Context context, int _idFamiliar){
        DBManager db = new DBManager(context);
        db.open();
        boolean familiareliminado = db.deleteFamiliar(_idFamiliar);
        db.close();
        return familiareliminado;
    }

    public static boolean actualizarFamiliar(Context context, Familiar newFamiliar){
        DBManager db = new DBManager(context);
        db.open();
        boolean familiarActualizado = db.updateFamiliar(newFamiliar);
        db.close();
        return familiarActualizado;

    }


}
