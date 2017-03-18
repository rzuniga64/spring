package com.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *  DatabaseErrorHandler class.
 */
@ControllerAdvice
public class DatabaseErrorHandler {

    /**
     *  handleDatabaseException method.
     *  @param ex exception
     *  @return a error String
     */
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(final DataAccessException ex) {
        return "error";
    }
}
