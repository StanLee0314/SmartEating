package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;

/**
 * Created by steven on 9/27/2018.
 */

public class EatenSuggestion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_eat_table);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);

    }
}
