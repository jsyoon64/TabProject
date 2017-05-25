package com.jsyoon.tabproject.setting;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.jsyoon.tabproject.R;

public class FragPref extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

        // Add visualizer preferences, defined in the XML file in res->xml->pref_visualizer
        addPreferencesFromResource(R.xml.setting_pref);
    }
}
