package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

//import com.example.steven.smarteating.BaseActivity;
import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;

/**
 * Created by steven on 8/24/2018.
 * This activity is for showing nutrition values
 */

public class NutritionShow extends AppCompatActivity {

    @BindView(R.id.input_foodName)
    TextView foodName;
    @BindView(R.id.input_energy)
    TextView energy;
    @BindView(R.id.input_carbohydrates)
    TextView carbohydrates;
    @BindView(R.id.input_protein)
    TextView protein;
    @BindView(R.id.input_dietaryFibre)
    TextView dietaryFibre;
    @BindView(R.id.input_totalFat)
    TextView totalFat;
    @BindView(R.id.input_totalSugars)
    TextView totalSugars;
    @BindView(R.id.input_b1)
    TextView b1;
    @BindView(R.id.input_b2)
    TextView b2;
    @BindView(R.id.input_b3)
    TextView b3;
    @BindView(R.id.input_b6)
    TextView b6;
    @BindView(R.id.input_b12)
    TextView b12;
    @BindView(R.id.input_c)
    TextView c;
    @BindView(R.id.input_e)
    TextView e;
    @BindView(R.id.input_a)
    TextView a;
    @BindView(R.id.input_folates)
    TextView folates;
    @BindView(R.id.input_calcium)
    TextView calcium;
    @BindView(R.id.input_iodine)
    TextView iodine;
    @BindView(R.id.input_iron)
    TextView iron;
    @BindView(R.id.input_magnesium)
    TextView magnesium;
    @BindView(R.id.input_phosphorus)
    TextView phosphorus;
    @BindView(R.id.input_potassium)
    TextView potassium;
    @BindView(R.id.input_selenium)
    TextView selenium;
    @BindView(R.id.input_sodium)
    TextView sodium;
    @BindView(R.id.input_zinc)
    TextView zinc;
    @BindView(R.id.input_cholesterol)
    TextView cholesterol;
    @BindView(R.id.input_starch)
    TextView starch;
    @BindView(R.id.jump_to_map)
    ImageView imageView;


