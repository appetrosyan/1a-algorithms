package uk.ac.cam.cl.algorithms.sup1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

/**
 * Created by oliverchick on 24/12/2015.
 * Modified by Henry Thompson on 22/01/2016
 */
@RunWith(Parameterized.class)
public class SortingAlgorithmTest extends junit.framework.TestCase {
    private final SortingAlgorithm<Integer> mSortingAlgorithm;

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        List<Integer> empty = new ArrayList<Integer>();
        List<Integer> output = mSortingAlgorithm.sort(empty);
        assertEquals(0, output.size());
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        List<Integer> single = new ArrayList<Integer>();
        single.add(3);

        List<Integer> output = mSortingAlgorithm.sort(single);

        assertEquals(single, output);
    }

    @Test
    public void testSortingAListSortsItsElements() {
        List<Integer> list = unsortedList();
        List<Integer> output = mSortingAlgorithm.sort(list);

        Assert.assertArrayEquals(sortedList().toArray(), output.toArray());
    }

    @Test
    public void testSortingReturnsANewInstanceOfList() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> output = mSortingAlgorithm.sort(list);

        assertNotSame(output, list);
    }

    @Test
    public void testSortingDoesNotAlterOriginalList() {
        List<Integer> list = unsortedList();
        mSortingAlgorithm.sort(list);

        assertEquals(unsortedList(), list);
    }

    public SortingAlgorithmTest(SortingAlgorithm sortingAlgorithm) {
        mSortingAlgorithm = sortingAlgorithm;
    }

    private List<Integer> sortedList() {
        List<Integer> list = new ArrayList<Integer>();

        list.add(-20);
        list.add(0);
        list.add(0);
        list.add(345);

        return list;
    }

    private List<Integer> unsortedList() {
        List<Integer> list = new ArrayList<Integer>();

        list.add(0);
        list.add(345);
        list.add(0);
        list.add(-20);

        return list;
    }

    @Parameterized.Parameters
    public static Collection<SortingAlgorithm[]> instancesToTest() {

        return Arrays.asList(
                new SortingAlgorithm[]{new QuickSort<Integer>(new RandomPivotStrategy<Integer>())},
                new SortingAlgorithm[]{new QuickSort<Integer>(new MiddleElementPivotStrategy<Integer>())},
                new SortingAlgorithm[]{new QuickSort<Integer>(new LastElementPivotStrategy<Integer>())},
                new SortingAlgorithm[]{new BubbleSort<Integer>()},
                new SortingAlgorithm[]{new InsertionSort<Integer>()},
                new SortingAlgorithm[]{new MergeSort<Integer>()}
        );
    }
}