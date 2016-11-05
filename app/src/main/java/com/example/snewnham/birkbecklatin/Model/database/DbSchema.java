package com.example.snewnham.birkbecklatin.Model.database;

/**
 * Scehema for the
 * Created by snewnham on 02/10/2016.
 */

public class DbSchema {


 // ========================= VERB ================================================================

    // inner STATIC class - VerbListCursor Table
    // ------------------------------------
    public static final class VerbListTable {
        public static final String VERB_LIST_TABLE = "Verb_List";


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
            public static final String LATIN_INFINITIVE_PASSIVE_STEM = "Latin_Infinitive_PassiveStem";
            public static final String LATIN_PRESENT_SUBJUNCSTEM = "Latin_Present_SubjuncStem";
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
        public static final String VERB_STEM_TABLE = "Verb_Stem";


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
        public static final String VERB_CONJ_TABLE = "Verb_Conjugation";


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


    // inner STATIC class - EnglishPersons Table
    // ------------------------------------------
    public static final class EnglishPersonsTable {
        public static final String ENG_PERSON_TABLE = "English_Persons";


        // inner inner STATIC class of the Table - Attributes
        // --------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String PERSON = "Person";
            public static final String NUMBER = "Number";
            public static final String ENGLISH_PERSON_WORD = "English_Person_Word";
        }
    }


    // inner STATIC class - English_Verb_Table Table
    // ----------------------------------------------
    public static final class EnglishVerbEndingTable {
        public static final String ENGLISH_VERB_ENDING_TABLE = "English_Verb_Ending";


        // inner inner STATIC class of the Table - Attributes
        // --------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String NUMBER = "Number";
            public static final String TENSE = "Tense";
            public static final String MOOD = "Mood";
            public static final String VOICE = "Voice";

            public static final String ENG_VERB_ENDING = "Eng_Verb_Ending";
        }
    }


    // inner STATIC class - VerbConjugation_Irregular
    // ----------------------------------------------
    public static final class VerbConjugation_Irregular {
        public static final String VERB_IRREGULAR_CONJ_TABLE = "Verb_Conjugation_Irregular";


        // inner inner STATIC class of the Table - Attributes
        // --------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String PERSON = "Person";
            public static final String NUMBER = "Number";
            public static final String TENSE = "Tense";
            public static final String MOOD = "Mood";
            public static final String VOICE = "Voice";

            public static final String ENG_VERB_ENDING = "Eng_Verb_Ending";
        }
    }

// ===================================== NOUN ======================================================


    // inner STATIC class - NounList
    // -----------------------------
    public static final class NounList {
        public static final String NOUN_LIST = "Noun_List";


        // inner inner STATIC class of the Table - Attributes
        // --------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String TYPE = "Type";
            public static final String DECLENSION = "Declension";
            public static final String GENDER = "Gender";
            public static final String NOMINATIVE = "Nominative";
            public static final String GENETIVE = "Genitive";
            public static final String GENETIVE_PLURAL = "Genitive_Plural";
            public static final String NOUN_STEM = "Noun_Stem";
            public static final String ENGLISH_NOUN = "English_Noun";
        }
    }


    // inner STATIC class - NounDeclension
    // -----------------------------------
    public static final class NounDeclension {
        public static final String NOUN_DECLENSION = "Noun_Declension";


        // inner inner STATIC class of the Table - Attributes
        // --------------------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String DECLENSION = "Declension";
            public static final String NUMBER = "Number";
            public static final String GENDER = "Gender";
            public static final String CASE = "Case";
            public static final String LATIN_ENDING = "Latin_Ending";

        }
    }




}


