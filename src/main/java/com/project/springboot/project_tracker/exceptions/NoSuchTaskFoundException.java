package com.project.springboot.project_tracker.exceptions;

public class NoSuchTaskFoundException extends RuntimeException{
    public NoSuchTaskFoundException() {
    }

    public NoSuchTaskFoundException(String message) {
        super(message);
    }

    public NoSuchTaskFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
