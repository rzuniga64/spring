package com.spring.autobeandiscovery;

import org.springframework.stereotype.Component;

/**
 *  FileWriter class.
 */
@Component("fileWriter")
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
