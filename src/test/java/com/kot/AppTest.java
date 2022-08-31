package com.kot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldReverceStringOptimal(){
        App app  = new App();
        String sentence = "Hello, java! Nice try!";
        String result = "olleH, avaj! eciN yrt!";
        assertEquals(App.reverseWordsOptimal(sentence), result);

    }

    @Test
    public void shouldReverseWordsWithStream(){
        App app  = new App();
        String sentence = "Hello, java! Nice try!";
        String result = "olleH, avaj! eciN yrt!";
        assertEquals(result, App.reverseWordsStream(sentence));
    }

    @Test
    public void shouldReverseWordsWithCustomReverse(){
        App app  = new App();
        String sentence = "Hello, java! Nice try!";
        String result = "olleH, avaj! eciN yrt!";
        assertEquals(result, App.customReverse(sentence));
    }



}
