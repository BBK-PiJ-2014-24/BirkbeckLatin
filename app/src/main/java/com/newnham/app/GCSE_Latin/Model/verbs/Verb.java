package com.newnham.app.GCSE_Latin.Model.verbs;

import com.newnham.app.GCSE_Latin.Model.database.DatabaseAccess;

/**
 * Interface for a Verb Class that will form the Latin and English Verb
 */

public interface Verb {

    /**
     *  makeLatinVerb()
     * ==============
     *
     * Method that builds the Actual Latin Verb given person, number tense, mood, voice etc.
     * @param databaseAccess
     * @param person
     * @param number
     * @param tense
     * @param mood
     * @param voice
     * @param conjNum
     * @return
    */
    public String makeLatinVerb(DatabaseAccess databaseAccess, String person, String number, String tense,
                                String mood, String voice, String conjNum);



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
     * @param voice
     * @return
     */
    public String makeEnglishVerb(DatabaseAccess databaseAccess, String person, String number,
                                  String tense, String mood, String voice);



    // GETTER/SETTERS
    // ==============

    /**
     * getId()
     * -------
     * @return
     */
    public int getId();

    /**
     * setId()
     * -------
     */
     public void setId(int id);

    /**
     * setLatin_Type()
     * ---------------
     * @param latin_Type
     */
    public void setLatin_Type(String latin_Type);

    /**
     * getLatin_Type()
     * ---------------
     * @return
     */
    public String getLatin_Type();

    /**
     * setLatin_ConjNum()
     * ------------------
     * @param latin_ConjNum
     */
    public void setLatin_ConjNum(int latin_ConjNum);

    /**
     * getLatin_ConjNum()
     * ------------------
     * @return
     */
    public int getLatin_ConjNum();

    /**
     * setLatin_Present()
     * ------------------
     * @param latin_Present
     */
    public void setLatin_Present(String latin_Present);  // Principle Parts

    /**
     * getLatin_Present()
     * ------------------
     * @return
     */
    public String getLatin_Present();

    /**
     * setLatin_Infinitive()
     * ---------------------
     * @param latin_Infinitive
     */
    public void setLatin_Infinitive(String latin_Infinitive);

    /**
     * getLatin_Infinitive()
     * ---------------------
     * @return
     */
    public String getLatin_Infinitive();

    /**
     * setLatin_Participle()
     * ---------------------
     * @param latin_Participle
     */
    public void setLatin_Participle(String latin_Participle);

    /**
     * getLatin_Participle()
     * ---------------------
     * @return
     */
    public String getLatin_Participle();

    /**
     * setLatin_Perfect()
     * ------------------
     * @param latin_Perfect
     */
    public void setLatin_Perfect(String latin_Perfect);

    /**
     * getLatin_Perfect()
     * ------------------
     * @return
     */
    public String getLatin_Perfect();

    /**
     * setLatin_Present_Stem()
     * -----------------------
     * @param latin_Present_Stem
     */
    public void setLatin_Present_Stem(String latin_Present_Stem);   // Stems

    /**
     * getLatin_Present_Stem()
     * -----------------------
     * @return
     */
    public String getLatin_Present_Stem();

    /**
     * setLatin_Present_SubjuncStem()
     * ------------------------------
     * @param latin_Present_SubjuncStem
     */
    public void setLatin_Present_SubjuncStem(String latin_Present_SubjuncStem);

    /**
     * getLatin_Present_SubjuncStem()
     * ------------------------------
     * @return
     */
    public String getLatin_Present_SubjuncStem();

    /**
     * setLatin_Infinitive_Stem()
     * ---------------------------
     * @param latin_Infinitive_Stem
     */
    public void setLatin_Infinitive_Stem(String latin_Infinitive_Stem);

    /**
     * getLatin_Infinitive_Stem();
     * ---------------------------
     * @return
     */
    public String getLatin_Infinitive_Stem();

    /**
     * setLatin_Infinitive_PassiveStem()
     * ---------------------------------
     * @param latin_Infinitive_PassiveStem
     */
    public void setLatin_Infinitive_PassiveStem(String latin_Infinitive_PassiveStem);

    /**
     * public String getLatin_Infinitive_PassiveStem()
     * ------------------------------------------------
     * @return
     */
    public String getLatin_Infinitive_PassiveStem();

