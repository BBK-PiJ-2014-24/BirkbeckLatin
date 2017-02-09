package com.example.snewnham.birkbecklatin.Model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.AdjectiveComparative;
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

    private final static String NOUN_REGULAR = "NounRegular";
    private final static String NOUN_IRREGULAR = "NounIrregular";

    private final static String ADJECTIVE = "Adjective";
    private final static String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";
    private final static String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";

    private final static String ADVERB = "Adverb";
    private final static String ADVERB_COMPARATIVE = "AdverbComparative";
    private final static String ADVERB_SUPERLATIVE = "AdverbSuperlative";

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

        if (table.equals(DbSchema.VerbListTable.VERB_LIST_TABLE) && column == null)
            return new VerbListCursor(cursor);
        else if (table.equals(DbSchema.NounListTable.NOUN_LIST_TABLE) && column == null )
            return new NounListCursor(cursor, NOUN_REGULAR);
        else if (table.equals(DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE) && column == null)
            return new AdjectiveListCursor(cursor, ADJECTIVE );
        else if (table.equals(DbSchema.PrepositionListTable.PREPOSITION_TABLE) && column == null)
            return new PrepositionListCursor(cursor);
        else if (table.equals(DbSchema.ConjunctionListTable.CONJUNCTION_TABLE) && column == null)
            return new ConjunctionListCursor(cursor);
        else if (table.equals(DbSchema.AdverbListTable.ADVERB_TABLE) && column == null)
            return new AdverbListCursor(cursor, ADVERB);
        else
            return cursor;
    }

    /**
     * sqlQuery(String subClassType)
     * ==========
     * @Overload Runs a SQL query on the DB for SubClasses of Adjective and Adverb.
     * (i.e. The Comparatives and Superlatives). An extra parameter, subClassType, is
     * used to set the appropriate sub-class.
     * NOTE that the CursorWrapper will handle the Instantiation of the correct
     * Subclass
     *
     * @param subClassType - The SubClass to Be Instantiated from the Cursor
     * @param table - DB Table
     * @param column - SELECT Attributes
     * @param whereClause - WHERE CONDITIONS
     * @param whereArgs
     * @return returns a cursor that has an option to be wrapped.
     *         Either a VerbListCursor - which converts db data to Java Verb object
     *         or a NounListCursor - which convertsdb data to a Java NounEtc object.
     */

    //@Overload
    public Cursor sqlQuery(String subClassType, String table, String[] column, String whereClause, String[] whereArgs) {

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
        if (table.equals(DbSchema.NounListTable.NOUN_LIST_TABLE)  && subClassType.equals(NOUN_IRREGULAR))
            return new NounListCursor(cursor, NOUN_IRREGULAR );
        else if (table.equals(DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE)  && subClassType.equals(ADJECTIVE_COMPARATIVE))
            return new AdjectiveListCursor(cursor, ADJECTIVE_COMPARATIVE );
        else if (table.equals(DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE) && subClassType.equals(ADJECTIVE_SUPERLATIVE))
            return new AdjectiveListCursor(cursor, ADJECTIVE_SUPERLATIVE );
        else if (table.equals(DbSchema.AdverbListTable.ADVERB_TABLE) && subClassType.equals(ADVERB_COMPARATIVE))
            return new AdverbListCursor(cursor, ADVERB_COMPARATIVE );
        else if (table.equals(DbSchema.AdverbListTable.ADVERB_TABLE) && subClassType.equals(ADVERB_SUPERLATIVE))
            return new AdverbListCursor(cursor, ADVERB_SUPERLATIVE );
        else
            return cursor;
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
     * getVerbConjugationList()
     * -------------------------
     * Sql query retreiving a list of all verbs of a certain conjugation. To BE USED WITH A PAGE_VIEWER.
     *
     * @return
     */
    public List<Verb> getVerbConjugationList(int conj){

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
     * getVerbIDConjugationList()
     * --------------------------
     * This is used for SKILL 1 in the VerbGame in order to Limit the Verbs Available.
     * Retrieves a List of Verb IDs from the DB where Conj is limited to max (ideally 2)
     * and Verbs are Regular plus the ESSE Irregular Verb.
     * @param maxConj set at 2
     * @return list of Verb IDs meeting criteria above.
     */
    public List<Integer> getVerbIDConjugationList(int maxConj){

        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;  // FROM VerbListTable
        String[] column = new String[]{DbSchema.VerbListTable.Cols._id}; // SELECT _id
        String whereClause = DbSchema.VerbListTable.Cols.LATIN_CONJNUM + "<=? AND " +
                             DbSchema.VerbListTable.Cols.LATIN_TYPE + "=? OR " +
                             DbSchema.VerbListTable.Cols.LATIN_INFINITIVE + "=?";
        String[] whereArgs = new String[]{Integer.toString(maxConj),
                                          "Regular",
                                          "esse"};

        List<Integer> verbIDList = new ArrayList<>();
        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs);  // set up cursor pointing at db

        try {
            cursor.moveToFirst();    // move cursor to first element of db
            while (!cursor.isAfterLast()) {  // while NOT after last element
                verbIDList.add(cursor.getInt(cursor.getColumnIndex(DbSchema.VerbListTable.Cols._id)));  // getCrime from cursorWrapper takes db tuple -> Java Crime object
                cursor.moveToNext();
            }
        } finally {
            cursor.close();  // CLOSE CURSOR  !!
        }
        return verbIDList;
    }


    /**
     * getVerbIDList()
     * ===============
     * Runs a SQL on VerbList Table retrieving a WHOLE list of (Not Yet ASKED) Verb IDs, which can be restricted
     * for a given skillLevels and left unrestricted.
     * It can be also set so to retrieve a list of Verb IDs that are INCORRECTLY Answered.
     * @param maxConj - max level of Conj Number
     * @param correct - WHERE CORRECT = 1: Correct Answers, 0: Incorrect Answers
     * @param restricted - Boolean flag: restricted: true, unrestricted: false
     * @return List<integer> of IDs
     */
    public List<Integer> getVerbIDList(int maxConj, int correct, boolean restricted){

        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;  // FROM VerbListTable
        String[] column = new String[]{DbSchema.VerbListTable.Cols._id}; // SELECT _id

        String whereClause = DbSchema.VerbListTable.Cols.ASKED + "=? AND " +  // UNRESTRICTED LIST
                             DbSchema.VerbListTable.Cols.CORRECT + "=?";

        if(restricted) {                                                      // RESTRICTED
             whereClause =  whereClause + " AND " +
                            DbSchema.VerbListTable.Cols.LATIN_CONJNUM + "<=? AND " +
                            DbSchema.VerbListTable.Cols.LATIN_TYPE + "=? OR " +
                            DbSchema.VerbListTable.Cols.LATIN_INFINITIVE + "=?";
        }

        String[] whereArgs;
        if(!restricted){
            whereArgs = new String[]{Integer.toString(0),        // ASKED
                                     Integer.toString(correct)};// CORRECT
        } else {
            whereArgs = new String[]{Integer.toString(0),        // ASKED
                                    Integer.toString(correct),// CORRECT
                                    Integer.toString(maxConj),  // CONJNUM
                                    "Regular",                  // LATIN TYPE
                                    "esse"};                    // LATIN INFINITIVE
        }

        List<Integer> verbIDList = new ArrayList<>();

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs);  // set up cursor pointing at db
        try {
            cursor.moveToFirst();    // move cursor to first element of db
            while (!cursor.isAfterLast()) {  // while NOT after last element
                verbIDList.add(cursor.getInt(cursor.getColumnIndex(DbSchema.VerbListTable.Cols._id)));  // getCrime from cursorWrapper takes db tuple -> Java Crime object
                cursor.moveToNext();
            }
        } finally {
            cursor.close();  // CLOSE CURSOR  !!
        }
        return verbIDList;
    }


    /**
     * sqlTableCountQuery()
     * ====================
     * Counts the number or rows in a given table
     * @param table
     * @return
     */
    public int  sqlTableCountQuery(String table) {

        int tableSize = (int) DatabaseUtils.queryNumEntries(mSQLiteDatabase, table);  // downcast as returns a long
        return tableSize;
    }


    /**
     * sqlNounTypeCount()
     * ------------------
     * @param type - NOUN_REGULAR, NOUN_IRREGULAR
     * @return - Number of Rows for a given Type.
     */
    public int sqlNounTypeCount(String type){

        String table = DbSchema.NounListTable.NOUN_LIST_TABLE;
        String[] column = new String[]{DbSchema.NounListTable.Cols.TYPE};            // SELECT *
        String whereClause = DbSchema.NounListTable.Cols.TYPE + "=?";
        String[] whereArgs = new String[]{type};    // WHERE _id =

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        int count = cursor.getCount();
        cursor.close();
        return count;
    }


    /**
     * sqlVerbTypeQuery()
     * ===============
     * Runs a SQL query on VERB_LIST table returning the TYPE of Verb (Regular, Irregular, Deponent etc.)
     * @param id
     * @return
     */
    public String sqlVerbTypeQuery(int id){
        String strId = Integer.toString(id);
        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;           // FROM Table = VerbListCursor
        String[] column = new String[]{DbSchema.VerbListTable.Cols.LATIN_TYPE};            // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        cursor.moveToFirst();
        String verbType = cursor.getString(cursor.getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_TYPE));
        cursor.close();
        return verbType;
    }


    /**
     * sqlVerbConjQuery()
     * ===============
     * Runs a SQL query on VERB_LIST table returning the CONJUGATION of Verb (1,2,3,4 or null)
     * @param id
     * @return
     */
    public String sqlVerbConjQuery(int id){
        String strId = Integer.toString(id);
        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;           // FROM Table = VerbListCursor
        String[] column = new String[]{DbSchema.VerbListTable.Cols.LATIN_CONJNUM};            // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        cursor.moveToFirst();
        String verbConj = cursor.getString(cursor.getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_CONJNUM));
        cursor.close();
        return verbConj;
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
        verbListCursor.close();
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
        cursor.close();
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
        cursor.close();
        return verbEnding;
    }


    /**
     * sqlLatinIrregularVerb(String irregularVerb, String person, String number, String mood, String voice, String tense)
     * =====================
     * sql query on Irregular Latin Words. Note that sometimes the cell in the database table is Null. Normally
     * this is because the Voice = Passive
     * In these situations,  we check the count of the cursor to determine a Null entry.
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

        if(cursor.getCount() == 0)
            return null;          // The Element in the table is Null. Possibly because Voice = Passive

        cursor.moveToFirst();

        String verb = cursor.getString(cursor.getColumnIndex(irregularVerb));
        cursor.close();
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
        cursor.close();
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
        cursor.close();
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
        cursor.close();
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
            cursor.close();
            return verb;

        } else {
            return null;
        }
    }

    // ------------------------------- CORRECT VERBS -------------------------------------

//    /**
//     * getRestrictedIncorrectVerbList()
//     * --------------------------------
//     * Gets a list of all Verb IDs from the IncorrecVerbList that
//     * are restricted to a max Conj.
//     * @param conj - Restricted
//     * @return  List<Integer> of VerbIDs from the
//     */
//    public List<Integer> getRestrictedIncorrectVerbList(int conj){
//
//        String table = DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE;  // FROM Incorrect_Verb_Table
//        String[] column = new String[]{DbSchema.Incorrect_Verb_Table.Cols.VERB_ID};   // Select VerbIDs
//        String whereClause = DbSchema.VerbListTable.Cols.LATIN_CONJNUM + "=?";
//        String[] whereArgs = new String[]{Integer.toString(conj)};
//
//        List<Integer> verbIDList = new ArrayList<>();
//        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs);  // set up cursor pointing at db
//
//        try {
//            cursor.moveToFirst();    // move cursor to first element of db
//            while (!cursor.isAfterLast()) {  // while NOT after last element
//                verbIDList.add(cursor.getInt(0));  // getID
//                cursor.moveToNext();
//            }
//        } finally {
//            cursor.close();  // CLOSE CURSOR  !!
//        }
//        return verbIDList;
//    }



