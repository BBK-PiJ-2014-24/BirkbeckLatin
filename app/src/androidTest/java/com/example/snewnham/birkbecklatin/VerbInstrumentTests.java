package com.example.snewnham.birkbecklatin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.Verb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * TESTS FOR CREATING VERBS
 * Created by snewnham on 12/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class VerbInstrumentTests {


    // Fields
    // ------
    Context appContext;
    DatabaseAccess databaseAccess;


    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getTargetContext();
        databaseAccess = DatabaseAccess.getInstance(appContext);  // CALL THE DATABASE STATICALY
        databaseAccess.open();                                  // OPEN THE DATABASE
    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        assertEquals("com.example.snewnham.birkbecklatin", appContext.getPackageName());
    }

    /**
     * testMakeVerbWord()
     * ==================
     * test Verb Class that It Can build Correct Latin Verb and English Translation
     * @throws Exception
     */
    @Test
    public void testMakeVerbWord() throws Exception {

        // test input + answers
        // --------------------

        int id = 2;
        Verb verb = new Verb(id, databaseAccess);

        verb.setLatin_Type("Regular");
        verb.setLatin_ConjNum(2);

        verb.setLatin_Present("moneo");        // Participle Parts
        verb.setLatin_Infinitive("monere");
        verb.setLatin_Perfect("monui");
        verb.setLatin_Participle("monitus");

        verb.setLatin_Present_Stem("mon");     // Stems
        verb.setLatin_Infinitive_Stem("moner");
        verb.setLatin_Infinitive_StemMod("monea");
        verb.setLatin_Perfect_Stem("monu");
        verb.setLatin_Participle_Stem("monit");

        verb.setEnglish_Infinitive("warn, advise");    // English
        verb.setEnglish_Present_3rdPerson("warns, advises");
        verb.setEnglish_Perfect("warned, advised");
        verb.setEnglish_Participle("warning, advising");

        String person1 = "2nd";
        String number1 = "Singular";
        String tense1 = "Present";
        String mood1 = "Active";
        String voice1 = "Indicative";
        String conjNum1 = "2";

        verb.makeLatinVerb(person1, number1, tense1, mood1, voice1, conjNum1);


        assertEquals("mone",verb.getLatinStem());
        assertEquals("s",verb.getLatinEnding());
        assertEquals("mones", verb.getLatinVerb());
        // assertEquals("he warns", verb.getEnglishVerb);


    }


}
