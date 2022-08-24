package com.example.contest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SurahDetails extends AppCompatActivity {

    TextView surahText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_details);
        surahText = findViewById(R.id.surahTrxt);

        QDH quranInfo = new QDH();
        int number = getIntent().getIntExtra("number", 0);
        Toast.makeText(this, "number is " + number + 1, Toast.LENGTH_SHORT).show();

        QuranArabicText arabic = new QuranArabicText();
        String[] Quran = arabic.QuranArabicText;


        int startIndex = quranInfo.getSurahStart(number); //1
        if(number != 113) {
            int nextSurahStartIndex = quranInfo.getSurahStart(number + 1);
            nextSurahStartIndex--; //7


            String str = "";
            for (int i = startIndex - 1; i < nextSurahStartIndex; i++) {
                str += Quran[i];
                str += "\n";
            }
            surahText.setText(str);
        }
        else if(number == 113)
        {
            int length = Quran.length;
            int lastIndex = length - 1;
            String str = "";
            for (int i = startIndex - 1; i <= lastIndex; i++) {
                str += Quran[i];
                str += "\n";
            }
            surahText.setText(str);
        }
    }
}