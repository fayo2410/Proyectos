package com.example.jrafaelmzg.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=((EditText)findViewById(R.id.txtuser)).getText().toString();
                String pass=((EditText)findViewById(R.id.txtpass)).getText().toString();
                EditText usuario=(EditText)findViewById(R.id.txtuser);
                EditText password=(EditText)findViewById(R.id.txtpass);

                if (user.equals("admin")&& pass.equals("ok")){
                    Intent me = new Intent(Login.this, Menu.class);
                    startActivity(me);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto" ,Toast.LENGTH_SHORT).show();
                    usuario.setText("");
                    password.setText("");
                }

            }
        });
    }


}
