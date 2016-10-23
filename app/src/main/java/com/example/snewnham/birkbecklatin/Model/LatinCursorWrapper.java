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
     * converts a cursor into a VerbRegular object
     * @return verb object
     */

    public VerbRegular turnCursorToVerb() {


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

        // Transfer data to a VerbRegular object
        // ------------------------------
        VerbRegular verbRegular = new VerbRegular(id);
        verbRegular.setLatin_Type(latin_Type);
        verbRegular.setLatin_ConjNum(latin_ConjNum);

        verbRegular.setLatin_Present(latin_Present);  // Principle Parts
        verbRegular.setLatin_Infinitive(latin_Infinitive);
        verbRegular.setLatin_Participle(latin_Participle);
        verbRegular.setLatin_Perfect(latin_Perfect);

        verbRegular.setLatin_Present_Stem(latin_Present_Stem);   // Stems
        verbRegular.setLatin_Infinitive_Stem(latin_Infinitive_Stem);
        verbRegular.setLatin_Infinitive_StemMod(latin_Infinitive_StemMod);
        verbRegular.setLatin_Perfect_Stem(latin_Perfect_Stem);
        verbRegular.setLatin_Participle_Stem(latin_Participle_Stem);

        verbRegular.setEnglish_Infinitive(english_Infinitive);   // ENGLISH
        verbRegular.setEnglish_Present_3rdPerson(english_Present_3rdPerson);
        verbRegular.setEnglish_Perfect(english_Perfect);
        verbRegular.setEnglish_Participle(english_Participle);

        return verbRegular;
    }

}
