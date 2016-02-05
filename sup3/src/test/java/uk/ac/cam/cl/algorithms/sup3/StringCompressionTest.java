package uk.ac.cam.cl.algorithms.sup3;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



import static junit.framework.TestCase.assertEquals;

/**
 * Created by app on 05/02/16.
 */
@RunWith(Parameterized.class)
public class StringCompressionTest {
    RandomStringGenerator randomStringGenerator = new RandomStringGenerator();

    @Test
    public void testCompressOfSingletonReturnsItself(){
        String input = "a";
        String expected = "a";
        String actual = StringCompression.compress(input);
        assertEquals(expected,actual);
    }

    @Test
    public void testCompressOfUnrepeatedStringReturnsitself(){
        String input = "abcabcsasdsasd";
        String expected = "abcabcsasdsasd";
        String actual = StringCompression.compress(input);
        assertEquals(expected,actual);
    }

    @Test
    public void testCompressAndDecompressAreInverse(){
        String input;
        for (int i = 0; i < 6; i++) {
            input = randomStringGenerator.get(i<<1);
            try {
                assertEquals(input, StringCompression.decompress(StringCompression.compress(input)));
            }catch (StringCompression.InsufficientRepeatsException error){
                error.printStackTrace();
            }
        }
    }

    @Test
    public void testCompressFollowsSpecificationsOfEncoding(){
        String input = "aaaabbbaabbbbbaba";
        assertEquals(StringCompression.compress(input),"a4b3a2b5aba");
    }


}
