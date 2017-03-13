package com.example.snewnham.birkbecklatin.Model;

/**
 * Created by snewnham on 26/02/2017.
 */


/**
 * CLASS TO HOLD CONSTANTS
 */
public class LatinConstants {

    // Private Constructor
    private LatinConstants(){
        throw new AssertionError();
    }



    // VERB CONSTANTS
    // ==============

    public static final int CONJNUM1 = 1;
    public static final int CONJNUM2 = 2;
    public static final int CONJNUM3 = 3;
    public static final int CONJNUM4 = 4;

    public final static String VERB_REGULAR = "Regular";
    public final static String VERB_DEPONENT = "Deponent";
    public final static String VERB_SEMI_DEPONENT = "Semi Deponent";
    public final static String VERB_IRREGULAR = "Irregular";

    public final static String TENSE_PRESENT = "Present";
    public final static String TENSE_IMPERFECT = "Imperfect";
    public final static String TENSE_FUTURE = "Future";
    public final static String TENSE_PERFECT = "Perfect";
    public final static String TENSE_PLUPERFECT = "Pluperfect";
    public final static String TENSE_FUTURE_PERFECT = "Future Perfect";

    public final static String NUMBER_SINGULAR = "Singular";
    public final static String NUMBER_PLURAL = "Plural";
    public final static String NUMBER_INFINITIVE = "Infinitive";

    public final static String PERSON_1ST = "1st";
    public final static String PERSON_2ND = "2nd";
    public final static String PERSON_3RD = "3rd";

    public final static String MOOD_INDICATIVE = "Indicative";
    public final static String MOOD_IMPERATIVE = "Imperative";
    public final static String MOOD_SUBJUNCTIVE = "Subjunctive";

    public final static String VOICE_ACTIVE = "Active";
    public final static String VOICE_PASSIVE = "Passive";

    public final static String esse = "esse";
    public final static String ESSE = "Esse";

    // VERB STATISTICS
    // ---------------

    public static final String CONJ1 = "Conj1";
    public static final String CONJ2 = "Conj2";
    public static final String CONJ3 = "Conj3";
    public static final String CONJ31 = "Conj31";
    public static final String CONJ4 = "Conj4";

    public static final String CONJ1_HIST_PERC = "Conj1_Hist%";  // % of Correctly Answered Conj# Questions
    public static final String CONJ2_HIST_PERC = "Conj2_Hist%";  // Key For statisticsMap
    public static final String CONJ3_HIST_PERC = "Conj3_Hist%";
    public static final String CONJ4_HIST_PERC = "Conj4_Hist%";


    public final static String TENSE_PRESENT_HIST_PERC = "Present_Hist%";    // % of Correctly Answered Tense Questions
    public final static String TENSE_IMPERFECT_HIST_PERC = "Imperfect_Hist%";  // Key For statisticsMap
    public final static String TENSE_FUTURE_HIST_PERC = "Future_Hist%";
    public final static String TENSE_PERFECT_HIST_PERC = "Perfect_Hist%";
    public final static String TENSE_PLUPERFECT_HIST_PERC = "Pluperfect_Hist%";
    public final static String TENSE_FUTURE_PERFECT_HIST_PERC = "Future Perfect_Hist%";

    public final static String MOOD_INDICATIVE_HIST_PERC = "Indicative_Hist%";   // % of Correctly Answered Mood Questions
    public final static String MOOD_IMPERATIVE_HIST_PERC = "Imperative_Hist%";   // Key For statisticsMap
    public final static String MOOD_SUBJUNCTIVE_HIST_PERC = "Subjunctive_Hist%";

    public final static String VOICE_ACTIVE_HIST_PERC = "Active_Hist%";   // % of Correctly Answered Voice Questions
    public final static String VOICE_PASSIVE_HIST_PERC = "Passive_Hist%";  // Key For statisticsMap

    public final static String VERB_TOTAL = "VerbTotal";  // Historical Score of ALL Correct Questions
    public final static String VERB_TOTAL_HIST_PERC = "VerbTotal_Hist%";  // Key For statisticsMap


    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // NOUN CONSTANTS
    // ==============

