package com.newnham.app.GCSE_Latin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.newnham.app.GCSE_Latin.Model.nouns.Adjective;
import com.newnham.app.GCSE_Latin.Model.nouns.AdjectiveComparative;
import com.newnham.app.GCSE_Latin.Model.nouns.AdjectiveSuperlative;

/**
 * AdjectiveListCursor
 * --------------
 * Takes a DB query on the Adjective_List table, which is in the form of a cursor, and converts
 * that data into a Adjective Object. A mini internal 'factory' is used to create the correct
 * Adjective class or subclass(i.e., Adjective, Comparative, Superlative etc.)
 *
 *
 * Created by snewnham on 05/11/2016.
 */

public class AdjectiveListCursor extends CursorWrapper{

    // Field
    // -----
    String adjective_type;

    private final static String ADJECTIVE = "Adjective";
    private final static String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";
    private final static String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";


    // Constructor
    // -----------
    public AdjectiveListCursor(Cursor cursor, String adjective_type) {
        super(cursor);
        this.adjective_type = adjective_type;
    }


    /**
     * makeAdjectiveObject()
     * ================
     * Converts a Cursor into a NounEtc Object
     * @return
     */
    public <T extends Adjective> T makeAdjectiveObject() {

        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.AdjectiveListTable.Cols._id));
        String type = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.TYPE));
        int declension = getInt(getColumnIndex(DbSchema.AdjectiveListTable.Cols.DECLENSION));
        String nominative = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.NOMINATIVE));
        String nominativeNeuter = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.NOMINATIVE_NEUTER));
        String latinAdjStem = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.LATIN_ADJECTIVE_STEM));
        String englishAdjective = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.ENGLISH_ADJECTIVE));
        String latinComparativeStem = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.LATIN_COMPARATIVE_STEM));
        String englishComparative = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.ENGLISH_COMPARATIVE));
        String latinSuplerlativeStem = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.LATIN_SUPERLATIVE_STEM));
        String englishSuperlative = getString(getColumnIndex(DbSchema.AdjectiveListTable.Cols.ENGLISH_SUPERLATIVE));

        Adjective adjective = getTypeObject(id);

        // Transfer db data to a Adjective object
        // --------------------------------------
        adjective.setId(id);
        adjective.setType(type);
        adjective.setDeclension(declension);
        adjective.setNominative(nominative);
        adjective.setNominative_Neuter(nominativeNeuter);
        adjective.setLatinAdjectiveStem(latinAdjStem);
        adjective.setEnglishAdjective(englishAdjective);
        adjective.setLatinComparativeStem(latinComparativeStem);
        adjective.setEnglishComparative(englishComparative);
        adjective.setLatinSuperlativeStem(latinSuplerlativeStem);
        adjective.setEnglishSuperlative(englishSuperlative);


        return (T) adjective;
    }

    /**
     * getTypeObject()
     * ---------------
     * Returns the Correct Class/SubClass of the Adjective Object
     * @param id - id of the NounEtc
     * @return -  Adjective Object or Comparative, Superlative Objects
     */
    public Adjective getTypeObject(int id){

        switch(adjective_type){
            case ADJECTIVE:
                return new Adjective(id);
            case ADJECTIVE_COMPARATIVE:
                return new AdjectiveComparative(id);
            case ADJECTIVE_SUPERLATIVE:
                return new AdjectiveSuperlative(id);
        }
        return null;
    }
}
