package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.steven.smarteating.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steven on 9/29/2018.
 */

public class PlantsItemShow extends AppCompatActivity {
    @BindView(R.id.plants_image)
    ImageView plantsImage;
    @BindView(R.id.plants_title)
    TextView plantsName;
//    @BindView(R.id.input_carbohydrates)
//    TextView carbohydrates;


    public static String EXTRA_FOODNAME = "extra_foodname";
    public static String EXTRA_ENERGY = "extra_energy";
    public static String EXTRA_CARBOHYDRATES = "extra_carbohydrates";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantfactshow);

        ButterKnife.bind(this);
// get the value from the fragment
        String mplantname = getIntent().getStringExtra(EXTRA_FOODNAME);
        String menergy = getIntent().getStringExtra(EXTRA_ENERGY);
        String mcarbohyrates = getIntent().getStringExtra(EXTRA_CARBOHYDRATES);
        plantsName.setText(mplantname);
        Glide.with(this).load(menergy).into(plantsImage);
    }

}

