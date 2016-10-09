package com.example.snewnham.birkbecklatin.Model;

/**
 * Scehema for the
 * Created by snewnham on 02/10/2016.
 */

public class DbSchema {

    // inner STATIC class - VerbList Table
    // ------------------------------------
    public static final class VerbListTable {
        public static final String VERB_LIST_TABLE = "VerbList";


        // inner inner STATIC class of the Table - Attributes
        // -------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String LATIN_TYPE = "Latin_Type";
            public static final String LATIN_CONJNUM = "Latin_ConjNum";

            public static final String LATIN_PRESENT = "Latin_Present";    // Principle Parts
            public static final String LATIN_INFINITIVE = "Latin_Infinitive";
            public static final String LATIN_PERFECT = "Latin_Perfect";
            public static final String LATIN_PARTICIPLE = "Latin_Participle";

            public static final String LATIN_PRESENT_STEM = "Latin_Present_Stem";
            public static final String LATIN_INFINITIVE_STEM = "Latin_Infinitive_Stem";
            public static final String LATIN_INFINITIVE_STEMMODIF = "Latin_Infinitive_StemModif";
            public static final String LATIN_PERFECT_STEM = "Latin_Perfect_Stem";
            public static final String LATIN_PARTICIPLE_STEM = "Latin_Participle_Stem";

            public static final String ENGLISH_INFINITIVE = "English_Infinitive";
            public static final String ENGLISH_PRESENT_3RDPERSON = "English_Present_3rdPerson";
            public static final String ENGLISH_PERFECT = "English_Perfect";
            public static final String ENGLISH_PARTICIPLE = "English_Participle";
        }

    }

    // inner STATIC class - VerbStem Table
    // ----------------------------------------
    public static final class VerbStemTable {
        public static final String VERB_STEM_TABLE = "VerbStem";


        // inner inner STATIC class of the Table - Attributes
        // -------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String NUMBER = "Number";
            public static final String MOOD = "Mood";
            public static final String VOICE = "Voice";
            public static final String TENSE = "Tense";
            public static final String STEM = "Stem";
        }
    }


    // inner STATIC class - VerbConjugation Table
    // ----------------------------------------
    public static final class VerbConjugationTable {
        public static final String VERB_CONJ_TABLE = "VerbConjugation";


        // inner inner STATIC class of the Table - Attributes
        // --------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String PERSON = "Person";
            public static final String NUMBER = "Number";
            public static final String MOOD = "Mood";
            public static final String VOICE = "Voice";
            public static final String TENSE = "Tense";
            public static final String CONJNUM = "ConjNum";
            public static final String CONJ = "Conj";
        }
    }

    // inner STATIC class - EnglishAuxiliaryVerb Table
    // ------------------------------------------------
    public static final class EnglishAuxillaryVerbTable {
        public static final String ENG_AUX_VERB_TABLE = "English_Auxiliary_Verbs";


        // inner inner STATIC class of the Table - Attributes
        // --------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String PERSON = "Person";
            public static final String NUMBER = "Number";
            public static final String MOOD = "Mood";
            public static final String VOICE = "Voice";
            public static final String TENSE = "Tense";
            public static final String ENG_AUX_VERB = "English_Aux_Verb";

        }
    }




}


