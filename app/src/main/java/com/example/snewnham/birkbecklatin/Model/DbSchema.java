package com.example.snewnham.birkbecklatin.Model;

/**
 * Scehema for the
 * Created by snewnham on 02/10/2016.
 */

public class DbSchema {

    // inner STATIC class - VerbList Table
    // ------------------------------------
    public static final class VerbListTable {
        public static final String VERBTABLE = "VerbList";


        // inner inner STATIC class of the Table - Attributes
        // ------------------------
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
}

