package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.nouns.Noun;
import com.example.snewnham.birkbecklatin.Model.nouns.NounRegular;

/**
 * NounListCursor
 * --------------
 * Takes a DB query on the Noun_List table, which is in the form of a cursor, and converts
 * that data into a Noun Object. A mini internal 'factory' is used to create the correct Noun class(i.e.,
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
     * Converts a Cursor into a Noun Object
     * @return
     */
    public Noun makeNounObject() {

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
        String latinOther = getString(getColumnIndex(DbSchema.NounListTable.Cols.LATIN_OTHER));
        String englishNoun = getString(getColumnIndex(DbSchema.NounListTable.Cols.ENGLISH_NOUN));


        // Mini Factory - Create Verb Object
        //----------------------------------
        Noun noun = null;
        switch (type) {
            case "Noun": {
                noun = new NounRegular(id);
                break;
            }
            case "Adjective": {
                noun = null;
                break;
            }
        }


        // Transfer db data to a Noun object
        // ----------------------------------
        noun.setId(id);
        noun.setType(type);
        noun.setDeclension(declension);
        noun.setGender(gender);
        noun.setNominative(nominative);
        noun.setGenitive(genitive);
        noun.setGenitivePlural(genitivePlural);
        noun.setLatinNounStem(latinNounStem);
        noun.setLatin_Other(latinOther);
        noun.setEnglishNoun(englishNoun);

        return noun;
    }
}
