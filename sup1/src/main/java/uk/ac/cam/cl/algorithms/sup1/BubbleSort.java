package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 * Modified by Henry Thompson on 21/01/2016
 */
public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {

    /**
     * Sorts the provided list using the BubbleSort algorithm.
     * @param input The list of data to be sorted.
     * @return A new instance of List containing the elements in {@param input} sorted from smallest to largest.
     */
    public List<T> sort(List<T> input) {
        final List<T> result = new ArrayList<T>(input);
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 1; i < input.size(); i++) {
                if (result.get(i - 1).compareTo(result.get(i)) > 0) {
                    sorted = false;
                    Collections.swap(result, i - 1, i);
                }
            }
        }

        return result;
    }
}
