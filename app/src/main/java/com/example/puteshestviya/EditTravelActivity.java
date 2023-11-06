package com.example.puteshestviya;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class EditTravelActivity extends AppCompatActivity {
    private EditText editTextPlace;
    private EditText editTextDate;
    private Button buttonSave;

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_travel);

        editTextPlace = findViewById(R.id.editTextPlace);
        editTextDate = findViewById(R.id.editTextDate);
        buttonSave = findViewById(R.id.buttonSave);

        databaseHelper = new DatabaseHelper(this);

    }
}