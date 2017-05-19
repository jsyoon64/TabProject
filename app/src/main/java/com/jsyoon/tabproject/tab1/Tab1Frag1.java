package com.jsyoon.tabproject.tab1;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jsyoon.tabproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Frag1 extends Fragment {
    private static final String TAG = "Tab1Frag1";
    int sel_page;

    LineGraphSeries<DataPoint> series1,series2;

    public Tab1Frag1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sel_page = getArguments() != null ? getArguments().getInt("num") : 0;
        Log.d(TAG, "onCreate, arg is " + sel_page);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab1_frag1, container, false);

        /*
        TextView tv = (TextView) view.findViewById(R.id.text);
        //tv.setText("Fragment #" + sel_page);
        tv.setText(getString(R.string.sub_section_format, getArguments().getInt("num")));
        */

        double w, y, x;
        x = -5.0;

        GraphView graph = (GraphView) view.findViewById(R.id.graph);

        series1 = new LineGraphSeries<>();
        series2 = new LineGraphSeries<>();
        for (int i = 0; i < 300; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            w = Math.cos(x);
            series1.appendData(new DataPoint(x,y),false,300);
            series2.appendData(new DataPoint(x,w),true,300);
        }
        series1.setTitle("Sine Curve 1");
        series1.setColor(Color.GREEN);
        series1.setDrawDataPoints(true);
        series1.setDataPointsRadius(10);
        series1.setThickness(8);
        graph.addSeries(series1);

        series2.setTitle("Cos Curve 1");
        series2.setColor(Color.RED);
        series2.setDrawDataPoints(true);
        series2.setDataPointsRadius(10);
        series2.setThickness(8);
        graph.addSeries(series2);
        /*
// set second scale
        graph.getSecondScale().addSeries(series2);
// the y bounds are always manual for second scale
        //graph.getSecondScale().setMinY(0);
        //graph.getSecondScale().setMaxY(100);
        series2.setColor(Color.RED);
        //graph.getGridLabelRenderer().setVerticalLabelsSecondScaleColor(Color.RED);
        */
        Log.d(TAG, "onCreateView page is " + sel_page);
        return view;
    }

}
