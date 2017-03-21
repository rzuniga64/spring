package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *  Logger class.
 *  We will turn this class into an aspect that will advise the Camera class.
 *  The class is called an Aspect and the method is called advice. AspectJ
 *  supports joint points. A joint point is anywhere in your code you could
 *  get an aspect to run some advice. There are method execution joint points.
 *  A point cut defines the joint point where we are going to run our code.
 *  We want to run the advice method before the Camera method runs.
 *
 *  You must add the dependency spring-aspects.4.x.x.
 *
 */
@Aspect
@Component
public class Logger {

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  This pointcut will run for any argument with any name with any return
     *  type. */
    //@Pointcut("execution(void com.spring.aop.Camera.snap(..))")
    //@Pointcut("execution(* com.spring.aop.Camera.*(..))")
    @Pointcut("execution(* com.spring.aop.Camera.*(..))")
    public void cameraSnap() {}

    /** Dummy method to define a reusable AOP pointcut. */
    @Pointcut("execution(* com.spring.aop.Camera.snap(String))")
    public void cameraSnapName() {}

    /** Dummy method to define a reusable AOP pointcut. */
    @Pointcut("execution(* com.spring.aop.*.*(..))")
    public void cameraRelatedAction() {}

    /**
     * aboutToTakePhoto method.
     * Define pointcut as the parameter to the @Before annotation.
     */
    @Before("cameraSnap()")
    public void aboutToTakePhoto() {

        System.out.println("About to take photo...");
    }

    /**
     * aboutToTakePhotoWithName method.
     * Define pointcut as the parameter to the @Before annotation.
     */
    @Before("cameraSnapName()")
    public void aboutToTakePhotoWithName() {

        System.out.println("About to take photo with name...");
    }

    /**
     * aboutToDoCameraRelatedAction
     * Define pointcut as the parameter to the @Before annotation.
     * This method will run before any method of a class in the package is
     * called.
     */
    @Before("cameraRelatedAction()")
    public void aboutToDoCameraRelatedAction() {

        System.out.println("Doing something related to cameras...");
    }
}
