package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.steven.smarteating.BaseActivity;
import com.example.steven.smarteating.R;
//import com.example.steven.smarteating.model.Questionnaire;
import java.util.Random;

/**
 * Created by steven on 10/1/2018.
 */
public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    public final String EXTRA_POINTS = "extra_points";
    ImageButton btn_one, btn_two;
    ImageView tv_question;
    TextView quiz_foot;

    int question_number = 0;
    int points = 0;
//    String quiz_num = "quiz_";
//    private Questionnaire question = new Questionnaire();

    //    private int questionLength = question.questions.length;
    private int questionLength = 10;

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
        quiz_foot = findViewById(R.id.quiz_foot);
        NextQuestion(question_number);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.yes_click:
                if (question_number == questionLength - 1)
                    GameOver();
                else {
                        points++;
                    NextQuestion(++question_number);

                }
                break;

            case R.id.no_click:
                if (question_number == questionLength - 1)
                    GameOver();
                else {
                    NextQuestion(++question_number);
                }
                break;

        }
    }

    private void GameOver() {
        Intent intent = new Intent(getApplicationContext(), QuizResultShow.class);
        intent.putExtra(EXTRA_POINTS, points + 1);
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
//        tv_question.setImageResource(R.drawable.(quiz_num + String.valueOf(question_number)));
        int[] images = new int[10];
        images[0] = R.drawable.quiz_1;
        images[1] = R.drawable.quiz_2;
        images[2] = R.drawable.quiz_3;
        images[3] = R.drawable.quiz_4;
        images[4] = R.drawable.quiz_5;
        images[5] = R.drawable.quiz_6;
        images[6] = R.drawable.quiz_7;
        images[7] = R.drawable.quiz_8;
        images[8] = R.drawable.quiz_9;
        images[9] = R.drawable.quiz_10;
        tv_question.setImageResource(images[num]);
        quiz_foot.setText((question_number + 1) + "/10");

    }

}
