package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
        final List<T> list = new ArrayList<T>(input);
        while (true) {
            int swaps = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                // Compare the ith and (i+1)th elements
                T currentElement = list.get(i);
                T nextElement = list.get(i + 1);

                if (currentElement.compareTo(nextElement) > 0) {
                    // currentElement comes after nextElement, so swap them
                    list.set(i, nextElement);
                    list.set(i+1, currentElement);
                    swaps++;
                }
            }
            if (swaps == 0) {
                break;
            }
        }
        return list;
    }
}
