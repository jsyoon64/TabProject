package com.jsyoon.tabproject.tab1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import com.jsyoon.tabproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Frag2 extends Fragment {
    private static final String TAG = "Tab1Frag2";
    int sel_page;

    Button btn_run;
    private Spinner mode_spinner;

    View frag2view;

    public Tab1Frag2() {  }

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
        frag2view =   inflater.inflate(R.layout.tab1_frag2, container, false);

        TextView tv = (TextView)frag2view.findViewById(R.id.text);
        //tv.setText("Fragment #" + sel_page);
        tv.setText(getString(R.string.sub_section_format, getArguments().getInt("num")));

        mode_spinner = (Spinner) frag2view.findViewById(R.id.modespinner);

        btn_run = (Button) frag2view.findViewById(R.id.btn_run);
        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Toast.makeText(MyAndroidAppActivity.this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(mode_spinner.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
                */
            }
        });

        Log.d(TAG,"onCreateView page is " + sel_page);
        return frag2view;
    }
}
