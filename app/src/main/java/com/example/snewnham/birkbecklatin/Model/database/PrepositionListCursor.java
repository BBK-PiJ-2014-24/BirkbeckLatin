package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Preposition;

import static android.R.attr.type;

/**
 * PrepositionListCursor
 * ---------------------
 * Takes a DB query on the Preposition_List table, which is in the form of a cursor, and converts
 * that data into a Preposition Object.
 *
 *
 * Created by snewnham on 05/11/2016.
 */

public class PrepositionListCursor extends CursorWrapper{

    // Constructor
    // -----------
    public PrepositionListCursor(Cursor cursor) {
        super(cursor);
    }


    /**
     * makePrepositionObject()
     * =======================
     * Converts a Cursor into a NounEtc Object
     * @return
     */
    public Preposition makePrepositionObject() {

        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.PrepositionListTable.Cols._id));
        String latinPreposition = getString(getColumnIndex(DbSchema.PrepositionListTable.Cols.LATIN_PREPOSITION));
        String englishPreposition = getString(getColumnIndex(DbSchema.PrepositionListTable.Cols.ENGLISH_PRESPOSITION));

        Preposition preposition = new Preposition(id);


        // Transfer db data to a Adjective object
        // --------------------------------------
        preposition.setId(id);
        preposition.setLatinWord(latinPreposition);
        preposition.setEnglishWordSingular(englishPreposition);

        return preposition;
    }
}
