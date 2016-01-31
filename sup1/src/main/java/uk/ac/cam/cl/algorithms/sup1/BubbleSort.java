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
            //Sorting a list of just one element (or an empty list is the list itself
        } else {
            boolean haveSwapped=false;
            while(length > 0) {
                for(int i=1; i < length; i++) {
                    if(arg.get(i-1).compareTo(arg.get(i)) > 0) {
                        Collections.swap(arg,i-1,i);
                        haveSwapped = true;
                    }
                }
                if(!haveSwapped){
                    return arg;
                }else {
                    length--;
                }
            }
        }
        return arg;

    }


}
