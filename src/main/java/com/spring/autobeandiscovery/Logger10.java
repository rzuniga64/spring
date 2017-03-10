package com.spring.autobeandiscovery;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 *  Dummy implementation of Logger4 class.
 *  We need to wire the ConsoleWriter and FileWriter beans into this class.
 *  Make sure you set scope of bean to singleton or leave it to its default.
 */
@Component
public class Logger10 {

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
    @Resource
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
}
