package uk.ac.cam.cl.algorithms.sup1;

import java.util.*;

/**
 * Created by oliverchick on 24/12/2015.
 *
 * Modified by ap886 on Thursday 21/1/2016.
 */
public class QuickSort<T extends Comparable<? super T>> implements SortingAlgorithm<T> {

    /*
     * Implement quick sort here
     */
    public List<T> sort(List<T> arg) {
        int length=arg.size();
        if(length <= 1) {
            return arg;
            //Sorting an empty list is an empty list,
            //a singleton sorts to a singleton.
        } else {

            return partition(arg);
        }
    }

    private List<T> partition (List<T> list){
        List<T> left= new java.util.ArrayList<>();
        List<T> right= new java.util.ArrayList<>();
        List <T> result;
        if(null == list || list.isEmpty()){
            return list;
        }
        int length = list.size();
        T pivot = list.get(length);
        for(int i=0; i < length-1; i++) {
            //Iterate through the whole list and partition elements accordingly;
            if(list.get(i).compareTo(pivot) <= 0) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }
        //Add pivot to the middle
        left.add(pivot);
        //sort left
        result = sort(left);
        //append sorted right
        result.addAll(sort(right));
        return result;


    }
}