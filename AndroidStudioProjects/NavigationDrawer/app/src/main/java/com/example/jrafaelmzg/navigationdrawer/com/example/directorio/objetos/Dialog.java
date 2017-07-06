package com.example.jrafaelmzg.navigationdrawer.com.example.directorio.objetos;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.BaseTransientBottomBar;

import javax.xml.datatype.Duration;

/**
 * Created by JRafaelMzG on 01/05/2017.
 */

public class Dialog {
    public static void show (Context context, String mensage){
        AlertDialog.Builder dialogo= new AlertDialog.Builder(context);
        dialogo.setMessage(mensage);
        dialogo.setPositiveButton("Aceptar",null);
        AlertDialog okok = dialogo.create();
        okok.show();
    }
}
