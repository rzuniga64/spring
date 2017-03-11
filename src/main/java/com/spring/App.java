package com.spring;

import com.spring.annotationautowire.Logger6;
import com.spring.annotationresource.Logger8;
import com.spring.annotationusingqualifiers.Logger7;
import com.spring.annotoationsetpropertyvalues.Robot;
import com.spring.autobeandiscovery.Logger10;
import com.spring.autowirearemovembiguities.Logger5;
import com.spring.autowirebyconstructor.Logger3;
import com.spring.autowirebydefault.Logger4;
import com.spring.autowirebyname.Logger2;
import com.spring.autowirebytype.Logger;
import com.spring.annotationinitdestroy.Logger9;
import com.spring.daopattern.Robot6;
import com.spring.dbcp.Robot7;
import com.spring.intro.Address;
import com.spring.intro.FruitBasket;
import com.spring.intro.Jungle;
import com.spring.intro.Person;
import com.spring.models.Offer;
import com.spring.models.OffersDAO;
import com.spring.models.OffersDAO2;
import com.spring.propertymaps.JungleFoods;
import com.spring.props.Robot5;
import com.spring.spel.Robot2;
import com.spring.spelannotations.Robot3;
import com.spring.speloperators.Robot4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.List;

/**
 *  Application class.
 *  Spring is just a bunch of jars and xml files that you create.
 *
 *  DEPENDENCY INJECTION
 *  We will use dependency injection to inject an Address object into a Person
 *  object.
 *  1.  We create an Address class
 *  2.  Add it as a property in the Person class
 *  3.  Create a setter for it in the Person class.
 *  4.  Then we add the Address class as a bean in the bean.xml setting values
 *      for the properties.
 *  5.  The we inject the Address bean in the bean.xml by adding a property to
 *      Person with a reference to the Address bean.
 *
 *  BEAN SCOPE
 *  A bean can have a scope of prototype, request, session, or singleton.
 *  1.  Singleton. A Java bean, by default, is a singleton. You can set the
 *      scope in the bean.xml to singleton if you want to make it more clear.
 *  2.  Prototype. If you set the scope to prototype then the you can
 *      instantiate more than one bean. So when you create a bean with scope
 *      of prototype you create a new object.
 *
 * INIT and DESTROY METHODS
 * 1. init method can be run after beans have been created and their properties
 *    have been set.
 * 2. destroy can be run before beans are destroyed.
 */
public final class App {

    /** Default constructor. */
    private App() { }

    /**
     * Main methods.
     * @param args args.
     */
    public static void main(final String[] args) {

        App app = new App();
        /**app.basicBeanConfiguration();
        app.settingListProperties();
        app.listOfBeans();
        app.innerBeans();
        app.propertymap();
        app.autowirebytype();
        app.autowirebyname();
        app.autowirebyconstructor();
        app.autowirebydefault();
        app.autowireremoveambiguities();
        app.annotationwiring();
        app.annotationusingqualifiers();
        app.annotationresource();
        app.annotationinitdestroy();
        app.automaticbeandiscovery();
        app.annotationsetpropertyvalues();
        app.spel();
        app.spelannotations();
        app.speloperators();
        app.usepropertyfile();
        app.daopattern();
        app.dbcp();
        app.databasequery();
        app.databaexception();
        app.namedparameters();*/
        app.updatestatements();
    }

