package com.spring.autowire.bytype;

/**
 *  FileWriter class.
 */
public class FileWriter implements LogWriter {

    /**
     *  Write to a file.
     *  @param text text
     */
    public void write(final String text) {
        // Write to a file here.
        // Dummy implementation
        System.out.println("Write to file: " + text);
    }
}
