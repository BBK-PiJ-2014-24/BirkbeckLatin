package com.newnham.app.birkbecklatin.Model.verbs;

import com.newnham.app.birkbecklatin.Model.database.DatabaseAccess;
import com.newnham.app.birkbecklatin.Model.database.DbSchema;

import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_IMPERATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_INDICATIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NUMBER_INFINITIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.NUMBER_SINGULAR;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PERFECT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.PERSON_3RD;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.TENSE_PRESENT;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.MOOD_SUBJUNCTIVE;
import static com.newnham.app.birkbecklatin.Model.LatinConstants.VOICE_ACTIVE;

/**
 * VerbRegular is the class for regular latin verbs. It contains the same data as that held in the database's 'VerbListCursor' table
 * Created by snewnham on 05/10/2016.
 */

public class VerbRegular implements Verb {

    // Constants
    // ---------

    protected static final String PRESENT_SUBJUNC_STEM = "Present_SubjuncStem";
    protected static final String PARTICIPLE = "Participle";
    protected static final String PARTICIPLE_STEM = "Participle_Stem";
    protected static final String INFINITIVE_STEM = "Infinitive_Stem";
    protected static final String INFINITIVE_PASSIVE_STEM = "Infinitive_PassiveStem";
    protected static final String ENGLISH_INFINITIVE = "English_Infinitive";
    protected static final String ENGLISH_PRESENT_3RDPERSON = "English_Present_3rdPerson";
    protected static final String ENGLISH_PERFECT = "English_Perfect";
    protected static final String ENGLISH_PARTICIPLE = "English_Participle";
    protected static final String START_INFINITIVE = "be ";



    // Fields
    // ------
    protected int mId;
    protected String mLatin_Type;
    protected int mLatin_ConjNum;
    protected String mLatin_Present;
    protected String mLatin_Infinitive;
    protected String mLatin_Perfect;
    protected String mLatin_Participle;
    protected String mLatin_Present_Stem;
    protected String mLatin_Infinitive_Stem;
    protected String mLatin_Infinitive_PassiveStem;
    protected String mLatin_Present_SubjuncStem;
    protected String mLatin_Perfect_Stem;
    protected String mLatin_Participle_Stem;
    protected String mEnglish_Infinitive;
    protected String mEnglish_Present_3rdPerson;
    protected String mEnglish_Perfect;
    protected String mEnglish_Participle;

    protected DatabaseAccess mDatabaseAccess;
    protected String mLatinStem;
    protected String mLatinEnding;
    protected String mLatinVerb;
    protected String mEnglishPerson;
    protected String mEnglishAuxiliaryVerb;
    protected String mEnglishVerbEnding;
    protected String mEnglishVerb;

    protected int mAsked;
    protected int mCorrect;

    protected String mTense;
    protected String mMood;
    protected String mVoice;



    // Constructors
    // ------------

    public VerbRegular(int id) {
        this.mId = id;
        this.mDatabaseAccess = null;

    }

    public VerbRegular(int id, DatabaseAccess databaseAccess) {
        this.mId = id;
        this.mDatabaseAccess = databaseAccess;
    }


