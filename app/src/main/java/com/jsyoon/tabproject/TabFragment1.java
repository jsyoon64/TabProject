package com.jsyoon.tabproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TabFragment1 extends Fragment implements View.OnClickListener{
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.tab_fragment1, container, false);

        mAdapter = new MyAdapter(getFragmentManager());
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
                mCallback.showToast("Pressed EDM Button");
                break;
            case R.id.button_eeg:
                mPager.setCurrentItem(1);
                mCallback.showToast("Pressed EEG Button");
                break;
            case R.id.button_gyro:
                mPager.setCurrentItem(2);
                mCallback.showToast("Pressed gyro Button");
                break;
            case R.id.button_ppg:
                mPager.setCurrentItem(3);
                mCallback.showToast("Pressed PPG Button");
                break;
            case R.id.button_temp:
                mPager.setCurrentItem(4);
                mCallback.showToast("Pressed temp Button");
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
            Tab1Frag1 tab1frag1 = new Tab1Frag1();

            // for test
            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("num", position);
            tab1frag1.setArguments(args);
            //

            return tab1frag1;
        }
    }

}
