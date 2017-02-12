package com.example.snewnham.birkbecklatin.Model.verbs;

import com.example.snewnham.birkbecklatin.Model.database.DatabaseAccess;

import java.net.PasswordAuthentication;

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


    protected final static String ACTIVE = "Active";
    protected final static String PASSIVE = "Passive";


    /**
     * makeLatinVerb()
     * ===============
     * Method that builds the DEPONENT Latin Verb given person, number tense, mood, voice
     *
     * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice - ALWAYS PASSIVE ELSE null
     * @param conjNum
     * @return
     */
    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        mTense = tense;
        mVoice = voice;
        mMood = mood;

        if( voice.equals(ACTIVE) ){
            // Override to Ensure that Deponent Latin Verbs ALWAYS HAVE PASSIVE ENDINGS
            String latinWord = super.makeLatinVerb(databaseAccess,person,number,tense,mood, PASSIVE, conjNum);
            mVoice = ACTIVE;  // Override again to Ensure that Voice = Acive
            return latinWord;
        } else {
            setLatinStem(null);
            setLatinEnding(null);
            setLatinVerb(null);
            return null;
        }
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
     * @param voice - ALWAYS ACTIVE OR ELSE null
     * @return
     */
    @Override
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice){

        if( voice.equals("Active") ) {
            String voiceActive = "Active"; //Override to Ensure that Deponent Latin Verbs ALWAYS HAVE ACTIVE ENGLISH MEANINGS
            return super.makeEnglishVerb(databaseAccess, person, number, tense, mood, voiceActive);
        } else {
            setEnglishPerson(null); // Deponent Verbs cannot be Passive!
            setEnglishAuxiliaryVerb(null);
            setEnglishVerbEnding(null);
            setEnglishVerb(null);
            return null;
        }
    }

}
