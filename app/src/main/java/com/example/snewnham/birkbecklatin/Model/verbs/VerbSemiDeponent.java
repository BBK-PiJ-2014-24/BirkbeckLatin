package com.example.snewnham.birkbecklatin.Model.verbs;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

/**
 * Created by snewnham on 25/10/2016.
 */

public class VerbSemiDeponent extends VerbRegular {

    // Constructors
    // ------------
    public VerbSemiDeponent(int id) {
        super(id);
    }

    public VerbSemiDeponent(int id, DatabaseAccess databaseAccess) {
        super(id, databaseAccess);
    }

    /**
     * makeLatinVerb()
     * ===============
     * Method that builds the SEMI-DEPONENT Latin Verb given person, number tense, mood, voice
     *
     *      * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice Override to Ensure that Deponent Latin Verbs
     *              HAVE PASSIVE ENDINGS for PERFECT, PLUPERFECT, FUTURE PERFECT
     * @param conjNum
     * @return
     */
    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        mTense = tense;
        mVoice = voice;
        mMood = mood;

        if (voice.equals("Passive")) { // SemiDeponent Verbs cannot be Passive!
            setLatinStem(null);
            setLatinEnding(null);
            setLatinVerb(null);
            return null;
        } else if( mood.equals("Imperative") ) { // check for Imperatives
            return super.makeLatinVerb(databaseAccess, person, number, tense, mood, voice, conjNum);
        } else if (tense.equals("Present") || tense.equals("Imperfect") || tense.equals("Future") ) {
            return super.makeLatinVerb(databaseAccess, person, number, tense, mood, voice, conjNum);
        } else if (tense.equals("Perfect") || tense.equals("Pluperfect") || tense.equals("Future Perfect")) {
            String voicePassive = "Passive";
            return super.makeLatinVerb(databaseAccess, person, number, tense, mood, voicePassive, conjNum);  // Voice Override
        } else {
            return null;
        }


    }
    /**
     * makeEnglishVerb()
     * =================
     * Make the correct English Translation of a given Latin Verb
     *
     * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice - ALWAYS SHOULD BE ACTIVE ELSE RETURN NULL
     * @return
     */

    @Override
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice){

        if( voice.equals("Passive") ) {
            setEnglishPerson(null); // SemiDeponent Verbs cannot be Passive!
            setEnglishAuxiliaryVerb(null);
            setEnglishVerbEnding(null);
            setEnglishVerb(null);
            return null;
        } else {
            return super.makeEnglishVerb(databaseAccess, person, number, tense, mood, voice);
        }
    }
}
