package dev.patika.creditscorecalculator.exceptions;

public class CustomerAlreadyExists extends RuntimeException{

    public CustomerAlreadyExists(String message){
        super(message);
    }
}
