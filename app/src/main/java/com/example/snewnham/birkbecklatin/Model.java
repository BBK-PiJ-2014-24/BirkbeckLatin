package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by snewnham on 01/10/2016.
 */

public class Model {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static Model instance;

    // DATABASE ACCESS IS THE DOORWAY TO THE DATABASE. IT IS A SINGLETON CLASS

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */
    private Model(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }


    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();  /// Called by the Constructor
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getQuotes() {
        List<String> list = new ArrayList<>();
        //Cursor cursor = database.rawQuery("SELECT str FROM myTable2", null);
        Cursor cursor = myQuery("myTable2", new String[]{"str"},null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    public Cursor myQuery(String table, String[] column, String whereClause, String[] whereArgs) {

        Cursor cursor = database.query(
                table,  // FROM TABLE
                column, // SELECT *
                whereClause,
                whereArgs,
                null, // GROUP BY
                null, // HAVING
                null // ORDER BY
        );
        return cursor;
    }


}
