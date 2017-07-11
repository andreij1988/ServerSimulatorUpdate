package com.andreij.serversimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent ianame;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.butAdd);
        add.setOnTouchListener(addn);
        ianame = new Intent(this, AddName.class);
        database database = new database();
        database.create();
    }
    private View.OnTouchListener addn = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            startActivity(ianame);
            return false;
        }
    };
}
