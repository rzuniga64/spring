package com.spring.aop;

import org.springframework.stereotype.Component;

/**
 *  Camera class.
 */
@Component
public class Camera {

    /** snap method.*/
    public void snap() {
        System.out.println("SNAP!");
    }
}
