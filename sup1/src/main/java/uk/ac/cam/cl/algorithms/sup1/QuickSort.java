package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;
import java.util.Collections;

/**
 * Created by oliverchick on 24/12/2015.
 *
 * Modified by ap886 on Thursday 21/1/2016.
 */
public class QuickSort<T extends Comparable<? super T>> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> arg) {
        quickSort(arg, 0, arg.size());
        return arg;
    }

    /**
     * PErforms Quicksort on the given list in place, between indices s and e
     * @param list
     * @param start
     * @param end
     */
    private void quickSort (List<T> list, int start, int end){
        if(end-start<=1 || end>list.size()){
            return;
        }
        else{
            int pivotIndex = partition (list,start,end);
            quickSort(list,start,pivotIndex);
            quickSort(list,pivotIndex+1,end);
        }
    }

    /**
     * partitions the input list into section all smaller han the pivot, the pivot itself, and the
     * section greater than the pivot. This opertaion is done on a segment of the list between start and end.
     * @param input
     * @param start
     * @param end
     * @return Index of the pivot element.
     */
    private int partition(List<T> input, int start, int end){
        T pivotElement = input.get(end-1);
        int pivotIndex = start;

        for(int i=start; i <end -1;i++){
            if(pivotElement.compareTo(input.get(i))>=0){
                Collections.swap(input,pivotIndex,i);
                pivotIndex++;
            }
        }

        Collections.swap(input,pivotIndex, end-1);
        return pivotIndex;

    }


}