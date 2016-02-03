package uk.ac.cam.cl.algorithms.sup3;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

/**
 * Created by oliverchick on 2016-02-01.
 *
 * Modified by Aleksadnr Petrosyan on Feb 3 2016
 */
public class StringCompression {

    /**
     * @param arg a string of letters [a-zA-Z], such as abbbccccd
     * @return a string where repeated letters are replaced with the letter once
     * and then the number of repeats. eg ab3c4d.
     */
    public static String compress(String arg) {
        char[] input = arg.trim().toCharArray();
        String result = "";
        Character buffer = null;
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == buffer.charValue()) {
                counter++;
            } else {
                result = result + buffer + (counter == 0 ? counter : "");
                counter = 0;
                buffer = input[i];
            }
        }
        return result;
    }

    /**
     * Is thrown in case the COmpose function is not supplied with a valid pair of lists of
     * Strings and repeats.
      */
    public static class InsufficientRepeatsException extends Exception {
        public InsufficientRepeatsException() {
            super("Too few repeats found");
        }
    }

    /**
     *
     * @param input String of form letter then number of repetitions and so on. No
     *              number given is assumed 1, for example
     *              a3b44c77d35e
     * @return      The string decompressed from arithemtic coding
     * @throws InsufficientRepeatsException if the string is formatted improperly,
     */
    public static String decompress(String input) throws InsufficientRepeatsException {
        Pattern p = Pattern.compile("(\\d+)|([a-zA-Z]+)");
        Matcher m = p.matcher(input);
        ArrayList<String> tokens = new ArrayList<String>();
        ArrayList<Integer> repeats = new ArrayList<Integer>();
        while (m.find()) {
            String token = m.group(2); // match Alphabetics
            if (token != null) {
                tokens.add(token);
            }
            token = m.group(1);//match numbers
            if (token != null) {
                repeats.add(Integer.parseInt(token));
            }
        }
        return compose(tokens, repeats);
    }


    /**
     * @param strings strings last char of which is followed by a numeric
     * @param repeats how many time sthe last character of thhe i-th element of strings
     *                needs to be repeated.
     * @return returns the single string decoded in accordance to the given
     * @throws InsufficientRepeatsException if the repeats is more than one element
     *                                      shorter than strings
     */
    private static final String compose(List<String> strings, List<Integer> repeats) throws InsufficientRepeatsException {
        String result = "";
        String current; //Fore readability
        for (int i = 0; i < repeats.size() - 1; i++) {
            current = strings.get(i);
            result = result + current +
                    repeat(current.charAt(current.length()), repeats.get(i));
        }
        if (strings.size() == repeats.size()) {
            return result;
        } else if (strings.size() == repeats.size() - 1) {
            return result + strings.get(strings.size());
        } else {
            throw new InsufficientRepeatsException();
        }
    }


    /**
     * @param character what character to repeat.
     * @param times     how many times.
     * @return
     */
    private static final String repeat(char character, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result = result + character;
        }
        return result;
    }
}
