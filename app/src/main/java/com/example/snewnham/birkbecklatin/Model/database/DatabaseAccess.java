package com.example.snewnham.birkbecklatin.Model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Adverb;
import com.example.snewnham.birkbecklatin.Model.nouns.Conjunction;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;

import java.util.ArrayList;
import java.util.List;


/**
 * THIS IS THE DOORWAY TO THE DATABASE GENERATING THE SQL COMMANDS
 * Created by snewnham on 01/10/2016.
 */

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase mSQLiteDatabase;

    private static DatabaseAccess sDatabaseAccess;

    private Context mContext;

    //

    /**
     * Private constructor to avoid object creation from outside classes.
     * ===================
     * @param context
     */
    private DatabaseAccess(Context context) {
        mContext = context.getApplicationContext();
        this.openHelper = new DatabaseHelper(mContext);
    }


    /**
     * getInstance()
     * =============
     * Return a singleton sDatabaseAccess of DatabaseAccess.
     *
     * @param context the Context
     * @return the sDatabaseAccess of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (sDatabaseAccess == null) {
            sDatabaseAccess = new DatabaseAccess(context);
        }
        return sDatabaseAccess;
    }


    /**
     * open()
     * ======
     * Open the mSQLiteDatabase connection.
     */
    public void open() {
        this.mSQLiteDatabase = openHelper.getWritableDatabase();  /// Called by the Constructor
    }

    /**
     * close()
     * =======
     * Close the mSQLiteDatabase connection.
     */
    public void close() {
        if (mSQLiteDatabase != null) {
            this.mSQLiteDatabase.close();
        }
    }


    /**
     * Read all quotes from the mSQLiteDatabase.
     *
     * @return a List of quotes
     */
    public List<String> getQuotes() {
        List<String> list = new ArrayList<>();
        //Cursor cursor = mSQLiteDatabase.rawQuery("SELECT str FROM myTable2", null);
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
     * getVerbList()
     * ------------
     * Sql query retreiving a list of all verbs of a certain conjugation
     *
     * @return
     */
    public List<Verb> getVerbList(int conj){

        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;  // FROM VerbStemTable
        String[] column = null;  // SELECT *
        String whereClause = DbSchema.VerbListTable.Cols.LATIN_CONJNUM + "=?";
        String[] whereArgs = new String[]{Integer.toString(conj)};


        List<Verb> verbList = new ArrayList<>();
        VerbListCursor cursor = (VerbListCursor) sqlQuery(table, column, whereClause, whereArgs);  // set up cursor pointing at db

        try {
            cursor.moveToFirst();    // move cursor to first element of db
            while (!cursor.isAfterLast()) {  // while NOT after last element
                verbList.add(cursor.makeVerbObject());  // getCrime from cursorWrapper takes db tuple -> Java Crime object
                cursor.moveToNext();
            }
        } finally {
            cursor.close();  // CLOSE CURSOR  !!
        }
        return verbList;
    }


    /**
     * sqlQuery()
     * ==========
     * Runs a SQL query on the DB.
     * @param table
     * @param column
     * @param whereClause
     * @param whereArgs
     * @return returns a cursor that has an option to be wrapped.
     *         Either a VerbListCursor - which converts db data to Java Verb object
     *         or a NounListCursor - which convertsdb data to a Java NounEtc object.
     */

    public Cursor sqlQuery(String table, String[] column, String whereClause, String[] whereArgs) {

        if(this.mSQLiteDatabase == null)
            open();

        Cursor cursor = this.mSQLiteDatabase.query(
                table,  // FROM TABLE
                column, // SELECT *
                whereClause,
                whereArgs,
                null, // GROUP BY
                null, // HAVING
                null // ORDER BY
        );


        if (table.equals(DbSchema.VerbListTable.VERB_LIST_TABLE))
            return new VerbListCursor(cursor);
        else if (table.equals(DbSchema.NounListTable.NOUN_LIST_TABLE))
            return new NounListCursor(cursor);
        else if (table.equals(DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE))
            return new AdjectiveListCursor(cursor);
        else if (table.equals(DbSchema.PrepositionListTable.PREPOSITION_TABLE))
            return new PrepositionListCursor(cursor);
        else if (table.equals(DbSchema.ConjunctionListTable.CONJUNCTION_TABLE))
            return new ConjunctionListCursor(cursor);
        else if (table.equals(DbSchema.AdverbListTable.ADVERB_TABLE))
            return new AdverbListCursor(cursor);
        else
            return cursor;

    }


    /**
     * sqlTableCountQuery()
     * Counts the number or rows in a given table
     * @param table
     * @return
     */
    public int  sqlTableCountQuery(String table) {

        int tableSize = (int) DatabaseUtils.queryNumEntries(mSQLiteDatabase, table);  // downcast as returns a long
        return tableSize;
    }

    /**
     * sqlVerbListQuery(int id)
     * =======================
     * Runs an SQL query to select a verb from the VerbList Table given the row Id.
     * The method then converts the sql cursor to an object.
     * @param id - row Number of Verb in the db's VerbList
     * @return verb object
     */


    public Verb sqlVerbListQuery(int id) {
        String strId = Integer.toString(id);
        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;           // FROM Table = VerbListCursor
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        VerbListCursor verbListCursor = (VerbListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        verbListCursor.moveToFirst();
        Verb verb = verbListCursor.makeVerbObject();  // Convert Query from Cursor to Verb Object.
        return verb;
    }

    /**
     * sqlVerbStemQuery(String mood, String voice, String tense)
     * =========================================================
     * A SQL query to select the correct stem for a Latin VerbRegular, given mood, voice, tense.
     * @param mood
     * @param voice
     * @param tense
     * @return
     */

    public String sqlVerbStemQuery(String number, String mood, String voice, String tense) {

        String table = DbSchema.VerbStemTable.VERB_STEM_TABLE;  // FROM VerbStemTable
        String[] column = new String[]{DbSchema.VerbStemTable.Cols.STEM};  // SELECT STEM

        String[] whereArgs;
        String whereClause;

        if( mood.equals("Imperative") ) { // FOR IMPERATIVES: reduce arguments for Imperatives (as SQLite can't take IS NULL)
            whereArgs = new String[]{number, mood, voice};
            whereClause = DbSchema.VerbStemTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                          DbSchema.VerbStemTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.VerbStemTable.Cols.VOICE + "=?";
        } else {  // FOR ALL OTHER VERBS
            whereArgs = new String[]{number, mood, voice, tense};
            whereClause = DbSchema.VerbStemTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                          DbSchema.VerbStemTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.VerbStemTable.Cols.VOICE + "=?" + " AND " +
                          DbSchema.VerbStemTable.Cols.TENSE + "=?";
        }

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();
        String stem = cursor.getString(cursor.getColumnIndex(DbSchema.VerbStemTable.Cols.STEM));
        return stem;
    }


    /**
     * sqlVerbEndingQuery(String person, String number, String mood, String voice, String tense, String conjnum)
     * =================
     * A SQL query to select the correct Ending for a Latin VerbRegular, given mood, voice, tense etc.
     * @param person will be null for Infintitive and Imperative verbs
     * @param number
     * @param mood
     * @param voice
     * @param tense will be null for Imperative verbs
     * @param conjnum
     * @return
     */
    public String sqlVerbEndingQuery(String person, String number, String mood, String voice, String tense, String conjnum) {

        String table = DbSchema.VerbConjugationTable.VERB_CONJ_TABLE;  // FROM VerbConjTable
        String[] column = new String[]{DbSchema.VerbConjugationTable.Cols.CONJ};  // SELECT CONJ

        String[] whereArgs;
        String whereClause;

        if( number.equals("Infinitive") ) {       // FOR INIFINITIVES: reduce arguments for Infinitive (as SQLite can't take IS NULL)
            whereArgs = new String[]{number, mood, voice, tense};
            whereClause = DbSchema.VerbConjugationTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                          DbSchema.VerbConjugationTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.VerbConjugationTable.Cols.VOICE + "=?" + " AND " +
                          DbSchema.VerbConjugationTable.Cols.TENSE + "=?";

        } else if( mood.equals("Imperative") ) {  // FOR IMPERATIVES: reduce arguments for Imperatives (as SQLite can't take IS NULL)
            whereArgs = new String[]{number, mood, voice};
            whereClause = DbSchema.VerbConjugationTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                          DbSchema.VerbConjugationTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.VerbConjugationTable.Cols.VOICE + "=?";

        } else {  // FOR ALL OTHER VERBS
            whereArgs = new String[]{person, number, mood, voice, tense, conjnum};
            whereClause = DbSchema.VerbConjugationTable.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                          DbSchema.VerbConjugationTable.Cols.NUMBER + "=?" + " AND " +
                          DbSchema.VerbConjugationTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.VerbConjugationTable.Cols.VOICE + "=?" + " AND " +
                          DbSchema.VerbConjugationTable.Cols.TENSE + "=?" + " AND " +
                          DbSchema.VerbConjugationTable.Cols.CONJNUM + "=?";
        }


        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String verbEnding = cursor.getString(cursor.getColumnIndex(DbSchema.VerbConjugationTable.Cols.CONJ));

        return verbEnding;
    }


    /**
     * sqlLatinIrregularVerb(String irregularVerb, String person, String number, String mood, String voice, String tense)
     * =====================
     * sql query on Irregular Latin Words
     * @param irregularVerb
     * @param person
     * @param number
     * @param mood
     * @param voice
     * @param tense
     * @return
     */
    public String sqlLatinIrregularVerb(String irregularVerb, String person, String number, String mood,
                                        String voice, String tense) {

        // Ensure First Letter is Upper Case in order to pick up the Correct Column in the mSQLiteDatabase
        irregularVerb = irregularVerb.substring(0,1).toUpperCase() + irregularVerb.substring(1);


        String table = DbSchema.VerbConjugation_Irregular_Table.VERB_IRREGULAR_CONJ_TABLE;  // FROM VerbConjugation_Irregular_Table Table
        String[] column = new String[]{irregularVerb};  // SELECT the Column with the Irregular Verb

        String[] whereArgs;
        String whereClause;

        if( number.equals("Infinitive") ) {       // FOR INIFINITIVES: reduce arguments for Infinitive (as SQLite can't take IS NULL)
            whereArgs = new String[]{number, mood, voice, tense};
            whereClause = DbSchema.VerbConjugation_Irregular_Table.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                    DbSchema.VerbConjugation_Irregular_Table.Cols.MOOD + "=?" + " AND " +
                    DbSchema.VerbConjugation_Irregular_Table.Cols.VOICE + "=?" + " AND " +
                    DbSchema.VerbConjugation_Irregular_Table.Cols.TENSE + "=?";

        } else if( mood.equals("Imperative") ) {  // FOR IMPERATIVES: reduce arguments for Imperatives (as SQLite can't take IS NULL)
            whereArgs = new String[]{number, mood, voice};
            whereClause = DbSchema.VerbConjugation_Irregular_Table.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                    DbSchema.VerbConjugation_Irregular_Table.Cols.MOOD + "=?" + " AND " +
                    DbSchema.VerbConjugation_Irregular_Table.Cols.VOICE + "=?";
        } else {
            whereArgs = new String[]{person, number, mood, voice, tense};
            whereClause = DbSchema.VerbConjugation_Irregular_Table.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                    DbSchema.VerbConjugation_Irregular_Table.Cols.NUMBER + "=?" + " AND " +
                    DbSchema.VerbConjugation_Irregular_Table.Cols.MOOD + "=?" + " AND " +
                    DbSchema.VerbConjugation_Irregular_Table.Cols.VOICE + "=?" + " AND " +
                    DbSchema.VerbConjugation_Irregular_Table.Cols.TENSE + "=?";
        }

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();


        String verb = cursor.getString(cursor.getColumnIndex(irregularVerb));

        return verb;
    }

    // ====================== ENGLISH VERBS ==============================================
    /**
     * sqlEngPersonQuery(String person, String number)
     * =================
     * A SQL query to select the correct English Person Word for a Latin VerbRegular translation
     * @param person
     * @param number
     */
    public String sqlEngPersonQuery(String person, String number) {

        String table = DbSchema.EnglishPersonsTable.ENG_PERSON_TABLE;  // FROM EnglishPerson Table
        String[] column = new String[]{DbSchema.EnglishPersonsTable.Cols.ENGLISH_PERSON_WORD};  // SELECT Eng_Person_Word

        String whereClause = DbSchema.EnglishPersonsTable.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                DbSchema.EnglishPersonsTable.Cols.NUMBER + "=?";

        String[] whereArgs = new String[]{person, number};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String engPersonWord = cursor.getString(cursor.getColumnIndex(DbSchema.EnglishPersonsTable.Cols.ENGLISH_PERSON_WORD));

        return engPersonWord;
    }

    /**
     * sqlEngAuxVerbQuery(String person, String number, String mood, String voice, String tense)
     * ==================
     * A SQL query to select the correct English Auxiliary VerbRegular for a Latin VerbRegular translation
     * @param person
     * @param number
     * @param mood
     * @param voice
     * @param tense
     * @return
     */

    public String sqlEngAuxVerbQuery(String person, String number, String mood, String voice, String tense) {

        String table = DbSchema.EnglishAuxillaryVerbTable.ENG_AUX_VERB_TABLE;  // FROM EnglishAuxiliaryTable
        String[] column = new String[]{DbSchema.EnglishAuxillaryVerbTable.Cols.ENG_AUX_VERB};  // SELECT Eng_Aux_Verb

        String[] whereArgs;
        String whereClause;

        if( number.equals("Infinitive") ) {       // reduce arguments for Infinitive (as SQLite can't take IS NULL
            whereArgs = new String[]{number, mood, voice, tense};
            whereClause = DbSchema.EnglishAuxillaryVerbTable.Cols.NUMBER + "=?" + " AND " +   // WHERE ... AND
                          DbSchema.EnglishAuxillaryVerbTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.EnglishAuxillaryVerbTable.Cols.VOICE + "=?" + " AND " +
                          DbSchema.EnglishAuxillaryVerbTable.Cols.TENSE + "=?";

        } else if( mood.equals("Imperative") ) {       // reduce arguments for Imperative (as SQLite can't take IS NULL
            whereArgs = new String[]{number, mood, voice};
            whereClause = DbSchema.EnglishAuxillaryVerbTable.Cols.NUMBER + "=?" + " AND " +   // WHERE ... AND
                          DbSchema.EnglishAuxillaryVerbTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.EnglishAuxillaryVerbTable.Cols.VOICE + "=?";
        } else {
            whereArgs = new String[]{person, number, mood, voice, tense};
            whereClause = DbSchema.EnglishAuxillaryVerbTable.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                          DbSchema.EnglishAuxillaryVerbTable.Cols.NUMBER + "=?" + " AND " +
                          DbSchema.EnglishAuxillaryVerbTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.EnglishAuxillaryVerbTable.Cols.VOICE + "=?" + " AND " +
                          DbSchema.EnglishAuxillaryVerbTable.Cols.TENSE + "=?";
        }



        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String engAuxVerb = cursor.getString(cursor.getColumnIndex(DbSchema.EnglishAuxillaryVerbTable.Cols.ENG_AUX_VERB));

        return engAuxVerb;
    }

    /**
     * sqlEngVerbEnding(String number, String tense, String mood, String voice)
     * =================
     * A SQL query to select the English VerbRegular with the correct Ending for a Latin VerbRegular translation
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @return
     */

    public String sqlEngVerbEnding(String number, String tense, String mood, String voice) {

        String table = DbSchema.EnglishVerbEndingTable.ENGLISH_VERB_ENDING_TABLE;  // FROM EnglishPerson Table
        String[] column = new String[]{DbSchema.EnglishVerbEndingTable.Cols.ENG_VERB_ENDING};  // SELECT Eng_Verb Ending

        String[] whereArgs;
        String whereClause;

        if( mood.equals("Imperative") ) {
            whereArgs = new String[]{number, mood, voice};
            whereClause = DbSchema.EnglishVerbEndingTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                    DbSchema.EnglishVerbEndingTable.Cols.MOOD + "=?" + " AND " +
                    DbSchema.EnglishVerbEndingTable.Cols.VOICE + "=?";

        } else {
            whereArgs = new String[]{number, tense, mood, voice};
            whereClause = DbSchema.EnglishVerbEndingTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                          DbSchema.EnglishVerbEndingTable.Cols.TENSE + "=?" + " AND " +
                          DbSchema.EnglishVerbEndingTable.Cols.MOOD + "=?" + " AND " +
                          DbSchema.EnglishVerbEndingTable.Cols.VOICE + "=?";
        }


        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String engPersonWord = cursor.getString(cursor.getColumnIndex(DbSchema.EnglishVerbEndingTable.Cols.ENG_VERB_ENDING));

        return engPersonWord;
    }

    /**
     * sqlEnglishIrregularESSEVerb( String irregularVerb, String person, String number, String tense, String mood, String voice)
     * ============================
     *
     * Special sql query for The Irregular English Verb 'to be / ESSE'
     * @param irregularVerb = "ESSE VERRB"
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @return
     */
    public String sqlEnglishIrregularESSEVerb( String irregularVerb, String person, String number, String tense,
                                            String mood, String voice) {


        if ( irregularVerb.equals("esse") || irregularVerb.equals("Esse") ) {

            String table = DbSchema.VerbConjugation_Irregular_Table.VERB_IRREGULAR_CONJ_TABLE;  // FROM VerbConjugation_Irregular_Table Table
            String columnName = "Esse_English";
            String[] column = new String[]{columnName};  // SELECT the Column "English_Esse"

            String[] whereArgs;
            String whereClause;

            if( number.equals("Infinitive") ) {       // FOR INIFINITIVES: reduce arguments for Infinitive (as SQLite can't take IS NULL)
                whereArgs = new String[]{number, mood, voice, tense};
                whereClause = DbSchema.VerbConjugation_Irregular_Table.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                        DbSchema.VerbConjugation_Irregular_Table.Cols.MOOD + "=?" + " AND " +
                        DbSchema.VerbConjugation_Irregular_Table.Cols.VOICE + "=?" + " AND " +
                        DbSchema.VerbConjugation_Irregular_Table.Cols.TENSE + "=?";

            } else if( mood.equals("Imperative") ) {  // FOR IMPERATIVES: reduce arguments for Imperatives (as SQLite can't take IS NULL)
                whereArgs = new String[]{number, mood, voice};
                whereClause = DbSchema.VerbConjugation_Irregular_Table.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                        DbSchema.VerbConjugation_Irregular_Table.Cols.MOOD + "=?" + " AND " +
                        DbSchema.VerbConjugation_Irregular_Table.Cols.VOICE + "=?";
            } else {
                whereArgs = new String[]{person, number, mood, voice, tense};
                whereClause = DbSchema.VerbConjugation_Irregular_Table.Cols.PERSON + "=?" + " AND " +  // WHERE ... AND
                        DbSchema.VerbConjugation_Irregular_Table.Cols.NUMBER + "=?" + " AND " +
                        DbSchema.VerbConjugation_Irregular_Table.Cols.MOOD + "=?" + " AND " +
                        DbSchema.VerbConjugation_Irregular_Table.Cols.VOICE + "=?" + " AND " +
                        DbSchema.VerbConjugation_Irregular_Table.Cols.TENSE + "=?";
            }

            Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
            cursor.moveToFirst();

            String verb = cursor.getString(cursor.getColumnIndex(columnName));
            return verb;

        } else {
            return null;
        }
    }

    // ------------------------------- INCORRECT VERBS -------------------------------------
    /**
     * sqlIncorrectVerb_GetId()
     * ------------------------
     * Retrieves the verbId from the INCORRECT_VERB_TABLE. This is the 'Incorrect Verb' that corresponds with the Table's id (passed as argument)
     * @param id the id of the Incorrect_Verb Table
     * @return the verbId
     */
    public int sqlIncorrectVerb_GetId(int id){

        String table = DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE;
        String columnName = DbSchema.Incorrect_Verb_Table.Cols.VERB_ID;  // SELECT verb_Id
        String[] column = new String[]{columnName};

        String whereClause = DbSchema.Incorrect_Verb_Table.Cols._id + "=?"; // WHERE _id =
        String strId = Integer.toString(id);
        String[] whereArgs = new String[]{strId};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        int verbId = cursor.getInt(cursor.getColumnIndex(columnName));

        return verbId;
    }

    /**
     * sqlIncorrectVerb_Insert()
     * -------------------------
     * Inserts a verbId into INCORRECT_VERB_TABLE.
     * @param verbId
     */
    public void sqlIncorrectVerb_Insert(int verbId) {

        // check if table is empty
        int tableSize = sqlTableCountQuery(DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE);
        int id = tableSize + 1;  // increment the table's id / primary key - Autoincrement will not do this properly following a reset

        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put(DbSchema.Incorrect_Verb_Table.Cols._id, id); // manual _id insert for first record
        contentValues.put(DbSchema.Incorrect_Verb_Table.Cols.VERB_ID, verbId);  // use key-value

        if (this.mSQLiteDatabase == null)
            open();

        this.mSQLiteDatabase.insert(DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE, null, contentValues);
    }

    /**
     * sqlIncorrectVerb_Delete()
     * -------------------------
     * Deletes row from INCORRECT_VERB_TABLE  WHERE VerbId is given as argument.
     * @param verbId
     */
    public void sqlIncorrectVerb_Delete(int verbId){

        String table = DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE;

        String whereClause = DbSchema.Incorrect_Verb_Table.Cols.VERB_ID + "=?"; // WHERE _id =
        String strId = Integer.toString(verbId);
        String[] whereArgs = new String[]{strId};

        if (this.mSQLiteDatabase == null)
            open();

        this.mSQLiteDatabase.delete(DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE, whereClause, whereArgs);
    }

    /**
     * sqlIncorrectVerb_Reset()
     * ------------------------
     * Clears all records from the INCORRECT_VERB_TABLE. That is, wipes all Incorrect Verbs
     */
    public void sqlIncorrectVerb_Reset(){

        String table = DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE;

        if (this.mSQLiteDatabase == null)
            open();

        this.mSQLiteDatabase.delete(table,null,null);
    }


    // =============================== LATIN NOUNS =================================================


    /**
     * sqlNounListQuery()
     * ------------------
     *  A sql inquiry on the Noun List Table given the id. Returns the NounRegular object.
     * @param id
     * @return
     */
    public NounRegular sqlNounListQuery(int id){
        String strId = Integer.toString(id);
        String table = DbSchema.NounListTable.NOUN_LIST_TABLE;           // FROM Table = VerbListCursor
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        NounListCursor nounListCursor = (NounListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        nounListCursor.moveToFirst();
        NounRegular noun = nounListCursor.makeNounObject();  // Convert Query from Cursor to Verb Object.
        return noun;
    }


    /**
     * sqlNounEndingQuery()
     * -------------------
     * A sql inquiry on the NounEtc Ending
     *
     * @param number
     * @param gender
     * @param nounCase
     * @return
     */
    public String sqlNounEndingQuery( String declension, String number, String gender, String nounCase ){

        String table = DbSchema.NounDeclensionTable.NOUN_DECLENSION_TABLE;  // FROM NOUN_DECLENSION_TABLE Table
        String columnName = DbSchema.NounDeclensionTable.Cols.LATIN_ENDING;
        String[] column = new String[]{columnName};  // SELECT the Column "Latin_Ending"

        String[] whereArgs;
        String whereClause;

        whereArgs = new String[]{ declension, number, gender, nounCase };
        whereClause = DbSchema.NounDeclensionTable.Cols.DECLENSION + "=?" + " AND " +  // WHERE ... AND
                      DbSchema.NounDeclensionTable.Cols.NUMBER + "=?" + " AND " +
                      DbSchema.NounDeclensionTable.Cols.GENDER + "=?" + " AND " +
                      DbSchema.NounDeclensionTable.Cols.CASE + "=?";

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String nounEnding = cursor.getString(cursor.getColumnIndex(columnName));
        return nounEnding;
    }


    /**
     * sqlNounIrregularQuery(String nounIrregular, String gender, String number, String latin_Case)
     * ---------------------
     * Runs a sql query on the NounEtc Irregular Table.
     * @param nounIrregular - this is the Nominative of the Irregular, which is also the Column Name
     * @param gender
     * @param number
     * @param latin_Case
     * @return
     */
    public String sqlNounIrregularQuery(String nounIrregular, String gender, String number, String latin_Case) {

        nounIrregular = nounIrregular.substring(0,1).toUpperCase() + nounIrregular.substring(1); // make First Letter Upper Case.

        String table = DbSchema.NounIrregularTable.NOUN_IRREGULAR_TABLE;  // FROM NOUN_IRREGULAR_TABLE Table

        String[] column = new String[]{nounIrregular};  // SELECT the Column ""

        String[] whereArgs;
        String whereClause;

        whereArgs = new String[]{ gender, number, latin_Case };
        whereClause = DbSchema.NounIrregularTable.Cols.GENDER + "=?" + " AND " +  // WHERE ... AND
                DbSchema.NounIrregularTable.Cols.NUMBER + "=?" + " AND " +
                DbSchema.NounIrregularTable.Cols.LATIN_CASE + "=?";

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();


        String latinNounIrregular = cursor.getString(cursor.getColumnIndex(nounIrregular));
        return latinNounIrregular;
    }


    /**
     * sqlAdjectiveList(int id)
     * --------------------------
     * SQL query on Adjective_List, using a cursor to collect data on a row and convert to Adjective
     * Object
     * @param id
     * @return
     */
    public Adjective sqlAdjectiveListQuery(int id) {
        String strId = Integer.toString(id);
        String table = DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE;           // FROM Table = AdjectiveList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        AdjectiveListCursor adjectiveListCursor = (AdjectiveListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        adjectiveListCursor.moveToFirst();
        Adjective adjective = adjectiveListCursor.makeAdjectiveObject();  // Convert Query from Cursor to Verb Object.
        return adjective;
    }


    /**
     * sqlAdjectiveEnding()
     * --------------------
     * sql query on Adjective_Ending Table.
     * @param declension
     * @param gender
     * @param number
     * @param latin_Case
     * @return
     */
    public String sqlAdjectiveEnding(String declension, String gender, String number, String latin_Case){

        String table = DbSchema.AdjectiveEndingTable.ADJECTIVE_ENDING_TABLE;  // FROM ADJECTIVE_ENDING_TABLE Table
        String columnName = DbSchema.AdjectiveEndingTable.Cols.LATIN_ENDING;
        String[] column = new String[]{columnName};  // SELECT the Column "Latin_Ending"

        String[] whereArgs;
        String whereClause;

        whereArgs = new String[]{ declension, gender, number, latin_Case };
        whereClause = DbSchema.NounDeclensionTable.Cols.DECLENSION + "=?" + " AND " +  // WHERE ... AND
                DbSchema.AdjectiveEndingTable.Cols.GENDER + "=?" + " AND " +
                DbSchema.AdjectiveEndingTable.Cols.NUMBER + "=?" + " AND " +
                DbSchema.AdjectiveEndingTable.Cols.CASE + "=?";

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();

        String adjEnding = cursor.getString(cursor.getColumnIndex(columnName));
        return adjEnding;
    }


    /**
     * sqlPrepositionListQuery()
     * -------------------------
     * Runs a SQL query on the Prepostion_List table, selects a row with a cursor
     * and converts into a Preposition Object.
     * @param id
     * @return
     */
    public Preposition sqlPrepositionListQuery(int id){
        String strId = Integer.toString(id);
        String table = DbSchema.PrepositionListTable.PREPOSITION_TABLE;           // FROM Table = AdjectiveList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        PrepositionListCursor prepositionListCursor = (PrepositionListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        prepositionListCursor.moveToFirst();
        Preposition preposition = prepositionListCursor.makePrepositionObject();  // Convert Query from Cursor to Verb Object.
        return preposition;
    }


    /**
     * sqlConjunctionListQuery(int id)
     * -------------------------------
     * Runs a SQL query on the Conjunction_List table, selects a row with a cursor
     * and converts into a Conjunction Object
     * @param id
     * @return
     */
    public Conjunction sqlConjunctionListQuery(int id){
        String strId = Integer.toString(id);
        String table = DbSchema.ConjunctionListTable.CONJUNCTION_TABLE;           // FROM Table = AdjectiveList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        ConjunctionListCursor conjunctionListCursor = (ConjunctionListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        conjunctionListCursor.moveToFirst();
        Conjunction conjunction = conjunctionListCursor.makeConjunctionObject();  // Convert Query from Cursor to Verb Object.
        return conjunction;

    }


    /**
     * sqlAdverbListQuery(int id)
     * -------------------------------
     * Runs a SQL query on the Adverb_List table, selects a row with a cursor
     * and converts into a Adverb Object.
     * @param id
     * @return
     */
    public Adverb sqlAdverbListQuery(int id) {
        String strId = Integer.toString(id);
        String table = DbSchema.AdverbListTable.ADVERB_TABLE;           // FROM Table = AdjectiveList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        AdverbListCursor adverbListTable = (AdverbListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        adverbListTable.moveToFirst();
        Adverb adverb = adverbListTable.makeAdverbObject();  // Convert Query from Cursor to Verb Object.
        return adverb;

    }


}
