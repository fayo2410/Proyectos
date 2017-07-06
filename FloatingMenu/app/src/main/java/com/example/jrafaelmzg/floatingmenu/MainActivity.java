package com.example.jrafaelmzg.floatingmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class MainActivity extends AppCompatActivity {

    FloatingActionsMenu floatingActionsMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionsMenu = (FloatingActionsMenu)findViewById(R.id.multiple_action);
        floatingActionsMenu.collapse();

    }
}
