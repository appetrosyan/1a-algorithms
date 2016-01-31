package uk.ac.cam.cl.algorithms.sup1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 * completed by Daniel Ellis
 */
@RunWith(Parameterized.class)
public class SortingAlgorithmTest extends junit.framework.TestCase {

    SortingAlgorithm sortingAlgorithm;

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>(sortingAlgorithm.sort(list1));

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(new Integer(5));
        ArrayList<Integer> list2 = new ArrayList<Integer>(sortingAlgorithm.sort(list1));

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSortingATwoElementListReturnsASortedList1() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            list1.add(new Integer(i));
        }

        Integer[] list2Vals = new Integer[] {0,1};
        List list2 =  Arrays.asList(list2Vals);

        list2 = new ArrayList<Integer>(sortingAlgorithm.sort(list2));

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSortingATwoElementListReturnsASortedList2() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            list1.add(new Integer(i));
        }

        Integer[] list2Vals = new Integer[] {1,0};
        List list2 =  Arrays.asList(list2Vals);

        list2 = new ArrayList<Integer>(sortingAlgorithm.sort(list2));

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSortingATenElementListReturnsASortedList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list1.add(new Integer(i)); 
        }

        Integer[] list2Vals = new Integer[] {9, 1, 2, 5, 4, 3, 6, 0, 8, 7};
        List list2 =  Arrays.asList(list2Vals);

        list2 = new ArrayList<Integer>(sortingAlgorithm.sort(list2));

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSortingATenElementListReturnsASortedList2() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list1.add(new Integer(i));
        }

        Integer[] list2Vals = new Integer[] {9,8,7,6,5,4,3,2,1,0};
        List list2 =  Arrays.asList(list2Vals);

        list2 = new ArrayList<Integer>(sortingAlgorithm.sort(list2));

        assertTrue(list1.equals(list2));
    }

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