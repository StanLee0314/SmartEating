package com.example.steven.smarteating.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steven.smarteating.R;
import com.example.steven.smarteating.activity.NutritionShow;
import com.example.steven.smarteating.activity.ReplacementRanks;
import com.example.steven.smarteating.model.NutritionContains;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.FileInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * This fragment is for searching food nutrition values
 */
public class ReplacementFragment extends Fragment {
    View view;
    Button btnSearch;
    private EditText mSearchField;
    private FirebaseAnalytics mFirebaseAnalytics;

    @BindView(R.id.foodreplacement_rv_list)
    RecyclerView taskList;

    private FirebaseRecyclerAdapter adapter;

    private DatabaseReference db;


    public ReplacementFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_replacement, container, false);
        ButterKnife.bind(this, view);
        mSearchField = view.findViewById(R.id.replacement_title);
        btnSearch = view.findViewById(R.id.replacement_search);
//        view.setBackground(getResources().getDrawable(R.drawable.background2));

        init();


        getBookReciptList("Search here");


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Searching......", Toast.LENGTH_LONG).show();

                String searchText = mSearchField.getText().toString();
                mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
                getBookReciptList(searchText);

            }
        });


        return view;
    }


    private void init() {


        taskList.setLayoutManager(new LinearLayoutManager(getActivity()));

        db = FirebaseDatabase.getInstance().getReference("smartEating").child("foodNutrition");
    }


    private void getBookReciptList(String searchText) {

        Query query = null;
        if (searchText.equals("Search here")) {
//            query = db.orderByChild("foodName");
            query = db.limitToLast(10);
        } else if (searchText.trim().isEmpty()) {
            query = db.limitToLast(10);
            Toast.makeText(getActivity(), "Please enter a food name",
                    Toast.LENGTH_LONG).show();
        }
//        else if (!(searchText.startsWith(".*[a-zA-Z]+.*)"))) {
//
//            Toast.makeText(getActivity(), "Input should be started with a word",
//                    Toast.LENGTH_LONG).show();
//            query = db.limitToLast(10);

        else {
            Toast.makeText(getActivity(), "Searching......", Toast.LENGTH_LONG).show();
            query = db.orderByChild("food_Name").startAt(searchText.trim().toLowerCase()).endAt(searchText.trim().toLowerCase() + "\uf8ff").limitToLast(10);
        }
        FirebaseRecyclerOptions<NutritionContains> response = new FirebaseRecyclerOptions.Builder<NutritionContains>()
                .setQuery(query, NutritionContains.class)
                .setLifecycleOwner(this)   //add auto listen
                .build();

        adapter = new FirebaseRecyclerAdapter<NutritionContains, BookReciptsHolder>(response) {
            @Override
            public void onBindViewHolder(ReplacementFragment.BookReciptsHolder holder, int position, final NutritionContains model) {
                // Bind the Chat object to the Holder

                holder.text_Name.setText(model.getFood_Name());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), ReplacementRanks.class);
                        intent.putExtra(ReplacementRanks.EXTRA_FOODNAME, model.getFood_Name());
                        intent.putExtra(ReplacementRanks.EXTRA_CATEGORY, model.getCategory());
                        startActivity(intent);

                    }
                });

            }

            @Override
            public ReplacementFragment.BookReciptsHolder onCreateViewHolder(ViewGroup group, int i) {

                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.item_row_foods, group, false);

                return new ReplacementFragment.BookReciptsHolder(view);
            }


        };

        adapter.notifyDataSetChanged();


        taskList.setAdapter(adapter);


    }


    // bindview to get views from recycleView then use in adapter (firebase UI)
    public class BookReciptsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.foodTitle)
        TextView text_Name;


        public BookReciptsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


}
