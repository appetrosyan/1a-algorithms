package uk.ac.cam.cl.algorithms.sup1;


import java.util.List;
import java.util.ArrayList;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class MergeSort<T extends Comparable> implements SortingAlgorithm<T> {

    public List<T> sort(List<T> input) {
    /*
    BEHAVIOUR: Runs the merge sort algorithm on the T List input returning a
    sorted version as the result (NB. Not in place)

    PRECONDITION: Array contains size() T values

    POSTCONDITION: List contains the same values as before sorted in ascending
    order according to comparable
     */
        if (input.size() < 2) return input;
        else {
            int m = input.size() / 2;
            List<T> a1 = (List)new ArrayList<T>(m);
            for (int i = 0; i < m; i++){
                a1.add(input.get(i));
            }
            a1 = sort(a1);
            
            List<T> a2 = (List)new ArrayList<T>(input.size()-m);
            for (int i = m; i < input.size(); i++){
                a2.add(input.get(i));
            }
            a2 = sort(a2);

            List<T> a3 = new ArrayList<T>();
            while (a1.size() > 0 && a2.size() > 0) {
                if (a1.get(0).compareTo(a2.get(0)) < 0) {
                    a3.add(a1.get(0));
                    a1.remove(0);
                } else {
                    a3.add(a2.get(0));
                    a2.remove(0);
                }
            }
            if (a1.size() > 0) {
                a3.addAll(a1);
            }
            if (a2.size() > 0) {
                a3.addAll(a2);
            }
            return a3;
        }
    }
}
