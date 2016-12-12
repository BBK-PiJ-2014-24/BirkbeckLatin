package com.example.snewnham.birkbecklatin.Model.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.snewnham.birkbecklatin.Model.database.DbSchema;
import com.example.snewnham.birkbecklatin.Model.verbs.Verb;
import com.example.snewnham.birkbecklatin.Model.verbs.*;

/**
 *
 * VerbListCursor - Takes a DB query on the Verb_List table, which is in the form of a cursor, and converts
 * that data into a Verb Object. A mini internal 'factory' is used to create the correct verb class(i.e.,
 * Regular, Irregular, Deponent, Semi-Deponent).
 *
 * Created by snewnham on 05/10/2016.
 */

public class VerbListCursor extends CursorWrapper {

    // Constructor
    // -----------
    public VerbListCursor(Cursor cursor) {
        super(cursor);
    }


    /**
     * turnCursorToVerb()
     * -----------------
     * converts a cursor into a Verb object
     * @return verb object
     */

    public Verb makeVerbObject() {


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
        String latin_Present_SubjuncStem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PRESENT_SUBJUNCSTEM));
        String latin_Infinitive_Stem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_INFINITIVE_STEM));
        String latin_Infinitive_PassiveStem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_INFINITIVE_PASSIVE_STEM));
        String latin_Perfect_Stem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PERFECT_STEM));
        String latin_Participle_Stem = getString(getColumnIndex(DbSchema.VerbListTable.Cols.LATIN_PARTICIPLE_STEM));

        String english_Infinitive = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_INFINITIVE));
        String english_Present_3rdPerson = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_PRESENT_3RDPERSON));
        String english_Perfect = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_PERFECT));
        String english_Participle = getString(getColumnIndex(DbSchema.VerbListTable.Cols.ENGLISH_PARTICIPLE));


        // Mini Factory - Create Verb Object
        //----------------------------------
        Verb verb = null;
        switch(latin_Type) {
            case "Regular": {
                verb = new VerbRegular(id);
                break;
            }
            case "Irregular": {
                verb = new VerbIrregular(id);
                break;
            }
            case "Deponent": {
                verb = new VerbDeponent(id);
                break;
            }
            case "Semi Deponent": {
                verb = new VerbSemiDeponent(id);
                break;
            }
        }


        // Transfer db data to a Verb object
        // ----------------------------------

        verb.setLatin_Type(latin_Type);
        verb.setLatin_ConjNum(latin_ConjNum);

        // Principle Parts
        verb.setLatin_Present(latin_Present);
        verb.setLatin_Infinitive(latin_Infinitive);
        verb.setLatin_Participle(latin_Participle);
        verb.setLatin_Perfect(latin_Perfect);

        // Stems
        verb.setLatin_Present_Stem(latin_Present_Stem);
        verb.setLatin_Present_SubjuncStem(latin_Present_SubjuncStem);
        verb.setLatin_Infinitive_Stem(latin_Infinitive_Stem);
        verb.setLatin_Infinitive_PassiveStem(latin_Infinitive_PassiveStem);
        verb.setLatin_Perfect_Stem(latin_Perfect_Stem);
        verb.setLatin_Participle_Stem(latin_Participle_Stem);

        // ENGLISH
        verb.setEnglish_Infinitive(english_Infinitive);
        verb.setEnglish_Present_3rdPerson(english_Present_3rdPerson);
        verb.setEnglish_Perfect(english_Perfect);
        verb.setEnglish_Participle(english_Participle);

        return verb;
    }

}
