package com.spring.aop;

import org.springframework.stereotype.Component;

/** Lens class. */
@Component
public class Lens {

    /**
     * zoom method.
     *
     * @param factor factor
     */
    public void zoom(final int factor) {
        System.out.println("Zooming lens: " + factor);
    }
}

