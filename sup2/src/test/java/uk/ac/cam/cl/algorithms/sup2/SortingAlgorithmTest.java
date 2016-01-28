package uk.ac.cam.cl.algorithms.sup2;

import org.junit.Test;
import org.junit.runners.Parameterized;
import uk.ac.cam.cl.algorithms.sup1.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SortingAlgorithmTest extends junit.framework.TestCase {
    /**
     * Test clas to implement the unit Tests.
     * collection
     * created by oc243. modified by ap886 on Jan 28 2016
     */

    private SortingAlgorithm sortingAlgorithm;

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        ArrayList<Integer> input1 = new ArrayList<Integer>();
        ArrayList<Integer> input2 = null;

        assertEquals(input1, sortingAlgorithm.sort(input1));
        assertEquals(input2, sortingAlgorithm.sort(input2));
    }


    @Test
    public void testSortingAOneElementListReturnsCopyOfTheOriginalList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        java.util.Random randomGenerator = new java.util.Random();
        list1.add(new Integer(randomGenerator.nextInt()));
        ArrayList<Integer> list2 = new ArrayList<Integer>(sortingAlgorithm.sort(list1));
        assertEquals(list1, list2);
    }

    @Test
    public void testSortingAListReturrnsSortedList() {
        List<Integer> input = new ArrayList<Integer>();
        java.util.Random rGen = new java.util.Random();
        int howMany = rGen.nextInt();
        for (int j = 0; j < howMany; j++) {
            input.add(rGen.nextInt());
        }
        HeapSort<Integer> hs = new HeapSort<Integer>();
        List<Integer> output = hs.sort(input);

        assertEquals(isSorted(output), true);


    }


    public SortingAlgorithmTest(SortingAlgorithm newSortingAlgorithm) {
        sortingAlgorithm = newSortingAlgorithm;
    }

    private boolean isSorted(List<? extends Comparable> input) {
        return isSortedAscending(input) || isSortedDescending(input);
    }

    private boolean isSortedDescending(List<? extends Comparable> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).compareTo(input.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;

    }

    private boolean isSortedAscending(List<? extends Comparable> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).compareTo(input.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    @Parameterized.Parameters
    public static Collection<SortingAlgorithm[]> instancesToTest() {

        return Arrays.asList(
                new SortingAlgorithm[]{new BubbleSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()},
                new SortingAlgorithm[]{new MergeSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()},
                new SortingAlgorithm[]{new InsertionSort<Integer>()},
                new SortingAlgorithm[]{new HeapSort<Integer>()}
        );

        // TODO: What else do we need to test?
    }

}
