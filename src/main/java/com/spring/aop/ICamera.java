package com.spring.aop;

/** ICamera interface. */
public interface ICamera {

    /**
     * Snap method.
     * @throws Exception Exception
     */
    void snap() throws Exception;

    /**
     * snap(int) method.
     * @param exposure exposure
     */
    void snap(int exposure);

    /**
     * snap(String) method.
     * @param name name
     * @return a String
     */
    String snap(String name);

    /** snapNigttime. */
    void snapNighttime();
}

