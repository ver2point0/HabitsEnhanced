package com.ver2point0.android.habitsenhanced.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ver2point0.android.habitsenhanced.R;
import com.ver2point0.android.habitsenhanced.data.HabitsEnhancedContract.HabitsEnhancedEntry;
import com.ver2point0.android.habitsenhanced.data.HabitsEnhancedDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitsEnhancedDbHelper mDbHelper = new HabitsEnhancedDbHelper(this);

        mDbHelper.insertEnhancedHabit(
                "Writing",
                "Let the words flow to express your thoughts",
                HabitsEnhancedEntry.HABIT_MINUTE_DURATION_S);

        mDbHelper.insertEnhancedHabit(
                "Reading",
                "Revise and edit what you wrote",
                HabitsEnhancedEntry.HABIT_MINUTE_DURATION_M);

        mDbHelper.insertEnhancedHabit(
                "Walking",
                "Have to get that exercise",
                HabitsEnhancedEntry.HABIT_MINUTE_DURATION_L);

        mDbHelper.insertEnhancedHabit(
                "Bathing",
                "Exercising makes you stinky",
                HabitsEnhancedEntry.HABIT_MINUTE_DURATION_XL);

        Cursor readCursor = mDbHelper.readEnhancedHabit();

        try {
            while (readCursor.moveToNext()) {
                Log.i(LOG_TAG,
                    "Enhanced habit: " + readCursor.getInt(0) + " - "
                        + readCursor.getString(1) + " - "
                        + readCursor.getString(2) + " - "
                        + readCursor.getInt(3));
            }
        } finally {
            readCursor.close();
        }

    }
}
