package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class BubbleSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
    /*
    BEHAVIOUR: Run the bubble sort on the T List input, sorting it in place

    PRECONDITION: List contains size T values

    POSTCONDITION: List contains the same values as before sorted in ascending
    order according to comparable
    */
        if (input.size() == 0) return input;
        boolean didSomeSwapsInThisPass = true;
        while(didSomeSwapsInThisPass){
            didSomeSwapsInThisPass = false;
            for (int k = 0; k < input.size()- 1; k++){
                if (input.get(k).compareTo(input.get(k+1))> 0){
                    swap(input.get(k), k, input.get(k+1), k+1, input);
                    didSomeSwapsInThisPass = true;
                }
            }
        }
        return input;
    }
    private void swap(T a, int i, T b, int j,List<T> data){
        data.add(i,b);
        data.remove(i+1);
        data.add(j,a);
        data.remove(j+1);
    }
}
