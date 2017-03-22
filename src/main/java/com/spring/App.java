package com.spring;

import com.spring.annotation.autowire.Logger6;
import com.spring.annotation.resource.Logger8;
import com.spring.annotation.usingqualifiers.Logger7;
import com.spring.annotation.setpropertyvalues.Robot;
import com.spring.aop.*;
import com.spring.autobeandiscovery.Logger10;
import com.spring.autowire.removeambiguities.Logger5;
import com.spring.autowire.byconstructor.Logger3;
import com.spring.autowire.bydefault.Logger4;
import com.spring.autowire.byname.Logger2;
import com.spring.autowire.bytype.Logger;
import com.spring.annotation.initdestroy.Logger9;
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

import java.util.ArrayList;
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
 * 1. init method can be run after config have been created and their properties
 *    have been set.
 * 2. destroy can be run before config are destroyed.
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
        app.namedparameters();
        app.updatestatements();
        app.getplaceholdervaluesfrombean();
        app.update();
        app.batchupdate();
        app.transactions();
        app.aop();
        app.aopadvisetypes();
        app.aopproxiesinterfaces();
        app.aopwithinpointcut();
        app.aopannotationspecific();
        app.aopannotationspecific2();
        app.aopatannotation();
        app.aopatargsannotation();
        app.aopbeanannotation();*/
        app.aopargspd();


        /* Aspect oriented programming is extending existing classes without
           modifying their existing code base.
         */
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

        /* Create a Spring config container. You can place the config container
         * anywhere in the application using FileSystemXmlApplicationContext.
         */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/applicationContext.xml");

        // The address object is injected into the person object using the ref
        // property in the bean.xml
        Address address = (Address) context.getBean("address");
        //System.out.println(address);

        // Use p namespace in bean.xml to set address properties.
        Address address2 = (Address) context.getBean("address2");
        System.out.println("Address using p namespace: " + address2);

        // Use the Spring config container, context, to get config from it.
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

        /* Create a Spring config container. You can place the config container
         * anywhere in the application using FileSystemXmlApplicationContext.
         */
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/applicationContext.xml");

        FruitBasket basket = (FruitBasket) context.getBean("basket");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Create a list of config using a junglebean.xml.
     */
    private void listOfBeans() {

        // A Spring bean container. */
        final ApplicationContext junglebean =
                new FileSystemXmlApplicationContext(
                "src/main/java/com/spring/config/junglebean.xml");

        Jungle jungle = (Jungle) junglebean.getBean("jungle");
        System.out.println(jungle);

        ((FileSystemXmlApplicationContext) junglebean).close();
    }

    /**
     *  Create a list of config using jungleinnerbeans.xml.
     */
    private void innerBeans() {

        // A Spring bean container.
        final ApplicationContext jungleinnerbeans =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/config/jungleinnerbean.xml");

        Jungle jungle = (Jungle) jungleinnerbeans.getBean("jungle");
        System.out.println(jungle);

        ((FileSystemXmlApplicationContext) jungleinnerbeans).close();
    }

    /**
     *  Create a list of config using propertymap.xml.
     */
    private void propertymap() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                "src/main/java/com/spring/config/propertymap.xml");

        JungleFoods junglefoods = (JungleFoods) context.getBean("jungleFoods");
        System.out.println(junglefoods);

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebytype.xml.
     */
    private void autowirebytype() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/config/autowirebytype.xml");

        Logger logger = (Logger) context.getBean("autowirebytype");

        logger.writeConsole("Autowire by type");
        logger.writeFile("Autowire by type");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebyname.xml.
     */
    private void autowirebyname() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/config/autowirebyname.xml");

        Logger2 logger = (Logger2) context.getBean("autowirebyname");

        logger.writeConsole("Autowire by name");
        logger.writeFile("Autowire by name");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebyconsctructor.xml.
     */
    private void autowirebyconstructor() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/autowirebyconstructor.xml");

        Logger3 logger = (Logger3) context.getBean("autowirebyconstructor");

        logger.writeConsole("Autowire by constructor");
        logger.writeFile("Autowire by constructor");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void autowirebydefault() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/autowirebydefault.xml");

        Logger4 logger = (Logger4) context.getBean("autowirebydefault");

        logger.writeConsole("Autowire by default");
        logger.writeFile("Autowire by default");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void autowireremoveambiguities() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/config/autowireremoveambiguities.xml");

        Logger5 logger = (Logger5) context.getBean("autowireremoveambiguities");

        logger.writeConsole("Autowire remove ambiguities");
        logger.writeFile("Autowire remove ambiguities");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void annotationwiring() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/annotationautowire.xml");

        Logger6 logger = (Logger6) context.getBean("annotationwiring");

        logger.writeConsole("Annotation autowire");
        logger.writeFile("Annotation autowire");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Autowire classes using autowirebydefault.xml.
     */
    private void annotationusingqualifiers() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/annotationusingqualifiers.xml");

        Logger7 logger = (Logger7) context.getBean("annotationusingqualifiers");

        logger.writeConsole("Annotation using qualifiers");
        logger.writeFile("Annotation using qualifiers");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Resource annotations using annotationsresource.xml.
     */
    private void annotationresource() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/annotationresource.xml");

        Logger8 logger = (Logger8) context.getBean("annotationresource");

        logger.writeConsole("Annotation resource");
        logger.writeFile("Annotation resource");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Resource annotations using annotationsresource.xml.
     */
    private void annotationinitdestroy() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
    "src/main/java/com/spring/config/annotationinitdestroy.xml");

        Logger9 logger = (Logger9) context.getBean("annotationinitdestroy");

        logger.writeConsole("Annotation init and destroy");
        logger.writeFile("Annotation init and destroy");

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Resource annotations using annotationsresource.xml.
     */
    private void automaticbeandiscovery() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/autobeandiscovery.xml");

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

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
        "src/main/java/com/spring/config/annotationsetpropertyvalues.xml");

        Robot robot = (Robot) context.getBean("annotationsetpropertyvalues");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel and
     *  spel.xml.
     */
    private void spel() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/spel.xml");

        Robot2 robot = (Robot2) context.getBean("spel");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel annotations and
     *  spelannotations.xml.
     */
    private void spelannotations() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/config/spelannotations.xml");

        Robot3 robot = (Robot3) context.getBean("spelannotations");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel annotations and
     *  spelannotations.xml.
     */
    private void speloperators() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/config/speloperators.xml");

        Robot4 robot = (Robot4) context.getBean("speloperators");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Set property values using spel annotations and
     *  spelannotations.xml.
     */
    private void usepropertyfile() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
            "src/main/java/com/spring/config/usepropertyfile.xml");

        Robot5 robot = (Robot5) context.getBean("usepropertyfile");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Implement the dao pattern.
     */
    private void daopattern() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/daopattern.xml");

        Robot6 robot = (Robot6) context.getBean("daopattern");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Implement a dbcp.
     */
    private void dbcp() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

        Robot7 robot = (Robot7) context.getBean("dbcp");

        robot.speak();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Query the database.
     */
    private void databasequery() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

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

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

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

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

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
     *  Example of deleting an Offer object from the database.
     */
    private void updatestatements() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

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

    /**
     *  Example of getting placeholder values from a bean.
     */
    private void getplaceholdervaluesfrombean() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

        OffersDAO2 offersDao = (OffersDAO2) context.getBean("offersDao2");

        try {

            Offer offer1 = new Offer("Dave",
                    "dave@hotmail.com", "Coding Java");
            Offer offer2 = new Offer("Karen",
                    "karen@hotmail.com", "UI/UX Designer");

            if (offersDao.create(offer1) && offersDao.create(offer2)) {
                System.out.println("Created Offer objects.");
            }

            List<Offer> offers = offersDao.getOffers();

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
     *  Example of updating an Offer object in the database.
     */
    private void update() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

        OffersDAO2 offersDao = (OffersDAO2) context.getBean("offersDao2");

        try {

            Offer updateOffer = new Offer(4, "Claire",
                    "claire@hotmail.com", "Coding Java");

            if (offersDao.update(updateOffer)) {
                System.out.println("Object updated.");
            } else {
                System.out.println("Cannot update object.");
            }

            List<Offer> offers = offersDao.getOffers();

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
     *  Example of batch updating Offer objects in the database using Spring
     *  (not JDBC).
     */
    private void batchupdate() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

        OffersDAO2 offersDao = (OffersDAO2) context.getBean("offersDao2");

        try {

            List<Offer> offersList = new ArrayList<Offer>();

            offersList.add(new Offer("Dave",
                                     "dave@caveofprogramming.com",
                                     "Cash for software."));
            offersList.add(new Offer("Karen",
                                     "karen@caveofprogramming.com",
                                     "Elegant web design"));

            int[] rvals = offersDao.create(offersList);

            for (int value: rvals) {
                System.out.println("Updated " + value + " rows.");
            }

            List<Offer> offers = offersDao.getOffers();

            for (Offer offer : offers) {
                System.out.println(offer);
            }

            Offer offer = offersDao.getOffer(2);

            System.out.println("Should be Mike: " + offer);
        } catch (CannotGetJdbcConnectionException ex) {
            System.out.println("Cannot get database connection.");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  Example of batch updating Offer objects in the database using Spring
     *  (not JDBC) usng the @Transaction annotation. This example should cause
     *  an exception if one of the ids is the same as one in the database.
     */
    private void transactions() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/config/dbcp.xml");

        OffersDAO2 offersDao = (OffersDAO2) context.getBean("offersDao2");

        try {

            List<Offer> offersList = new ArrayList<Offer>();

            offersList.add(new Offer(3, "Dave",
                    "dave@caveofprogramming.com",
                    "Cash for software."));
            offersList.add(new Offer(2, "Karen",
                    "karen@caveofprogramming.com",
                    "Elegant web design"));

            int[] rvals = offersDao.create(offersList);

            for (int value: rvals) {
                System.out.println("Updated " + value + " rows.");
            }

            List<Offer> offers = offersDao.getOffers();

            for (Offer offer : offers) {
                System.out.println(offer);
            }

            Offer offer = offersDao.getOffer(2);

            System.out.println("Should be Mike: " + offer);
        } catch (CannotGetJdbcConnectionException ex) {
            System.out.println("Cannot get database connection.");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((FileSystemXmlApplicationContext) context).close();
    }

    /** aop method. */
    private void aop() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Camera camera = (Camera) context.getBean("camera");
        Lens lens = (Lens) context.getBean("lens");
        try {
            camera.snap();
            camera.snap(1000);
            camera.snap("Prague castle");
            camera.snapNighttime();
            lens.zoom(5);
        } catch (Exception e) {
            e.getMessage();
        }

        ((FileSystemXmlApplicationContext) context).close();
    }

    /** aopadvisetypes method. */
    private void aopadvisetypes() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Camera camera = (Camera) context.getBean("camera");

        try {
            camera.snap();

        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopadvisetypes method.
     *  To implement aspects when you ask for your bean Spring gives you a proxy
     *  which is a class ( subclass of camera) that has code that will run code
     *  in your aspect. It combines your aspect with your target class in order
     *  to run your advice.
     */
    private void aopproxiesinterfaces() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Camera camera = (Camera) context.getBean("camera");
        System.out.println("Class of camera bean: " + camera.getClass());
        System.out.println(camera instanceof Camera);
        System.out.println(camera instanceof PhotoSnapper);
        System.out.println(camera instanceof Machine);
        //System.out.println(camera instanceof ICamera);

        try {
            camera.snap();

        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopadvisetypes method.
     *  To implement aspects when you ask for your bean Spring gives you a proxy
     *  which is a class ( subclass of camera) that has code that will run code
     *  in your aspect. It combines your aspect with your target class in order
     *  to run your advice.
     */
    private void aopwithinpointcut() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Car car = (Car) context.getBean("car");
        car.withinDemo();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopannotationspecific method.
     *  To implement aspects when you ask for your bean Spring gives you a proxy
     *  which is a class ( subclass of camera) that has code that will run code
     *  in your aspect. It combines your aspect with your target class in order
     *  to run your advice.
     */
    private void aopannotationspecific() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Dog dog = (Dog) context.getBean("dog");
        dog.annotationSpecificDemo();

        Cat cat = (Cat) context.getBean("cat");
        cat.annotationSpecificDemo();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopannotationspecific2 method.
     *
     */
    private void aopannotationspecific2() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Cat cat = (Cat) context.getBean("cat");
        cat.annotationSpecificDemo();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopannotationspecific2 method.
     *
     */
    private void aopatannotation() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Cat cat = (Cat) context.getBean("cat");
        cat.atAnnotationDemo();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopannotationspecific2 method.
     *
     */
    private void aopatargsannotation() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Cat cat = (Cat) context.getBean("cat");
        cat.atArgsAnnotationDemo();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopannotationspecific2 method.
     *
     */
    private void aopbeanannotation() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Cat cat = (Cat) context.getBean("cat");
        cat.annotationSpecificDemo();

        ((FileSystemXmlApplicationContext) context).close();
    }

    /**
     *  aopannotationspecific2 method.
     *
     */
    private void aopargspd() {

        // A Spring bean container.
        final ApplicationContext context =
                new FileSystemXmlApplicationContext(
                        "src/main/java/com/spring/aop/beans.xml");

        Camera camera = (Camera) context.getBean("camera");

        try {
            camera.snap();
            camera.snap(500);
            camera.snap(1.8);
            camera.snap(500, 1.8);
            camera.snapNighttime();

        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        ((FileSystemXmlApplicationContext) context).close();
    }
}
