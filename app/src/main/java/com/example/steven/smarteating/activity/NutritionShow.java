package com.example.steven.smarteating.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.steven.smarteating.R;

/**
 * Created by steven on 8/24/2018.
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


    public static String EXTRA_FOODNAME = "extra_foodname";
    public static String EXTRA_ENERGY = "extra_energy";
    public static String EXTRA_CARBOHYDRATES = "extra_carbohydrates";
    public static String EXTRA_PROTEIN = "extra_protein";
    public static String EXTRA_DIETARYFIBRE = "extra_dietaryFibre";
    public static String EXTRA_TOTALFAT = "extra_totalFat";
    public static String EXTRA_TOTALSUGARS = "extra_totalSugars";
    public static String EXTRA_B1 = "extra_b1";
    public static String EXTRA_B2 = "extra_b2";
    public static String EXTRA_B3 = "extra_b3";
    public static String EXTRA_B6 = "extra_b6";
    public static String EXTRA_B12 = "extra_b12";
    public static String EXTRA_C = "extra_c";
    public static String EXTRA_E = "extra_e";
    public static String EXTRA_A = "extra_a";
    public static String EXTRA_FOLATES = "extra_folates";
    public static String EXTRA_CALCIUM = "extra_calcium";
    public static String EXTRA_IODINE = "extra_iodine";
    public static String EXTRA_IRON = "extra_iron";
    public static String EXTRA_MAGNESIUM = "extra_magnesium";
    public static String EXTRA_PHOSPHORUS = "extra_phosphorus";
    public static String EXTRA_POTASSIUM = "extra_potassium";
    public static String EXTRA_SELENIUM = "extra_selenium";
    public static String EXTRA_SODIUM = "extra_sodium";
    public static String EXTRA_ZINC = "extra_zinc";
    public static String EXTRA_CHOLESTEROL = "extra_cholesterol";
    public static String EXTRA_STARCH = "extra_starch";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutritiondetail);

        ButterKnife.bind(this);

        String mfoodname = getIntent().getStringExtra(EXTRA_FOODNAME);
        Long menergy = getIntent().getLongExtra(EXTRA_ENERGY, 0);
        Long mcarbohyrates = getIntent().getLongExtra(EXTRA_CARBOHYDRATES, 0);
        Long mprotein = getIntent().getLongExtra(EXTRA_PROTEIN, 0);
        Long mdietaryfibre = getIntent().getLongExtra(EXTRA_DIETARYFIBRE, 0);
        Long mtotalfat = getIntent().getLongExtra(EXTRA_TOTALFAT, 0);
        Long mtotalsugars = getIntent().getLongExtra(EXTRA_TOTALSUGARS, 0);
        Long mb1 = getIntent().getLongExtra(EXTRA_B1, 0);
        Long mb2 = getIntent().getLongExtra(EXTRA_B2, 0);
        Long mb3 = getIntent().getLongExtra(EXTRA_B3, 0);
        Long mb6 = getIntent().getLongExtra(EXTRA_B6, 0);
        Long mb12 = getIntent().getLongExtra(EXTRA_B12, 0);
        Long mc = getIntent().getLongExtra(EXTRA_C, 0);
        Long me = getIntent().getLongExtra(EXTRA_E, 0);
        Long ma = getIntent().getLongExtra(EXTRA_A, 0);
        Long mfolates = getIntent().getLongExtra(EXTRA_FOLATES, 0);
        Long mcalcium = getIntent().getLongExtra(EXTRA_CALCIUM, 0);
        Long miodine = getIntent().getLongExtra(EXTRA_IODINE, 0);
        Long miron = getIntent().getLongExtra(EXTRA_IRON, 0);
        Long mmagnesium = getIntent().getLongExtra(EXTRA_MAGNESIUM, 0);
        Long mphosphorus = getIntent().getLongExtra(EXTRA_PHOSPHORUS, 0);
        Long mpotassium = getIntent().getLongExtra(EXTRA_POTASSIUM, 0);
        Long mselenium = getIntent().getLongExtra(EXTRA_SELENIUM, 0);
        Long msodium = getIntent().getLongExtra(EXTRA_SODIUM, 0);
        Long mzinc = getIntent().getLongExtra(EXTRA_ZINC, 0);
        Long mcholesterol = getIntent().getLongExtra(EXTRA_CHOLESTEROL, 0);
        Long mstarch = getIntent().getLongExtra(EXTRA_STARCH, 0);
        String mfoodname_first = mfoodname.substring(0, mfoodname.indexOf(",")).toUpperCase();
        foodName.setText(mfoodname_first);
        energy.setText(menergy.toString());
        carbohydrates.setText(mcarbohyrates.toString());
        protein.setText(mprotein.toString());
        dietaryFibre.setText(mdietaryfibre.toString());
        totalFat.setText(mtotalfat.toString());
        totalSugars.setText(mtotalsugars.toString());
        b1.setText(mb1.toString());
        b2.setText(mb2.toString());
        b3.setText(mb3.toString());
        b6.setText(mb6.toString());
        b12.setText(mb12.toString());
        c.setText(mc.toString());
        e.setText(me.toString());
        a.setText(ma.toString());
        folates.setText(mfolates.toString());
        calcium.setText(mcalcium.toString());
        iodine.setText(miodine.toString());
        iron.setText(miron.toString());
        magnesium.setText(mmagnesium.toString());
        phosphorus.setText(mphosphorus.toString());
        potassium.setText(mpotassium.toString());
        selenium.setText(mselenium.toString());
        sodium.setText(msodium.toString());
        zinc.setText(mzinc.toString());
        cholesterol.setText(mcholesterol.toString());
        starch.setText(mstarch.toString());


    }
}


