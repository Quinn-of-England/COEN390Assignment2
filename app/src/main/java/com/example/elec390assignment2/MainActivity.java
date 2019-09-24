package com.example.elec390assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected Button profileButton;
    protected SharedPreferenceHelper sharedPreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.icon_launcher_round);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);
        profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfileViewer();
            }
        });
        String name = sharedPreferenceHelper.getProfileName();

        if(name == null)
            openProfileViewer();
        else
            profileButton.setText(name);

    }

    protected void onStart()
    {
        super.onStart();
        String name = sharedPreferenceHelper.getProfileName();

        Log.d("test",""+sharedPreferenceHelper.getProfileName());
//        Toast.makeText(getApplicationContext(), sharedPreferenceHelper.getProfileName(), Toast.LENGTH_SHORT).show();
        if(name == null)
            openProfileViewer();
        else
            profileButton.setText(name);
    }
    public void openProfileViewer(){
        Intent intent = new Intent(this,profileActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
//                Toast.makeText(this, "click..!!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