    /**
     *  Basic bean configuration method.
     *  1. Constructor arguments
     *  2. Setting bean properties
     *  3. Dependency Injection
     *  4. Bean scope
     *  5. Init and destroy methods.
     *  6. Factory bean methods.
     *  7. The P namespace.
     */
    private void basicBeanConfiguration() {

        /** Create a Spring beans container. You can place the beans container
         * anywhere in the application using FileSystemXmlApplicationContext.
         */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/applicationContext.xml");

        // The address object is injected into the person object using the ref
        // property in the bean.xml
        Address address = (Address) context.getBean("address");
        //System.out.println(address);

        // Use p namespace in bean.xml to set address properties.
        Address address2 = (Address) context.getBean("address2");
        System.out.println("Address using p namespace: " + address2);

        // Use the Spring beans container, context, to get beans from it.
        // FileSystemXmlApplicationContext object reads the xml file and then
        // finds the Person class mentioned in the xml file and instantiates it.
        // Then we can fetch the object from the ApplicationContext and call
        // methods on the object.
        Person person = (Person) context.getBean("person");
        Person person2 = (Person) context.getBean("person");

        // Tax id get set for person if scope is prototype in bean.xml.
        // Tax id is et for every person if scope is set to singleton.
        person.setTaxId(999);

        System.out.println(person);
        System.out.println();
        System.out.println(person2);

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set list properties using bean.xml.
     *  Example of setting list properties using a bean.xml.
     */
    private void settingListProperties() {

        /** Create a Spring beans container. You can place the beans container
         * anywhere in the application using FileSystemXmlApplicationContext.
         */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/applicationContext.xml");

        FruitBasket basket = (FruitBasket) context.getBean("basket");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Create a list of beans using a junglebean.xml.
     */
    private void listOfBeans() {

        /** A Spring bean container. */
        final ApplicationContext junglebean =
                new FileSystemXmlApplicationContext(
                "src/main/java/com/spring/beans/junglebean.xml");

        Jungle jungle = (Jungle) junglebean.getBean("jungle");
        System.out.println(jungle);

        ((FileSystemXmlApplicationContext) junglebean).close();
    }

    /**
     *  Create a list of beans using jungleinnerbeans.xml.
     */
    private void innerBeans() {

        // A Spring bean container.
        final ApplicationContext jungleinnerbeans =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/beans/jungleinnerbean.xml");

        Jungle jungle = (Jungle) jungleinnerbeans.getBean("jungle");
        System.out.println(jungle);

        ((FileSystemXmlApplicationContext) jungleinnerbeans).close();
    }

    /**
     *  Create a list of beans using propertymap.xml.
     */
    private void propertymap() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                "src/main/java/com/spring/beans/propertymap.xml");

        JungleFoods junglefoods = (JungleFoods) context.getBean("jungleFoods");
        System.out.println(junglefoods);

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebytype.xml.
     */
    private void autowirebytype() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/beans/autowirebytype.xml");

        Logger logger = (Logger) context.getBean("autowirebytype");

        logger.writeConsole("Autowire by type");
        logger.writeFile("Autowire by type");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebyname.xml.
     */
    private void autowirebyname() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/beans/autowirebyname.xml");

        Logger2 logger = (Logger2) context.getBean("autowirebyname");

        logger.writeConsole("Autowire by name");
        logger.writeFile("Autowire by name");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebyconsctructor.xml.
     */
    private void autowirebyconstructor() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/autowirebyconstructor.xml");

        Logger3 logger = (Logger3) context.getBean("autowirebyconstructor");

        logger.writeConsole("Autowire by constructor");
        logger.writeFile("Autowire by constructor");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void autowirebydefault() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/autowirebydefault.xml");

        Logger4 logger = (Logger4) context.getBean("autowirebydefault");

        logger.writeConsole("Autowire by default");
        logger.writeFile("Autowire by default");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void autowireremoveambiguities() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/beans/autowireremoveambiguities.xml");

        Logger5 logger = (Logger5) context.getBean("autowireremoveambiguities");

        logger.writeConsole("Autowire remove ambiguities");
        logger.writeFile("Autowire remove ambiguities");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void annotationwiring() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/annotationautowire.xml");

        Logger6 logger = (Logger6) context.getBean("annotationwiring");

        logger.writeConsole("Annotation autowire");
        logger.writeFile("Annotation autowire");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void annotationusingqualifiers() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/annotationusingqualifiers.xml");

        Logger7 logger = (Logger7) context.getBean("annotationusingqualifiers");

        logger.writeConsole("Annotation using qualifiers");
        logger.writeFile("Annotation using qualifiers");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Resource annotations using annotationsresource.xml.
     */
    private void annotationresource() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/annotationresource.xml");

        Logger8 logger = (Logger8) context.getBean("annotationresource");

        logger.writeConsole("Annotation resource");
        logger.writeFile("Annotation resource");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Resource annotations using annotationsresource.xml.
     */
    private void annotationinitdestroy() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
    "src/main/java/com/spring/beans/annotationinitdestroy.xml");

