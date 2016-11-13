package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.nouns.NounEtc;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;

/**
 * NounListCursor
 * --------------
 * Takes a DB query on the Noun_List table, which is in the form of a cursor, and converts
 * that data into a NounEtc Object. A mini internal 'factory' is used to create the correct NounEtc class(i.e.,
 * NounRegular, Pronoun etc.)
 *
 *
 * Created by snewnham on 05/11/2016.
 */

public class NounListCursor extends CursorWrapper{

    // Constructor
    // -----------
    public NounListCursor(Cursor cursor) {
        super(cursor);
    }


    /**
     * makeNounObject()
     * ================
     * Converts a Cursor into a NounEtc Object
     * @return
     */
    public NounRegular makeNounObject() {

        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.NounListTable.Cols._id));
        String type = getString(getColumnIndex(DbSchema.NounListTable.Cols.TYPE));
        int declension = getInt(getColumnIndex(DbSchema.NounListTable.Cols.DECLENSION));
        String gender = getString(getColumnIndex(DbSchema.NounListTable.Cols.GENDER));
        String nominative = getString(getColumnIndex(DbSchema.NounListTable.Cols.NOMINATIVE));
        String genitive = getString(getColumnIndex(DbSchema.NounListTable.Cols.GENITIVE));
        String genitivePlural = getString(getColumnIndex(DbSchema.NounListTable.Cols.GENITIVE_PLURAL));
        String latinNounStem = getString(getColumnIndex(DbSchema.NounListTable.Cols.LATIN_NOUN_STEM));
        String englishNounSingular = getString(getColumnIndex(DbSchema.NounListTable.Cols.ENGLISH_NOUN_SINGULAR));
        String englishNounPlural = getString(getColumnIndex(DbSchema.NounListTable.Cols.ENGLISH_NOUN_PLURAL));


        // Mini Factory - Create Verb Object
        //----------------------------------
        NounRegular noun = new NounRegular(id);



        // Transfer db data to a NounEtc object
        // ----------------------------------
        noun.setId(id);
        noun.setType(type);
        noun.setDeclension(declension);
        noun.setGender(gender);
        noun.setNominative(nominative);
        noun.setGenitive(genitive);
        noun.setGenitivePlural(genitivePlural);
        noun.setLatinWordStem(latinNounStem);
        noun.setEnglishWordSingular(englishNounSingular);
        noun.setEnglishWordPlural(englishNounPlural);
        return noun;
    }
}
