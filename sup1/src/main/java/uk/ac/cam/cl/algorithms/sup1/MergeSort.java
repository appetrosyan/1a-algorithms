package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 * Modified by Henry Thompson on 23/01/2016
 */
public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {

    /**
     * Sorts the provided list using the MergeSort algorithm.
     * @param input The list of data to be sorted.
     * @return A new instance of List containing the elements in {@param input} sorted from smallest to largest.
     */
    public List<T> sort(List<T> input) {
        return mergesort(input);
    }

    /**
     * Performs the MergeSort algorithm on the provided list. The list provided is left
     * unaltered; instead, a new instance of List is returned.
     * @param list The list to be sorted
     * @return A list containing all the elements provided in parameter {@code list}, but in sorted order.
     */
    private List<T> mergesort(List<T> list) {
        if (list.size() <= 1) {
            return new ArrayList<T>(list);

        } else {
            int middle = list.size() / 2;
            List<T> left = mergesort(list.subList(0, middle));
            List<T> right = mergesort(list.subList(middle, list.size()));

            return merge(left, right);
        }
    }

    /**
     * Generates a new list which is the ordered merging of the to lists provided
     * @param a One of the lists to be merged. This list must be in sorted order.
     * @param b The other list to be merged. This list must be in sorted order.
     * @return The ordered list containing all the elements in lists a and b. a and b
     * are not altered by calling this method.
     */
    private List<T> merge(List<T> a, List<T> b) {
        List<T> result = new ArrayList<T>();

        int aLen = a.size(), bLen = b.size();
        int len = aLen + bLen;
        int aIndex = 0, bIndex = 0;

        // The loop below would be made much simpler if I used List.remove(int index) but I felt that
        // the method shouldn't alter the contents of left and right

        while (aIndex + bIndex < len) {
            if (aIndex >= aLen) {
                result.addAll(b.subList(bIndex, b.size()));
                break;
            }

            if (bIndex >= bLen) {
                result.addAll(a.subList(aIndex, a.size()));
                break;
            }

            if (a.get(aIndex).compareTo(b.get(bIndex)) <= 0) {
                result.add(a.get(aIndex++));
            } else {
                result.add(b.get(bIndex++));
            }
        }

        return result;
    }
}
