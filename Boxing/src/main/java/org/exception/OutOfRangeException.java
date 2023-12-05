package org.exception;

public class OutOfRangeException extends RuntimeException{

    public OutOfRangeException(String argument){
        super(("\"" + argument + "\"" + " is Out of range"));
    }
}