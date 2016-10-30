package com.example.snewnham.birkbecklatin.Model;

/**
 * Created by snewnham on 29/10/2016.
 */

public class VerbIrregular extends VerbRegular {

    // Constructor
    // -----------
    public VerbIrregular(int id) {
        super(id);
    }

    public VerbIrregular(int id, DatabaseAccess databaseAccess) {
        super(id, databaseAccess);
    }

    /**
     * makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense, String mood, String voice, String conjNum)
     * ============
     * compose Irregular Latin Verb
     * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @param conjNum - set as null as irregular conjucation
     * @return
     */
    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        if(mDatabaseAccess == null) {
            this.mDatabaseAccess = databaseAccess;
        }

        setLatinStem(null);  // set stem to null
        setLatinEnding(null);  // set ending to null
        String irregularVerb = getLatin_Infinitive();

        String latinIrregularVerb = databaseAccess.sqlLatinIrregularVerb(irregularVerb, person, number, tense, mood, voice);
        setLatinVerb(latinIrregularVerb);  // set field of latin IrregularVerb

        return latinIrregularVerb;
    }

    @Override
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice) {

        String latinInfinitive = getLatin_Infinitive();
        if( latinInfinitive.equals("esse") ){

        } else {
            String englishVerb = super.makeEnglishVerb(databaseAccess, person, number, tense, mood, voice);
        }

        return null;
    }



}
