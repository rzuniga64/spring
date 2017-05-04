package com.spring.web.controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *  DatabaseErrorHandler class.
 */
@ControllerAdvice
public class ErrorHandler {

    /**
     *  handleDatabaseException method.
     *  @param ex exception
     *  @return a error String
     */
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(final DataAccessException ex) {
        ex.printStackTrace();
        return "error";
    }

    /**
     * handleAccessException method.
     * @param ex ex
     * @return a String
     */
    @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
    public String handleAccessException(final AccessDeniedException ex) {

        return "denied";
    }
}
