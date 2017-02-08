package com.example.snewnham.birkbecklatin.Model.verbs;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

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

        mTense = tense;
        mVoice = voice;
        mMood = mood;

        if(mDatabaseAccess == null) {
            this.mDatabaseAccess = databaseAccess;
        }

        setLatinStem(null);  // set stem to null
        setLatinEnding(null);  // set ending to null
        String irregularVerb = getLatin_Infinitive();

        String latinIrregularVerb = databaseAccess.sqlLatinIrregularVerb(irregularVerb,person,number,mood,voice,tense);
        setLatinVerb(latinIrregularVerb);  // set field of latin IrregularVerb
        mLatinVerb = latinIrregularVerb;

        return latinIrregularVerb;
    }

    /**
     * makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number, String tense, String mood, String voice)
     * ===============
     * Makes an English Verb from an Irregular Latin Verb.
     * Note that ESSE, to be, is irregular in English as well, which is taken into account.
     * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @return
     */
    @Override
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice) {

        String latin_infinitive_verb = getLatin_Infinitive();
        // Check to See If The Verb is Not Defective for the given verb parameters - person, mood etc.
        String latin_Verb = makeLatinVerb(databaseAccess, person, number, tense, mood, voice, null);

        if(latin_Verb == null){
            makeEnglishVerbNull();  // If latin verb == null => English verb should be null
            return null;
        } else {
            String englishVerb = super.makeEnglishVerb(databaseAccess, person, number, tense, mood, voice);

            // Verb Ending Adjustment if Irregular Verb is 'to be' ESSE
            // --------------------------------------------------------
            if (latin_infinitive_verb.equals("esse") || latin_infinitive_verb.equals("Esse")) {

                if (voice.equals("Passive")) {  // defence checker for all passive to be to null.
                    makeEnglishVerbNull();
                    return getEnglishVerb();
                }
                englishVerb = databaseAccess.sqlEnglishIrregularESSEVerb(latin_infinitive_verb, person, number, tense, mood, voice);

                if (englishVerb == null) {
                    englishVerb = "";
                }
                setEnglishVerbEnding(englishVerb);  // Reset Verb Ending
                setEnglishVerb(getEnglishPerson() + getEnglishAuxiliaryVerb() + englishVerb); // Reset Complete Verb
            }
        }
        return getEnglishVerb();
    }

    /**
     * makeEnglishVerbNull()
     * =====================
     * helper method to set the English Verb Fields to Null.
     *
     */
    private void makeEnglishVerbNull(){
        setEnglishPerson(null);
        setEnglishAuxiliaryVerb(null);
        setEnglishVerbEnding(null);
        setEnglishVerb(null);
    }



}
