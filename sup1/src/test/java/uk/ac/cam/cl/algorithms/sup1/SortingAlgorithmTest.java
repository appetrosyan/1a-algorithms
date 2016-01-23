package uk.ac.cam.cl.algorithms.sup1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by oliverchick on 24/12/2015.
 */
@RunWith(Parameterized.class)
public class SortingAlgorithmTest extends junit.framework.TestCase {

    SortingAlgorithm sortingAlgorithm;

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        ArrayList<Integer> outputList = new ArrayList<Integer>(sortingAlgorithm.sort(inputList));

        assertEquals(inputList.isEmpty(), true);
        assertEquals(outputList.isEmpty(), false);
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        inputList.add(14);
        ArrayList<Integer> outputList = new ArrayList<Integer>(sortingAlgorithm.sort(inputList));

        assertEquals(inputList.size(), 1);
        assertEquals(outputList.size(), 1);
        assertEquals(inputList.get(0), outputList.get(0));
    }

    @Test
    public void testSortingAnUnSortedListReturnsASortedList() {
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        inputList.add(3);
        inputList.add(17);
        inputList.add(8);
        inputList.add(-2);
        ArrayList<Integer> outputList = new ArrayList<Integer>(sortingAlgorithm.sort(inputList));
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        sortedList.add(-2);
        sortedList.add(3);
        sortedList.add(8);
        sortedList.add(17);

        for (int i = 0; i < inputList.size(); i++){
            assertEquals(outputList.get(i), sortedList.get(i));
        }
    }

    // TODO: What else do we need to test?

    public SortingAlgorithmTest(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @Parameterized.Parameters
    public static Collection<SortingAlgorithm[]> instancesToTest() {

        return Arrays.asList(
                new SortingAlgorithm[]{new BubbleSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()},
                new SortingAlgorithm[]{new MergeSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()}
        );
    }

}