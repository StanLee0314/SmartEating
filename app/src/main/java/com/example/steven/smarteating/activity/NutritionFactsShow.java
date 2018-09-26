package com.example.steven.smarteating.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.steven.smarteating.R;
import com.example.steven.smarteating.model.NutritionContains;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by steven on 8/26/2018.
 * This activity is for showing undernutrition facts
 */

public class NutritionFactsShow extends AppCompatActivity {
    public String IMAGE_RES_ID = "image_res_id";
    public String INTRODUCTION_RES_ID = "introduction_res_id";
    public String NAME_RES_ID = "title_id";
    @BindView(R.id.undernutrition_chosen)
    ImageView imageView;
    @BindView(R.id.introduction)
    ImageView introductionView;
    @BindView(R.id.suggested_title)
    TextView titleView;
    @BindView(R.id.undernutrition_rank_list)
    RecyclerView taskList;
    private FirebaseRecyclerAdapter adapter;

    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutritionfacts_show);
        ButterKnife.bind(this);
        //get the value of the fragment
        imageView.setImageResource(getIntent().getIntExtra(IMAGE_RES_ID, R.drawable.vitamin_a_click));
        introductionView.setImageResource(getIntent().getIntExtra(INTRODUCTION_RES_ID, R.drawable.introduction_va));

        titleView.setText(getIntent().getStringExtra(NAME_RES_ID));
        taskList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Vitamin A")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("vitamin_a");
        } else if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Vitamin B1")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("vitamin_b1");
        } else if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Vitamin B6")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("vitamin_b6");
        } else if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Vitamin B12")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("vitamin_b12");
        } else if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Vitamin C")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("vitamin_c");
        } else if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Vitamin E")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("vitamin_e");
        } else if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Iron")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("iron");
        } else if (getIntent().getStringExtra(NAME_RES_ID).equals("Top 10 Suggested Food For Calcium")) {
            db = FirebaseDatabase.getInstance().getReference("smartEating").child("underNutrition").child("calcium");
        }
        getList();
    }

    private void getList() {

        Query query = null;

        query = db.limitToFirst(10);

        FirebaseRecyclerOptions<NutritionContains> response = new FirebaseRecyclerOptions.Builder<NutritionContains>()
                .setQuery(query, NutritionContains.class)
                .setLifecycleOwner(this)   //add auto listen
                .build();

        adapter = new FirebaseRecyclerAdapter<NutritionContains, NutritionFactsShow.BookReciptsHolder>(response) {
            @Override
            public void onBindViewHolder(NutritionFactsShow.BookReciptsHolder holder, int position, final NutritionContains model) {
                // Bind the Chat object to the Holder

                holder.text_Name.setText(model.getFood_ID() + "  " + model.getFood_Name());

// click function to start new activity
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplication(), NutritionShow.class);
//
                        intent.putExtra(NutritionShow.EXTRA_FOODNAME, model.getFood_Name());
                        intent.putExtra(NutritionShow.EXTRA_ENERGY, model.getEnergy());
                        intent.putExtra(NutritionShow.EXTRA_CARBOHYDRATES, model.getCarbohydrates());
                        intent.putExtra(NutritionShow.EXTRA_PROTEIN, model.getProtein());
                        intent.putExtra(NutritionShow.EXTRA_DIETARYFIBRE, model.getDietary_fibre());
                        intent.putExtra(NutritionShow.EXTRA_TOTALFAT, model.getTotal_fat());
                        intent.putExtra(NutritionShow.EXTRA_TOTALSUGARS, model.getTotal_sugars());
                        intent.putExtra(NutritionShow.EXTRA_B1, model.getVitamin_B1());
                        intent.putExtra(NutritionShow.EXTRA_B2, model.getVitamin_B2());
                        intent.putExtra(NutritionShow.EXTRA_B3, model.getVitamin_B3());
                        intent.putExtra(NutritionShow.EXTRA_B6, model.getVitamin_B6());
                        intent.putExtra(NutritionShow.EXTRA_B12, model.getVitamin_B12());
                        intent.putExtra(NutritionShow.EXTRA_C, model.getVitamin_C());
                        intent.putExtra(NutritionShow.EXTRA_E, model.getVitamin_E());
                        intent.putExtra(NutritionShow.EXTRA_A, model.getVitamin_A());
                        intent.putExtra(NutritionShow.EXTRA_FOLATES, model.getTotal_Folates());
                        intent.putExtra(NutritionShow.EXTRA_CALCIUM, model.getCalcium());
                        intent.putExtra(NutritionShow.EXTRA_IODINE, model.getIodine());
                        intent.putExtra(NutritionShow.EXTRA_IRON, model.getIron());
                        intent.putExtra(NutritionShow.EXTRA_MAGNESIUM, model.getMagnesium());
                        intent.putExtra(NutritionShow.EXTRA_PHOSPHORUS, model.getPhosphorus());
                        intent.putExtra(NutritionShow.EXTRA_POTASSIUM, model.getPotassium());
                        intent.putExtra(NutritionShow.EXTRA_SELENIUM, model.getSelenium());
                        intent.putExtra(NutritionShow.EXTRA_SODIUM, model.getSodium());
                        intent.putExtra(NutritionShow.EXTRA_ZINC, model.getZinc());
                        intent.putExtra(NutritionShow.EXTRA_CHOLESTEROL, model.getCholesterol());
                        intent.putExtra(NutritionShow.EXTRA_STARCH, model.getStarch());
                        startActivity(intent);
                    }
                });

            }

            @Override
            public NutritionFactsShow.BookReciptsHolder onCreateViewHolder(ViewGroup group, int i) {

                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.item_row_foods, group, false);

                return new NutritionFactsShow.BookReciptsHolder(view);
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

