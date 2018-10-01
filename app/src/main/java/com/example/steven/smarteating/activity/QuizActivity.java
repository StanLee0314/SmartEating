package com.example.steven.smarteating.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;
import com.example.steven.smarteating.model.Questionnaire;

import java.util.Random;

/**
 * Created by steven on 10/1/2018.
 */
public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    int question_number = 0;
    int points = 0;
    private Questionnaire question = new Questionnaire();

    private String answer;
    private int questionLength = question.questions.length;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);


        btn_one = findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        tv_question = findViewById(R.id.tv_question);

        NextQuestion(question_number);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_one:
                if (question_number == questionLength)
                    GameOver();
                else {
                    if (btn_one.getText() == answer) {
                        points++;
                        NextQuestion(question_number++);
                    } else {
                        NextQuestion(question_number++);
                    }
                }
                break;

            case R.id.btn_two:
                if (question_number == questionLength)
                    GameOver();
                else {
                    if (btn_two.getText() == answer) {
                        points++;
                        NextQuestion(question_number++);
                    } else {
                        NextQuestion(question_number++);
                    }
                }
                break;

        }
    }

    private void GameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
        alertDialogBuilder
                .setMessage("Continue?")
                .setCancelable(false)
                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NextQuestion(random.nextInt(questionLength));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                });
        alertDialogBuilder.show();

    }

    private void NextQuestion(int num) {
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));

        answer = question.getCorrectAnswer(num);
    }

}
