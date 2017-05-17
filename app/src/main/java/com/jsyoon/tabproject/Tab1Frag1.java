package com.jsyoon.tabproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Frag1 extends Fragment {
    int sel_page;

    public Tab1Frag1() {
        sel_page = getArguments() != null ? getArguments().getInt("num") : 0;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =   inflater.inflate(R.layout.tab1_frag1, container, false);

        View tv = view.findViewById(R.id.text);
        ((TextView)tv).setText("Fragment #" + sel_page);

        return view;
    }

}
