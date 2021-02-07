package com.pineapple.palapa.exception;

public class UserNotFoundException extends RuntimeException {
    
    /**
     * A serial was added
     */
    private static final long serialVersionUID = -6745807494104839339L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
