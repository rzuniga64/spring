package com.spring.spelannotations;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 *  RandomText class.
 */
@Component
public class RandomText {

    /** Array of strings. */
    private static String[] texts = {
            "I don't know my name",
            "Beautiful thing",
            "Clay",
            null
    };

    /**
     *  Get the text.
     *  @return text
     */
    public String getText() {
        Random random = new Random();

        return texts[random.nextInt(texts.length)];
    }
}
