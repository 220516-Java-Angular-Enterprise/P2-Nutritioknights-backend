package com.revature.nutritioknights.util.custom_exceptions;

public class ForbiddenUserException extends RuntimeException {

    public ForbiddenUserException() {
        super();
    }

    public ForbiddenUserException(String message) {
        super(message);
    }
}
