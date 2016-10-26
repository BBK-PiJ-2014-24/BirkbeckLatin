package com.example.snewnham.birkbecklatin.Model;

/**
 * Created by snewnham on 23/10/2016.
 */

public class VerbDeponent extends VerbRegular {

    // CONSTRUCTORS
    // ------------
    public VerbDeponent(int id) {
        super(id);
    }

    public VerbDeponent(int id, DatabaseAccess databaseAccess) {
        super(id, databaseAccess);
    }


    /**
     * makeLatinVerb()
     * ===============
     * Method that builds the DEPONENT Latin Verb given person, number tense, mood, voice
     *
     *      * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice - ALWAYS PASSIVE
     * @param conjNum
     * @return
     */
    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        String voicePassive = "Passive"; // Override to Ensure that Deponent Latin Verbs ALWAYS HAVE PASSIVE ENDINGS

        return super.makeLatinVerb(databaseAccess,person,number,tense,mood, voicePassive, conjNum);
    }

    /**
     * makeEnglishVerb()
     * =================
     * Make the correct English Translation of a given DEPONENT Latin Verb
     *
     * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice - ALWAYS ACTIVE
     * @return
     */
    @Override
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice){

        String voiceActive = "Active"; //Override to Ensure that Deponent Latin Verbs ALWAYS HAVE ACTIVE ENGLISH MEANINGS
        return super.makeEnglishVerb(databaseAccess,person,number,tense,mood, voiceActive);
    }

}
