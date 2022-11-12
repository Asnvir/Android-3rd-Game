package com.example.android_hw_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import java.util.concurrent.TimeUnit;

import com.google.android.material.textview.MaterialTextView;

public class Activity_score extends AppCompatActivity {
    public static final String KEY_SCORE = "KEY_SCORE";
    public static final String KEY_DURATION = "KEY_DURATION";
    private MaterialTextView score_TXT_score;
    private MaterialTextView score_TXT_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        findViews();
        Intent previousIntent = getIntent();
        long durationMillis = previousIntent.getExtras().getLong(KEY_DURATION);

        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(durationMillis),
                TimeUnit.MILLISECONDS.toMinutes(durationMillis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(durationMillis)),
                TimeUnit.MILLISECONDS.toSeconds(durationMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(durationMillis)));


        int score = previousIntent.getExtras().getInt(KEY_SCORE);
        score_TXT_score.setText("Score: " + score);
        score_TXT_time.setText("Time: " + hms);


    }

    public void findViews() {
        score_TXT_score = findViewById(R.id.score_TXT_score);
        score_TXT_time = findViewById(R.id.score_TXT_time);
    }
}