    public final static String EXTRA_FOODNAME = "extra_foodname";
    public final static String EXTRA_ENERGY = "extra_energy";
    public final static String EXTRA_CARBOHYDRATES = "extra_carbohydrates";
    public final static String EXTRA_PROTEIN = "extra_protein";
    public final static String EXTRA_DIETARYFIBRE = "extra_dietaryFibre";
    public final static String EXTRA_TOTALFAT = "extra_totalFat";
    public final static String EXTRA_TOTALSUGARS = "extra_totalSugars";
    public final static String EXTRA_B1 = "extra_b1";
    public final static String EXTRA_B2 = "extra_b2";
    public final static String EXTRA_B3 = "extra_b3";
    public final static String EXTRA_B6 = "extra_b6";
    public final static String EXTRA_B12 = "extra_b12";
    public final static String EXTRA_C = "extra_c";
    public final static String EXTRA_E = "extra_e";
    public final static String EXTRA_A = "extra_a";
    public final static String EXTRA_FOLATES = "extra_folates";
    public final static String EXTRA_CALCIUM = "extra_calcium";
    public final static String EXTRA_IODINE = "extra_iodine";
    public final static String EXTRA_IRON = "extra_iron";
    public final static String EXTRA_MAGNESIUM = "extra_magnesium";
    public final static String EXTRA_PHOSPHORUS = "extra_phosphorus";
    public final static String EXTRA_POTASSIUM = "extra_potassium";
    public final static String EXTRA_SELENIUM = "extra_selenium";
    public final static String EXTRA_SODIUM = "extra_sodium";
    public final static String EXTRA_ZINC = "extra_zinc";
    public final static String EXTRA_CHOLESTEROL = "extra_cholesterol";
    public final static String EXTRA_STARCH = "extra_starch";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutritiondetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
// get the value from the fragment
        String mfoodname = getIntent().getStringExtra(EXTRA_FOODNAME);
        Double menergy = getIntent().getDoubleExtra(EXTRA_ENERGY, 0.0);
        double mcarbohyrates = getIntent().getDoubleExtra(EXTRA_CARBOHYDRATES, 0.0);
        double mprotein = getIntent().getDoubleExtra(EXTRA_PROTEIN, 0.0);
        double mdietaryfibre = getIntent().getDoubleExtra(EXTRA_DIETARYFIBRE, 0.0);
        double mtotalfat = getIntent().getDoubleExtra(EXTRA_TOTALFAT, 0.0);
        double mtotalsugars = getIntent().getDoubleExtra(EXTRA_TOTALSUGARS, 0.0);
        double mb1 = getIntent().getDoubleExtra(EXTRA_B1, 0.0);
        double mb2 = getIntent().getDoubleExtra(EXTRA_B2, 0.0);
        double mb3 = getIntent().getDoubleExtra(EXTRA_B3, 0.0);
        double mb6 = getIntent().getDoubleExtra(EXTRA_B6, 0.0);
        double mb12 = getIntent().getDoubleExtra(EXTRA_B12, 0.0);
        double mc = getIntent().getDoubleExtra(EXTRA_C, 0.0);
        double me = getIntent().getDoubleExtra(EXTRA_E, 0.0);
        double ma = getIntent().getDoubleExtra(EXTRA_A, 0.0);
        double mfolates = getIntent().getDoubleExtra(EXTRA_FOLATES, 0.0);
        double mcalcium = getIntent().getDoubleExtra(EXTRA_CALCIUM, 0.0);
        double miodine = getIntent().getDoubleExtra(EXTRA_IODINE, 0.0);
        double miron = getIntent().getDoubleExtra(EXTRA_IRON, 0.0);
        double mmagnesium = getIntent().getDoubleExtra(EXTRA_MAGNESIUM, 0.0);
        double mphosphorus = getIntent().getDoubleExtra(EXTRA_PHOSPHORUS, 0.0);
        double mpotassium = getIntent().getDoubleExtra(EXTRA_POTASSIUM, 0.0);
        double mselenium = getIntent().getDoubleExtra(EXTRA_SELENIUM, 0.0);
        double msodium = getIntent().getDoubleExtra(EXTRA_SODIUM, 0.0);
        double mzinc = getIntent().getDoubleExtra(EXTRA_ZINC, 0.0);
        double mcholesterol = getIntent().getDoubleExtra(EXTRA_CHOLESTEROL, 0.0);
        double mstarch = getIntent().getDoubleExtra(EXTRA_STARCH, 0.0);
        String[] arr = mfoodname.split(",");
        String[] foodNameShow = arr[0].split(" ");
        foodName.setText(captureName(foodNameShow[0]));
        energy.setText(menergy.toString());
        carbohydrates.setText(String.valueOf(mcarbohyrates));
        protein.setText(String.valueOf(mprotein));
        dietaryFibre.setText(String.valueOf(mdietaryfibre));
        totalFat.setText(String.valueOf(mtotalfat));
        totalSugars.setText(String.valueOf(mtotalsugars));
        b1.setText(String.valueOf(mb1));
        b2.setText(String.valueOf(mb2));
        b3.setText(String.valueOf(mb3));
        b6.setText(String.valueOf(mb6));
        b12.setText(String.valueOf(mb12));
        c.setText(String.valueOf(mc));
        e.setText(String.valueOf(me));
        a.setText(String.valueOf(ma));
        folates.setText(String.valueOf(mfolates));
        calcium.setText(String.valueOf(mcalcium));
        iodine.setText(String.valueOf(miodine));
        iron.setText(String.valueOf(miron));
        magnesium.setText(String.valueOf(mmagnesium));
        phosphorus.setText(String.valueOf(mphosphorus));
        potassium.setText(String.valueOf(mpotassium));
        selenium.setText(String.valueOf(mselenium));
        sodium.setText(String.valueOf(msodium));
        zinc.setText(String.valueOf(mzinc));
        cholesterol.setText(String.valueOf(mcholesterol));
        starch.setText(String.valueOf(mstarch));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });


    }

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);

    }
}


