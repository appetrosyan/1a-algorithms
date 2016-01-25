package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 * Modified by Henry Thompson on 23/01/2016
 */
public class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {

    /**
     * Sorts the provided list using the InsertionSort algorithm.
     * @param input The list of data to be sorted.
     * @return A new instance of List containing the elements in {@param input} sorted from smallest to largest.
     */
    public List<T> sort(List<T> input) {
        List<T> result = new ArrayList<T>(input);

        for (int i = 1; i < result.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (result.get(j - 1).compareTo(result.get(j)) <= 0) {
                    break;
                }

                Collections.swap(result, j - 1, j);
            }
        }

        return result;
    }
}
