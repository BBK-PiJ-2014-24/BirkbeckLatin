package com.example.snewnham.birkbecklatin.Model;

/**
 * VERB is the class for verb. It contains the same data as that held in the database's 'VerbList' table
 * Created by snewnham on 05/10/2016.
 */

public class VerbRegular implements Verb {

    // Fields
    // ------
    private int mId;
    private String mLatin_Type;
    private int mLatin_ConjNum;
    private String mLatin_Present;
    private String mLatin_Infinitive;
    private String mLatin_Perfect;
    private String mLatin_Participle;
    private String mLatin_Present_Stem;
    private String mLatin_Infinitive_Stem;
    private String mLatin_Infinitive_PassiveStem;
    private String mLatin_Infinitive_StemMod;
    private String mLatin_Perfect_Stem;
    private String mLatin_Participle_Stem;
    private String mEnglish_Infinitive;
    private String mEnglish_Present_3rdPerson;
    private String mEnglish_Perfect;
    private String mEnglish_Participle;

    private DatabaseAccess mDatabaseAccess;
    private String mLatinStem;
    private String mLatinEnding;
    private String mLatinVerb;
    private String mEnglishPerson;
    private String mEnglishAuxiliaryVerb;
    private String mEnglishVerbEnding;
    private String mEnglishVerb;



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
     * makeLatinVerb(String person, String number, String tense, String mood, String voice)
     * =============
     *
     * Method that builds the Actual Latin and English VerbRegular given person, number tense, mood, voice
     */
    @Override
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum) {

        if(mDatabaseAccess == null) {
            this.mDatabaseAccess = databaseAccess;
        }

        // Find Latin Stem
        //----------------
        String stemTense = mDatabaseAccess.sqlVerbStemQuery(number,mood,voice,tense);
        switch(stemTense){
            case "Present": {
                this.mLatinStem = mLatin_Present_Stem;
                break;
            }
            case "Perfect":{
                this.mLatinStem = mLatin_Perfect_Stem;
                break;
            }
            case "Participle": {
                this.mLatinStem = mLatin_Participle;
                break;
            }
            case "Participle_Stem": {
                this.mLatinStem = mLatin_Participle_Stem;
                break;
            }
            case "Infinitive": {
                this.mLatinStem = mLatin_Infinitive;
                break;
            }
            case "Infinitive_PassiveStem": {
                this.mLatinStem = mLatin_Infinitive_PassiveStem;
                break;
            }
            case "Infinitive_Stem": {
                this.mLatinStem = mLatin_Infinitive_Stem;
                break;
            }
            case "Infinitive_Mod": {
                this.mLatinStem = mLatin_Infinitive_StemMod;
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
     * makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number, String tense, String mood, String voice)
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

        if (mood.equals("Imperative") ) {
            mEnglishPerson = ""; // override to drop Person for All Imperatives
        } else if(tense.equals("Present") && mood.equals("Subjunctive")){
            mEnglishPerson = ""; // override to drop Person for Subjunctive, Present Verbs
        } else if (number.equals("Infinitive")) {
            mEnglishPerson = ""; // override to drop Person for All Infinitives
        } else {
            mEnglishPerson = databaseAccess.sqlEngPersonQuery(person, number);
        }

        mEnglishAuxiliaryVerb = databaseAccess.sqlEngAuxVerbQuery(person, number, mood, voice, tense);
        String englishVerbCase = databaseAccess.sqlEngVerbEnding(number, tense, mood, voice);

        if( !number.equals("Infinitive")  && !mood.equals("Imperative")) { // Avoid nullpointerException for infinitives
            if (person.equals("3rd") && number.equals("Singular") && tense.equals("Present") && mood.equals("Indicative") && voice.equals("Active")) {
                englishVerbCase = "English_Present_3rdPerson";   // override to pick up present 3rd person present
            }
        }
        switch(englishVerbCase){
            case "English_Infinitive":{
                mEnglishVerbEnding = this.mEnglish_Infinitive;
                break;
            }
            case "English_Present_3rdPerson":{
                mEnglishVerbEnding = this.mEnglish_Present_3rdPerson;
                break;
            }
            case "English_Perfect":{
                mEnglishVerbEnding = this.mEnglish_Perfect;
                break;
            }
            case "English_Participle":{
                mEnglishVerbEnding = this.mEnglish_Participle;
                break;
            }
        }
        if(mEnglishAuxiliaryVerb == null){
            mEnglishAuxiliaryVerb = "";
        }
        mEnglishVerb = mEnglishPerson + mEnglishAuxiliaryVerb + mEnglishVerbEnding;
        return mEnglishVerb;
    }


    // Getter/Setters
    // --------------

    public int getId() {return mId;}


    public String getLatin_Type() {
        return mLatin_Type;
    }

    public void setLatin_Type(String latin_Type) {
        mLatin_Type = latin_Type;
    }


    public int getLatin_ConjNum() {
        return mLatin_ConjNum;
    }

    public void setLatin_ConjNum(int latin_ConjNum) {
        mLatin_ConjNum = latin_ConjNum;
    }


    public String getLatin_Present() {
        return mLatin_Present;
    }

    public void setLatin_Present(String latin_Present) {
        mLatin_Present = latin_Present;
    }


    public String getLatin_Infinitive() {
        return mLatin_Infinitive;
    }

    public void setLatin_Infinitive(String latin_Infinitive) {
        mLatin_Infinitive = latin_Infinitive;
    }


    public String getLatin_Perfect() {
        return mLatin_Perfect;
    }

    public void setLatin_Perfect(String latin_Perfect) {
        mLatin_Perfect = latin_Perfect;
    }


    public String getLatin_Participle() {
        return mLatin_Participle;
    }

    public void setLatin_Participle(String latin_Participle) {
        mLatin_Participle = latin_Participle;
    }


    public String getLatin_Present_Stem() {
        return mLatin_Present_Stem;
    }

    public void setLatin_Present_Stem(String latin_Present_Stem) {
        mLatin_Present_Stem = latin_Present_Stem;
    }


    public String getLatin_Infinitive_Stem() {
        return mLatin_Infinitive_Stem;
    }

    public void setLatin_Infinitive_Stem(String latin_Infinitive_Stem) {
        mLatin_Infinitive_Stem = latin_Infinitive_Stem;
    }

    public String getLatin_Infinitive_PassiveStem() {
        return mLatin_Infinitive_PassiveStem;
    }

    public void setLatin_Infinitive_PassiveStem(String latin_Infinitive_PassiveStem) {
        mLatin_Infinitive_PassiveStem = latin_Infinitive_PassiveStem;
    }

    public String getLatin_Infinitive_StemMod() {
        return mLatin_Infinitive_StemMod;
    }

    public void setLatin_Infinitive_StemMod(String latin_Infinitive_StemMod) {
        mLatin_Infinitive_StemMod = latin_Infinitive_StemMod;
    }


    public String getLatin_Perfect_Stem() {
        return mLatin_Perfect_Stem;
    }

    public void setLatin_Perfect_Stem(String latin_Perfect_Stem) {
        mLatin_Perfect_Stem = latin_Perfect_Stem;
    }


    public String getLatin_Participle_Stem() {
        return mLatin_Participle_Stem;
    }

    public void setLatin_Participle_Stem(String latin_Participle_Stem) {
        mLatin_Participle_Stem = latin_Participle_Stem;
    }


    public String getEnglish_Infinitive() {
        return mEnglish_Infinitive;
    }

    public void setEnglish_Infinitive(String english_Infinitive) {
        mEnglish_Infinitive = english_Infinitive;
    }


    public String getEnglish_Present_3rdPerson() {
        return mEnglish_Present_3rdPerson;
    }

    public void setEnglish_Present_3rdPerson(String english_Present_3rdPerson) {
        mEnglish_Present_3rdPerson = english_Present_3rdPerson;
    }


    public String getEnglish_Perfect() {
        return mEnglish_Perfect;
    }

    public void setEnglish_Perfect(String english_Perfect) {
        mEnglish_Perfect = english_Perfect;
    }


    public String getEnglish_Participle() {
        return mEnglish_Participle;
    }

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
}
