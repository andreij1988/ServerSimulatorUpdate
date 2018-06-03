package com.andreij.serversimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BasicSearch extends AppCompatActivity {
    Button fworker;
    Button asearch;
    EditText wnumber;
    String swnumber;
    int check;
    database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new database(this);
        wnumber = (EditText)findViewById(R.id.editENumber);
        setContentView(R.layout.activity_basic_search);
        fworker  = (Button) findViewById(R.id.bFEmployee);
        fworker.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                swnumber = wnumber.getText().toString();
                if (check == 0){

                }
                else {
                    Toast.makeText(getApplicationContext(), "Employee does not exist", Toast.LENGTH_LONG).show();
                }
            }
        });
        asearch  = (Button) findViewById(R.id.bAdvance);
        asearch.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
            }
        });
    }
}