    /**
     * setLatin_Perfect_Stem()
     * -----------------------
     * @param latin_Perfect_Stem
     */
    public void setLatin_Perfect_Stem(String latin_Perfect_Stem);

    /**
     * getLatin_Perfect_Stem()
     * -----------------------
     * @return
     */
    public String getLatin_Perfect_Stem();

    /**
     * setLatin_Participle_Stem()
     * --------------------------
     * @param latin_Participle_Stem
     */
    public void setLatin_Participle_Stem(String latin_Participle_Stem);

    /**
     * getLatin_Participle_Stem()
     * --------------------------
     * @return
     */
    public String getLatin_Participle_Stem();

    /**
     * setEnglish_Infinitive()
     * -----------------------
     * @param english_Infinitive
     */
    public void setEnglish_Infinitive(String english_Infinitive);   // ENGLISH

    /**
     * getEnglish_Infinitive()
     * -----------------------
     * @return
     */
    public String getEnglish_Infinitive();

    /**
     * setEnglish_Present_3rdPerson()
     * ------------------------------
     * @param english_Present_3rdPerson
     */
    public void setEnglish_Present_3rdPerson(String english_Present_3rdPerson);

    /**
     * getEnglish_Present_3rdPerson()
     * ------------------------------
     * @return
     */
    public String getEnglish_Present_3rdPerson();

    /**
     * setEnglish_Perfect()
     * --------------------
     * @param english_Perfect
     */
    public void setEnglish_Perfect(String english_Perfect);

    /**
     * getEnglish_Perfect()
     * --------------------
     * @return
     */
    public String getEnglish_Perfect();

    /**
     * setEnglish_Participle()
     * -----------------------
     * @param english_Participle
     */
    public void setEnglish_Participle(String english_Participle);

    /**
     * getEnglish_Participle()
     * -----------------------
     * @return
     */
    public String getEnglish_Participle();




    /**
     * getLatinStem()
     * ============
     * @return Latin Verb Stem
     */
    public String getLatinStem();

    /**
     * setLatinStem()
     * @param latinStem
     */
    public void setLatinStem(String latinStem);



    /**
     * getLatinEnding()
     * ================
     * @return Latin Verb Ending
     */
    public String getLatinEnding();


    /**
     *  public void setLatin()
     *  ======================
     * @param latinEnding
     */
    public void setLatinEnding(String latinEnding);


    /**
     * getLatinVerb()
     * ==============
     * @return The Complete Latin Verb
     */
    public String getLatinVerb();

    /**
     * setLatinVerb()
     * ==============
     * @param latinVerb
     */
    public void setLatinVerb(String latinVerb);



    /**
     * getEnglishPerson()
     * ==================
     * @return English Person (I, You, He, etc. )
     */
    public String getEnglishPerson();

    /**
     * public void setEnglish()
     * ========================
     * @param person
     */
    public void setEnglishPerson(String person);

    /**
     * getEnglishAuxiliaryVerb
     * =======================
     * @return English Auxiliary Verb (be, would, etc.)
     */
    public String getEnglishAuxiliaryVerb();


    /**
     * setEnglishAuxiliaryVerb()
     * =========================
     * @param englishAuxiliaryVerb
     */
    public void setEnglishAuxiliaryVerb(String englishAuxiliaryVerb);



    /**
     * getEnglishVerbEnding()
     * ======================
     * @return English Verb Ending (-ing, -ed, etc.)
     */
    public String getEnglishVerbEnding();


    /**
     * setEnglishVerbEnding()
     * ======================
     * @param verbEnding
     */
    public void setEnglishVerbEnding(String verbEnding);



    /**
     * getEnglishVerb()
     * ================
     * @return The Complete English Verb
     */
    public String getEnglishVerb();


    /**
     * setEnglishVerb()
     * ================
     * @param englishVerb
     */
    public void setEnglishVerb(String englishVerb);


    /**
     * setAsked()
     * ===========
     * @param asked
     */
    public void setAsked(int asked);


    /**
     * getAsked()
     * ===========
     * @return
     */
    public int getAsked();

    /**
     * setCorrect()
     * ==============
     * @param correct
     */
    public void setCorrect(int correct);

    /**
     * getCorrect()
     * ==============
     */
    public int getCorrect();



    String getTense();

    void setTense(String tense);

    String getMood();

    void setMood(String mood);

    String getVoice();

    void setVoice(String voice);

}
