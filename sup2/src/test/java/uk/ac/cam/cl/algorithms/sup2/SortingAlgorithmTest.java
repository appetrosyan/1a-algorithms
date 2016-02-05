package uk.ac.cam.cl.algorithms.sup2;

import uk.ac.cam.cl.algorithms.sup1.MergeSort;
import uk.ac.cam.cl.algorithms.sup1.SortingAlgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingAlgorithmTest extends junit.framework.TestCase {

    SortingAlgorithm heapSort = new HeapSort<Integer>();

    @Test
    public void testSortingAnEmptyListReturnsAnEmptyList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>(heapSort.sort(list1));

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSortingAOneElementListReturnsTheOriginalList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(new Integer(5));
        ArrayList<Integer> list2 = new ArrayList<Integer>(heapSort.sort(list1));

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

        list2 = new ArrayList<Integer>(heapSort.sort(list2));

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

        list2 = new ArrayList<Integer>(heapSort.sort(list2));

        assertTrue(list1.equals(list2));
    }

    @Test
    public void testSortingARandomListReturnsASortedList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            Random ran = new Random();
            int rand = ran.nextInt();
            list1.add(new Integer(rand));
            list2.add(new Integer(rand));
        }

        MergeSort<Integer> merge = new MergeSort<Integer>();
        list1 = new ArrayList<Integer>(merge.sort(list1));
        list2 = new ArrayList<Integer>(heapSort.sort(list2));

        assertTrue(list1.equals(list2));
    }

}
