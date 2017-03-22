package com.spring.aop;

/** Machine class. */
public class Machine implements IMachine {

    /**
     *  start method.
     */
    @Override
    public void start() {
        System.out.println("Machine starting ...");
    }
}
