package com.myposts.services.users.exceptions;

public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
        super("Wrong password");
    }
}
