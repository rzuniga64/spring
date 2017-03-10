package com.spring.autowirebyconstructor;

/**
 *  Dummy implementation of Logger4 class.
 *  We need to wire the ConsoleWriter and FileWriter beans into this class.
 *  We have two properties of the same type that we want to autowire with beans.
 */
public class Logger3 {

    /** Consoler writer. */
    private LogWriter consoleWriter;
    /** File writer. */
    private LogWriter fileWriter;

    /**
     * Constructor so classes can be autowired by constructor. The parameters
     * must have the write types and cannot be ambiguous.
     * @param consoleWriter consoleWriter
     * @param fileWriter fileWriter
     */
    public Logger3(final ConsoleWriter consoleWriter,
                   final FileWriter fileWriter) {

        this.consoleWriter = consoleWriter;
        this.fileWriter = fileWriter;
    }

    /**
     *  Set the consoleWriter.
     *  @param writer writer
     */
    public void setConsoleWriter(final LogWriter writer) {
        this.consoleWriter = writer;
    }

    /**
     *  Set the fileWriter.
     *  @param newFileWriter newFileWriter
     */
    public void setFileWriter(final LogWriter newFileWriter) {
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
        consoleWriter.write(text);
    }
}