//    /**
//     * sqlIncorrectVerb_GetId()
//     * ------------------------
//     * Retrieves the verbId from the INCORRECT_VERB_TABLE. This is the 'Incorrect Verb' that corresponds with the Table's id (passed as argument)
//     * @param id the id of the Incorrect_Verb Table
//     * @return the verbId
//     */
//    public int sqlIncorrectVerb_GetId(int id){
//
//        String table = DbSchema.Incorrect_Verb_Table.INCORRECT_VERB_TABLE;
//        String columnName = DbSchema.Incorrect_Verb_Table.Cols.VERB_ID;  // SELECT verb_Id
//        String[] column = new String[]{columnName};
//
//        String whereClause = DbSchema.Incorrect_Verb_Table.Cols._id + "=?"; // WHERE _id =
//        String strId = Integer.toString(id);
//        String[] whereArgs = new String[]{strId};
//
//        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
//        cursor.moveToFirst();
//
//        int verbId = cursor.getInt(cursor.getColumnIndex(columnName));
//        cursor.close();
//
//        return verbId;
//    }


    /**
     * sqlVerbList_Insert()
     * -------------------------
     * Updates the 'Incorrect' Field in the_VERB_LIST_TABLE t
     * @param verbID - verb ID to update
     * @param  fieldName - The Field to be Reset, 'Incorrect' or 'Answer'
     * @param fieldValue - Insert 0 (for Correct Answer) and 1 (for Incorrect Answer)
     */
    public void sqlVerbList_Insert( int verbID, String fieldName, int fieldValue ) {

        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put(fieldName, fieldValue); // manual _id insert for first record

        if (this.mSQLiteDatabase == null)
            open();

        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;
        String whereClause = DbSchema.VerbListTable.Cols._id + "=?";
        String[] whereArgument = new String[]{Integer.toString(verbID)}; // WHERE ROW of ID = Verb ID

        this.mSQLiteDatabase.update(table, contentValues, whereClause, whereArgument);  // CV is the Update (Field, Value)
                                                                                        // whereClause tells which row to update
    }

    /**
     * sqlVerbList_TestInsertion()
     * --------------------------------
     * Test if A Record Entry of 'Incorrect' or 'Answer' Field has been properly inserted in the Verb_List Table
     * @param verbID - verb ID to test update
     * @param  fieldName - The Field to test, 'Incorrect' or 'Answer'
     * @param fieldValue - the right value for the Attribute.
     * @return True if check matches incorrectFlag
     */
    public boolean sqlVerbList_TestInsertion( int verbID, String fieldName, int fieldValue ){
        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;

        String[] column = new String[]{fieldName}; // Select Column

        String whereClause = DbSchema.VerbListTable.Cols._id + "=?";  // Where
        String strId = Integer.toString(verbID);
        String[] whereArgs = new String[]{strId};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();
        int answer = cursor.getInt(cursor.getColumnIndex(fieldName));


        int x = cursor.getCount();
        String[] cols = cursor.getColumnNames();

        cursor.close();  // CLOSE CURSOR  !!
        return (answer == fieldValue) ? true : false;

    }


    /**
     * sqlVerbList_Reset()
     * -------------------
     * Resets ALL ROWS of 'Incorrect' OR 'Answer' Fields to zero
     * in the Verb_List Table
     * @param  attribute - The Field to be Reset, 'Incorrect' or 'Answer'
     */
    public void sqlVerbList_Reset(String attribute){

        int fieldValue;
        if(attribute.equals(DbSchema.VerbListTable.Cols.CORRECT))
            fieldValue = 1;  // SET CORRECT = 1
        else
            fieldValue = 0;  // SET ASKED = 0

        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put(attribute, fieldValue );

        if (this.mSQLiteDatabase == null)
            open();

        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;
        String whereClause =  null;
        String[] whereArgument = null; // Select *

        this.mSQLiteDatabase.update(table, contentValues, whereClause, whereArgument);
    }

    /**
     * sqlVerbList_AskedReset()
     * ------------------------
     * Resets the 'ASKED' Field in VebList to zero,
     * WHERE CORRECT = 0 or 1 depending on which list of Verbs
     * to reset.
     *
     * @param  correct - The ASKED Field to be Reset. WHERE CORRECT = 0 {Incorrect Answers} or WHERE CORRECT = 1 {Correct Answers}
     */
    public void sqlVerbList_AskedReset(int correct){

        int zeroInt = 0;
        String attribute = DbSchema.VerbListTable.Cols.ASKED;
        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put( attribute, zeroInt ); // manual _id insert for first record

        if (this.mSQLiteDatabase == null)
            open();

        String table = DbSchema.VerbListTable.VERB_LIST_TABLE;
        String whereClause =  DbSchema.VerbListTable.Cols.CORRECT + "=?";
        String[] whereArgument = new String[]{Integer.toString(correct)}; // Select *

        this.mSQLiteDatabase.update(table, contentValues, whereClause, whereArgument);
    }


    // =============================== LATIN NOUNS =================================================

    /**
     * getNounEtcIDlist()
     * -----------------
     * Generates a list of NounEtc IDs, given table, CORRECT selection, and option for constrained
     * restrictions on Declension
     * @param table - NounList, PrepositionList, ConjunctionList
     * @param correct - Select WHERE CORRECT = 0 or CORRECT = 1;
     * @param restricted - True: Restrict Declensions to 3 or under.
     * @return List<Integer> of Noun IDs subject to conditions.
     *
     * */
    public List<Integer> getNounEtcIDlist(String table, int correct, boolean restricted){

        int maxDecl = 3;
        String[] column = new String[]{DbSchema.NounListTable.Cols._id}; // SELECT _id

        String whereClause = DbSchema.NounListTable.Cols.ASKED + "=? AND " +  // UNRESTRICTED LIST
                             DbSchema.NounListTable.Cols.CORRECT + "=?";

        if(restricted) {                                                      // RESTRICTED
            whereClause =  whereClause + " AND " +
                    DbSchema.NounListTable.Cols.DECLENSION + "<=?";
        }

        String[] whereArgs;
        if(!restricted){
            whereArgs = new String[]{Integer.toString(0),        // ASKED
                    Integer.toString(correct)};// CORRECT
        } else {
            whereArgs = new String[]{Integer.toString(0),        // ASKED
                    Integer.toString(correct),// CORRECT
                    Integer.toString(maxDecl) }; // DECLENSION
        }

        List<Integer> nounIDList = new ArrayList<>();

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs);  // set up cursor pointing at db
        try {
            cursor.moveToFirst();    // move cursor to first element of db
            while (!cursor.isAfterLast()) {  // while NOT after last element
                nounIDList.add(cursor.getInt(cursor.getColumnIndex(DbSchema.VerbListTable.Cols._id)));  // getCrime from cursorWrapper takes db tuple -> Java Crime object
                cursor.moveToNext();
            }
        } finally {
            cursor.close();  // CLOSE CURSOR  !!
        }
        return  nounIDList;
    }


    /**
     * sqlNounListQuery()
     * ------------------
     *  A sql inquiry on the Noun List Table given the id. Returns the NounRegular object.
     * or its SubClass Noun_Irregular.
     * @param nounType - REGULAR or IRREGULAR
     * @param id - Row ID
     * @return NounRegular (which can be DownCast to NounIrregular).
     */
    public NounRegular sqlNounListQuery(String nounType, int id){
        String strId = Integer.toString(id);
        String table = DbSchema.NounListTable.NOUN_LIST_TABLE;           // FROM Table = VerbListCursor
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        NounListCursor nounListCursor;
        if(nounType.equals(NOUN_REGULAR))
            nounListCursor = (NounListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        else  // NOUN IRREGULAR
            nounListCursor = (NounListCursor) sqlQuery(nounType, table, column, whereClause, whereArgs  ); // Run SQL query

        nounListCursor.moveToFirst();

        NounRegular noun = nounListCursor.makeNounObject();  // Convert Query from Cursor to Verb Object.
        nounListCursor.close();
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
        cursor.close();
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
    public String sqlNounIrregularQuery(String nounIrregular, String number, String latin_Case, String gender) {

        nounIrregular = nounIrregular.substring(0,1).toUpperCase() + nounIrregular.substring(1); // make First Letter Upper Case.

        String table = DbSchema.NounIrregularTable.NOUN_IRREGULAR_TABLE;  // FROM NOUN_IRREGULAR_TABLE Table

        String[] column = new String[]{nounIrregular};  // SELECT the Column ""

        String[] whereArgs;
        String whereClause;

        whereArgs = new String[]{  number, latin_Case, gender };
        whereClause = DbSchema.NounIrregularTable.Cols.NUMBER + "=?" + " AND " +  // WHERE ... AND
                DbSchema.NounIrregularTable.Cols.LATIN_CASE + "=?" + " AND " +
                DbSchema.NounIrregularTable.Cols.GENDER + "=?";

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();


        String latinNounIrregular = cursor.getString(cursor.getColumnIndex(nounIrregular));
        cursor.close();
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
        adjectiveListCursor.close();
        return adjective;
    }

    /**
     * sqlAdjectiveSubClassListQuery(String subClassType,int id)
     * -----------------------------
     * SQL query for SubClasses of Adjective, using a cursor to collect data on a row
     * and convert to Adjective. Note that the sql Query Downcasts into the SubClass
     * for you.
     * Object
     * @param subClassType - Adjective Comparative or Superlative
     * @param id - Row Refernce
     * @return Adjective Object
     */
    public Adjective sqlAdjectiveSubClassListQuery(String subClassType, int id) {
        String strId = Integer.toString(id);
        String table = DbSchema.AdjectiveListTable.ADJECTIVE_LIST_TABLE;           // FROM Table = AdjectiveList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        AdjectiveListCursor adjectiveListCursor = (AdjectiveListCursor) sqlQuery(subClassType, table, column, whereClause, whereArgs  ); // Run SQL query
        adjectiveListCursor.moveToFirst();

        Adjective subClassAdjective = adjectiveListCursor.makeAdjectiveObject();  // Convert Query from Cursor to Verb Object.
        adjectiveListCursor.close();
        return subClassAdjective;
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
        cursor.close();
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
        prepositionListCursor.close();
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
        conjunctionListCursor.close();
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

        AdverbListCursor adverbListCursor = (AdverbListCursor) sqlQuery(table, column, whereClause, whereArgs  ); // Run SQL query
        adverbListCursor.moveToFirst();
        Adverb adverb = adverbListCursor.makeAdverbObject();  // Convert Query from Cursor to Verb Object.
        adverbListCursor.close();
        return adverb;
    }


    /**
     * sqlAdverbCheckStem()
     * --------------------
     * Boolean check to see if Adverb has a  stem. This will determoine if
     * the Adverb can be formed to create Noun Cases or
     * Comparartive or Superlatives Sub Classes
     *
     * @param id - Row ID
     * @return True if Adverb Stem Exists.
     */
    public boolean sqlAdverbCheckStem(int id) {
        String strId = Integer.toString(id);
        String table = DbSchema.AdverbListTable.ADVERB_TABLE;
        String[] column = new String[]{DbSchema.AdverbListTable.Cols.LATIN_ADVERB_STEM};
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs);
        int x = cursor.getCount();
        return (x>0) ? true : false;
    }


    /**
     * sqlAdverbSubClassListQuery(String subClassType,int id)
     * -----------------------------
     * SQL query for SubClasses of Adverb, using a cursor to collect data on a row
     * and convert to Adverb. Note that the sql Query Downcasts into the SubClass
     * for you.
     * Object
     * @param subClassType - Adverb Comparative or Superlative
     * @param id - Row Refernce
     * @return Adverb Object
     */
    public Adverb sqlAdverbSubClassListQuery(String subClassType, int id) {
        String strId = Integer.toString(id);
        String table = DbSchema.AdverbListTable.ADVERB_TABLE;           // FROM Table = AdjectiveList
        String[] column = null;             // SELECT *
        String whereClause = "_id=?";
        String[] whereArgs = new String[]{strId}; // WHERE _id =

        AdverbListCursor adverbListCursor = (AdverbListCursor) sqlQuery(subClassType, table, column, whereClause, whereArgs  ); // Run SQL query
        adverbListCursor.moveToFirst();

        Adverb subClassAdverb = adverbListCursor.makeAdverbObject();  // Convert Query from Cursor to Verb Object.
        adverbListCursor.close();
        return subClassAdverb;
    }


    // ------------------------------- CORRECT NOUNS -------------------------------------


    /**
     * sqlNounEtcTable_Insert()
     * -----------------------
     * SQL update of ASKED and CORRECT Fields for ANY NounEtc Table (NounList, Adjective Table, etc.)
     * @param table Database table. Either NounList or Smaller Tables, Adjectives, Adverb, etc.
     * @param nounEtcID Row to be updated, identified by NounEtcID of the given table
     * @param fieldName attribute to be updated:  ASKED or CORRECT
     * @param fieldValue updated value of attribute.
     */
    public void sqlNounEtcTable_Insert(String table, int nounEtcID, String fieldName, int fieldValue ) {

        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put(fieldName, fieldValue); // manual _id insert for first record

        if (this.mSQLiteDatabase == null)
            open();

        String whereClause = DbSchema.NounListTable.Cols._id + "=?";  // ID for
        String[] whereArgument = new String[]{Integer.toString(nounEtcID)}; // WHERE ROW of ID = Verb ID

        this.mSQLiteDatabase.update(table, contentValues, whereClause, whereArgument);  // CV is the Update (Field, Value)
        // whereClause tells which row to update
    }



    /**
     * sqlVerbList_TestInsertion()
     * --------------------------------
     * Test if A Record Entry of 'Incorrect' or 'Answer' Field has been properly inserted in the Verb_List Table
     * @param table Database table. Either NounList or Smaller Tables, Adjectives, Adverb, etc.
     * @param NounEtcID - NounEtc ID to test update
     * @param  fieldName - The Field to test, 'Incorrect' or 'Answer'
     * @param fieldValue - the right value for the Attribute.
     * @return True if check matches fieldValue
     */
    public boolean sqlNounEtcTable_TestInsertion(String table, int NounEtcID, String fieldName, int fieldValue ){

        String[] column = new String[]{fieldName}; // Select Column

        String whereClause = DbSchema.NounListTable.Cols._id + "=?";  // Where
        String strId = Integer.toString(NounEtcID);
        String[] whereArgs = new String[]{strId};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();
        int answer = cursor.getInt(cursor.getColumnIndex(fieldName));


        int x = cursor.getCount();
        String[] cols = cursor.getColumnNames();

        cursor.close();  // CLOSE CURSOR  !!
        return (answer == fieldValue) ? true : false;

    }



    /**
     * sqlNounEtcTable_Reset()
     * ----------------------
     * Resets ALL ROWS of 'Incorrect' OR 'Answer' Fields to zero
     * in the NounEtc Tables
     * @param table Database table. Either NounList or Smaller Tables, Adjectives, Adverb, etc.
     * @param  attribute - The Field to be Reset, 'Incorrect' or 'Answer'
     */
    public void sqlNounEtcTable_Reset(String table, String attribute){

        int fieldValue;
        if(attribute.equals(DbSchema.NounListTable.Cols.CORRECT))
            fieldValue = 1;  // SET CORRECT = 1
        else
            fieldValue = 0;  // SET ASKED = 0

        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put(attribute, fieldValue );

        if (this.mSQLiteDatabase == null)
            open();

        String whereClause =  null;
        String[] whereArgument = null; // Select *

        this.mSQLiteDatabase.update(table, contentValues, whereClause, whereArgument);
    }

    /**
     * sqlNounEtcTable_AskedReset()
     * ------------------------
     * Resets the 'ASKED' Field in a NounEtc table to zero,
     * WHERE CORRECT = 0 or 1 depending on which list of Verbs
     * to reset.
     *
     * @param  correct - UPDATE WHERE CORRECT = 0 {Incorrect Answers} or WHERE CORRECT = 1 {Correct Answers}
     */
    public void sqlNounEtcTable_AskedReset(String table, int correct){

        int zeroInt = 0;
        String attribute = DbSchema.NounListTable.Cols.ASKED;
        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put( attribute, zeroInt ); // manual _id insert for first record

        if (this.mSQLiteDatabase == null)
            open();

        String whereClause =  DbSchema.NounListTable.Cols.CORRECT + "=?";
        String[] whereArgument = new String[]{Integer.toString(correct)}; // Select *

        this.mSQLiteDatabase.update(table, contentValues, whereClause, whereArgument);
    }

//    /**
//     * sqlIncorrectVerb_GetId()
//     * ------------------------
//     * Retrieves the NounId from the INCORRECT_NOUNETC_TABLE.
//     * This is the 'Incorrect NounEtc' that corresponds with the Table's id (passed as argument)
//     * @param id the id of the Incorrect_NounEtc Table
//     * @return the NounId
//     */
//    public int sqlIncorrectNounEtc_GetId(int id){
//
//        String table = DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE;
//        String columnName = DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_ID;  // SELECT verb_Id
//        String[] column = new String[]{columnName};
//
//        String whereClause = DbSchema.Incorrect_NounEtc_Table.Cols._id + "=?"; // WHERE _id =
//        String strId = Integer.toString(id);
//        String[] whereArgs = new String[]{strId};
//
//        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
//        int nounId;
//
//        if(cursor.getCount() == 0)
//            nounId = -1;     // defence check to see if id is in Table
//        else {
//            cursor.moveToFirst();
//            nounId = cursor.getInt(cursor.getColumnIndex(columnName));
//        }
//        cursor.close();
//        return nounId;
//    }


//    /**
//     * sqlIncorrectNounEtc_GetType()
//     * -----------------------------
//     * Retrieves the NounType from the INCORRECT_NOUNETC_TABLE.
//     * This is the Type of the 'Incorrect NounEtc' that corresponds with the Table's id (passed as argument)
//     * @param id
//     * @return Type of the 'Incorrect NounEtc' (Noun, Pronoun, Conjunction etc.)
//     */
//    public String sqlIncorrectNounEtc_GetType(int id){
//
//        String table = DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE;
//        String columnName = DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_TYPE;  // SELECT verb_Id
//        String[] column = new String[]{columnName};
//
//        String whereClause = DbSchema.Incorrect_NounEtc_Table.Cols._id + "=?"; // WHERE _id =
//        String strId = Integer.toString(id);
//        String[] whereArgs = new String[]{strId};
//
//        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
//        cursor.moveToFirst();
//
//        String nounType = cursor.getString(cursor.getColumnIndex(columnName));
//        cursor.close();
//        return nounType;
//    }
//
//
//
//
//    /**
//     * sqlIncorrectNounEtc_Insert()
//     * ----------------------------
//     * Inserts a nounType and nounId into INCORRECT_NOUNETC_TABLE.
//     * @param nounId
//     * @param nounId
//     */
//    public void sqlIncorrectNounEtc_Insert(String nounType, int nounId) {
//
//        // check that record does not exist already
//        boolean testIfAlreadyInserted = sDatabaseAccess.sqlIncorrectNounEtc_TestInsertion(nounType,nounId);
//        if(testIfAlreadyInserted)
//            return;   // STOP ALREADY INSERTED
//
//        // check table size
//        int tableSize = sqlTableCountQuery(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE);
//        int id = tableSize + 1;  // increment the table's id - Autoincrement will not do this properly following a reset
//
//        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
//        contentValues.put(DbSchema.Incorrect_NounEtc_Table.Cols._id, id);
//        contentValues.put(DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_TYPE, nounType);
//        contentValues.put(DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_ID, nounId);  // use key-value
//
//        if (this.mSQLiteDatabase == null)
//            open();
//
//        this.mSQLiteDatabase.insertWithOnConflict(DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE, null, contentValues, SQLiteDatabase.CONFLICT_IGNORE);
//    }
//
//    /**
//     * sqlIncorrectNounEtc_TestInsertion()
//     * -----------------------------------
//     * Test if A Record Entry has been properly inserted in the INCORRECT_NOUNETC_TABLE.
//     * @param nounType
//     * @param nounId
//     * @return
//     */
//    public boolean sqlIncorrectNounEtc_TestInsertion(String nounType, int nounId){
//        String table = DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE;
//
//        String[] column = null; // Select *
//
//        String whereClause = DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_TYPE + "=?" + " AND " +
//                DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_ID + "=?";
//
//        String strId = Integer.toString(nounId);
//        String[] whereArgs = new String[]{nounType, strId};
//
//        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
//        if (cursor.getCount() == 0) // Cursor is empty, so no record exists
//            return false;
//        else
//            return true;
//    }
//
//    /**
//     * sqlIncorrectNounEtc_Delete()
//     * ----------------------------
//     * Deletes row from INCORRECT_NOUNETC_TABLE  WHERE NounType and NounId are given as arguments.
//     * @param nounId
//     * @param nounType
//     */
//    public void sqlIncorrectNounEtc_Delete(String nounType, int nounId){
//
//        String table = DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE;
//
//        String whereClause = DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_TYPE + "=?" + " AND " +
//                             DbSchema.Incorrect_NounEtc_Table.Cols.NOUNETC_ID + "=?";
//
//        String strId = Integer.toString(nounId);
//        String[] whereArgs = new String[]{nounType, strId};
//
//        if (this.mSQLiteDatabase == null)
//            open();
//
//        this.mSQLiteDatabase.delete(table, whereClause, whereArgs);
//    }
//
//    /**
//     * sqlIncorrectNounEtc_Reset()
//     * ---------------------------
//     * Clears all records from the INCORRECT_NOUNETC_TABLE. That is, wipes all Incorrect Verbs
//     */
//    public void sqlIncorrectNounEtc_Reset(){
//
//        String table = DbSchema.Incorrect_NounEtc_Table.INCORRECT_NOUNETC_TABLE;
//
//        if (this.mSQLiteDatabase == null)
//            open();
//
//        this.mSQLiteDatabase.delete(table,null,null);
//    }

// ----------------------------- META TABLE --------------------------------------


    /**
     * sqlMeta_Insertion()
     * -------------------
     * Updates a Field in the Meta Table using a key-value set up.
     * @param key  Field: Variable (e.g. skill Level)
     * @param value Field Value (e.g. 3)
     *
     */
    public void sqlMeta_Insertion(String key, double value){

        String table = DbSchema.Meta_Table.META_TABLE;   // UPDATE META-TABLE
        ContentValues contentValues = new ContentValues(); // ContentValues is a class to help format insertion
        contentValues.put(DbSchema.Meta_Table.Cols.VALUE, value); // Value

        String whereClause = DbSchema.Meta_Table.Cols.KEY + "=?";
        String[] whereArgument = new String[]{key}; // WHERE ROW  = Key

        if (this.mSQLiteDatabase == null)
            open();
        this.mSQLiteDatabase.update(table, contentValues, whereClause, whereArgument);  // CV is the Update (Field, Value)
                                                                                        // whereClause tells which row to update
    }


    /**
     * sqlMetaQuery()
     * --------------
     * Does a SQL query on Meta Table using a Key-Value system.
     * @param key
     * @return Corresponding Value for the Key.
     */
    public int sqlMetaQuery(String key){

        String table = DbSchema.Meta_Table.META_TABLE;  // FROM Meta Table
        String[] column = new String[]{DbSchema.Meta_Table.Cols.VALUE};  // SELECT KEY

        String[] whereArgs;
        String whereClause;

        whereClause = DbSchema.Meta_Table.Cols.KEY + "=?"; // WHERE
        whereArgs = new String[]{key};

        Cursor cursor = sqlQuery(table, column, whereClause, whereArgs );
        cursor.moveToFirst();
        int value = cursor.getInt(cursor.getColumnIndex(DbSchema.Meta_Table.Cols.VALUE));
        cursor.close();
        return value;
    }





}
