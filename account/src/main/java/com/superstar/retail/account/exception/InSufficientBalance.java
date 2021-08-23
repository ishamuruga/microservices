package com.superstar.retail.account.exception;

public class InSufficientBalance extends Exception {
    
    public InSufficientBalance(String message) {
        super(message);
    }

    public InSufficientBalance(Throwable th,String message) {
        super(message, th);
    }

}
