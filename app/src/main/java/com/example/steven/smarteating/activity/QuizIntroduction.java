package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;

import butterknife.BindView;

/**
 * Created by steven on 10/4/2018.
 */

public class QuizIntroduction extends AppCompatActivity {
    @BindView(R.id.quiz_start)
    ImageView start_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_introduction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        start_quiz = findViewById(R.id.start_quiz);
        start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intent);
            }
        });
        return;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}

