package com.example.jrafaelmzg.obtenerimei;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TelephonyManager manager;
    TextView txtmensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtmensaje = (TextView)findViewById(R.id.tmensaje);
        manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        StringBuilder builder = new StringBuilder();
        builder.append("IMEI : ").append(manager.getDeviceId()).append("\n");
        builder.append("Nombre Operador : ").append(manager.getNetworkOperatorName()).append("\n");
        builder.append("Numero CEL : ").append(manager.getLine1Number()).append("\n");
        builder.append("prueba : ").append(manager.getSimOperatorName()).append("\n");

        txtmensaje.setText(builder.toString());

    }
}
