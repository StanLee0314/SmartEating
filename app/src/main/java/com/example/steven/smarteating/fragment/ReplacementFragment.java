package com.example.steven.smarteating.fragment;


import android.app.Activity;
import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steven.smarteating.R;
import com.example.steven.smarteating.activity.GroupFruitShow;
import com.example.steven.smarteating.activity.GroupGrainShow;
import com.example.steven.smarteating.activity.GroupMeatShow;
import com.example.steven.smarteating.activity.GroupMilkShow;
import com.example.steven.smarteating.activity.GroupVegetableShow;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
    @BindView(R.id.empty_view)
    TextView emptyView;
    @BindView(R.id.five_fruits_click)
    ImageView fruits_cli;
    @BindView(R.id.five_grains_click)
    ImageView grains_cli;
    @BindView(R.id.five_meat_click)
    ImageView meat_cli;
    @BindView(R.id.five_milk_click)
    ImageView milk_cli;
    @BindView(R.id.five_vegetables_click)
    ImageView vegetable_cli;

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

        init();


        getBookReciptList("Search here");

        milk_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GroupMilkShow.class);
                startActivity(intent);
            }
        });
        vegetable_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GroupVegetableShow.class);
                startActivity(intent);
            }
        });
        fruits_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GroupFruitShow.class);
                startActivity(intent);
            }
        });
        grains_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GroupGrainShow.class);
                startActivity(intent);
            }
        });
        meat_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GroupMeatShow.class);
                startActivity(intent);
            }
        });

//    search button function
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    hideKeyboard(getActivity());
                } catch (Exception e) {

                }
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
            query = db.limitToLast(10);
            //validation here
        } else if (searchText.trim().isEmpty()) {
            query = db.limitToFirst(10);
            Toast.makeText(getActivity(), "Please enter a food name",
                    Toast.LENGTH_LONG).show();
        }

        else {
            Toast.makeText(getActivity(), "Searching......", Toast.LENGTH_LONG).show();
            query = db.orderByChild("food_Name").startAt(searchText.trim().toLowerCase()).endAt(searchText.trim().toLowerCase() + "\uf8ff").limitToLast(10);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        taskList.setVisibility(View.VISIBLE);
                        emptyView.setVisibility(View.GONE);

                    } else {
                        taskList.setVisibility(View.GONE);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        FirebaseRecyclerOptions<NutritionContains> response = new FirebaseRecyclerOptions.Builder<NutritionContains>()
                .setQuery(query, NutritionContains.class)
                .setLifecycleOwner(this)   //add auto listen
                .build();

        adapter = new FirebaseRecyclerAdapter<NutritionContains, BookReciptsHolder>(response) {
            @Override
            public void onBindViewHolder(ReplacementFragment.BookReciptsHolder holder, int position, final NutritionContains model) {
                // Bind the Chat object to the Holder

                holder.text_Name.setText(captureName(model.getFood_Name()));

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (model.getCategory() == 0) {
                            Toast.makeText(getActivity(), "This food does not belong to above five categories", Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent(getActivity(), ReplacementRanks.class);
                            intent.putExtra(ReplacementRanks.EXTRA_FOODNAME, model.getFood_Name());
                            intent.putExtra(ReplacementRanks.EXTRA_CATEGORY, model.getCategory());

                            startActivity(intent);
                        }
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

    //   hide virtual keyboard function
    public static void hideKeyboard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(((Activity) mContext).getWindow()
                .getCurrentFocus().getWindowToken(), 0);
    }

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;

    }
}
