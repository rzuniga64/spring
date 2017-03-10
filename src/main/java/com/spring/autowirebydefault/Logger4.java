package com.spring.autowirebydefault;

/**
 *  Dummy implementation of Logger4 class.
 *  We need to wire the ConsoleWriter and FileWriter beans into this class.
 *  We have two properties of the same type that we want to autowire with beans.
 */
public class Logger4 {

    /** Consoler writer. */
    private LogWriter consoleWriter;
    /** File writer. */
    private LogWriter fileWriter;

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
