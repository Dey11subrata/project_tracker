package com.project.springboot.project_tracker.exceptions;

public class NoSuchBugFoundException extends RuntimeException{
    public NoSuchBugFoundException() {
    }

    public NoSuchBugFoundException(String message) {
        super(message);
    }

    public NoSuchBugFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
