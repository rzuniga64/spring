package com.spring.annotationresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 *  Dummy implementation of Logger4 class.
 *  We need to wire the ConsoleWriter and FileWriter beans into this class.
 */
public class Logger8 {

    /** Consoler writer. */
    private LogWriter consoleWriter;

    /** File writer. */
    private FileWriter fileWriter;

    /**
     *  Set the consoleWriter.
     *  Only inject the bean if it is found in the XML.
     *  @Resource(name) = "consoleWriter" eliminates ambiguity when there are
     *  two beans with the same class. We have two ConsoleWriters of type
     *  LogWriter in annoationresource.xml.
     *
     *  @param writer writer
     */
    @Resource(name = "consoleWriter")
    public void setConsoleWriter(final LogWriter writer) {
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
