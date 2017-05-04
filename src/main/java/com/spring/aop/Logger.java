package com.spring.aop;

import org.aspectj.lang.JoinPoint;
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

    /**************************** POINTCUTS ***********************************/

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
    public void withinDemo() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Specifies when we want to run any method within a class.
     *  Defines a pointcut for any method with the class's target type.
     *  We cannot use wildcards here! We can use interfaces the class
     *  implements.
     */
    @Pointcut("target(com.spring.aop.Car)")
    public void targetDemo() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Specifies when we want to run any method within a class.
     *  Refers to the type of the proxy bean created from that class. A proxy
     *  bean is created when a class implements an interface.
     */
    @Pointcut("this(com.spring.aop.Car)")
    public void thisDemo() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Specifies when we want to run any method within a class.
     *  Refers to the type of the proxy bean created from that class. A proxy
     *  bean is created when a class implements an interface.
     */
    @Pointcut("within(@org.springframework.stereotype.Component com.spring.aop.Dog)")
    public void somePointcut() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Target all methods within all classes that have the @Component
     *  annotation using the @target annotation. @target and @within are almost
     *  the same as far as is known.
     */
    @Pointcut("@target(org.springframework.stereotype.Component)")
    public void annotationSpecific() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Target all methods @Deprecated annotation using the @annotation
     *  annotation.
     */
    @Pointcut("@annotation(Deprecated)")
    public void atAnnotation() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Target arguments passed into a method where the class being passed in,
     *  the actual object, has the annotation that you specify (@Deprecated in
     *  this example).
     */
    @Pointcut("@args(java.lang.Deprecated)")
    public void atArgsAnnotation() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Target a bean using bean pointcut annotation.
     *  Asterisk means 0 or more characters. You can use the asterisk at the
     *  beginning or end.
     */
    @Pointcut("bean(*cat)")
    public void beanAnnotation() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Target a bean using Args PCD.
     */
    @Pointcut("bean(*cat)")
    public void argsPCDAnnotation() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Match any methods that take no arguments.
     *  Actually we can match a method with different arguments.
     */
    @Pointcut("args()")
    //@Pointcut("args(int)")
    //@Pointcut("args(int, double)")

    //target any method that takes Camera as its argument
    //@Pointcut("args(com.spring.aop.Camera)")

    // can use wildcards as a parameter
    // @Pointcut("args(int, *)")

    // match any method that starts with int and has zero or more arguments
    // @Pointcut("args

    // @Pointcut("args(Object)")
    // @Pointcut("args(INTEGER)")
    // @Pointcut("args(DOUBLE)")
    public void argsPCD() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Getting target method arguments.
     */
    @Pointcut("target(com.spring.aop.Cat)")
    public void getTargetMethodArguments() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Getting arguments using args.
     */
    @Pointcut("args(int, double)")
    public void getArgumentsUsingArgs() { }


    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Getting arguments using names of args
     */
    @Pointcut("args(int, double)")
    public void getArgumentsUsingTypesOfVars() { }

    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Getting arguments using names of args. Still going to match anything
     *  taking an int and a double.
     *  @param exposure exposure
     *  @param aperture aperture
     */
    @Pointcut("args(exposure, aperture)")
    public void getArgumentsUsingNamesOfVars(final int exposure,
                                             final double aperture) { }


    /**
     *  Dummy method to define a reusable AOP pointcut.
     *  Combining pointcuts
     */
    @Pointcut("target(com.spring.aop.Camera)")
    public void targetCamera() { }
    /****************************** ADVICE*************************************/
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
     *  withDemoAdvice method.
     *  Define pointcut as the parameter to the @Before annotation.
     *  This will match any joint point, any method within Spring, within the
     *  Car class
     */
    @Before("withinDemo()")
    public void withDemoAdvice() {

        System.out.println("********** BEFORE DEMO..");
    }

    /**
     *  targetDemoAdvice method.
     *  Define pointcut as the parameter to the @Before annotation.
     *  This should only work for a proxy class not the class itself. But it
     *  seems to work for the class as well.
     */
    @Before("targetDemo()")
    public void targetDemoAdvice() {

        System.out.println("********** TARGET DEMO..");
    }

    /**
     *  thisDemoAdvice method.
     *  Define pointcut as the parameter to the @Before annotation.
     *  This will match any joint point, any method within Spring, within the
     *  Car class
     */
    @Before("thisDemo()")
    public void thisDemoAdvice() {

        System.out.println("********** THIS DEMO..");
    }

    /**
     *  somePointcutDemo method.
     *  Define pointcut as the parameter to the @Before annotation.
     *  This will match any joint point, any method within Spring, within the
     *  Car class
     */
    @Before("somePointcut()")
    public void somePointcutDemo() {

        System.out.println("********** ANNOTATION SPECIFIC DEMO..");
    }

    /**
     *  annotationSpecificDemo method.
     *  Define pointcut as the parameter to the @Before annotation.
     *
     */
    @Before("annotationSpecific()")
    public void annotationSpecificDemo() {

        System.out.println("**********@ANNOTATION SPECIFIC DEMO..");
    }

    /**
     *  atArgsAnnotationDemo method.
     */
    @Before("atArgsAnnotation()")
    public void atArgsAnnotationDemo() {

        System.out.println("**********@ARGS SPECIFIC DEMO..");
    }

    /**
     *  beanAnnotationDemo method.
     */
    @Before("beanAnnotation()")
    public void beanAnnotationDemo() {

        System.out.println("**********BEAN ANNOTATION SPECIFIC DEMO..");
    }

    /**
     *  argsPCDDemo method.
     *  Match any methods that take no arguments.
     *  Actually we can match a method with different arguments.
     */
    @Before("argsPCD()")
    public void argsPCDDemo() {

        System.out.println("**********ARGS PCD SPECIFIC DEMO..");
    }

    /**
     *  argsPCDDemo method.
     *  Match any methods that take no arguments.
     *  Actually we can match a method with different arguments.
     *  @param jp jp
     */
    @Before("getTargetMethodArguments()")
    public void getTargetMethodArgumentsDemo(final JoinPoint jp) {

        System.out.println("**********GET TARGET METHOD ARGUMENTS DEMO..");
        for (Object obj: jp.getArgs()) {
            System.out.println("ARG: " + obj);
        }
    }

    /**
     *  getArgumentsUsingArgsDemo method.
     *  Getting arguments using args.
     *  @param jp jp
     */
    @Before("getArgumentsUsingArgs()")
    public void getArgumentsUsingArgsDemo(final JoinPoint jp) {

        System.out.println("****GET TARGET METHOD ARGUMENTS USING ARGS DEMO..");
        for (Object obj: jp.getArgs()) {
            System.out.println("ARG: " + obj);
        }
    }

    /**
     *  getArgumentsUsingNamesOfArgsDemo method.
     *  Getting arguments using types of args.
     *  @param jp jp
     */
    @Before("getArgumentsUsingTypesOfVars()")
    public void getArgumentsUsingTypesOfArgsDemo(final JoinPoint jp) {

        System.out.println("****GET TARGET METHOD ARGUMENTS USING TYPES OF ARGS DEMO..");
        for (Object obj: jp.getArgs()) {
            System.out.println("ARG: " + obj);
        }
    }

    /**
     *  getArgumentsUsingNamesOfArgsDemo method.
     *  Getting arguments using names of args. Still gong to match anything
     *  taking an int and a double.
     *  @param jp jp
     */
    @Before("getArgumentsUsingNamesOfVars(exposure, aperture)")
    public void getArgumentsUsingNamesOfArgsDemo(final JoinPoint jp,
                                                 final int exposure,
                                                 final double aperture) {

        System.out.println("****GET TARGET METHOD ARGUMENTS USING NAMES OF ARGS DEMO..");
        System.out.printf("exposure %d, aperture %.2f%n", exposure, aperture);
    }

    /**
     *  combingPointcutsDemo method.
     *  Combining Pointcuts
     */
    @Before("targetCamera() && getArgumentsUsingNamesOfVars(exposure, aperture)")
    public void combingPointcutsDemo(final int exposure,
                                     final double aperture) {

        System.out.println("****COMBINING POINTCUTS DEMO..");
        System.out.printf("exposure %d, aperture %.2f%n", exposure, aperture);
    }
}


