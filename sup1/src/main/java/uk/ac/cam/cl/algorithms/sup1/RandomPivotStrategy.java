package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;
import java.util.Random;

/**
 * A strategy for choosing a pivot for QuickSort where we always choose a random
 * element in the list which is being currently sorted.
 *
 * @author Henry Thompson
 * @since 23/01/2016
 * @param <T> The type of the elements in the list being sorted
 */
public class RandomPivotStrategy<T> implements IQuickSortPartitionStrategy<T> {
    private static final Random mRandomNumberGenerator = new Random();

    @Override
    public int pivot(List elements, int begin, int end) {
        return begin + mRandomNumberGenerator.nextInt(end - begin);
    }
}
