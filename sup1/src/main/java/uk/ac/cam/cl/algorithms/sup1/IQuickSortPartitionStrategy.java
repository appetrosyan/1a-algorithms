package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

/**
 * A strategy for choosing a pivot for QuickSort, given the list which is
 * being currently sorted.
 *
 * @author Henry Thompson
 * @since 23/01/2016
 * @param <T> The type of the elements in the list being sorted
 */
public interface IQuickSortPartitionStrategy<T> {
    /**
     * Generates an index for the element to be used as a pivot.
     * @param elements The list being sorted.
     * @param begin The index of the first element in the list to be considered to be made a pivot.
     * @param end The index of the last element in the list to be considered to be made a pivot.
     * @return The index for the element to be used as a pivot.
     */
    int pivot(List<T> elements, int begin, int end);
}
