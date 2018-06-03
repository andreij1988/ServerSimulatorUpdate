package com.andreij.serversimulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddName extends AppCompatActivity {

    Spinner sex;

    Spinner occupation;
    Button aname;
    String name;
    String ssex;
    String serial;
    String soccupation;
    int check;
    int iserial;
    private ArrayList<String> asex;
    private ArrayList<String> aoccupation;
    private database mydb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        Calendar calendar = Calendar.getInstance();
        int cyear = calendar.get(Calendar.YEAR);
        final EditText ename = (EditText) findViewById(R.id.editName);
        final EditText eserial = (EditText) findViewById(R.id.editSerial);
        mydb = new database(this);
        sex = (Spinner) findViewById(R.id.spinnerSex);
        asex = new ArrayList<String>();
        asex.add("Any");
        asex.add("Male");
        asex.add("Female");
        ArrayAdapter<String> dataAdapterS = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,asex);
        sex.setAdapter(dataAdapterS);
        sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ssex = sex.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        occupation = (Spinner) findViewById(R.id.spinnerOccupation);
        aoccupation = new ArrayList<String>();
        aoccupation.add("Any");
        aoccupation.add("Manager");
        aoccupation.add("Worker");
        aoccupation.add("Team Lead");
        ArrayAdapter<String> dataAdapterO = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,aoccupation);
        occupation.setAdapter(dataAdapterO);
        occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                soccupation = occupation.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        aname = (Button) findViewById(R.id.butAdd);
        aname.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                name = ename.getText().toString();
                serial = eserial.getText().toString();
                if (serial.equals("")) {
                    Toast.makeText(getApplicationContext(), "Input Employee Number", Toast.LENGTH_LONG).show();
                }
                else if(serial.length() < 6){
                    Toast.makeText(getApplicationContext(),"Employee Number must be 6 digits long, please use 0 in front if the number is less than 6", Toast.LENGTH_LONG).show();
                }
                else if(serial.equals("000000")) {
                    Toast.makeText(getApplicationContext(),"Employee Number cannot be 0", Toast.LENGTH_LONG).show();
                }
                else {
                    if (name.equals("")) {
                        Toast.makeText(getApplicationContext(), "Input a name please", Toast.LENGTH_LONG).show();
                    } else {
                        if (!ssex.equals("Any")) {
                            if (!soccupation.equals("Any")) {
                                iserial = Integer.parseInt(serial);
                                mydb.insertContact(iserial, name, ssex, soccupation);
                                Toast.makeText(getApplicationContext(), "Name added", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Input a occupation please", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Input gender please", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }
}
