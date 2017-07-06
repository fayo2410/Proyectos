package com.example.lalo.tipohuracan;

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
    public void velocidad(View V) {
        int a;
        EditText n1, n2;

        n1 = (EditText) findViewById(R.id.editText);



        a=Integer.parseInt(n1.getText().toString());
        if (a <=62){
            Toast.makeText(this, "Categoria: DEPRESION TROPICAL", Toast.LENGTH_LONG).show();
            }

         if (a >=62 && a <=117){
            Toast.makeText(this, "Categoria: TORMETA TROPICAL", Toast.LENGTH_LONG).show();
         }

             if (a >=118 && a <=153){
            Toast.makeText(this, "Huracan categoria I", Toast.LENGTH_LONG).show();
                }

                  if (a >=154 && a <=177){
                    Toast.makeText(this, "Huracan categoria II", Toast.LENGTH_LONG).show();
                    }

                        if (a >=178 && a <=209){
                         Toast.makeText(this, "Huracan categoria III", Toast.LENGTH_LONG).show();
                        }

                             if (a >=210 && a <=249){
                               Toast.makeText(this, "Huracan categoria IV", Toast.LENGTH_LONG).show();
                              }

                                  if (a >=250){
                                     Toast.makeText(this, "Huracan categoria V", Toast.LENGTH_LONG).show();
                                     }


    }

}
