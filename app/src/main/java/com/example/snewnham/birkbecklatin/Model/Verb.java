package com.example.snewnham.birkbecklatin.Model;

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


    /**
     * getLatinStem()
     * ============
     * @return Latin Verb Stem
     */
    public String getLatinStem();


    /**
     * getLatinEnding()
     * ================
     * @return Latin Verb Ending
     */
    public String getLatinEnding();

    /**
     * getLatinVerb()
     * ==============
     * @return The Complete Latin Verb
     */
    public String getLatinVerb();

    /**
     * getEnglishPerson()
     * ==================
     * @return English Person (I, You, He, etc. )
     */
    public String getEnglishPerson();

    /**
     * getEnglishAuxiliaryVerb
     * =======================
     * @return English Auxiliary Verb (be, would, etc.)
     */
    public String getEnglishAuxiliaryVerb();

    /**
     * getEnglishVerbEnding()
     * ======================
     * @return English Verb Ending (-ing, -ed, etc.)
     */
    public String getEnglishVerbEnding();

    /**
     * getEnglishVerb()
     * @return The Complete English Verb
     */
    public String getEnglishVerb();


}
