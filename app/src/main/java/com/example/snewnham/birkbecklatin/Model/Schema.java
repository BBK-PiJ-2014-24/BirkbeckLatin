package com.example.snewnham.birkbecklatin.Model;

/**
 * Scehema for the
 * Created by snewnham on 02/10/2016.
 */

public class Schema {

    // inner STATIC class - VerbList Table
    // ------------------------------------
    public static final class VerbListTable {
        public static final String VERBLIST = "VerbList";


        // inner inner STATIC class of the Table - Attributes
        // ------------------------
        public static final class Cols {
            public static final String _id = "_id";
            public static final String LATIN_CONJNAME = "Latin_ConjName";
            public static final String LATIN_PRESENT = "Latin_Present";
            public static final String LATIN_INFINITIVE = "Latin_Infinitive";
            public static final String LATIN_PERFECT = "Latin_Perfect";
            public static final String LATIN_PARTICIPLE = "Latin_Particple";
            public static final String LATIN_PRESENT_STEM = "Latin_Present_Stem";
            public static final String LATIN_INFINITIVE_STEM = "Latin_Infinitive_Stem";
            public static final String LATIN_INFINITIVE_STEMMODIF = "Latin_Infinitive_StemModif";
            public static final String LATIN_PERFECT_STEM = "Latin_Perfect_Stem";
            public static final String LATIN_PARTICIPLE_STEM = "Latin_Particple_Stem";
            public static final String ENGLISH_INFINITIVE = "English_Infinitive";
            public static final String ENGLISH_PRESENT_3RDPERSON = "English_Present_3rdPerson";
            public static final String ENGLISH_PERFECT = "English_Perfect";
            public static final String ENGLISH_PARTICIPLE = "English_Participle";
        }

    }
}


