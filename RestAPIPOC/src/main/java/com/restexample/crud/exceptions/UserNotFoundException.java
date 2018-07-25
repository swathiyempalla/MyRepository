package com.restexample.crud.exceptions;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String userId;
	 
    public UserNotFoundException(String id, String message) {
        super(message);
        this.userId = id;
    }
}
