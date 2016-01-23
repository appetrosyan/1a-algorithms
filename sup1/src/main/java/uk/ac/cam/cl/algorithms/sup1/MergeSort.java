package uk.ac.cam.cl.algorithms.sup1;

import java.util.*;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
    /*
    BEHAVIOUR: Runs the merge sort algorithm on the T List input returning a
    sorted version as the result (NB. Not in place)

    PRECONDITION: Array contains size() T values

    POSTCONDITION: List contains the same values as before sorted in ascending
    order according to comparable
     */
        if (input.isEmpty()) return input;
        if (input.size() < 2) return input;
        else {
            int m = input.size() / 2;
            List<T> a1 = sort(input.subList(0, m));
            List<T> a2 = sort(input.subList(m, input.size()));

            List<T> a3 = new ArrayList<T>();
            while (a1.size() > 0 & a2.size() > 0) {
                if (a1.get(0).compareTo(a2.get(0)) < 0) {
                    a3.add(a1.get(0));
                    a1.remove(0);
                } else {
                    a3.add(a2.get(0));
                    a2.remove(0);
                }
            }
            if (a1.size() > 0) {
                a3.addAll(a1);
            }
            if (a2.size() > 0) {
                a3.addAll(a2);
            }
            return a3;
        }
    }
}
