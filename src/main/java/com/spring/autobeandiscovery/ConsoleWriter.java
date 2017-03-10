package com.spring.autobeandiscovery;

import org.springframework.stereotype.Component;

/**
 * ConsoleWriter Class.
 */
@Component("consoleWriter")
public class ConsoleWriter implements LogWriter {

    /**
     *  Write to the console.
     *   @param text text
     */
    public void write(final String text) {
        System.out.println(text);
    }
}
