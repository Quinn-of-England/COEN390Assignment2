package com.example.elec390assignment2;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class profileActivity extends AppCompatActivity {

    EditText age;
    EditText studentID;
    EditText name;
    Button editButton;
    Context context;
    protected SharedPreferenceHelper sharedPreferenceHelper;
    protected profile Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = getApplicationContext();
//        sharedPreferenceHelper = new SharedPreferenceHelper(profileActivity.this);
        Profile= new profile(profileActivity.this);

        //age constraint
        age = findViewById(R.id.age);
        name = findViewById(R.id.name);
        studentID = findViewById(R.id.student_id);

        //back button
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        //set edit text as false
        studentID.setFocusableInTouchMode(false);
        studentID.setFocusable(false);
        age.setFocusableInTouchMode(false);
        age.setFocusable(false);
        name.setFocusableInTouchMode(false);
        name.setFocusable(false);

//                editButton
        editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProfileViewer();

            }
        });
        //editText
//        Log.d("test",Profile.getName());
        if (Profile.getName()==null) {
        } else {
            name.setText(Profile.getName());
            age.setText("" + Profile.getAge());
            studentID.setText("" + Profile.getID());
        }


    }

    public void saveProfileViewer() {
        try {
            if (Integer.parseInt(age.getText().toString()) > 17 && Integer.parseInt(age.getText().toString()) < 100) {
                if (name.getText().toString().equals("")) {
                    Toast.makeText(context, "Name cannot be blank", Toast.LENGTH_SHORT).show();
                } else {
                //save to shared preference
                Profile.saveProfile(name.getText().toString(),Integer.parseInt(age.getText().toString()),Integer.parseInt(studentID.getText().toString()));

                Toast.makeText(context, "Profile saved", Toast.LENGTH_SHORT).show();
                studentID.setFocusableInTouchMode(false);
                studentID.setFocusable(false);
                age.setFocusableInTouchMode(false);
                age.setFocusable(false);
                name.setFocusableInTouchMode(false);
                name.setFocusable(false);


                editButton.setVisibility(View.INVISIBLE);


                }


            } else {
                Toast.makeText(context, "Valid for ages between 18-99", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(context, "Fill in all data", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            case R.id.edit:

                editButton.setVisibility(View.VISIBLE);
                studentID.setFocusableInTouchMode(true);
                studentID.setFocusable(true);
                age.setFocusableInTouchMode(true);
                age.setFocusable(true);
                name.setFocusableInTouchMode(true);
                name.setFocusable(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }
}
