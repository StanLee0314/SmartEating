package com.example.steven.smarteating.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.steven.smarteating.R;
import com.example.steven.smarteating.activity.NutritionShow;
import com.example.steven.smarteating.model.NutritionContains;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * This fragment is for searching food nutrition values
 */
public class NutritionSearchFragment extends Fragment {
    View view;


    Button btnSearch;
    private EditText mSearchField;
    private FirebaseAnalytics mFirebaseAnalytics;

    @BindView(R.id.foodsearch_rv_list)
    RecyclerView taskList;

    private FirebaseRecyclerAdapter adapter;

    private DatabaseReference db;


    public NutritionSearchFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        mSearchField = (EditText) view.findViewById(R.id.et_title);
        btnSearch = (Button) view.findViewById(R.id.btn_search);
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

        db = FirebaseDatabase.getInstance().getReference("foodNutrition");
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
            public void onBindViewHolder(NutritionSearchFragment.BookReciptsHolder holder, int position, final NutritionContains model) {
                // Bind the Chat object to the Holder

                holder.text_Name.setText(model.getFood_Name());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Snackbar.make(taskList, model.getFoodName(), Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
                        Intent intent = new Intent(getActivity(), NutritionShow.class);
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


//

                        startActivity(intent);
                    }
                });

            }

            @Override
            public NutritionSearchFragment.BookReciptsHolder onCreateViewHolder(ViewGroup group, int i) {

                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.item_row_foods, group, false);

                return new NutritionSearchFragment.BookReciptsHolder(view);
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
