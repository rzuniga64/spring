package com.spring.autowirebydefault;

/**
 *  LogWriter interface. In Spring it is quite common to create an interface
 *  because if you have a property that expects an interface type you can inject
 *  any implementing type to that property.
 */
public interface LogWriter {

    /**
     *  Write to a log.
     *  @param text text
     */
    void write(String text);
}
