package com.example.lalo.reproducirmp3_2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View v){
        MediaPlayer reproSonido = MediaPlayer.create(this, R.raw.Sonido);
        reproSonido.start();
    }

}
