package com.example.elec390assignment2;


import android.content.Context;

public class profile {
    protected  String Name;
    protected  int age ;
    protected  int ID;
    protected SharedPreferenceHelper sharedPreferenceHelper;

    public  profile (Context context){
        sharedPreferenceHelper = new SharedPreferenceHelper(context);
        age=sharedPreferenceHelper.getAge();
        ID=sharedPreferenceHelper.getID();
        Name=sharedPreferenceHelper.getProfileName();
    }

    public void saveProfile(String name1, int age1, int ID1) {
        sharedPreferenceHelper.saveProfileName(name1);
        sharedPreferenceHelper.saveAge(age1);
        sharedPreferenceHelper.saveID(ID1);
        age=age1;
        ID=ID1;
        Name=name1;
    }


    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }



}
