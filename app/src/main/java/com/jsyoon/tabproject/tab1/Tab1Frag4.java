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
public class Tab1Frag4 extends Fragment {
    private static final String TAG = "Tab1Frag4";
    int sel_page;

    public Tab1Frag4() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        sel_page = getArguments() != null ? getArguments().getInt("num") : 0;
        Log.d(TAG,"onCreate, arg is " +sel_page);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab1_frag4, container, false);

        TextView tv = (TextView) view.findViewById(R.id.text);
        //tv.setText("Fragment #" + sel_page);
        tv.setText(getString(R.string.sub_section_format, getArguments().getInt("num")));
        Log.d(TAG,"onCreateView page is " + sel_page);
        return view;
    }
}
