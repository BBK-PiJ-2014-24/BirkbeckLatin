package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Adverb;

/**
 * AdjectiveListCursor
 * --------------
 * Takes a DB query on the Adverb_List table, which is in the form of a cursor, and converts
 * that data into a Adverb Object.
 *
 *
 * Created by snewnham on 05/16/2016.
 */

public class AdverbListCursor extends CursorWrapper{

    // Constructor
    // -----------
    public AdverbListCursor(Cursor cursor) {
        super(cursor);
    }


    /**
     * makeAdverbObject()
     * ================
     * Converts a Cursor into a Adverb-NounEtc Object
     * @return
     */
    public Adverb makeAdverbObject() {

        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.AdverbListTable.Cols._id));
        int declension = getInt(getColumnIndex(DbSchema.AdverbListTable.Cols.DECLENSION));
        String latinAdverb = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.LATIN_ADVERB));
        String latinAdverbStem = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.LATIN_ADVERB_STEM));
        String englishAdverb = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.ENGLISH_ADVERB));
        String englishAdverbComparative = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.ENGLISH_ADVERB_COMPARATIVE));
        String englishAdverbSuperlative = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.ENGLISH_ADVERB_SUPERLATIVE));

        Adverb adverb = new Adverb(id);
        
        // Transfer db data to a Adverb object
        // -----------------------------------
        adverb.setId(id);
        adverb.setDeclension(declension);
        adverb.setLatinAdverb(latinAdverb);
        adverb.setLatinAdverbStem(latinAdverbStem);
        adverb.setEnglishAdverb(englishAdverb);
        adverb.setEnglishAdverbComparative(englishAdverbComparative);
        adverb.setEnglishAdverbSuperlative(englishAdverbSuperlative);
        return adverb;
    }
}
