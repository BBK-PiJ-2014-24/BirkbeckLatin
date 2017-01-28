package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.nouns.Adjective;
import com.example.snewnham.birkbecklatin.Model.nouns.Adverb;
import com.example.snewnham.birkbecklatin.Model.nouns.AdverbComparative;
import com.example.snewnham.birkbecklatin.Model.nouns.AdverbSuperlative;

/**
 * AdjectiveListCursor
 * --------------
 * Takes a DB query on the Adverb_List table, which is in the form of a cursor, and converts
 * that data into a Adverb Object or its SubClass. A mini internal 'factory' is used to create the correct
 * Adverb class or subclass(i.e., Adverb, Comparative, Superlative etc.)
 *
 *
 * Created by snewnham on 05/16/2016.
 */

public class AdverbListCursor extends CursorWrapper{

    // Field
    // -----
    private final static String ADVERB = "Adverb";
    private final static String ADVERB_COMPARATIVE = "AdverbComparative";
    private final static String ADVERB_SUPERLATIVE = "AdverbSuperlative";


    String adverb_type;

    // Constructor
    // -----------
    public AdverbListCursor(Cursor cursor, String adverb_type ) {
        super(cursor);
        this.adverb_type = adverb_type;
    }


    /**
     * makeAdverbObject()
     * =================
     * Converts a Cursor into a Adverb-NounEtc Object
     * @return
     */
    public <T extends Adverb> T makeAdverbObject() {

        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.AdverbListTable.Cols._id));
        int declension = getInt(getColumnIndex(DbSchema.AdverbListTable.Cols.DECLENSION));
        String latinAdverb = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.LATIN_ADVERB));
        String latinAdverbStem = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.LATIN_ADVERB_STEM));
        String englishAdverb = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.ENGLISH_ADVERB));
        String englishAdverbComparative = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.ENGLISH_ADVERB_COMPARATIVE));
        String englishAdverbSuperlative = getString(getColumnIndex(DbSchema.AdverbListTable.Cols.ENGLISH_ADVERB_SUPERLATIVE));

        Adverb adverb = getTypeObject(id);
        
        // Transfer db data to a Adverb object
        // -----------------------------------
        adverb.setId(id);
        adverb.setDeclension(declension);
        adverb.setLatinAdverb(latinAdverb);
        adverb.setLatinAdverbStem(latinAdverbStem);
        adverb.setEnglishAdverb(englishAdverb);
        adverb.setEnglishAdverbComparative(englishAdverbComparative);
        adverb.setEnglishAdverbSuperlative(englishAdverbSuperlative);


        return (T) adverb;
    }


    /**
     * getTypeObject()
     * ---------------
     * Returns the Correct Class/SubClass of the Adverb Object
     * @param id - id of the NounEtc
     * @return -  Adverb Object or Comparative, Superlative Objects
     */
    public Adverb getTypeObject(int id){

        switch(this.adverb_type){
            case ADVERB:
                return new Adverb(id);
            case ADVERB_COMPARATIVE:
                return new AdverbComparative(id);
            case ADVERB_SUPERLATIVE:
                return new AdverbSuperlative(id);
        }
        return null;
    }
}
