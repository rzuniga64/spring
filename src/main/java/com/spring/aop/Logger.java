package com.spring.aop;

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
@Component
public class Logger {

    /** aboutToTakePhote method. */
    public void aboutToTakePhoto() {

        System.out.println("About to take photo...");
    }
}
