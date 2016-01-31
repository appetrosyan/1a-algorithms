package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 * completed by Daniel Ellis
 */
public class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {

    /*
     * Insertion sort implementation
     */
    public List<T> sort(List<T> input) {
        if (input.size() <= 1) {
            return input;
        }

        for (int unsorted = 1; unsorted < input.size(); unsorted ++) {
            for (int j = 0; j < unsorted; j++) {
                if (input.get(unsorted).compareTo(input.get(j)) < 0) {
                    T temp = input.get(unsorted);
                    for (int k = j; k < unsorted; k++) {
                        input.set(k+1,input.get(k));
                    }
                    input.set(j, temp);
                    break;
                }
            }
        }
        return input;
    }
}
