package com.newnham.app.GCSE_Latin.Model.verbs;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;

import static com.newnham.app.GCSE_Latin.Model.LatinConstants.MOOD_IMPERATIVE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_FUTURE;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_FUTURE_PERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_IMPERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_PERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_PLUPERFECT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.TENSE_PRESENT;
import static com.newnham.app.GCSE_Latin.Model.LatinConstants.VOICE_PASSIVE;

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
     *              HAVE VOICE_PASSIVE ENDINGS for TENSE_PERFECT, TENSE_PLUPERFECT, TENSE_FUTURE TENSE_PERFECT
     * @param conjNum
     * @return
     */
    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        mTense = tense;
        mVoice = voice;
        mMood = mood;

        if (voice.equals(VOICE_PASSIVE)) { // SemiDeponent Verbs cannot be Passive!
            setLatinStem(null);
            setLatinEnding(null);
            setLatinVerb(null);
            return null;
        } else if( mood.equals(MOOD_IMPERATIVE) ) { // check for Imperatives
            return super.makeLatinVerb(databaseAccess, person, number, tense, mood, voice, conjNum);
        } else if (tense.equals(TENSE_PRESENT) || tense.equals(TENSE_IMPERFECT) || tense.equals(TENSE_FUTURE) ) {
            return super.makeLatinVerb(databaseAccess, person, number, tense, mood, voice, conjNum);
        } else if (tense.equals(TENSE_PERFECT) || tense.equals(TENSE_PLUPERFECT) || tense.equals(TENSE_FUTURE_PERFECT)) {
            String voicePassive = VOICE_PASSIVE;
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
     * @param voice - ALWAYS SHOULD BE VOICE_ACTIVE ELSE RETURN NULL
     * @return
     */

    @Override
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice){

        if( voice.equals(VOICE_PASSIVE) ) {
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
