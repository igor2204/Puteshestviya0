package com.example.puteshestviya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditTravelActivity extends AppCompatActivity {

    EditText editTextDate;
    EditText editTextTravel;
    Button buttonSave;

    Button buttonSaveDate;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_travel);

        editTextTravel = findViewById(R.id.editTextTravel);
        editTextDate = findViewById(R.id.editTextDate);
        buttonSave = findViewById(R.id.buttonSave);
        buttonSaveDate = findViewById(R.id.buttonSaveDate);

        position = getIntent().getIntExtra("position", -1);
        String travel = getIntent().getStringExtra("travel");
        String date = getIntent().getStringExtra("date");

        // Установка текущего значения путешествия в поле ввода
        editTextTravel.setText(travel);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedTravel = editTextTravel.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("position", position);
                intent.putExtra("travel", updatedTravel);
                setResult(RESULT_OK, intent);
                finish();
            }

        });
        editTextDate.setText(date);

        buttonSaveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedDate = editTextDate.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("position", position);
                intent.putExtra("date", updatedDate);
                setResult(RESULT_OK, intent);
            finish();
            }
        });
    }
}