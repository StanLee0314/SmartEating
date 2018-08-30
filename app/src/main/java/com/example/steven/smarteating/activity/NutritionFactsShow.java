package com.example.steven.smarteating.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.steven.smarteating.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by steven on 8/26/2018.
 */

public class NutritionFactsShow extends AppCompatActivity {
    public static String IMAGE_RES_ID = "image_res_id";
    public static String TABLE_RES_ID = "table_res_id";
    public static String INTRODUCTION_RES_ID = "introduction_res_id";
    public static final String NAME_RES_ID = "title_id";
    @BindView(R.id.undernutrition_chosen)
    ImageView imageView;
    @BindView(R.id.introduction)
    ImageView introductionView;
    @BindView(R.id.suggested_table)
    ImageView tableView;
    @BindView(R.id.suggested_title)
    TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutritionfacts_show);
        ButterKnife.bind(this);
        imageView.setImageResource(getIntent().getIntExtra(IMAGE_RES_ID, R.drawable.vitamin_a_click));
//        int b = getIntent().getIntExtra(INTRODUCTION_RES_ID,R.drawable.introduction_va);
        introductionView.setImageResource(getIntent().getIntExtra(INTRODUCTION_RES_ID, R.drawable.introduction_va));
//        int c = getIntent().getIntExtra(TABLE_RES_ID,R.drawable.vitamin_a_table);
        tableView.setImageResource(getIntent().getIntExtra(TABLE_RES_ID, R.drawable.vitamin_a_table));
        titleView.setText(getIntent().getStringExtra(NAME_RES_ID));
    }
}
