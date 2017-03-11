package com.spring.props;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *  Robot class.
 */
@Component
public class Robot5 {

    /** ID. */
    private String id = "Default robot";
    /** Speech. */
    private String speech = "hello";

    /** Speak method. */
    public void speak() {
        System.out.println(id + ": " + speech);
    }

    /**
     *  Set ID.
     *  @param newId newId
     */
    @Autowired
    public void setId(final @Value("${jdbc.user}") String newId) {
        this.id = newId;
    }

    /**
     *  Set speech.
     *  @param newSpeech newSpeech
     */
    @Autowired
    public void setSpeech(final @Value("${jdbc.password}") String newSpeech) {
        this.speech = newSpeech;
    }
}
