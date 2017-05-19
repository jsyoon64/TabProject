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
public class TabFragDbg extends Fragment {


    public TabFragDbg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.tab_frag_dbg, container, false);
        TextView tv = (TextView)view.findViewById(R.id.DbgText);
        tv.setText(getString(R.string.section_format, 4));
        return view;
    }

}
