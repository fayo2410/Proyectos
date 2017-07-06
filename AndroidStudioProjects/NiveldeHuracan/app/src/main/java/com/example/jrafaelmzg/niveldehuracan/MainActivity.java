package com.example.jrafaelmzg.niveldehuracan;

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
    public void nivel (View v){
        int n;
        EditText n1,n2;

        n1 = (EditText) findViewById(R.id.editText);



        n=Integer.parseInt(n1.getText().toString());
        if (n<=62){
            Toast.makeText(this, "Depresion Tropical",Toast.LENGTH_LONG).show();
        }
        if (n >=62 && n <=117){
            Toast.makeText(this, "Tormenta Tropical", Toast.LENGTH_LONG).show();
        }

        if (n >=118 && n <=153){
            Toast.makeText(this, "Huracan categoria 1", Toast.LENGTH_LONG).show();
        }

        if (n >=154 && n <=177){
            Toast.makeText(this, "Huracan categoria 2", Toast.LENGTH_LONG).show();
        }

        if (n >=178 && n <=209){
            Toast.makeText(this, "Huracan categoria 3", Toast.LENGTH_LONG).show();
        }

        if (n >=210 && n <=249){
            Toast.makeText(this, "Huracan categoria 4", Toast.LENGTH_LONG).show();
        }

        if (n >=250){
            Toast.makeText(this, "Huracan categoria 5 ¡¡¡PELIGRO!!!", Toast.LENGTH_LONG).show();
        }

    }
}
