package com.project.springboot.project_tracker.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionHandler {

    @ExceptionHandler(value = NoSuchProjectFoundException.class)
    public String noSuchProjectFoundExceptionHandler(){
        return "No such Project Found....";
    }

    @ExceptionHandler(value = NoSuchEpicFoundException.class)
    public String noSuchEpicFoundException(){
        return "No such Epic Found....";
    }

    @ExceptionHandler(value = NoSuchStoryFoundException.class)
    public String noSuchStoryFoundException(){
        return "No such Story Found....";
    }

    @ExceptionHandler(value = NoSuchTaskFoundException.class)
    public String noSuchTaskFoundException(){
        return "No such Task Found....";
    }
}
