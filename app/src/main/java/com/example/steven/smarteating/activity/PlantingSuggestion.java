package com.example.steven.smarteating.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.steven.smarteating.R;
import com.example.steven.smarteating.model.GrowingFood;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steven on 9/28/2018.
 */

public class PlantingSuggestion extends AppCompatActivity {
    @BindView(R.id.plants_search_title)
    EditText editText;
    @BindView(R.id.plants_search_rv_list)
    RecyclerView taskList;
    private FirebaseRecyclerAdapter adapter;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantingsearch);
        ButterKnife.bind(this);

        init();
        String searchText = editText.getText().toString();
        Query query = null;

//            query = db.startAt(searchText.trim().toLowerCase()).endAt(searchText.trim().toLowerCase() + "\uf8ff").limitToLast(10);
        query = db.startAt(searchText).limitToLast(10);
        FirebaseRecyclerOptions<GrowingFood> response = new FirebaseRecyclerOptions.Builder<GrowingFood>()
                .setQuery(query, GrowingFood.class)
                .setLifecycleOwner(this)   //add auto listen
                .build();

        adapter = new FirebaseRecyclerAdapter<GrowingFood, PlantingSuggestion.BookReciptsHolder>(response) {
            @Override
            public void onBindViewHolder(PlantingSuggestion.BookReciptsHolder holder, int position, final GrowingFood model) {
                // Bind the Chat object to the Holder

                holder.text_Name.setText(model.getName());

// click function to start new activity
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplication(), PlantsItemShow.class);
                        intent.putExtra(NutritionShow.EXTRA_FOODNAME, model.getName());
                        intent.putExtra(NutritionShow.EXTRA_ENERGY, model.getImage_url());
                        intent.putExtra(NutritionShow.EXTRA_CARBOHYDRATES, model.getImage_url());
                        startActivity(intent);
                    }
                });

            }

            @Override
            public PlantingSuggestion.BookReciptsHolder onCreateViewHolder(ViewGroup group, int i) {

                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.item_row_foods, group, false);

                return new PlantingSuggestion.BookReciptsHolder(view);
            }


        };

        adapter.notifyDataSetChanged();
        taskList.setAdapter(adapter);
    }

    // initial the database
    private void init() {
        taskList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        db = FirebaseDatabase.getInstance().getReference("smartEating").child("growFood");
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

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;

    }

}




