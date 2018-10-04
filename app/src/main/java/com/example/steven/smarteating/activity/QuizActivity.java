package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

//import com.example.steven.smarteating.BaseActivity;
import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;
import com.example.steven.smarteating.model.Questionnaire;
import java.util.Random;

/**
 * Created by steven on 10/1/2018.
 */
public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    public final String EXTRA_POINTS = "extra_points";
    ImageButton btn_one, btn_two;
    TextView tv_question;
    int question_number = 0;
    int points = 0;
    private Questionnaire question = new Questionnaire();

    private int questionLength = question.questions.length;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_one = findViewById(R.id.yes_click);
        btn_one.setOnClickListener(this);
        btn_two = findViewById(R.id.no_click);
        btn_two.setOnClickListener(this);
        tv_question = findViewById(R.id.tv_question);

        NextQuestion(question_number);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.yes_click:
                if (question_number == questionLength)
                    GameOver();
                else {
                        points++;
                        NextQuestion(question_number++);

                }
                break;

            case R.id.no_click:
                if (question_number == questionLength)
                    GameOver();
                else {
                        NextQuestion(question_number++);
                }
                break;

        }
    }

    private void GameOver() {
        Intent intent = new Intent(getApplicationContext(), QuizResultShow.class);
        intent.putExtra(EXTRA_POINTS, points);
        startActivity(intent);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);

    }

    private void NextQuestion(int num) {
        tv_question.setText(question.getQuestion(num));

    }

}
