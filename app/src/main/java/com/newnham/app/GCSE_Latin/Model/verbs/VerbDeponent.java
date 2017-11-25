package com.newnham.app.GCSE_Latin.Model.verbs;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.VOICE_ACTIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.VOICE_PASSIVE;

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


   // protected final static String ACTIVE = "Active";
   // protected final static String PASSIVE = "Passive";


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
     * @param voice - ALWAYS VOICE_PASSIVE ELSE null
     * @param conjNum
     * @return
     */
    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        mTense = tense;
        mVoice = voice;
        mMood = mood;

        if( voice.equals(VOICE_ACTIVE) ){
            // Override to Ensure that Deponent Latin Verbs ALWAYS HAVE VOICE_PASSIVE ENDINGS
            String latinWord = super.makeLatinVerb(databaseAccess,person,number,tense,mood, VOICE_PASSIVE, conjNum);
            mVoice = VOICE_ACTIVE;  // Override again to Ensure that Voice = Acive
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
     * @param voice - ALWAYS VOICE_ACTIVE OR ELSE null
     * @return
     */
    @Override
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice){

        if( voice.equals(VOICE_ACTIVE) ) {
            String voiceActive = VOICE_ACTIVE; //Override to Ensure that Deponent Latin Verbs ALWAYS HAVE VOICE_ACTIVE ENGLISH MEANINGS
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
