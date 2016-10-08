package com.example.snewnham.birkbecklatin.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.snewnham.birkbecklatin.Model.DbSchema.VerbListTable.VERBTABLE;


/**
 * THIS IS THE DOORWAY TO THE DATABASE GENERATING THE SQL COMMANDS
 * Created by snewnham on 01/10/2016.
 */

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    //

    /**
     * Private constructor to avoid object creation from outside classes.
     * ===================
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseHelper(context);
    }


    /**
     * getInstance()
     * =============
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
     * open()
     * ======
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();  /// Called by the Constructor
    }

    /**
     * close()
     * =======
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
        Cursor cursor = sqlQuery("myTable2", new String[]{"str"},null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    /**
     * sqlQuery()
     * ==========
     * Runs a SQL query on the DB.
     * @param table
     * @param column
     * @param whereClause
     * @param whereArgs
     * @return returns a cursor that is wrapped - the LatinCursorWrapper - which converts db data to Java objectss
     */

    public LatinCursorWrapper sqlQuery(String table, String[] column, String whereClause, String[] whereArgs) {

        Cursor cursor = database.query(
                table,  // FROM TABLE
                column, // SELECT *
                whereClause,
                whereArgs,
                null, // GROUP BY
                null, // HAVING
                null // ORDER BY
        );
        return new LatinCursorWrapper(cursor);
    }

    /**
     * sqlVerbQuery(int id)
     * ====================
     * Runs an SQL query to select a verb from the VerbList Table given the row Id.
     * The method then converts the sql cursor to an object.
     * @param id - row Number of Verb in the db's VerbList
     * @return verb object
     */


    public Verb sqlVerbQuery(int id) {
        String strId = Integer.toString(id);
        String table = VERBTABLE;           // FROM Table = VerbList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        LatinCursorWrapper cursor = sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        cursor.moveToFirst();
        Verb verb = cursor.turnCursorToVerb();  // Convert Query from Cursor to object.
        return verb;

    }




}
