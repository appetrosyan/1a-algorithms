package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by oliverchick on 24/12/2015.
 * completed by Daniel Ellis
 */
public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {

     /*
     * sort copies the inputted list and calls quicksort on it
     */
    public List<T> sort(List<T> input) {
        quickSort(input, 0, input.size());
        return input;
    }

    /*
     * quicksort implementation, using only one array
     */
    private void quickSort(List<T> sortList, int iBegin, int iEnd) {
        if (iEnd - iBegin <= 1) {
            return;
        }
        T pivot = sortList.get(iEnd - 1);
        int leftPointer = iBegin;
        int rightPointer = iEnd - 1;

        while (leftPointer < rightPointer) {
            if (sortList.get(leftPointer).compareTo(pivot) > 0) {
                while (leftPointer < rightPointer) {
                    if (sortList.get(rightPointer - 1).compareTo(pivot) <= 0) {
                        T temp = sortList.get(leftPointer);
                        sortList.set(leftPointer, sortList.get(rightPointer - 1));
                        sortList.set(rightPointer - 1, temp);
                        rightPointer--;
                        break;
                    }
                    rightPointer--;
                }
            } else {
                leftPointer++;
            }
        }
        sortList.set(iEnd - 1, sortList.get(leftPointer));
        sortList.set(leftPointer, pivot);

        quickSort(sortList, iBegin, leftPointer);
        quickSort(sortList, leftPointer + 1, iEnd);
    }
}
