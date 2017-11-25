package com.jlb.quizzcraft;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity {
    private static ListPreference listprefLevelSummary = null;

    private static String mDifficultyLevelString = "Non initialisé";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        listprefLevelSummary = (ListPreference) findPreference("listprefLevel");

    }

    public void onResume() {
        super.onResume();

        listprefLevelSummary.setSummary(mDifficultyLevelString);
    }

    public  static void setDiffcultyLevelStringString (String pDifficultyLevelString) { mDifficultyLevelString = pDifficultyLevelString; }

}
