package com.example.snewnham.birkbecklatin.Model.database;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 *  A Helper for Android to Access SQLite Database .
 */

public class DatabaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "LatinDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
