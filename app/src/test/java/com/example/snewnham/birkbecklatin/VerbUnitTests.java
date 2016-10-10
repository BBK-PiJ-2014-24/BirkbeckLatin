package com.example.snewnham.birkbecklatin;

import com.example.snewnham.birkbecklatin.Model.DatabaseAccess;
import com.example.snewnham.birkbecklatin.Model.Verb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VerbUnitTests {



    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
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
        Verb verb = new Verb(id);

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

        verb.makeVerb(person1, number1, tense1, mood1, voice1);


        assertEquals("mones", verb.getLatinVerb);
        assertEquals("he warns", verb.getEnglishVerb);


    }



}