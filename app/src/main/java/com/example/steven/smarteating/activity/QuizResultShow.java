package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;
import com.example.steven.smarteating.fragment.NutritionSearchFragment;
import com.example.steven.smarteating.fragment.ReplacementFragment;

/**
 * Created by steven on 10/1/2018.
 */

public class QuizResultShow extends AppCompatActivity {
    public String EXTRA_POINTS = "extra_points";
    ImageButton learn_more, add_variety, find_recommend;
    TextView pointsResult;
    TextView resultShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int points = getIntent().getIntExtra(EXTRA_POINTS, 0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (points >= 8) {
            setContentView(R.layout.quiz_result_high);
            pointsResult = findViewById(R.id.high_score);
            pointsResult.setText("You scored " + points + " out of 10 points");

            learn_more = findViewById(R.id.high_learn_more);
            learn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 2);
                    startActivity(intent);
                }
            });
            add_variety = findViewById(R.id.high_add_vareity);
            add_variety.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 1);
                    startActivity(intent);
                }
            });
        } else if ((points < 8) && (points >= 6)) {
            setContentView(R.layout.quiz_medium_high);
            pointsResult = findViewById(R.id.medium_high_score);
            pointsResult.setText("You scored " + points + " out of 10 points");

            learn_more = findViewById(R.id.mediumH_learn_more);
            learn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 1);
                    startActivity(intent);
                }
            });
            add_variety = findViewById(R.id.mediumH_add_vareity);
            add_variety.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 2);
                    startActivity(intent);
                }
            });
        } else if ((points < 6) && (points >= 4)) {
            setContentView(R.layout.quiz_medium_low);
            pointsResult = findViewById(R.id.medium_low_score);
            pointsResult.setText("You scored " + points + " out of 10 points");
            learn_more = findViewById(R.id.medium_low_learn_more);
            learn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 1);
                    startActivity(intent);
                }
            });

            find_recommend = findViewById(R.id.medium_low_find_recommened);
            find_recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EatenSuggestion.class);
                    startActivity(intent);
                }
            });

            add_variety = findViewById(R.id.medium_low_add);
            add_variety.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 2);
                    startActivity(intent);
                }
            });

        } else {
            setContentView(R.layout.quiz_result_low);
            pointsResult = findViewById(R.id.low_score);
            pointsResult.setText("You scored " + points + " out of 10 points");
            learn_more = findViewById(R.id.low_learn_more);
            learn_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 1);
                    startActivity(intent);
                }
            });

            find_recommend = findViewById(R.id.low_find_recommend);
            find_recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EatenSuggestion.class);
                    startActivity(intent);
                }
            });

            add_variety = findViewById(R.id.low_add_variety);
            add_variety.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QuizResultShow.this, MainActivity.class);
                    intent.putExtra("FRAGMENT_ID", 2);
                    startActivity(intent);
                }
            });

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}
