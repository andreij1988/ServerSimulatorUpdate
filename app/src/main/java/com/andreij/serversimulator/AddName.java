package com.andreij.serversimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static android.R.attr.data;
import static android.R.attr.name;
import static android.R.id.input;

public class AddName extends AppCompatActivity {

    Spinner sex;
    Spinner day;
    Spinner month;
    Spinner year;
    Button aname;
    String name;
    String dob;
    String ssex;
    String sday;
    String smonth;
    String syear;
    String country;
    String serial;
    int check;
    private ArrayList<String> asex;
    private ArrayList<String> aday;
    private ArrayList<String> amonth;
    private ArrayList<String> ayear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        Calendar calendar = Calendar.getInstance();
        int cyear = calendar.get(Calendar.YEAR);
        final EditText ename = (EditText) findViewById(R.id.editName);
        final EditText ecountry = (EditText) findViewById(R.id.editCountry);
        final EditText eserial = (EditText) findViewById(R.id.editSerial);
        final database database = new database();
        day = (Spinner) findViewById(R.id.spinnerDay);
        aday = new ArrayList<String>();
        aday.add("D");
        for (int i=1; i<32; i++){
            aday.add(Integer.toString(i));
        }
        ArrayAdapter<String> dataAdapterD = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,aday);
        day.setAdapter(dataAdapterD);
        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                sday = day.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        month = (Spinner) findViewById(R.id.spinnerMonth);
        amonth = new ArrayList<String>();
        amonth.add("M");
        for (int i=1; i<13; i++){
            amonth.add(Integer.toString(i));
        }
        ArrayAdapter<String> dataAdapterM = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,amonth);
        month.setAdapter(dataAdapterM);
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                smonth = month.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        year = (Spinner) findViewById(R.id.spinnerYear);
        ayear = new ArrayList<String>();
        ayear.add("Y");
        for (int i=1900; i<=cyear; i++){
            ayear.add(Integer.toString(i));
        }
        ArrayAdapter<String> dataAdapterY = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ayear);
        year.setAdapter(dataAdapterY);
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                syear = year.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
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
        aname = (Button) findViewById(R.id.butAdd);
        aname.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                name = ename.getText().toString();
                country = ecountry.getText().toString();
                serial = eserial.getText().toString();
                if (serial.equals("")) {
                    Toast.makeText(getApplicationContext(), "Input Employee Number", Toast.LENGTH_LONG).show();
                }
                else {
                    if (name.equals("")) {
                        Toast.makeText(getApplicationContext(), "Input a name please", Toast.LENGTH_LONG).show();
                    } else {
                        if (!sday.equals("D") && !smonth.equals("M") && !syear.equals("Y")) {
                            if (!ssex.equals("Any")) {
                                if (!country.equals("")) {
                                    check = database.check(serial);
                                    if (check == 0) {
                                        dob = sday + "/" + smonth + "/" + syear;
                                        database.add(serial, name, dob, ssex, country);
                                        Toast.makeText(getApplicationContext(), "Name added", Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Employee Already exists", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Input a country of origin please", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Input gender please", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Input correct date of birth", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }
}
