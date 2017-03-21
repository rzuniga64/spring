package com.spring.autowire.bytype;

/**
 *  Dummy implementation of Logger4 class.
 *  We need to wire the ConsoleWriter and FileWriter config into this class.
 */
public class Logger {

    /** Consoler writer. */
    private ConsoleWriter consoleWriter;
    /** File writer. */
    private FileWriter fileWriter;

    /**
     *  Set the consoleWriter.
     *  @param writer writer
     */
    public void setConsoleWriter(final  ConsoleWriter writer) {
        this.consoleWriter = writer;
    }

    /**
     *  Set the fileWriter.
     *  @param newFileWriter newFileWriter
     */
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
        consoleWriter.write(text);
    }
}