    public final static String NOUN = "Noun";
    public final static String NOUN_REGULAR = "NounRegular";
    public final static String NOUN_IRREGULAR = "NounIrregular";
    public final static String PREPOSITION = "Preposition";
    public final static String CONJUNCTION = "Conjunction";
    public final static String ADJECTIVE = "Adjective";
    public final static String ADJECTIVE_COMPARATIVE = "AdjectiveComparative";
    public final static String ADJECTIVE_SUPERLATIVE = "AdjectiveSuperlative";
    public final static String ADVERB = "Adverb";
    public final static String ADVERB_COMPARATIVE = "AdverbComparative";
    public final static String ADVERB_SUPERLATIVE = "AdverbSuperlative";

    public final static String DECL1 = "decl1";
    public final static String DECL2 = "decl2";
    public final static String DECL3 = "decl3";
    public final static String DECL4 = "decl4";

    public static final int DECLNUM1 = 1;
    public static final int DECLNUM2 = 2;
    public static final int DECLNUM3 = 3;
    public static final int DECLNUM4 = 4;
    public static final int DECLNUM5 = 5;


    public final static String NOMINATIVE = "Nominative";
    public final static String ACCUSATIVE = "Accusative";
    public final static String GENITIVE = "Genitive";
    public final static String DATIVE = "Dative";
    public final static String ABLATIVE = "Ablative";
    public final static String VOCATIVE = "Vocative";

    public final static String SINGULAR = "Singular";
    public final static String PLURAL = "Plural";

    public final static String GENDER_MALE = "m";
    public final static String GENDER_FEMALE = "f";
    public final static String GENDER_NEUTER = "n";

    public final static int DECLENSION1 = 1;
    public final static int DECLENSION2 = 2;
    public final static int DECLENSION3 = 3;
    public final static int DECLENSION4 = 4;
    public final static int DECLENSION5 = 5;
    public final static int DECLENSION212 = 212;
    public final static int DECLENSION333 = 333;


    // NOUN STATISTICS
    // ---------------
    public final static String NOUN_HIST_PERC = "Noun_Hist%";
    public final static String NOUN_REGULAR_HIST_PERC = "NounRegular_Hist%";
    public final static String NOUN_IRREGULAR_HIST_PERC = "NounIrregular_Hist%";
    public final static String PREPOSITION_HIST_PERC = "Preposition_Hist%";
    public final static String CONJUNCTION_HIST_PERC = "Conjunction_Hist%";
    public final static String ADJECTIVE_HIST_PERC = "Adjective_Hist%";
    public final static String ADJECTIVE_COMPARATIVE_HIST_PERC = "AdjectiveComparative_Hist%";
    public final static String ADJECTIVE_SUPERLATIVE_HIST_PERC = "AdjectiveSuperlative_Hist%";
    public final static String ADVERB_HIST_PERC = "Adverb_Hist%";
    public final static String ADVERB_COMPARATIVE_HIST_PERC = "AdverbComparative_Hist%";
    public final static String ADVERB_SUPERLATIVE_HIST_PERC = "AdverbSuperlative_Hist%";

    public final static String DECL1_HIST_PERC = "Decl1_Hist%";  // % of Correctly Answered Conj# Questions
    public final static String DECL2_HIST_PERC = "Decl2_Hist%";  // Key For statisticsMap
    public final static String DECL3_HIST_PERC = "Decl3_Hist%";
    public final static String DECL4_HIST_PERC = "Decl4_Hist%";

    public final static String NOMINATIVE_HIST_PERC = "Nominative_Hist%";
    public final static String ACCUSATIVE_HIST_PERC = "Accusative_Hist%";
    public final static String GENITIVE_HIST_PERC = "Genitive_Hist%";
    public final static String DATIVE_HIST_PERC = "Dative_Hist%";
    public final static String ABLATIVE_HIST_PERC = "Ablative_Hist%";
    public final static String VOCATIVE_HIST_PERC = "Vocative_Hist%";

    public final static String NOUN_TOTAL = "NounTotal";  // Historical Score of ALL Correct Questions
    public final static String NOUN_TOTAL_HIST_PERC = "NounTotal_Hist%";  // Key For statisticsMap


     // --------------------------------------------------------------------------------------------

    // MISCELLANEOUS
    // -------------

    public final static String ENGLISH_TO_LATIN = "english_to_latin";
    public final static String LATIN_TO_ENGLISH = "latin_to_english";





}
