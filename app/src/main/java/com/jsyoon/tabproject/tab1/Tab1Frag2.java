package com.jsyoon.tabproject.tab1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jsyoon.tabproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Frag2 extends Fragment {
    int sel_page;

    public Tab1Frag2() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        sel_page = getArguments() != null ? getArguments().getInt("num") : 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =   inflater.inflate(R.layout.tab1_frag2, container, false);

        TextView tv = (TextView)view.findViewById(R.id.text);
        tv.setText("Fragment #" + sel_page);
        //Log.d("Tab1Frag2 onCreateView",String.valueOf(sel_page));
        return view;
    }
}
