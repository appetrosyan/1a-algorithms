package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by oliverchick on 24/12/2015.
 * completed by Daniel Ellis
 */
public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {

    /*
     * Bubble sort implementation
     */
    public List<T> sort(List<T> input) {
        boolean swaps = true;
        for (int i = 0; i < input.size() - 1; i++) {
            swaps = false;
            for (int j = 0; j < input.size() - 1; j++) {
                if (input.get(j).compareTo(input.get(j+1)) > 0) {
                    swaps = true;
                    T temp = input.get(j);
                    input.set(j,input.get(j+1));
                    input.set(j+1,temp);
                }
            }
            if (!swaps) {
                return input;
            }
        }
        return input;
    }
}
