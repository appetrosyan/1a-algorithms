package uk.ac.cam.cl.algorithms.sup3;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by app on 05/02/16.
 */

public class PermutationsTest {


    @Test
    public void testEmptyStringsArePermutations(){
        String arg1="";
        String arg2="";
        assertEquals(Permutations.arePermuations(arg1,arg2),true);
    }

    @Test
    public void testSingletons(){
        assertEquals(Permutations.arePermuations("a","b"),false);
        assertEquals(Permutations.arePermuations("a","a"),true);

    }

    @Test
    public void testDifferentLengthsAreNot(){
        assertEquals(Permutations.arePermuations("asd","asd "),false);
        assertEquals(Permutations.arePermuations("asdasdasd",""),false);
        assertEquals(Permutations.arePermuations("wdwdwdw","wxwxwxw"),false);
    }

    @Test
    public void testStringsSameLength(){
        assertEquals(Permutations.arePermuations("hellman","lehlnam"),true);
        assertEquals(Permutations.arePermuations("Lorem Ipsum Dolor Sit Amet","Ipsum Dolor Amet Sit Lorem"),true);
    }

    // Testing a static method, so nothing to do here.

    public PermutationsTest(){

    }

}
