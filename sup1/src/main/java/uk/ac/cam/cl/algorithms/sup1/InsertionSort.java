package uk.ac.cam.cl.algorithms.sup1;

import java.util.*;
/**
 * Created by oliverchick on 24/12/2015.
 *
 * Modified by ap886 on Thursday 21/1/2016.
 */
public class InsertionSort<T extends Comparable<? super T>> implements SortingAlgorithm<T> {

    /*
     * Implement insertion sort here
     */
    public List<T> sort(List<T> arg) {
        int length=arg.size();
        if(length<=1) {
            return arg;
            //Sorting a list that contains fewer than two elements is the list itself.
        } else {
            int j;
            for(int i=1; i <length - 1; i++) {
                j=i;
                while(j>0 && arg.get(j-1).compareTo(arg.get(j))>0){
                    Collections.swap(arg,i-1,i);
                    j--;
                }
            }

            return arg;
        }

    }
}
