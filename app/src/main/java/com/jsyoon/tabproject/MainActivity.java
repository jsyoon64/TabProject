package com.jsyoon.tabproject;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IFragmentToActivity {

    private PagerAdapter adapter;
    private TabLayout tabLayout;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"Main onCreateView");

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<String> tabs = new ArrayList<>();
        tabs.add(getString(R.string.tab1_title));
        tabs.add(getString(R.string.tab2_title));
        tabs.add(getString(R.string.tab3_title));
        tabs.add(getString(R.string.tab4_title));

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        adapter = new PagerAdapter(getSupportFragmentManager(), tabs);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*
        if (id == R.id.action_refresh) {
            int position = tabLayout.getSelectedTabPosition();
            Fragment fragment = adapter.getFragment(tabLayout
                    .getSelectedTabPosition());
            if (fragment != null) {
                switch (position) {
                    case 0:
                        ((TabFragment1) fragment).onRefresh();
                        break;
                    case 1:
                        ((TabFragment2) fragment).onRefresh();
                        break;
                }
            }
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
