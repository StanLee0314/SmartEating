package com.example.steven.smarteating.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.steven.smarteating.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steven on 9/10/2018.
 */

public class ReplacementRanks extends AppCompatActivity {
    public static String EXTRA_FOODNAME = "extra_foodName";
    public static String EXTRA_CATEGORY = "extra_category";
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
        setContentView(R.layout.replacement_rank_show);
        ButterKnife.bind(this);

    }
}