        Logger9 logger = (Logger9) context.getBean("annotationinitdestroy");

        logger.writeConsole("Annotation init and destroy");
        logger.writeFile("Annotation init and destroy");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Resource annotations using annotationsresource.xml.
     */
    private void automaticbeandiscovery() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/autobeandiscovery.xml");

        Logger10 logger = (Logger10) context.getBean("autobeandiscovery");

        logger.writeConsole("Automatic bean discovery");
        logger.writeFile("Automatic bean discovery");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using annotations and
     *  annotationssetpropertyvalues.xml.
     */
    private void annotationsetpropertyvalues() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/beans/annotationsetpropertyvalues.xml");

        Robot robot = (Robot) context.getBean("annotationsetpropertyvalues");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel and
     *  spel.xml.
     */
    private void spel() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/beans/spel.xml");

        Robot2 robot = (Robot2) context.getBean("spel");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel annotations and
     *  spelannotations.xml.
     */
    private void spelannotations() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/beans/spelannotations.xml");

        Robot3 robot = (Robot3) context.getBean("spelannotations");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel annotations and
     *  spelannotations.xml.
     */
    private void speloperators() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/beans/speloperators.xml");

        Robot4 robot = (Robot4) context.getBean("speloperators");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel annotations and
     *  spelannotations.xml.
     */
    private void usepropertyfile() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/beans/usepropertyfile.xml");

        Robot5 robot = (Robot5) context.getBean("usepropertyfile");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Implement the dao pattern.
     */
    private void daopattern() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/beans/daopattern.xml");

        Robot6 robot = (Robot6) context.getBean("daopattern");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Implement a dbcp.
     */
    private void dbcp() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/beans/dbcp.xml");

        Robot7 robot = (Robot7) context.getBean("dbcp");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Query the database.
     */
    private void databasequery() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/beans/dbcp.xml");

        OffersDAO offersDAO = (OffersDAO) context.getBean("offersDao");

        List<Offer> offers = offersDAO.getOffers();

        for (Offer offer: offers) {
            System.out.println(offer);
        }

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Query the database.
     */
    private void databaexception() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/beans/dbcp.xml");

        OffersDAO offersDAO = (OffersDAO) context.getBean("offersDao");

        try {
            List<Offer> offers = offersDAO.getOffers();

            for (Offer offer : offers) {
                System.out.println(offer);
            }
        } catch (CannotGetJdbcConnectionException ex) {
                System.out.println("Cannot get database connection.");
        } catch (DataAccessException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getClass());
        }

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Query the database.
     */
    private void namedparameters() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/beans/dbcp.xml");

        OffersDAO2 offersDAO2 = (OffersDAO2) context.getBean("offersDao2");

        List<Offer> offers = offersDAO2.getOffers();

        for (Offer offer: offers) {
            System.out.println(offer);
        }

        Offer offer = offersDAO2.getOffer(2);

        System.out.println("Should be Mike: " + offer);

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Query the database.
     */
    private void updatestatements() {

        /** A Spring bean container. */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/beans/dbcp.xml");

        OffersDAO2 offersDAO2 = (OffersDAO2) context.getBean("offersDao2");

        try {
            offersDAO2.delete(3);

            List<Offer> offers = offersDAO2.getOffers();

            for (Offer offer: offers) {
                System.out.println(offer);
            }
        } catch (CannotGetJdbcConnectionException ex) {
            System.out.println("Cannot get database connection.");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((FileSystemXmlApplicationContext) context).close();
    }
}
