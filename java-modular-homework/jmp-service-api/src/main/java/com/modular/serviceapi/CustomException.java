package com.modular.serviceapi;

public class CustomException extends Exception{

    public CustomException() {
        super("SUBSCRIPTION DOES NOT EXIST IN THE SYSTEM");
    }

}
