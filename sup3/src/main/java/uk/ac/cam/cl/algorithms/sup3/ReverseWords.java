package uk.ac.cam.cl.algorithms.sup3;


import java.lang.Math;
/**
 * Created by oliverchick on 2016-02-01.
 */
public class ReverseWords {

    private final static String INPUT_SEPARATOR = " ";
    private final static String OUTPUT_SEPARATOR =" ";

    /**
     * @param input A string consisting of words separated with spaces. No
     *              punctuation. eg 'Chelsea five Manchester Utd Nill'
     * @return A string with the letters in each word reversed. eg 'aeslehC evif
     *  retsehcnaM dtU liN'
     */
    public static String reverseWords(String input) {
        String[] inputStrings = input.split(INPUT_SEPARATOR);
        reverseStringArray(inputStrings);
        return concatenate(inputStrings,OUTPUT_SEPARATOR);
    }

    /**
     *
     * @param input The array of Strings to be concatenated.
     * @param separator the separator of the array elements
     * @return single String that contains every String in the input plus a separator.
     */
    private static final String concatenate (String [] input,String separator){
        String result="";
        for (String element: input){
            result = element + separator;
        }
        return result.trim(); // Makes sense to remove the trailing whitespace
    }

    /**
     * map reverse to elements of the input array.
     * @param input
     */
    private static final void reverseStringArray (String[] input){
        for(String element: input){
            element  = reverseString(element);
        }
    }

    /**
     * reverses the input
     * @param input
     * @return reversed input
     */
    private final static String reverseString(String input) {
        if (input.length() <= 1) {
            return input;
        } else{
            char[] inputChars = input.toCharArray();
        for (int i = inputChars.length; i > inputChars.length/2; i--) {
            swap(inputChars, i, inputChars.length - i);
        }
        return inputChars.toString();
        }
    }

    /**
     * Provided for readability. Would be more efficient to reaplce in code as a macro.
     * @param input
     * @param i
     * @param j
     */
    private final static void swap (char [] input, int i, int j){
        char buffer = input[i];
        input[i]=input[j];
        input[j] = buffer;
    }
}
