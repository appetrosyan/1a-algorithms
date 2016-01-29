package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 */
public class QuickSort<T extends Comparable> implements SortingAlgorithm<T> {


    public List<T> sort(List<T> input) {
        if (input.size() == 0) return input;
        return quicksort(input, 0, input.size());
    }
    private List<T> quicksort(List<T> input, int iBegin, int iEnd){
        if (iBegin == iEnd) return input;
        else {
            T pivot = input.get(iEnd-1);
            int iLeft = iBegin;
            int iRight = iEnd -1;
            while(iLeft < iRight){
                if (input.get(iLeft).compareTo(pivot) < 0) iLeft++;
                else if (input.get(iRight-1).compareTo(pivot) > 0) iRight--;
                else {
                    swap(input.get(iLeft), iLeft, input.get(iRight-1), iRight-1, input);
                    iLeft++;
                    iRight--;
                }
            }
            swap(input.get(iLeft), iLeft, pivot, iEnd-1, input);
            input = quicksort(input, iBegin, iLeft);
            return quicksort(input, iRight+1, iEnd);
        }

    }

    private void swap(T a, int i, T b, int j,List<T> data){
        data.add(i,b);
        data.remove(i+1);
        data.add(j,a);
        data.remove(j+1);
    }
}
