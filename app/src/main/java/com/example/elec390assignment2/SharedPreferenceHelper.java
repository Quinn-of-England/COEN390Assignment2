package com.example.elec390assignment2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("ProfilePreference",
                Context.MODE_PRIVATE);
    }

    public void saveAge(int age) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("age", age);
        editor.commit();
    }

    public void saveID(int ID) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("ID", ID);
        editor.commit();
    }

    public void saveProfileName(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName", name);
        editor.commit();
    }

    public String getProfileName() {
        return sharedPreferences.getString("profileName", null);
    }

    public int getAge() {
        return sharedPreferences.getInt("age", 0);
    }

    public int getID() {
        return sharedPreferences.getInt("ID", 0);
    }

}
