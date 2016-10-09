package com.example.snewnham.birkbecklatin.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


import static com.example.snewnham.birkbecklatin.Model.DbSchema.VerbListTable.VERB_LIST_TABLE;
import static com.example.snewnham.birkbecklatin.Model.DbSchema.VerbStemTable.VERB_STEM_TABLE;
import static com.example.snewnham.birkbecklatin.Model.DbSchema.VerbConjugationTable.VERB_CONJ_TABLE;
import static com.example.snewnham.birkbecklatin.Model.DbSchema.EnglishAuxillaryVerbTable.ENG_AUX_VERB_TABLE;
import static com.example.snewnham.birkbecklatin.Model.DbSchema.EnglishPersonsTable.ENG_PERSON_TABLE;
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
        String table = VERB_LIST_TABLE;           // FROM Table = VerbList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        LatinCursorWrapper cursor = sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        cursor.moveToFirst();
        Verb verb = cursor.turnCursorToVerb();  // Convert Query from Cursor to object.
        return verb;

    }

    /**
     * sqlVerbStemQuery(String mood, String voice, String tense)
     * =========================================================
     * A SQL query to select the correct stem for a Latin Verb, given mood, voice, tense.
     * @param mood
     * @param voice
     * @param tense
     * @return
     */

    public String sqlVerbStemQuery(String number, String mood, String voice, String tense) {

        String table = VERB_STEM_TABLE;  // FROM VerbStemTable
        String[] column = new String[]{DbSchema.VerbStemTable.Cols.STEM};  // SELECT STEM
        String whereClause = DbSchema.VerbStemTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                             DbSchema.VerbStemTable.Cols.MOOD + "=?" + " AND " +
                             DbSchema.VerbStemTable.Cols.VOICE + "=?" + " AND " +
                             DbSchema.VerbStemTable.Cols.TENSE + "=?";

        String[] whereArgs = new String[]{number, mood, voice, tense};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();
        String stem = cursor.getString(cursor.getColumnIndex(DbSchema.VerbStemTable.Cols.STEM));
        return stem;
    }


    /**
     * sqlVerbEndingQuery(String person, String number, String mood, String voice, String tense, String conjnum)
     * =================
     * A SQL query to select the correct Ending for a Latin Verb, given mood, voice, tense etc.
     * @param person
     * @param number
     * @param mood
     * @param voice
     * @param tense
     * @param conjnum
     * @return
     */
    public String sqlVerbEndingQuery(String person, String number, String mood, String voice, String tense, String conjnum) {

        String table = VERB_CONJ_TABLE;  // FROM VerbConjTable
        String[] column = new String[]{DbSchema.VerbConjugationTable.Cols.CONJ};  // SELECT CONJ
        String whereClause = DbSchema.VerbConjugationTable.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                DbSchema.VerbConjugationTable.Cols.NUMBER + "=?" + " AND " +
                DbSchema.VerbConjugationTable.Cols.MOOD + "=?" + " AND " +
                DbSchema.VerbConjugationTable.Cols.VOICE + "=?" + " AND " +
                DbSchema.VerbConjugationTable.Cols.TENSE + "=?" + " AND " +
                DbSchema.VerbConjugationTable.Cols.CONJNUM + "=?";

        String[] whereArgs = new String[]{person, number, mood, voice, tense, conjnum};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String verbEnding = cursor.getString(cursor.getColumnIndex(DbSchema.VerbConjugationTable.Cols.CONJ));

        return verbEnding;
    }

    /**
     * sqlEngAuxVerbQuery(String person, String number, String mood, String voice, String tense)
     * ==================
     * A SQL query to select the correct English Auxiliary Verb for a Latin Verb translation
     * @param person
     * @param number
     * @param mood
     * @param voice
     * @param tense
     * @return
     */

    public String sqlEngAuxVerbQuery(String person, String number, String mood, String voice, String tense) {

        String table = ENG_AUX_VERB_TABLE;  // FROM EnglishAuxiliaryTable
        String[] column = new String[]{DbSchema.EnglishAuxillaryVerbTable.Cols.ENG_AUX_VERB};  // SELECT Eng_Aux_Verb

        String whereClause = DbSchema.EnglishAuxillaryVerbTable.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                DbSchema.EnglishAuxillaryVerbTable.Cols.NUMBER + "=?" + " AND " +
                DbSchema.EnglishAuxillaryVerbTable.Cols.MOOD + "=?" + " AND " +
                DbSchema.EnglishAuxillaryVerbTable.Cols.VOICE + "=?" + " AND " +
                DbSchema.EnglishAuxillaryVerbTable.Cols.TENSE + "=?";

        String[] whereArgs = new String[]{person, number, mood, voice, tense};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String engAuxVerb = cursor.getString(cursor.getColumnIndex(DbSchema.EnglishAuxillaryVerbTable.Cols.ENG_AUX_VERB));

        return engAuxVerb;
    }


    /**
     * sqlEngPersonQuery(String person, String number)
     * =================
     * A SQL query to select the correct English Person Word for a Latin Verb translation
     * @param person
     * @param number
     */
    public String sqlEngPersonQuery(String person, String number) {

        String table = ENG_PERSON_TABLE;  // FROM EnglishPerson Table
        String[] column = new String[]{DbSchema.EnglishPersonsTable.Cols.ENGLISH_PERSON_WORD};  // SELECT Eng_Person_Word

        String whereClause = DbSchema.EnglishPersonsTable.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                DbSchema.EnglishPersonsTable.Cols.NUMBER + "=?";

        String[] whereArgs = new String[]{person, number};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String engPersonWord = cursor.getString(cursor.getColumnIndex(DbSchema.EnglishPersonsTable.Cols.ENGLISH_PERSON_WORD));

        return engPersonWord;

    }



}
