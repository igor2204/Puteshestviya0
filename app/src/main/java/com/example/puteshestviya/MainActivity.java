package com.example.puteshestviya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> travelList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        // Создаем список путешествий
        travelList = new ArrayList<>();
        travelList.add("Путешествие 1");
        travelList.add("Путешествие 2");
        travelList.add("Путешествие 3");

        // Создаем адаптер для отображения списка в ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, travelList);
        listView.setAdapter(adapter);

        // Обработчик нажатия на путешествие
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Открываем активити для редактирования путешествия
                Intent intent = new Intent(MainActivity.this, EditTravelActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("travel", travelList.get(position));
                startActivityForResult(intent, 1);
            }
        });
    }
    // Обработка результата из активити редактирования
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1) {
            int position = data.getIntExtra("position", -1);
            String updatedTravel = data.getStringExtra("travel");
            if (position != -1) {
                // Обновляем список измененными данными
                travelList.set(position, updatedTravel);
                adapter.notifyDataSetChanged();
            }
        }
    }
}

//сделал практически так же, как было в предыдущей программе