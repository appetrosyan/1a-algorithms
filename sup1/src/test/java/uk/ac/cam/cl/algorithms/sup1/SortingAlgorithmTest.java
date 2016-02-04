package uk.ac.cam.cl.algorithms.sup1;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.Test;

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
        // An example assertion. This will obviously break.
        // Replace is with a proper test!
        assertEquals(true, false);
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        // TODO: Fill this in
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