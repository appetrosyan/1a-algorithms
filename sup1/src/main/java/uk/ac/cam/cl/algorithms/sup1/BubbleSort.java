package uk.ac.cam.cl.algorithms.sup1;

import java.util.*;

/**
 * Created by oliverchick on 24/12/2015.
 *
 * Modified by ap886 on Thursday 21/1/2016.
 */
public class BubbleSort<T extends Comparable<? super T>> implements SortingAlgorithm<T> {

    /*
     * Implement bubble sort here
     */
    public List<T> sort(List<T> arg) {
        int length=arg.size();
        if(length<=1) {
            return arg;
            //Sorting an empty list is an empty list
        } else {
            ArrayList <T> result = new ArrayList<>(arg.size());
            for(T element :arg) {
                result.add(element);
            }//create local copy so as to sort non-destructively;

            T buffer;
            boolean swapped=false;

            while(!swapped && length > 0) {
                for(int i=1; i < length; i++) {
                    if(result.get(i-1).compareTo(result.get(i)) > 0) {
                        //if(result.get(i-1)>result.get(i)) {
                        //swap (result[i],result[i-1]);
                        buffer=result.get(i);
                        result.set(i, result.get(i-1));
                        result.set(i-1, buffer);
                        swapped=true;
                    }
                }
                length--;
            }
            return result;
        }

    }

}
