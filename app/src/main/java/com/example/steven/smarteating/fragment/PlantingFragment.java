package com.example.steven.smarteating.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.steven.smarteating.R;


/**
 * A simple {@link Fragment} subclass.
 * use Log
 */
public class PlantingFragment extends Fragment {


    public PlantingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planting, container, false);
        return view;
    }


}
