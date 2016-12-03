package com.example.snewnham.birkbecklatin.Control.randomGenerator;

/**
 * Created by snewnham on 03/12/2016.
 *
 * IncorrectNounOutput:
 * --------------------
 *
 * Helper Class to Package the Output from the IncorrectNounTable
 *
 */
public class IncorrectNounOutput{

    private String nounType;
    private int nounId;

    public IncorrectNounOutput(String nounType, int nounId){
        this.nounType = nounType;
        this.nounId = nounId;
    }

    public String getNounType(){
        return this.nounType;
    }

    public int getNounId(){
        return this.nounId;
    }
}