package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
    /*
    BEHAVIOUR: Run the insort algorithm on the T list input, sorting it in place

    PRECONDITION: Input list contains size() T values

    POSTCONDITION: List contains the same values as before sorted in ascending
    order according to comparable
     */
        if (input.isEmpty()) return input;
        for (int i = 1; i < input.size(); i++){
            //ASSERT: The first i positions are already sorted

            //Insert input.get(i) where it belongs
            int j = i-1;
            while (j > 0 | input.get(j).compareTo(input.get(j+1)) < 0){
                swap(input.get(j), j, input.get(j+1),j+1, input);
                j = j-1;
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
