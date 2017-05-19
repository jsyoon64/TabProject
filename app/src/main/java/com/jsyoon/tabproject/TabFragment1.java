package com.jsyoon.tabproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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

import java.util.ArrayList;
import java.util.List;

public class TabFragment1 extends Fragment implements View.OnClickListener {
    private static final String TAG = "TabFragment1";
    ViewPager mPager;

    private IFragmentToActivity mCallback;
    private Button btn_edm;
    private Button btn_eeg;
    private Button btn_gyro;
    private Button btn_ppg;
    private Button btn_temp;

    public TabFragment1() { // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {  }
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);

        mPager = (ViewPager) view.findViewById(R.id.pager);
        setupViewPager(mPager);

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

        Log.d(TAG, "onCreateView");
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
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        int frag_idx = 0;
        switch (v.getId()) {
            default:
            case R.id.button_edm:
                frag_idx = 0; //mCallback.showToast("Pressed EDM Button");
                break;
            case R.id.button_eeg:
                frag_idx = 1; //mCallback.showToast("Pressed EEG Button");
                break;
            case R.id.button_gyro:
                frag_idx = 2; //mCallback.showToast("Pressed gyro Button");
                break;
            case R.id.button_ppg:
                frag_idx = 3; //mCallback.showToast("Pressed PPG Button");
                break;
            case R.id.button_temp:
                frag_idx = 4; //mCallback.showToast("Pressed temp Button");
                break;
        }
        mPager.setCurrentItem(frag_idx);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getChildFragmentManager());
        adapter.addFrag(new Tab1Frag1());
        adapter.addFrag(new Tab1Frag2());
        adapter.addFrag(new Tab1Frag3());
        adapter.addFrag(new Tab1Frag4());
        adapter.addFrag(new Tab1Frag5());
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter2 extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter2(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d(TAG, "getItem, position is " + position);
            Bundle args = new Bundle();
            args.putInt("num", position);

            Fragment fg = mFragmentList.get(position);
            fg.setArguments(args);
            return fg;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
