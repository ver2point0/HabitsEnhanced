package com.ver2point0.android.habitsenhanced.data;

import android.provider.BaseColumns;

public final class HabitsEnhancedContract {

    private HabitsEnhancedContract() {}

    public static class HabitsEnhancedEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits_enhanced_log";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_DESCRIPTION = "description";
        public static final String COLUMN_HABIT_MINUTE_DURATION = "duration";

        /*
        *  Duration increments in minutes
        *  S = 15, M = 30, L = 45, XL = 60
        */
        public static final int HABIT_MINUTE_DURATION_S = 0;
        public static final int HABIT_MINUTE_DURATION_M = 1;
        public static final int HABIT_MINUTE_DURATION_L = 2;
        public static final int HABIT_MINUTE_DURATION_XL = 3;
    }
}
