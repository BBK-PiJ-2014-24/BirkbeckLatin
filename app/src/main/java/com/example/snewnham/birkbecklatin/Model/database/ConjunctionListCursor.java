package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.nouns.Conjunction;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;

/**
 * ConjunctionListCursor
 * ---------------------
 * Takes a DB query on the Conjunction_List table, which is in the form of a cursor, and converts
 * that data into a Conjunction Object.
 *
 *
 * Created by snewnham on 05/11/2016.
 */

public class ConjunctionListCursor extends CursorWrapper{

    // Constructor
    // -----------
    public ConjunctionListCursor(Cursor cursor) {
        super(cursor);
    }


    /**
     * makePrepositionObject()
     * =======================
     * Converts a Cursor into a NounEtc Object
     * @return
     */
    public Conjunction makeConjunctionObject() {

        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.ConjunctionListTable.Cols._id));
        String latinConjunction = getString(getColumnIndex(DbSchema.ConjunctionListTable.Cols.LATIN_CONJUNCTION));
        String englishConjunction = getString(getColumnIndex(DbSchema.ConjunctionListTable.Cols.ENGLISH_CONJUNCTION));

        Conjunction conjunction = new Conjunction(id);


        // Transfer db data to a Adjective object
        // --------------------------------------
        conjunction.setId(id);
        conjunction.setLatinWord(latinConjunction);
        conjunction.setEnglishWordSingular(englishConjunction);

        return conjunction;
    }
}