    /**
     *  makeLatinVerb()
     * ==============
     *
     * Method that builds a Latin Regular Verb given person, number tense, mood, voice, etc.
     * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @param conjNum
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

        // Find Latin Stem
        //----------------
        String stemTense = mDatabaseAccess.sqlVerbStemQuery(number,mood,voice,tense);
        switch(stemTense){
            case TENSE_PRESENT: {
                this.mLatinStem = mLatin_Present_Stem;
                break;
            }
            case PRESENT_SUBJUNC_STEM: {
                this.mLatinStem = mLatin_Present_SubjuncStem;
                break;
            }
            case TENSE_PERFECT:{
                this.mLatinStem = mLatin_Perfect_Stem;
                break;
            }
            case PARTICIPLE: {
                this.mLatinStem = mLatin_Participle;
                break;
            }
            case PARTICIPLE_STEM: {
                this.mLatinStem = mLatin_Participle_Stem;
                break;
            }
            case NUMBER_INFINITIVE: {
                this.mLatinStem = mLatin_Infinitive;
                break;
            }
            case INFINITIVE_PASSIVE_STEM: {
                this.mLatinStem = mLatin_Infinitive_PassiveStem;
                break;
            }
            case INFINITIVE_STEM: {
                this.mLatinStem = mLatin_Infinitive_Stem;
                break;
            }

        }


        // Find Latin Ending
        // -----------------
        this.mLatinEnding = mDatabaseAccess.sqlVerbEndingQuery(person,number,mood,voice,tense, conjNum);
        if(this.mLatinEnding == null){
            this.mLatinEnding = "";
        }
        this.mLatinVerb = mLatinStem+mLatinEnding;

        return this.mLatinVerb;
    }

    /**
     * makeEnglishVerb()
     * ===============
     * Make the correct English Translation of a given Latin VerbRegular
     *
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

        if(mDatabaseAccess == null) {
            this.mDatabaseAccess = databaseAccess;
        }

        // Determine If the verb requires a person
        if (mood.equals(MOOD_IMPERATIVE) ) {
            mEnglishPerson = ""; // override to drop Person for All Imperatives
        } else if(tense.equals(TENSE_PRESENT) && mood.equals(MOOD_SUBJUNCTIVE)){
            mEnglishPerson = ""; // override to drop Person for Subjunctive, Present Verbs
        } else if (number.equals(NUMBER_INFINITIVE)) {
            mEnglishPerson = ""; // override to drop Person for All Infinitives
        } else {
            mEnglishPerson = databaseAccess.sqlEngPersonQuery(person, number);
        }

        // Pick up an Auxiliary Verb
        mEnglishAuxiliaryVerb = databaseAccess.sqlEngAuxVerbQuery(person, number, mood, voice, tense);
        String englishVerbCase = databaseAccess.sqlEngVerbEnding(number, tense, mood, voice);



        // Determine case of verb
        if( !number.equals(NUMBER_INFINITIVE)  && !mood.equals(MOOD_IMPERATIVE)) { // Avoid nullpointerException for infinitives
            if (person.equals(PERSON_3RD) && number.equals(NUMBER_SINGULAR) && tense.equals(TENSE_PRESENT) && mood.equals(MOOD_INDICATIVE) && voice.equals(VOICE_ACTIVE)) {
                englishVerbCase = DbSchema.VerbListTable.Cols.ENGLISH_PRESENT_3RDPERSON;   // override to pick up present 3rd person present
            }
        }

        switch(englishVerbCase){
            case ENGLISH_INFINITIVE:{
                mEnglishVerbEnding = this.mEnglish_Infinitive;
                break;
            }
            case ENGLISH_PRESENT_3RDPERSON:{
                mEnglishVerbEnding = this.mEnglish_Present_3rdPerson;
                break;
            }
            case ENGLISH_PERFECT:{
                mEnglishVerbEnding = this.mEnglish_Perfect;
                break;
            }
            case ENGLISH_PARTICIPLE:{
                mEnglishVerbEnding = this.mEnglish_Participle;
                break;
            }
        }

        if(mEnglishAuxiliaryVerb == null){
            mEnglishAuxiliaryVerb = "";
        }

        // Adjustments for Compound Verbs
        String startOfInfinitive;
        if(mEnglish_Infinitive.length() > 2) {
            startOfInfinitive = mEnglish_Infinitive.substring(0, 3);  // get the first 3 letters of infinitive
            if (startOfInfinitive.equals(START_INFINITIVE)) {  // if "be " -> Compound verb
                mEnglishAuxiliaryVerb = databaseAccess.sqlEngAuxCompoundVerbQuery(person, number, mood, voice, tense);
                mEnglishVerbEnding = mEnglish_Infinitive.substring(3);  // remove the compound "be " from the infinitive
            }
        }

        mEnglishVerb = mEnglishPerson + mEnglishAuxiliaryVerb + mEnglishVerbEnding;
        return mEnglishVerb;
    }


    // Field Getter/Setters
    // --------------------


    @Override
    public int getId() {return mId;}
    @Override
    public void setId(int id){mId = id;}

    @Override
    public String getLatin_Type() {
        return mLatin_Type;
    }
    @Override
    public void setLatin_Type(String latin_Type) {
        mLatin_Type = latin_Type;
    }

    @Override
    public int getLatin_ConjNum() {
        return mLatin_ConjNum;
    }
    @Override
    public void setLatin_ConjNum(int latin_ConjNum) {
        mLatin_ConjNum = latin_ConjNum;
    }

    @Override
    public String getLatin_Present() {
        return mLatin_Present;
    }
    @Override
    public void setLatin_Present(String latin_Present) {
        mLatin_Present = latin_Present;
    }

    @Override
    public String getLatin_Infinitive() {
        return mLatin_Infinitive;
    }
    @Override
    public void setLatin_Infinitive(String latin_Infinitive) {
        mLatin_Infinitive = latin_Infinitive;
    }

    @Override
    public String getLatin_Perfect() {
        return mLatin_Perfect;
    }
    @Override
    public void setLatin_Perfect(String latin_Perfect) {
        mLatin_Perfect = latin_Perfect;
    }


    public String getLatin_Participle() {
        return mLatin_Participle;
    }
    @Override
    public void setLatin_Participle(String latin_Participle) {
        mLatin_Participle = latin_Participle;
    }

    @Override
    public String getLatin_Present_Stem() {
        return mLatin_Present_Stem;
    }
    @Override
    public void setLatin_Present_Stem(String latin_Present_Stem) {
        mLatin_Present_Stem = latin_Present_Stem;
    }

    @Override
    public String getLatin_Infinitive_Stem() {
        return mLatin_Infinitive_Stem;
    }
    @Override
    public void setLatin_Infinitive_Stem(String latin_Infinitive_Stem) {
        mLatin_Infinitive_Stem = latin_Infinitive_Stem;
    }

    @Override
    public String getLatin_Infinitive_PassiveStem() {
        return mLatin_Infinitive_PassiveStem;
    }
    @Override
    public void setLatin_Infinitive_PassiveStem(String latin_Infinitive_PassiveStem) {
        mLatin_Infinitive_PassiveStem = latin_Infinitive_PassiveStem;
    }

    @Override
    public String getLatin_Present_SubjuncStem() {
        return mLatin_Present_SubjuncStem;
    }
    @Override
    public void setLatin_Present_SubjuncStem(String latin_Present_SubjuncStem) {
        mLatin_Present_SubjuncStem = latin_Present_SubjuncStem;
    }

    @Override
    public String getLatin_Perfect_Stem() {
        return mLatin_Perfect_Stem;
    }
    @Override
    public void setLatin_Perfect_Stem(String latin_Perfect_Stem) {
        mLatin_Perfect_Stem = latin_Perfect_Stem;
    }

    @Override
    public String getLatin_Participle_Stem() {
        return mLatin_Participle_Stem;
    }
    @Override
    public void setLatin_Participle_Stem(String latin_Participle_Stem) {
        mLatin_Participle_Stem = latin_Participle_Stem;
    }

    @Override
    public String getEnglish_Infinitive() {
        return mEnglish_Infinitive;
    }
    @Override
    public void setEnglish_Infinitive(String english_Infinitive) {
        mEnglish_Infinitive = english_Infinitive;
    }

    @Override
    public String getEnglish_Present_3rdPerson() {
        return mEnglish_Present_3rdPerson;
    }
    @Override
    public void setEnglish_Present_3rdPerson(String english_Present_3rdPerson) {
        mEnglish_Present_3rdPerson = english_Present_3rdPerson;
    }

    @Override
    public String getEnglish_Perfect() {
        return mEnglish_Perfect;
    }
    @Override
    public void setEnglish_Perfect(String english_Perfect) {
        mEnglish_Perfect = english_Perfect;
    }

    @Override
    public String getEnglish_Participle() {
        return mEnglish_Participle;
    }
    @Override
    public void setEnglish_Participle(String english_Participle) {
        mEnglish_Participle = english_Participle;
    }


    public void setDatabaseAccess(DatabaseAccess databaseAccess) {
        mDatabaseAccess = databaseAccess;
    }


    // INTERFACE GETTER/SETTERS
    // ------------------------
    @Override
    public String getLatinStem() {
        return mLatinStem;
    }

    @Override
    public String getLatinEnding() {
        return mLatinEnding;
    }


    @Override
    public String getLatinVerb() {
        return mLatinVerb;
    }

    @Override
    public String getEnglishPerson() {
        return mEnglishPerson;
    }

    @Override
    public String getEnglishAuxiliaryVerb() {
        return mEnglishAuxiliaryVerb;
    }

    @Override
    public String getEnglishVerbEnding() {
        return mEnglishVerbEnding;
    }

    @Override
    public String getEnglishVerb() {
        return mEnglishVerb;
    }


    @Override
    public void setLatinStem(String latinStem) {
        mLatinStem = latinStem;
    }

    @Override
    public void setLatinEnding(String latinEnding) {
        mLatinEnding = latinEnding;
    }

    @Override
    public void setLatinVerb(String latinVerb) {
        mLatinVerb = latinVerb;
    }

    @Override
    public void setEnglishPerson(String englishPerson) {
        mEnglishPerson = englishPerson;
    }

    @Override
    public void setEnglishAuxiliaryVerb(String englishAuxiliaryVerb) {
        mEnglishAuxiliaryVerb = englishAuxiliaryVerb;
    }

    @Override
    public void setEnglishVerbEnding(String englishVerbEnding) {
        mEnglishVerbEnding = englishVerbEnding;
    }

    @Override
    public void setEnglishVerb(String englishVerb) {
        mEnglishVerb = englishVerb;
    }


    public int getAsked() {
        return mAsked;
    }

    public void setAsked(int asked) {
        mAsked = asked;
    }

    public int getCorrect() {
        return mCorrect;
    }

    public void setCorrect(int correct) {
        mCorrect = correct;
    }

    @Override
    public String getTense() {
        return mTense;
    }
    @Override
    public void setTense(String tense) {
        mTense = tense;
    }
    @Override
    public String getMood() {
        return mMood;
    }
    @Override
    public void setMood(String mood) {
        mMood = mood;
    }
    @Override
    public String getVoice() {
        return mVoice;
    }
    @Override
    public void setVoice(String voice) {
        mVoice = voice;
    }
}
