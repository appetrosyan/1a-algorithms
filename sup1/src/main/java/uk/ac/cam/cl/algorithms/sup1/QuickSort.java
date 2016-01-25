package uk.ac.cam.cl.algorithms.sup1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 * Modified by Henry Thompson on 22/01/2016
 */
public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {
    private final IQuickSortPartitionStrategy<T> mPivotStrategy;

    public QuickSort(IQuickSortPartitionStrategy<T> pivotStrategy) {
        mPivotStrategy = pivotStrategy;
    }

    /**
     * Sorts the provided list using the QuickSort algorithm.
     * @param input The list of data to be sorted.
     * @return A new instance of List containing the elements in {@param input} sorted from smallest to largest.
     */
    public List<T> sort(List<T> input) {
        List<T> result = new ArrayList<T>(input);
        quicksort(result, 0, input.size() - 1);
        return result;
    }

    /**
     * Runs the QuickSort algorithm on the elements in a sublist of the list provided between the begin and
     * end indices, inclusive.
     * @param elements The list of elements to be sorted.
     * @param begin The index of the first element in the list which should be sorted, inclusive.
     * @param end The index of the last element in the list which should be sorted, inclusive.
     */
    private void quicksort(List<T> elements, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(elements, begin, end);
            quicksort(elements, begin, pivotIndex - 1);
            quicksort(elements, pivotIndex + 1, end);
        }
    }

    /**
     * Takes the elements in the sublist of the list provided between the begin and end indices, inclusive,
     * and splits it into two regions separated by a pivot element. The elements from index {@code begin}
     * inclusive to the end the index of the pivot exclusive are less than the value of the pivot. The
     * elements from the index of the pivot inclusive to {@code end} inclusive are of value greater than
     * or equal to the pivot.
     * @param elements The list of elements to be partitioned.
     * @param begin The index of the first element in the list which should be partitioned.
     * @param end The index of the last element in the list which should be partitioned.
     * @return The index of the pivot element. All elements from {@code begin} inclusive to this pivot
     * element exclusive are less than the pivot element; all elements from this pivot element inclusive
     * to {@code end} exclusive are greater than or equal to the pivot element.
     */
    private int partition(List<T> elements, int begin, int end) {
        int pivotIndex = mPivotStrategy.pivot(elements, begin, end);
        Collections.swap(elements, pivotIndex, end);
        T pivot = elements.get(end);

        // High and low are indices which point to the position before and after an element respectively - they
        // are not the indices of the elements themselves
        int low = begin;
        int high = end;

        while (true) {
            while (elements.get(low).compareTo(pivot) < 0) {
                if (low > high) {
                    break;
                }

                low++;
            }

            while (high > 0 && elements.get(high - 1).compareTo(pivot) >= 0) {
                if (high < low) {
                    break;
                }

                high--;
            }

            if (low < high) {
                Collections.swap(elements, low, high - 1);
                low++;
                high--;
            } else {
                // Return the pivot to its correct position
                Collections.swap(elements, low, end);
                return low;
            }
        }
    }
}
