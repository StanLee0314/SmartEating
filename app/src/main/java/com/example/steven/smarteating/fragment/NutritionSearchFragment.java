package com.example.steven.smarteating.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private NutritionContains broccoli;
    private NutritionContains tomato;
    private NutritionContains banana;
    private NutritionContains zucchini;
    private NutritionContains avocado;
    private NutritionContains beef;
    private NutritionContains pork;
    private NutritionContains lamb;

    @BindView(R.id.foodsearch_rv_list)
    RecyclerView taskList;
    @BindView(R.id.broccoli_click)
    ImageView broccoli_cli;
    @BindView(R.id.banana_click)
    ImageView banana_cli;
    @BindView(R.id.beef_click)
    ImageView beef_cli;
    @BindView(R.id.lamb_click)
    ImageView lamb_cli;
    @BindView(R.id.zucchini_click)
    ImageView zucchini_cli;
    @BindView(R.id.avocado_click)
    ImageView avocado_cli;
    @BindView(R.id.pork_click)
    ImageView pork_cli;
    @BindView(R.id.tomato_click)
    ImageView tomato_cli;

    private FirebaseRecyclerAdapter adapter;

    private DatabaseReference db;


    public NutritionSearchFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        mSearchField = view.findViewById(R.id.et_title);
        btnSearch = view.findViewById(R.id.btn_search);
        init();
        initialFoods();
        getBookReciptList("Search here");
        broccoli_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains broccoli = new NutritionContains("A0001", "Broccoli", 2, 101, 0.4, 4.7, 3.7, 0.3, 0.4, 0.08, 0.22, 0.5, 0.09, 0, 106, 0.18, 48, 48, 32, 0.5, 0.84, 21, 75, 336, 0.5, 22, 0.6, 0, 0);
                getResult(broccoli);
            }
        });

        banana_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains banana = new NutritionContains("A0006", "Banana", 3, 445, 25, 1.5, 3.7, 0.1, 18.2, 0.04, 0.07, 0.4, 0.2, 0, 19, 0.1, 8, 33, 10, 0.5, 0.4, 38, 21, 320, 0.5, 2, 0.2, 0, 6.8);
                getResult(banana);
            }
        });

        beef_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains beef = new NutritionContains("A0003", "Beef", 5, 534, 0, 21.9, 0, 4.4, 0, 0.06, 0.2, 2.97, 0.12, 1, 1, 0.51, 3, 0, 4, 1.2, 1.88, 24, 197, 335, 11.8, 55, 4.49, 45, 0);
                getResult(beef);
            }
        });

        lamb_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains lamb = new NutritionContains("A0004", "Lamb", 5, 2315, 0, 10.8, 0, 57.6, 0, 0, 0.07, 2, 0.1, 2.9, 0, 1.1, 34, 0, 5, 0.5, 0.41, 6, 56, 91, 5, 22, 0.54, 62, 0);
                getResult(lamb);
            }
        });

        zucchini_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains zucchini = new NutritionContains("A0005", "Zucchini", 2, 56, 1.7, 0.9, 1.1, 0.3, 1.7, 0.03, 0.06, 0.6, 0.03, 0, 24, 0.52, 46, 17, 18, 0.5, 0.5, 16, 34, 188, 0.5, 1, 0.33, 0, 0);

                getResult(zucchini);
            }
        });

        pork_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains pork = new NutritionContains("A0007", "Pork", 5, 433, 0, 23.1, 0, 1.1, 0, 1.5, 0, 9.7, 0.73, 0.3, 0, 0.31, 0, 32, 4, 0.8, 0.86, 26, 240, 390, 17.5, 42, 1.75, 47, 0);
                getResult(pork);
            }
        });

        tomato_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains tomato = new NutritionContains("A0002", "Tomato", 2, 64, 2.4, 1, 1.2, 0.1, 2.3, 0.02, 0.01, 0.7, 0.03, 0, 18, 0.26, 26, 16, 9, 0.3, 0.27, 7, 26, 214, 0.4, 8, 0.31, 0, 0.1);

                getResult(tomato);
            }
        });

        avocado_cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NutritionContains avocado = new NutritionContains("A0008", "Avocado", 2, 843, 0.4, 1.8, 3, 21.6, 0.4, 0.07, 0.13, 1.8, 0.12, 0, 10, 2.2, 27, 67, 13, 0.5, 0.59, 25, 49, 472, 0.5, 4, 0.52, 0, 0);

                getResult(avocado);
            }
        });

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
        } else if (searchText.trim().isEmpty()) {
            query = db.limitToLast(10);
            Toast.makeText(getActivity(), "Please enter a food name",
                    Toast.LENGTH_LONG).show();
        }

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
                        Intent intent = new Intent(getActivity(), NutritionShow.class);
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

    public static void hideKeyboard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(((Activity) mContext).getWindow()
                .getCurrentFocus().getWindowToken(), 0);
    }

    public void initialFoods() {
        NutritionContains broccoli = new NutritionContains("A0001", "Broccoli", 2, 101, 0.4, 4.7, 3.7, 0.3, 0.4, 0.08, 0.22, 0.5, 0.09, 0, 106, 0.18, 48, 48, 32, 0.5, 0.84, 21, 75, 336, 0.5, 22, 0.6, 0, 0);
        NutritionContains tomato = new NutritionContains("A0002", "Tomato", 2, 64, 2.4, 1, 1.2, 0.1, 2.3, 0.02, 0.01, 0.7, 0.03, 0, 18, 0.26, 26, 16, 9, 0.3, 0.27, 7, 26, 214, 0.4, 8, 0.31, 0, 0.1);
        NutritionContains beef = new NutritionContains("A0003", "Beef", 5, 534, 0, 21.9, 0, 4.4, 0, 0.06, 0.2, 2.97, 0.12, 1, 1, 0.51, 3, 0, 4, 1.2, 1.88, 24, 197, 335, 11.8, 55, 4.49, 45, 0);
        NutritionContains lamb = new NutritionContains("A0004", "Lamb", 5, 2315, 0, 10.8, 0, 57.6, 0, 0, 0.07, 2, 0.1, 2.9, 0, 1.1, 34, 0, 5, 0.5, 0.41, 6, 56, 91, 5, 22, 0.54, 62, 0);
        NutritionContains zucchini = new NutritionContains("A0005", "Zucchini", 2, 56, 1.7, 0.9, 1.1, 0.3, 1.7, 0.03, 0.06, 0.6, 0.03, 0, 24, 0.52, 46, 17, 18, 0.5, 0.5, 16, 34, 188, 0.5, 1, 0.33, 0, 0);
        NutritionContains banana = new NutritionContains("A0006", "Banana", 3, 445, 25, 1.5, 3.7, 0.1, 18.2, 0.04, 0.07, 0.4, 0.2, 0, 19, 0.1, 8, 33, 10, 0.5, 0.4, 38, 21, 320, 0.5, 2, 0.2, 0, 6.8);
        NutritionContains pork = new NutritionContains("A0007", "Pork", 5, 433, 0, 23.1, 0, 1.1, 0, 1.5, 0, 9.7, 0.73, 0.3, 0, 0.31, 0, 32, 4, 0.8, 0.86, 26, 240, 390, 17.5, 42, 1.75, 47, 0);
        NutritionContains avocado = new NutritionContains("A0008", "Avocado", 2, 843, 0.4, 1.8, 3, 21.6, 0.4, 0.07, 0.13, 1.8, 0.12, 0, 10, 2.2, 27, 67, 13, 0.5, 0.59, 25, 49, 472, 0.5, 4, 0.52, 0, 0);


    }

    public void getResult(NutritionContains model) {
        Intent intent = new Intent(getActivity(), NutritionShow.class);
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
}

