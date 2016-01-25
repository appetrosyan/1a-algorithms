package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

/**
 * A strategy for choosing a pivot for QuickSort where we always choose the last
 * element in the list which is being currently sorted.
 *
 * @author Henry Thompson
 * @since 23/01/2016
 * @param <T> The type of the elements in the list being sorted
 */
public class LastElementPivotStrategy<T> implements IQuickSortPartitionStrategy<T> {
    @Override
    public int pivot(List elements, int begin, int end) {
        return end - 1;
    }
}
