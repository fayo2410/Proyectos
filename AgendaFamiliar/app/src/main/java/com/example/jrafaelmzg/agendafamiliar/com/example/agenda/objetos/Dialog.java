package com.example.jrafaelmzg.agendafamiliar.com.example.agenda.objetos;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by JRafaelMzG on 01/05/2017.
 */

public class Dialog {
    public static void show (Context context, String mensage){
        AlertDialog.Builder dialogo= new AlertDialog.Builder(context);
        dialogo.setMessage(mensage);
        dialogo.setPositiveButton("Aceptar", null);
        AlertDialog okok = dialogo.create();
        okok.show();
    }
}
