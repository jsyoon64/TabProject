package com.jsyoon.tabproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jsyoon.tabproject.tab1.Tab1Frag1;
import com.jsyoon.tabproject.tab1.Tab1Frag2;
import com.jsyoon.tabproject.tab1.Tab1Frag3;
import com.jsyoon.tabproject.tab1.Tab1Frag4;
import com.jsyoon.tabproject.tab1.Tab1Frag5;

public class TabFragment1 extends Fragment implements View.OnClickListener{
    private static final String TAG = "TabFragment1";
    static final int NUM_ITEMS = 5;

    MyAdapter mAdapter;
    ViewPager mPager;
    View tab1view;

    private IFragmentToActivity mCallback;
    private Button btn_edm;
    private Button btn_eeg;
    private Button btn_gyro;
    private Button btn_ppg;
    private Button btn_temp;

    public TabFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        Log.d(TAG,"onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.tab_fragment1, container, false);

        mAdapter = new MyAdapter(getChildFragmentManager());
        mPager = (ViewPager)view.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        btn_edm = (Button) view.findViewById(R.id.button_edm);
        btn_edm.setOnClickListener(this);
        btn_eeg = (Button) view.findViewById(R.id.button_eeg);
        btn_eeg.setOnClickListener(this);
        btn_gyro = (Button) view.findViewById(R.id.button_gyro);
        btn_gyro.setOnClickListener(this);
        btn_ppg = (Button) view.findViewById(R.id.button_ppg);
        btn_ppg.setOnClickListener(this);
        btn_temp = (Button) view.findViewById(R.id.button_temp);
        btn_temp.setOnClickListener(this);

        Log.d(TAG,"onCreateView");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (IFragmentToActivity) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }
        Log.d(TAG,"onAttach");
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_edm:
                mPager.setCurrentItem(0);
                //mCallback.showToast("Pressed EDM Button");
                break;
            case R.id.button_eeg:
                mPager.setCurrentItem(1);
                //mCallback.showToast("Pressed EEG Button");
                break;
            case R.id.button_gyro:
                mPager.setCurrentItem(2);
                //mCallback.showToast("Pressed gyro Button");
                break;
            case R.id.button_ppg:
                mPager.setCurrentItem(3);
                //mCallback.showToast("Pressed PPG Button");
                break;
            case R.id.button_temp:
                mPager.setCurrentItem(4);
                //mCallback.showToast("Pressed temp Button");
                break;
        }
    }


    public static class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            // Supply num input as an argument.
            Log.d(TAG,"getItem, position is " + position);
            Bundle args = new Bundle();
            args.putInt("num", position);

            switch(position){
                default:
                case 0: Tab1Frag1 tab1frag1 = new Tab1Frag1(); tab1frag1.setArguments(args);
                    return tab1frag1;
                case 1: Tab1Frag2 tab1frag2 = new Tab1Frag2(); tab1frag2.setArguments(args);
                    return tab1frag2;
                case 2: Tab1Frag3 tab1frag3 = new Tab1Frag3(); tab1frag3.setArguments(args);
                    return tab1frag3;
                case 3: Tab1Frag4 tab1frag4 = new Tab1Frag4(); tab1frag4.setArguments(args);
                    return tab1frag4;
                case 4: Tab1Frag5 tab1frag5 = new Tab1Frag5(); tab1frag5.setArguments(args);
                    return tab1frag5;
            }
        }
    }

}
