package com.jobintech.springapp.exceptions;

public class NoSuchElementFoundException extends RuntimeException{
    public NoSuchElementFoundException(String message){
        super(message);
    }
}
