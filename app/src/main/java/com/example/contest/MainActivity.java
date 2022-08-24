package com.example.contest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.myListView);

        QDH quranInfo = new QDH();
        ArrayList<String> surahNames = quranInfo.GetSurahNames();
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, surahNames);
        myListView.setAdapter(adaptor);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SurahDetails.class);
                intent.putExtra("number", i );
                startActivity(intent);
            }
        });
    }
}