package com.ver2point0.android.habitsenhanced.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ver2point0.android.habitsenhanced.data.HabitsEnhancedContract.HabitsEnhancedEntry;

public class HabitsEnhancedDbHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = HabitsEnhancedDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "habit_log.db";
    private static final int DATABASE_VERSION = 1;

    public HabitsEnhancedDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HABIT_ENHANCED_LOG_TABLE = "CREATE TABLE " + HabitsEnhancedEntry.TABLE_NAME + " ("
                + HabitsEnhancedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsEnhancedEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitsEnhancedEntry.COLUMN_HABIT_DESCRIPTION + " TEXT, "
                + HabitsEnhancedEntry.COLUMN_HABIT_MINUTE_DURATION + " INTEGER NOT NULL DEFAULT 0);";
        Log.i(LOG_TAG, CREATE_HABIT_ENHANCED_LOG_TABLE);
        db.execSQL(CREATE_HABIT_ENHANCED_LOG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void insertEnhancedHabit(String name, String description, int duration) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitsEnhancedEntry.COLUMN_HABIT_NAME, name);
        habitValues.put(HabitsEnhancedEntry.COLUMN_HABIT_DESCRIPTION, description);
        habitValues.put(HabitsEnhancedEntry.COLUMN_HABIT_MINUTE_DURATION, duration);
        db.insert(HabitsEnhancedEntry.TABLE_NAME, null, habitValues);
    }

    public Cursor queryAllHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
            HabitsEnhancedEntry._ID,
            HabitsEnhancedEntry.COLUMN_HABIT_NAME,
            HabitsEnhancedEntry.COLUMN_HABIT_DESCRIPTION,
            HabitsEnhancedEntry.COLUMN_HABIT_MINUTE_DURATION
        };

        return db.query(
            HabitsEnhancedEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null);
    }
}


