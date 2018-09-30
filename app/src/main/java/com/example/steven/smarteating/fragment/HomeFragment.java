package com.example.steven.smarteating.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.steven.smarteating.R;
import com.example.steven.smarteating.activity.EatenKnowledge;
import com.example.steven.smarteating.activity.EatenSuggestion;
import com.example.steven.smarteating.activity.FiveGroupsShow;
import com.example.steven.smarteating.activity.NutritionFactsShow;
import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 *
 * This fragement is for showing homepage
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.the_five_group)
    ImageButton five_groups_view;
    @BindView(R.id.eating_suggestion)
    ImageButton eating_suggestion;
    @BindView(R.id.what_need_know)
    ImageButton what_need_know;

    public HomeFragment() {
        // Required empty public constructor
    }

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        five_groups_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FiveGroupsShow.class);

                startActivity(intent);
            }
        });

        eating_suggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EatenSuggestion.class);

                startActivity(intent);
            }
        });

        what_need_know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EatenKnowledge.class);

                startActivity(intent);
            }
        });
        return view;
    }
}
