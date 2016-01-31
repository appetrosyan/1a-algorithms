package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by oliverchick on 24/12/2015.
 * completed by Daniel Ellis
 */
public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
         return mergeSort(input, 0, input.size()-1);
        }

    private List<T> mergeSort(List<T> input, int start, int end) {
        if (end - start < 1) {
            return input;
        } else {
            int mid = (end + start)/2;
            input = mergeSort(input, start, mid);
            input = mergeSort(input, mid + 1, end);
            return merge(input, start, mid, mid+1, end);
        }
    }

    private List<T> merge (List<T> input, int start1, int end1, int start2, int end2) {
        while (start1 <= end1 && start2 <= end2) {
            if (input.get(start1).compareTo(input.get(start2)) > 0) {
                T temp = input.get(start2);
                for (int i = start2; i > start1; i--) {
                    input.set(i, input.get(i-1));
                }
                input.set(start1, temp);
                start1 ++;
                end1 ++;
                start2 ++;
            } else {
                start1 ++;
            }
        }
        return input;
    }
}
