package com.example.steven.smarteating.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.steven.smarteating.MainActivity;
import com.example.steven.smarteating.R;
import com.example.steven.smarteating.model.GrowingFood;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
    @BindView(R.id.empty_view)
    TextView emptyView;
    private FirebaseRecyclerAdapter adapter;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantingsearch);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        getList("Search here");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchText = editText.getText().toString();
                getList(searchText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void getList(String searchText) {
        Query query = null;
        if (searchText.equals("Search here")) {
            query = db.limitToFirst(10);
        } else if (searchText.trim().isEmpty()) {
            query = db.limitToFirst(10);
            Toast.makeText(getApplicationContext(), "Please enter a food name",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Searching......", Toast.LENGTH_LONG).show();
            query = db.orderByChild("name").startAt(captureName(searchText.trim())).endAt(captureName(searchText.trim()) + "\uf8ff").limitToLast(10);
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
                        intent.putExtra(PlantsItemShow.EXTRA_DESCRIPTION, model.getDescription());
                        intent.putExtra(PlantsItemShow.EXTRA_GROWING_FROM_SEED, model.getGrowing_from_seed());
                        intent.putExtra(PlantsItemShow.EXTRA_HARVESTING, model.getHarvesting());
                        intent.putExtra(PlantsItemShow.EXTRA_ID, model.getId());
                        intent.putExtra(PlantsItemShow.EXTRA_IMAGE_URL, model.getImage_url());
                        intent.putExtra(PlantsItemShow.EXTRA_NAME, model.getName());
                        intent.putExtra(PlantsItemShow.EXTRA_OPTIMAL_SOIL, model.getOptimal_soil());
                        intent.putExtra(PlantsItemShow.EXTRA_OPTIMAL_SUN, model.getOptimal_sun());
                        intent.putExtra(PlantsItemShow.EXTRA_PLANTING_CONSIDERATION, model.getplanting_considerations());
                        intent.putExtra(PlantsItemShow.EXTRA_SPACING, model.getSpacing());
                        intent.putExtra(PlantsItemShow.EXTRA_STORAGE_USE, model.getstorage_use());
                        intent.putExtra(PlantsItemShow.EXTRA_TRANSPLANTING, model.getTransplanting());
                        intent.putExtra(PlantsItemShow.EXTRA_WATERING, model.getWatering());
                        intent.putExtra(PlantsItemShow.EXTRA_WHEN_TO_PLANT, model.getWhen_to_plant());
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

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);

    }
}




