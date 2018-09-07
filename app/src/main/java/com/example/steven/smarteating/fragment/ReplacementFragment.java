package com.example.steven.smarteating.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.steven.smarteating.R;

/**
 * Created by steven on 9/7/2018.
 */

public class ReplacementFragment extends Fragment {

    public ReplacementFragment() {
        // Required empty public constructor
    }

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_replacement, container, false);
        view.setBackground(getResources().getDrawable(R.drawable.background3));
        return view;
    }
}
