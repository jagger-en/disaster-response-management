package com.pineapple.palapa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class UserNotFoundException extends RuntimeException {
    
    /**
     * A serial was added
     */
    private static final long serialVersionUID = -6745807494104839339L;

    public UserNotFoundException(String message) {
        super(message);
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
        );
    }
}
