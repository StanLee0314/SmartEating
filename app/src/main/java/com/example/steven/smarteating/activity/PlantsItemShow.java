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
    @BindView(R.id.grow_food_picture)
    ImageView plantsImage;
    @BindView(R.id.grow_food_name)
    TextView plantsName;
    @BindView(R.id.grow_food_introduction)
    TextView plantsIntroduction;
    @BindView(R.id.optimal_sun)
    TextView optimal_sun;
    @BindView(R.id.optimal_soil)
    TextView optimal_soil;
    @BindView(R.id.plant_considerations)
    TextView plantsConsideration;
    @BindView(R.id.when_to_plant)
    TextView when_to_plant;
    @BindView(R.id.grow_from_seed)
    TextView grow_from_seed;
    @BindView(R.id.transplanting)
    TextView transPlanting;
    @BindView(R.id.spacing)
    TextView plantSpacing;
    @BindView(R.id.harvesting)
    TextView plantHarvesting;
    @BindView(R.id.storage_use)
    TextView stroage_use;
    @BindView(R.id.watering)
    TextView watering;


    public static String EXTRA_DESCRIPTION = "extra_description";
    public static String EXTRA_GROWING_FROM_SEED = "growing_from_seed";
    public static String EXTRA_HARVESTING = "harvesting";
    public static String EXTRA_ID = "id";
    public static String EXTRA_IMAGE_URL = "image_url";
    public static String EXTRA_NAME = "name";
    public static String EXTRA_OPTIMAL_SOIL = "optimal_soil";
    public static String EXTRA_OPTIMAL_SUN = "optimal_sun";
    public static String EXTRA_PLANTING_CONSIDERATION = "planting_considerations";
    public static String EXTRA_SPACING = "spacing";
    public static String EXTRA_STORAGE_USE = "storage_use";
    public static String EXTRA_TRANSPLANTING = "transplanting";
    public static String EXTRA_WATERING = "watering";
    public static String EXTRA_WHEN_TO_PLANT = "when_to_plant";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantfactshow);

        ButterKnife.bind(this);
// get the value from the fragment
        plantsName.setText(getIntent().getStringExtra(EXTRA_NAME));
        plantsIntroduction.setText(getIntent().getStringExtra(EXTRA_DESCRIPTION));
        optimal_sun.setText(getIntent().getStringExtra(EXTRA_OPTIMAL_SUN));
        optimal_soil.setText(getIntent().getStringExtra(EXTRA_OPTIMAL_SOIL));
        plantsConsideration.setText(getIntent().getStringExtra(EXTRA_PLANTING_CONSIDERATION));
        when_to_plant.setText(getIntent().getStringExtra(EXTRA_WHEN_TO_PLANT));
        grow_from_seed.setText(getIntent().getStringExtra(EXTRA_GROWING_FROM_SEED));
        transPlanting.setText(getIntent().getStringExtra(EXTRA_TRANSPLANTING));
        plantSpacing.setText(getIntent().getStringExtra(EXTRA_SPACING));
        plantHarvesting.setText(getIntent().getStringExtra(EXTRA_HARVESTING));
        stroage_use.setText(getIntent().getStringExtra(EXTRA_STORAGE_USE));
        watering.setText(getIntent().getStringExtra(EXTRA_WATERING));
        String image_url = getIntent().getStringExtra(EXTRA_IMAGE_URL);
        Glide.with(this).load(image_url).into(plantsImage);
    }

}

