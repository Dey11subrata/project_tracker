package com.project.springboot.project_tracker.exceptions;

public class NoSuchStoryFoundException extends RuntimeException{
    public NoSuchStoryFoundException() {
    }

    public NoSuchStoryFoundException(String message) {
        super(message);
    }

    public NoSuchStoryFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
