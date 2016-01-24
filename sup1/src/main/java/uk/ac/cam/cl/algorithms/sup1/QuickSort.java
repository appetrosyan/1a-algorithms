package uk.ac.cam.cl.algorithms.sup1;

import java.util.*;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {

    private static final int minSizeToUseMedianOfThreeRule = 50;

    private T pivot(List<T> input, int start, int end) {
        // Selects the pivot, moves it to the end of the array, and returns it
        if (end - start > minSizeToUseMedianOfThreeRule) {
            // Use the "median-of-three" rule to select the pivot: take the median of the
            // first, middle, and last elements of the array
            int middle = Math.floorDiv(end - start, 2);
            T firstElem = input.get(start);
            T middleElem = input.get(middle);
            T lastElem = input.get(end - 1);

            T pivot = ComparisonFunctions.medianOfThree(firstElem, middleElem, lastElem);
            int index = end - 1;
            if (pivot.equals(firstElem)) {
                index = start;
            } else if (pivot.equals(middleElem)) {
                index = middle;
            }
            swap(input, index, end - 1);
            return pivot;
        } else {
            Random random = new Random(); // get a random element to avoid very bad performance for sorted lists
            int index = start + random.nextInt(end - start);
            swap(input, index, end - 1);
            return input.get(end - 1);
        }
    }

    private void swap(List<T> list, int i, int j) {
        // swaps elements at indices i and j
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int partition(List<T> list, int start, int end, T pivot) {
        // Partitions the list for indices i such that start <= i < end into n <= pivot, n > pivot,
        // and returns the index of the pivot

        // Strategy: pointers i and j.  i starts at i=start, j starts at j=end, and we maintain the invariants
        // everything left of i is <= pivot, everything right of j is > pivot
        // while i != j i moves right, j moves left.  when both pointers stopped and i != j we swap the elements i and j-1

        int i = start;
        int j = end;

        while (i != j) {
            while (i < j && list.get(i).compareTo(pivot) <= 0) {
                i++;
            }
            while (j > i && list.get(j - 1).compareTo(pivot) > 0) {
                j--;
            }
            if (i != j) {
                // Swap i and j-1
                swap(list, i, j - 1);
            }
        }

        return i;
    }

    private void sortHelper(List<T> list, int start, int end) {
        // Adopt same convention as before, we will sort start <= i < end
        if (end - start < 2) {
            // Data already sorted
            return;
        }

        T pivot = pivot(list, start, end); // This puts the pivot at the end too
        int i = partition(list, start, end-1, pivot);
        swap(list, i, end-1);

        // Now quicksort the two partitions
        sortHelper(list, start, i);
        sortHelper(list, i+1, end);

        List<T> sortedPart = list.subList(start, end);
    }

    public List<T> sort(List<T> input) {
        final List<T> list = new ArrayList<T>(input);
        sortHelper(list, 0, input.size());
        return list;
    }
}
