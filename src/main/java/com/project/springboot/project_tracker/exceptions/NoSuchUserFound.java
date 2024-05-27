package com.project.springboot.project_tracker.exceptions;

public class NoSuchUserFound extends RuntimeException {
    public NoSuchUserFound() {
    }

    public NoSuchUserFound(String message) {
        super(message);
    }

    public NoSuchUserFound(String message, Throwable cause) {
        super(message, cause);
    }
}
