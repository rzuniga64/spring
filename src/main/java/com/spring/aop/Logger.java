package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
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
    public void cameraSnap() { }

    /** Dummy method to define a reusable AOP pointcut. */
    @Pointcut("execution(* com.spring.aop.Camera.snap(String))")
    public void cameraSnapName() { }

    /** Dummy method to define a reusable AOP pointcut. */
    @Pointcut("execution(* com.spring.aop.*.*(..))")
    public void cameraRelatedAction() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  This pointcut will run for any argument with any name with any return
     *  type. */
    @Pointcut("within(com.spring.aop.Car)")
    public void start() { }

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

    /**
     *  afterCameraSnap method.
     *  Define pointcut as the parameter to the @After annotation.
     *  This method will always run when the method finishes executing whether
     *  it throws an exception or not.
     */
    @After("cameraSnap()")
    public void afterCameraSnap() {

        System.out.println("After camera snap...");
    }

    /**
     *  afterReturningAdvice method.
     *  Define pointcut as the parameter to the @After annotation.
     *  This method will run when the method finishes executing except if
     *  it throws an exception.
     */
    @AfterReturning("cameraSnap()")
    public void afterReturningAdvice() {

        System.out.println("After returning advice...");
    }

    /**
     *  afterThrowingAdvice method.
     *  Define pointcut as the parameter to the @After annotation.
     *  This method will run when the method finishes executing when
     *  it throws an exception.
     */
    @AfterThrowing("cameraSnap()")
    public void afterThrowingAdvice() {

        System.out.println("After throwing advice...");
    }

    /**
     *  aroundAdvice method.
     *  Runs some code before the method proceeds. And then it runs some more
     *  code after the target method runs.
     *  @param p p
     */
    @Around("cameraSnap()")
    public void aroundAdvice(final ProceedingJoinPoint p) {

        System.out.println("Around advice (before)");

        try {
            p.proceed();
        } catch (Throwable e) {
            System.out.println("In around advice: " + e.getMessage());
        }

        System.out.println("Around advice (after)");
    }

    /**
     *  aboutToStartCar method.
     *  Define pointcut as the parameter to the @Before annotation.
     *  This will match any joint point, any method within Spring, within the
     *  Car class
     */
    @Before("start()")
    public void aboutToStartCar() {

        System.out.println("About to start car...");
    }
}


