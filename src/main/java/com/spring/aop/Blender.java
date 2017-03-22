package com.spring.aop;

import org.springframework.stereotype.Component;

/** Blender class. */
@Component
public class Blender implements IBlender {
    /* non-Javadoc)
     * @see com.spring.aop.IBlender#blend()
     */
    /** blend method. */
    @Override
    public void blend() {
        System.out.println("Blending ...");
    }
}

