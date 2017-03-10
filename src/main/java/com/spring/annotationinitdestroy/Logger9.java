package com.spring.annotationinitdestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 *  Dummy implementation of Logger4 class.
 *  We need to wire the ConsoleWriter and FileWriter beans into this class.
 *
 */
public class Logger9 {

    /** Consoler writer. */
    private ConsoleWriter consoleWriter;

    /** File writer. */
    private FileWriter fileWriter;

    /**
     *  Set the consoleWriter.
     *  Only inject the bean if it is found in the XML.
     *
     *  @param writer writer
     */
    @Resource(name = "consoleWriter")
    public void setConsoleWriter(final ConsoleWriter writer) {
        this.consoleWriter = writer;
    }

    /**
     *  Set the fileWriter.
     *  @param newFileWriter newFileWriter
     */
    @Resource
    public void setFileWriter(final FileWriter newFileWriter) {
        this.fileWriter = newFileWriter;
    }

    /**
     *  Write to the file.
     *  @param text text
     */
    public void writeFile(final String text) {
        fileWriter.write(text);
    }

    /**
     *  Write to the console.
     *  @param text text
     */
    public void writeConsole(final String text) {
        if (consoleWriter != null) {
            consoleWriter.write(text);
        }
    }

    /** Init method. */
    @PostConstruct
    public void init() {
        System.out.println("init using @PostConstruct annotation.");
    }

    /** Destroy method. */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy using @PostConstruct annotation.");
    }
}
