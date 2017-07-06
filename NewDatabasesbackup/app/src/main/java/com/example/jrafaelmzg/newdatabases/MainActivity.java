package com.example.jrafaelmzg.newdatabases;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBAdapter db= new DBAdapter(this);
        db.open();
        long id= db.insertContact("Jorge Ramos", "jorger54@hotmail.com");
        id=db.insertContact("Itzayanna", "janyta@gmail.com");
        id=db.insertContact("José Rafael","fayo2410@hotmail.com");

        Cursor c=db.getAllContacts();
        if(c.moveToFirst())
        {
            do
            {
                displayContact(c);
            }while(c.moveToNext());
        }
        db.close();
    }
    public void displayContact(Cursor c){
        Toast.makeText(this,
                "id: "+ c.getInt(0)+ "\n"
                        + "Nombre: " + c.getString(1)+ "\n"
                        + "Correo: "+ c.getString(2)  , Toast.LENGTH_LONG) .show();
    }

}
