package com.andreij.serversimulator;

import java.util.ArrayList;

public class database {
    private static ArrayList<String> serial ;
    private static ArrayList<String> name ;
    private static ArrayList<String> dob;
    private static ArrayList<String> sex;
    private static ArrayList<String> country;
    public void create() {
        serial = new ArrayList<String>();
        name = new ArrayList<String>();
        dob = new ArrayList<String>();
        sex = new ArrayList<String>();
        country = new ArrayList<String>();
    }
     public void add(String aSerial, String aName, String aDOB, String aSex, String aCountry){
         serial.add(aSerial);
         name.add(aName);
         dob.add(aDOB);
         sex.add(aSex);
         country.add(aCountry);
     }
    public int check(String sserial){
        int icheck = 0;
        if (serial.size() !=0){
            for (int i=0;  i<serial.size(); i++){
                if (sserial.equals(serial.get(i))){
                    icheck = 1;
                }
            }
        }
        return icheck;
    }
}
