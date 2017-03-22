package com.spring.aop;

import org.springframework.stereotype.Component;

/** Cat class. */
@Component
@Deprecated
public class Cat {

    /** start method. */
    public void annotationSpecificDemo() {
        System.out.println("Cat starting to meow");
    }

    /** hiss method. */
    @Deprecated
    public void atAnnotationDemo() {
        System.out.println("Cat starting to hiss");
    }

    /** scratch method. */
    public void atArgsAnnotationDemo() {
        System.out.println("Cat starting to scratch");
    }
}

