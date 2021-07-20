package com.superstar.forex.forexfeed.exception;

public class NoForexFeedException extends Exception {

    public NoForexFeedException(String message,Throwable cause){
        super(message,cause);
    }

    public NoForexFeedException(String message){
        super(message);
    }

    
}
