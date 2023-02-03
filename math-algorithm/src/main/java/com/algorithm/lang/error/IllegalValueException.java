package com.algorithm.lang.error;

/**
 * Error to use when assign illegal value. Example, negative number, imaginary number, etc...
 */
public class IllegalValueException extends RuntimeException {
    /**
     * Error to use when assign illegal value. Example, negative number, imaginary number, etc...
     */
    public IllegalValueException() {}
    /**
     * Error to use when assign illegal value. Example, negative number, imaginary number, etc...
     * @param message the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public IllegalValueException(String message) {
        super(message);
    }
}

