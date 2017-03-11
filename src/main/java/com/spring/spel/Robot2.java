package com.spring.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *  Robot class.
 */
@Component
public class Robot2 {

    /** ID. */
    private int id = 0;
    /** Speech. */
    private String speech = "hello";

    /** Speak method. */
    public void speak() {
        System.out.println(id + ": " + speech);
    }

    /**
     * Set ID.
     * @param newId newId
     */
    @Autowired
    public void setId(final @Value("1138") int newId) {
        this.id = newId;
    }

    /**
     * Set speech.
     * @param newSpeech newSpeech
     */
    @Autowired
    public void setSpeech(final @Value("I'll be back.") String newSpeech) {
        this.speech = newSpeech;
    }
}
