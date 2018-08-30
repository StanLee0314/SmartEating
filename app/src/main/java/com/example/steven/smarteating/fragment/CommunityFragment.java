package com.example.steven.smarteating.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.steven.smarteating.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends Fragment {

    View view;

    public CommunityFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_consule, container, false);

        //   RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.consule_recycler_view);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //  recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }

}
