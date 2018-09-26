package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.steven.smarteating.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steven on 9/27/2018.
 */

public class FiveGroupsShow extends AppCompatActivity {
    @BindView(R.id.fruits_click)
    ImageButton fruits_click;
    @BindView(R.id.vegetables_click)
    ImageButton vegetables_click;
    @BindView(R.id.lean_meats_click)
    ImageButton lean_meats_click;
    @BindView(R.id.grains_click)
    ImageButton grains_click;
    @BindView(R.id.milk_click)
    ImageButton milk_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_five_group);
        ButterKnife.bind(this);
        milk_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), GroupMilkShow.class);

                startActivity(intent);
            }
        });
        vegetables_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), GroupVegetableShow.class);

                startActivity(intent);
            }
        });
        grains_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), GroupGrainShow.class);

                startActivity(intent);
            }
        });
        lean_meats_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), GroupMeatShow.class);

                startActivity(intent);
            }
        });
        fruits_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), GroupFruitShow.class);

                startActivity(intent);
            }
        });
        return;
    }
}