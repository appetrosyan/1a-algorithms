package uk.ac.cam.cl.algorithms.sup1;

/**
 * Created by Henry on 19/01/2016.
 */
public class ComparisonFunctions {

    public static <T extends Comparable> T medianOfThree(T a, T b, T c) {
        if (a.compareTo(b) <= 0) {
            // a <= b
            if (b.compareTo(c) <= 0) {
                // a <= b <= c
                return b;
            } else {
                // a <= c <= b
                return c;
            }
        } else {
            // b <= a
            if (a.compareTo(c) <= 0) {
                // b <= a <= c
                return a;
            } else {
                // b <= c <= a
                return c;
            }
        }
    }
}
