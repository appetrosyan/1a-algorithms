package uk.ac.cam.cl.algorithms.sup1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
/**
 * Created by oliverchick on 24/12/2015.
 *
 * Modified by ap886 on Feb 5 2016,
 *
 * Credits to Henry Thompson for general Recommendations on design.
 */
@RunWith(Parameterized.class)
public class SortingAlgorithmTest extends junit.framework.TestCase {
    private final SortingAlgorithm<Integer> sorter;
    private final IntegerListGenerator generator= new IntegerListGenerator();

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        List<Integer> input = new ArrayList<>();
        List<Integer> output = sorter.sort(input);
        assertEquals(0, output.size());
        output = sorter.sort(null);
        assertEquals(output, null);
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        List<Integer> input = new ArrayList<>();
        input.add(7);
        List<Integer> output = sorter.sort(input);
        assertEquals(input, output);
    }

    @Test
    public void testSortingAListSortsItsElements() {
        for (int i = 0; i < 8; i++) {
            List<Integer> input = generator.generateDisordered(i);
        List<Integer> output = sorter.sort(input);
        assertEquals(true, isSorted(output));
        }

    }

    @Test
    public void testSortingReturnsANewInstanceOfList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> output = sorter.sort(list);

        assertNotSame(output, list);
    }

    @Test
    public void testSortingDoesNotAlterOriginalList() {
        for (int i = 0; i < 8; i++) {
        List<Integer> list = generator.generateDisordered(i);
        sorter.sort(list);

        assertEquals(true, isSorted(list));
        }

    }

    public SortingAlgorithmTest(SortingAlgorithm arg) {
        sorter = arg;
    }

    private boolean isSorted(List<? extends Comparable> input) {
        return isSortedAscending(input) || isSortedDescending(input);
    }

    private boolean isSortedDescending(List<? extends Comparable> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).compareTo(input.get(i + 1)) > 0) return false;
        }
        return true;

    }

    private boolean isSortedAscending(List<? extends Comparable> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).compareTo(input.get(i + 1)) < 0) return false;
        }
        return true;
    }


    @Parameterized.Parameters
    public static Collection<SortingAlgorithm[]> instancesToTest() {

        return Arrays.asList(
                new SortingAlgorithm[]{new BubbleSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()},
                new SortingAlgorithm[]{new InsertionSort<Integer>()},
                new SortingAlgorithm[]{new MergeSort<Integer>()}
        );
    }
}
