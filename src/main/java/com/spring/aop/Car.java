package com.spring.aop;

import org.springframework.stereotype.Component;

/** Car class. */
@Component
public class Car {

    /** start method. */
    public void start() {
        System.out.println("Car starting");
    }
}

