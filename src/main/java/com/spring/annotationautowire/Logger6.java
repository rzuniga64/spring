package com.spring.annotationautowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *  Dummy implementation of Logger4 class.
 *  We need to wire the ConsoleWriter and FileWriter config into this class.
 */
public class Logger6 {

    /** Consoler writer. */
    @Autowired
    private ConsoleWriter consoleWriter;
    /** File writer. */
    @Autowired
    private FileWriter fileWriter;

    /** Constructor. */
    public Logger6() { }

    /**
     * Constructor.
     * @param newConsoleWriter newConsoleWriter
     * @param newFileWriter newFileWriter
     */
    //@Autowired
    public Logger6(final ConsoleWriter newConsoleWriter,
                   final FileWriter newFileWriter) {
        super();
        this.consoleWriter = newConsoleWriter;
        this.fileWriter = newFileWriter;
    }

    /**
     *  Set the consoleWriter.
     *  Only inject the bean if it is found in the XML.
     *  @param writer writer
     */
    @Autowired(required = false)
    public void setConsoleWriter(final ConsoleWriter writer) {
        this.consoleWriter = writer;
    }

    /**
     *  Set the fileWriter.
     *  @param newFileWriter newFileWriter
     */
    @Autowired
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
