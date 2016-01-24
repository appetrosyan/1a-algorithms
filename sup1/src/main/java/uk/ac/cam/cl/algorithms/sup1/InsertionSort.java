package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
        final List<T> list = new ArrayList<T>(input);

        for (int i=1; i < list.size(); i++) {
            // Assume we've sorted the array up to some index i
            // Put list[i] in the right place within list[0:i]

            T elem = list.get(i);
            // Make j the index before the first index such that list[j] > list[i]
            // (if we put our element to the right of equal elements then we need to do less shifting)
            int j = i;
            while (j != 0 && list.get(j-1).compareTo(elem) > 0) {
                j--;
            }

            // Make space for i by moving everything j<=index<i up by 1
            for (int k=i; k>j; k--) {
                list.set(k, list.get(k-1));
            }
            list.set(j, elem);
        }

        return list;
    }
}
