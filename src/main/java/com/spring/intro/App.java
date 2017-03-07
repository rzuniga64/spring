package com.spring.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *  Application class.
 *  Spring is just a bunch of jars and xml files that you create.
 */
public final class App {

    /** Default constructor. */
    private App() { }

    /**
     * Main methods.
     * @param args args.
     */
    public static void main(final String[] args) {

        // Create a Spring beans container. You can place the beans container
        // anywhere in the application using FileSystemXmlApplicationContext.
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "src/main/java/com/spring/beans/applicationContext.xml");

        // Use the Spring beans container, context, to get beans from it.
        // FileSystemXmlApplicationContext object reads the xml file and then
        // finds the Person class mentioned in the xml file and instantiates it.
        // Then we can fetch the object from the ApplicationContext and call
        // methods on the object.
        Person person = (Person) context.getBean("person");
        person.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }
}
