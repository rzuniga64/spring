package com.spring.aop;

import org.springframework.stereotype.Component;

/**
 *  Camera class.
 */
@Component
public class Camera implements PhotoSnapper, Machine {

    /**
     * Constructor.
     */
    public Camera() {
        System.out.println("Hello from camera constructor");
    }

    /**
     * snap method.
     *
     * @throws Exception Exception
     */
    public void snap() throws Exception {
        System.out.println("SNAP!");

        //throw new Exception("bye bye!");
    }

    /**
     * snap method.
     *
     * @param exposure exposure
     */
    public void snap(final int exposure) {
        System.out.println("SNAP! Exposure:" + exposure);
    }

    /**
     * snap method.
     *
     * @param name name
     * @return the name
     */
    public String snap(final String name) {
        System.out.println("SNAP! Name:" + name);

        return name;
    }

    /**
     * snap method.
     * @param exposure exposure
     */
    public void snap(final double exposure) {
        System.out.println("SNAP! Exposure:" + exposure);
    }

    /**
     * snap method.
     * @param exposure exposure
     * @param aperture aperture
     */
    public void snap(final int exposure, final double aperture) {
        System.out.printf("SNAP with exposure %d aperture %.2f\n", exposure,
                aperture);

    }

    /**
     * snapNighttime method.
     */
    public void snapNighttime() {
        System.out.println("SNAP! Night mode.");
    }
}
