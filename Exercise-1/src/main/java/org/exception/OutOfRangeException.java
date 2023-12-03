package org.exception;

public class OutOfRangeException extends RuntimeException{

    public OutOfRangeException(String argument, Throwable err){
        super(("\"" + argument + "\"" + " is Out of range"), err);
    }
}