package com.example.snewnham.birkbecklatin.Model;

import android.database.Cursor;
import android.database.CursorWrapper;



/**
 * Created by snewnham on 05/10/2016.
 */

public class LatinCursorWrapper extends CursorWrapper {

    public LatinCursorWrapper(Cursor cursor) {
        super(cursor);
    }


    /**
     * turnCursorToVerb()
     * ---------
     * converts a cursor into a Verb object
     * @return verb object
     */

    public Verb turnCursorToVerb() {


        // Pull data from the Cursor
        //--------------------------
        int id = getInt(getColumnIndex(DbSchema.VerbListTable.Cols._id));
        String latin_Type = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_TYPE));
        int latin_ConjNum = getInt(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_CONJNUM));

        String latin_Present = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PRESENT)); // Principle Parts
        String latin_Infinitive = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_INFINITIVE));
        String latin_Perfect = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PERFECT));
        String latin_Participle = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PARTICIPLE));

        String latin_Present_Stem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PRESENT_STEM));  // STEMS
        String latin_Infinitive_Stem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_INFINITIVE_STEM));
        String latin_Infinitive_StemMod = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_INFINITIVE_STEMMODIF));
        String latin_Perfect_Stem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PERFECT_STEM));
        String latin_Participle_Stem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PARTICIPLE_STEM));

        String english_Infinitive = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_INFINITIVE));
        String english_Present_3rdPerson = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_PRESENT_3RDPERSON));
        String english_Perfect = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_PERFECT));
        String english_Participle = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_PARTICIPLE));

        // Transfer data to a Verb object
        // ------------------------------
        Verb verb = new Verb(id);
        verb.setLatin_Type(latin_Type);
        verb.setLatin_ConjNum(latin_ConjNum);

        verb.setLatin_Present(latin_Present);  // Principle Parts
        verb.setLatin_Infinitive(latin_Infinitive);
        verb.setLatin_Participle(latin_Participle);
        verb.setLatin_Perfect(latin_Perfect);

        verb.setLatin_Present_Stem(latin_Present_Stem);   // Stems
        verb.setLatin_Infinitive_Stem(latin_Infinitive_Stem);
        verb.setLatin_Infinitive_StemMod(latin_Infinitive_StemMod);
        verb.setLatin_Perfect_Stem(latin_Perfect_Stem);
        verb.setLatin_Participle_Stem(latin_Participle_Stem);

        verb.setEnglish_Infinitive(english_Infinitive);   // ENGLISH
        verb.setEnglish_Present_3rdPerson(english_Present_3rdPerson);
        verb.setEnglish_Perfect(english_Perfect);
        verb.setEnglish_Participle(english_Participle);

        return verb;
    }

}
