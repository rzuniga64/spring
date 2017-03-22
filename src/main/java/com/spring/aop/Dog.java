package com.spring.aop;

import org.springframework.stereotype.Component;

/** Dog class. */
@Component
public class Dog {

    /** start method. */
    public void annotationSpecificDemo() {
        System.out.println("Dog starting to bark");
    }
}

