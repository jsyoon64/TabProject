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
import android.widget.TextView;

import com.jsyoon.tabproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Frag2 extends Fragment {
    private static final String TAG = "Tab1Frag2";
    int sel_page;

    Button btn_run, btn_popmenu;
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

        btn_run = (Button) frag2view.findViewById(R.id.btn_run);
        btn_popmenu = (Button) frag2view.findViewById(R.id.btn_popmenu);

        btn_popmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(frag2view.getContext(), btn_popmenu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.mode_popupmenu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        btn_popmenu.setText(item.getTitle());
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method


        Log.d(TAG,"onCreateView page is " + sel_page);
        return frag2view;
    }
}
