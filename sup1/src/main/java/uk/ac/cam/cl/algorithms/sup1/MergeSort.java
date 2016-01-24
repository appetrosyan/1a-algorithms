package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
        if (input.size() < 2) {
            // Already sorted
            return input;
        }
        int middle = input.size()/2;
        List<T> left = sort(input.subList(0, middle));
        List<T> right = sort(input.subList(middle, input.size()));

        List<T> mergedArray = new ArrayList<T>(input.size());
        int iLeft = 0;
        int iRight = 0;
        while (iLeft < left.size() || iRight < right.size()) {
            if (iLeft == left.size()) {
                mergedArray.add(right.get(iRight));
                iRight++;
            } else if (iRight == right.size()) {
                mergedArray.add(left.get(iLeft));
                iLeft++;
            } else {
                if (left.get(iLeft).compareTo(right.get(iRight)) <= 0) {
                    mergedArray.add(left.get(iLeft));
                    iLeft++;
                } else {
                    mergedArray.add(right.get(iRight));
                    iRight++;
                }
            }
        }
        return mergedArray;
    }
}
