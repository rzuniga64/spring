package com.spring.aop;

import org.springframework.stereotype.Component;

/**
 * Fan class.
 */
@Component
public class Fan implements IFan {
    /* (non-Javadoc)
     * @see com.spring.aop.IFan#activate(int)
     */
    @Override
    public void activate(final int level) {
        System.out.println("Fan running at level " + level);
    }
}

