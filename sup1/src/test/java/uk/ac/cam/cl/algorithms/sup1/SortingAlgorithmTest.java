package uk.ac.cam.cl.algorithms.sup1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

/**
 * Created by oliverchick on 24/12/2015.
 */
@RunWith(Parameterized.class)
public class SortingAlgorithmTest extends junit.framework.TestCase {

    private SortingAlgorithm<Integer> sortingAlgorithm;
    private static final Integer numElements = 20; // Number of elements to use for tests of n elements

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        assertEquals(Collections.emptyList(), sortingAlgorithm.sort(Collections.emptyList()));
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        Integer a = 1;
        List<Integer> oneElementList = Collections.singletonList(a);
        assertEquals(oneElementList, sortingAlgorithm.sort(oneElementList));
    }

    private List<Integer> nRandomElementListWithDuplicates() {
        ArrayList<Integer> nElementList = new ArrayList<>(numElements);
        Random random = new Random();
        for (int i=0; i<numElements; i++) {
            Integer randNumber = random.nextInt(numElements); // Using numElements gives us a spread of numbers
            nElementList.add(randNumber);
            if (i == numElements/2 || i == numElements-2) {
                nElementList.add(randNumber); // Add duplicates deterministically because we definitely want duplicates
                i++;
            }
        }
        return nElementList;
    }

    // Easiest just to check Collections.sort works but I'm assuming we don't have access to any sorting algorithms
    @Test
    public void testSortingAListOfNElementsReturnsASortedList() {
        List<Integer> nElementList = nRandomElementListWithDuplicates();
        List<Integer> sortedList = sortingAlgorithm.sort(nElementList);

        // O(n): compare pairwise elements of the array and if we don't have any swaps then the array is sorted.
        for (int i=0; i<sortedList.size() - 1; i++) {
            if (sortedList.get(i).compareTo(sortedList.get(i+1)) > 0) {
                fail(String.format("Elements %d and %d out of order", i, i+1));
            }
        }
    }

    private static <T> HashMap<T, Integer> countPerElementMap(List<T> list) {
        HashMap<T, Integer> countPerElement = new HashMap<>();

        for (T a : list) {
            if (countPerElement.containsKey(a)) {
                countPerElement.replace(a, countPerElement.get(a) + 1);
            } else {
                countPerElement.put(a, 1);
            }
        }

        return countPerElement;
    }

    @Test
    public void testSortingAListOfNElementsReturnsAListWithAPermutationOfTheOriginalElements() {
        List<Integer> nElementList = nRandomElementListWithDuplicates();
        List<Integer> sortedList = sortingAlgorithm.sort(nElementList);

        System.out.println(nElementList);
        System.out.println(sortedList);

        assertEquals(countPerElementMap(nElementList), countPerElementMap(sortedList));
    }

    public SortingAlgorithmTest(SortingAlgorithm<Integer> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    @Parameterized.Parameters
    public static Collection<SortingAlgorithm<Integer>[]> instancesToTest() {

        return Arrays.asList(
                new SortingAlgorithm[]{new BubbleSort<Integer>()},
                new SortingAlgorithm[]{new QuickSort<Integer>()},
                new SortingAlgorithm[]{new MergeSort<Integer>()},
                new SortingAlgorithm[]{new InsertionSort<Integer>()}
        );
    }

}