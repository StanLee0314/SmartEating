package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;

/**
 * Created by steven on 10/4/2018.
 */

public class AboutSmartEating extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
}

