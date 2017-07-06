package com.example.lalo.numerosprimos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.ArrayList;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListViewNumeros;
    EditText EditTextNumero1,EditTextNumero2;
    Button ButtonCalcular;
    //RadioButton RadioButtonPrimos;
    List<String> item= null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewNumeros= (ListView)findViewById(R.id.listView_Numeros);
        EditTextNumero1= (EditText)findViewById(R.id.editTextNumero1);
        EditTextNumero2= (EditText)findViewById(R.id.editTextNumero2);
        //RadioButtonPrimos =(RadioButton)findViewById(R.id.radioButton_Primo);
        ButtonCalcular= (Button)findViewById(R.id.button_Calcular);
        ButtonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumerosPrimos();
            }
        });

    }
    private void NumerosPrimos(){
        String valor1;
        String valor2;
        int NumInicio,NumFinal,contador,contador2 =0, contador3= 0;

        valor1= EditTextNumero1.getText().toString();
        valor2= EditTextNumero2.getText().toString();

        if (valor1.equals("")){
            Mensaje();
            EditTextNumero1.requestFocus();


        }else {
            NumInicio= Integer.parseInt(valor1);
            NumFinal= Integer.parseInt(valor2);
            String[]Primos =new String[NumFinal];
            item =new ArrayList<String>();
            contador2=0;
            contador3=0;
            for (int i = NumInicio; i< NumFinal; i++){
                contador=0;
                for (int j = 1; j<=i; j++){
                    if (i%j ==0){
                        contador++;
                    }
                }
                if (contador == 2){
                    //if (RadioButtonPrimos.isChecked())
                    Primos[contador2]=String.valueOf(i);
                    String numeros1 =Primos[contador2];
                    item.add("Numero Primo:" + numeros1);
                    contador2++;

                }
            }

            ArrayAdapter<String> adaptador =
                    new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1,item);
            ListViewNumeros.setAdapter(adaptador);


        }
    }

    public void Mensaje (){
        Toast toast= Toast.makeText(this, "Ingrese un valor",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();

    }

}