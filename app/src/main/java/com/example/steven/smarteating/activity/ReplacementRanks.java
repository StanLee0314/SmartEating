package com.example.steven.smarteating.activity;

import android.app.Activity;
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
import android.widget.Toast;

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
 * Created by steven on 9/10/2018.
 */

public class ReplacementRanks extends AppCompatActivity {
    public static String EXTRA_FOODNAME = "extra_foodName";
    public static String EXTRA_CATEGORY = "extra_category";
    @BindView(R.id.input_replacement_food_name)
    TextView textView;
    @BindView(R.id.input_food_category)
    TextView categoryView;
    @BindView(R.id.foodreplacement_rv_list)
    RecyclerView taskList;
    private FirebaseRecyclerAdapter adapter;

    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replacement_rank_show);
        ButterKnife.bind(this);
        String mfoodname = getIntent().getStringExtra(EXTRA_FOODNAME);
        String[] arr = mfoodname.split(",");
        textView.setText(captureName(arr[0]));
        Double menergy = getIntent().getDoubleExtra(EXTRA_CATEGORY, 0);
        init();
        int i = (int) Math.round(menergy);
        // get the category number of food
        switch (i) {
            case 1:
                categoryView.setText("(Grains)");
                db = db.child("category_1");
                break;
            case 2:
                categoryView.setText("(Vegetable)");
                db = db.child("category_2");
                break;
            case 3:
                categoryView.setText("(Fruits)");
                db = db.child("category_3");
                break;
            case 4:
                categoryView.setText("(Milk)");
                db = db.child("category_4");
                break;
            case 5:
                categoryView.setText("(Lean Meats)");
                db = db.child("category_5");
                break;

        }
        getList();

    }

    // initial the database
    private void init() {
        taskList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        db = FirebaseDatabase.getInstance().getReference("smartEating").child("foodReplacement");
    }


    private void getList() {

        Query query = null;

        query = db.limitToFirst(20);

        FirebaseRecyclerOptions<NutritionContains> response = new FirebaseRecyclerOptions.Builder<NutritionContains>()
                .setQuery(query, NutritionContains.class)
                .setLifecycleOwner(this)   //add auto listen
                .build();

        adapter = new FirebaseRecyclerAdapter<NutritionContains, ReplacementRanks.BookReciptsHolder>(response) {
            @Override
            public void onBindViewHolder(ReplacementRanks.BookReciptsHolder holder, int position, final NutritionContains model) {
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
            public ReplacementRanks.BookReciptsHolder onCreateViewHolder(ViewGroup group, int i) {

                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.item_row_foods, group, false);

                return new ReplacementRanks.BookReciptsHolder(view);
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

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;

    }

}


