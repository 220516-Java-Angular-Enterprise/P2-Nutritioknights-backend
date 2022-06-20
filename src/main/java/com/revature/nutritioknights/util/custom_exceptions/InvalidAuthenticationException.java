package com.revature.nutritioknights.util.custom_exceptions;

public class InvalidAuthenticationException extends RuntimeException{

    public InvalidAuthenticationException() {super();}

    public InvalidAuthenticationException(String message) {super(message);}
}
