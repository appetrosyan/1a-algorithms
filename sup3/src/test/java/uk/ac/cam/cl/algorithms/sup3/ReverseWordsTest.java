package uk.ac.cam.cl.algorithms.sup3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Created by app on 05/02/16.
 *
 * Tests to determine whether the everseWords implementation follows the specs.
 */
@RunWith(Parameterized.class)
public class ReverseWordsTest {

    @Test
    public void testReversingEmptyReturnsEmpty(){
        String input = "";
        assertEquals(ReverseWords.reverseWords(input),"");
    }

    @Test
    public void testReversingSingletonReturnsitself(){
        String input = "a";
        assertEquals(ReverseWords.reverseWords(input),"a");
    }

    @Test
    public void testReversingSentences(){
        String input = "Lorem Ipsum Dolor Sit amet";
        String expected = "meroL muspI roloD tiS tema";
        String actual = ReverseWords.reverseWords(input);
        assertEquals(expected,actual);
    }

    @Test
    public void testReversingPalidnromeGetsitReversed(){
        String input = "avid diva";
        assertEquals(ReverseWords.reverseWords(input),input);
    }

}
