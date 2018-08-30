package com.example.steven.smarteating.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.steven.smarteating.R;
import com.example.steven.smarteating.activity.NutritionFactsShow;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * A simple {@link Fragment} subclass.
 * use AsyncTask, toast
 */
public class HomeFragment extends Fragment {
    ImageView imageView_va;
    ImageView imageView_vb1;
    ImageView imageView_vb6;
    ImageView imageView_vb12;
    ImageView imageView_vc;
    ImageView imageView_ve;
    ImageView imageView_iron;
    ImageView imageView_ca;


    public HomeFragment() {
        // Required empty public constructor
    }

    View view;
    public static final String IMAGE_RES_ID = "image_res_id";
    public static final String TABLE_RES_ID = "table_res_id";
    public static final String INTRODUCTION_RES_ID = "introduction_res_id";
    public static final String NAME_RES_ID = "title_id";
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        view.setBackground(getResources().getDrawable(R.drawable.background3));
        imageView_va = view.findViewById(R.id.vitamin_a_click);
        imageView_va.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.vitamin_a_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_va);
                intent.putExtra(TABLE_RES_ID, R.drawable.vitamin_a_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Vitamin A");
                startActivity(intent);
            }
        });
        imageView_vb1 = view.findViewById(R.id.vitamin_b1_click);
//        Intent intent = new Intent(getContext(), NutritionFactsShow.class);
        imageView_vb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.vitamin_b1_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_vb1);
                intent.putExtra(TABLE_RES_ID, R.drawable.vitamin_b1_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Vitamin B1");
                startActivity(intent);
            }
        });

        imageView_vb6 = view.findViewById(R.id.vitamin_b6_click);
//        Intent intent = new Intent(getContext(), NutritionFactsShow.class);
        imageView_vb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.vitamin_b6_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_vb6);
                intent.putExtra(TABLE_RES_ID, R.drawable.vitamin_b6_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Vitamin B6");
                startActivity(intent);
            }
        });

        imageView_vb12 = view.findViewById(R.id.vitamin_b12_click);
//        Intent intent = new Intent(getContext(), NutritionFactsShow.class);
        imageView_vb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.vitamin_b12_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_vb12);
                intent.putExtra(TABLE_RES_ID, R.drawable.vitamin_b12_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Vitamin B12");
                startActivity(intent);
            }
        });


        imageView_vc = view.findViewById(R.id.vitamin_c_click);
//        Intent intent = new Intent(getContext(), NutritionFactsShow.class);
        imageView_vc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.vitamin_c_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_vc);
                intent.putExtra(TABLE_RES_ID, R.drawable.vitamin_c_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Vitamin C");
                startActivity(intent);
            }
        });

        imageView_ve = view.findViewById(R.id.vitamin_e_click);
//        Intent intent = new Intent(getContext(), NutritionFactsShow.class);
        imageView_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.vitamin_e_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_ve);
                intent.putExtra(TABLE_RES_ID, R.drawable.vitamin_e_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Vitamin E");
                startActivity(intent);
            }
        });

        imageView_iron = view.findViewById(R.id.iron_click);
//        Intent intent = new Intent(getContext(), NutritionFactsShow.class);
        imageView_iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.iron_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_iron);
                intent.putExtra(TABLE_RES_ID, R.drawable.iron_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Iron");
                startActivity(intent);
            }
        });

        imageView_ca = view.findViewById(R.id.calcium_click);
//        Intent intent = new Intent(getContext(), NutritionFactsShow.class);
        imageView_ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NutritionFactsShow.class);
                intent.putExtra(IMAGE_RES_ID, R.drawable.calcium_click);
                intent.putExtra(INTRODUCTION_RES_ID, R.drawable.introduction_calcium);
                intent.putExtra(TABLE_RES_ID, R.drawable.calcium_table);
                intent.putExtra(NAME_RES_ID, "Top 10 Suggested Food For Vitamin Calcium");
                startActivity(intent);
            }
        });
        return view;
    }
}
