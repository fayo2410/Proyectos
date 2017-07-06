package com.example.lalo.suma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void suma (View V){
        int a,b,r;
        EditText n1,n2;
        n1=(EditText)findViewById(R.id.editTextNumero1);
        n2=(EditText)findViewById(R.id.editTextNumero2);
        a=Integer.parseInt(n1.getText().toString());
        b=Integer.parseInt(n2.getText().toString());
        r=a+b;
        Toast.makeText(this,"La suma es: "+ r,Toast.LENGTH_LONG).show();
    }
    public void resta (View V){
        int a,b,r;
        EditText n1,n2;
        n1=(EditText)findViewById(R.id.editTextNumero1);
        n2=(EditText)findViewById(R.id.editTextNumero2);
        a=Integer.parseInt(n1.getText().toString());
        b=Integer.parseInt(n2.getText().toString());
        r=a-b;
        Toast.makeText(this,"La resta es: "+ r,Toast.LENGTH_LONG).show();
    }
    public void multiplicacion (View V){
        int a,b,r;
        EditText n1,n2;
        n1=(EditText)findViewById(R.id.editTextNumero1);
        n2=(EditText)findViewById(R.id.editTextNumero2);
        a=Integer.parseInt(n1.getText().toString());
        b=Integer.parseInt(n2.getText().toString());
        r=a*b;
        Toast.makeText(this,"La multiplicacion es: "+ r,Toast.LENGTH_LONG).show();
    }
    public void division (View V){
        float a,b,r;
        EditText n1,n2;
        n1=(EditText)findViewById(R.id.editTextNumero1);
        n2=(EditText)findViewById(R.id.editTextNumero2);
        a=Integer.parseInt(n1.getText().toString());
        b=Integer.parseInt(n2.getText().toString());
        r=a/b;  ¿
        Toast.makeText(this,"La división es: "+ r,Toast.LENGTH_LONG).show();
    }
}
