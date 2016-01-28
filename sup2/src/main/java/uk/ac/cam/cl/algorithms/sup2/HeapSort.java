package uk.ac.cam.cl.algorithms.sup2;

import uk.ac.cam.cl.algorithms.sup1.SortingAlgorithm;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class HeapSort<T extends Comparable<? super T>> implements SortingAlgorithm<T> {
    /**
     * Creates a copy of the original list and sorts it in n (Log n) time using Hcreates a max heap from the given array in place. From rootIndex to endIndex.
     * The 0-th element is the root of the binary tree.eapsort algorithm.
     *
     * @param input - the list to be sorted.
     * @return a sorted copy of the initial List.
     */
    public List<T> sort(List<T> input) {
        List<T> result = new ArrayList(input.size());
        result.addAll(input); //Make local copy
        int last = result.size();
        buildMaxHeap (result,last);
        if (input.isEmpty() || input.size() <= 1) {
            return result;
        } else {
            //buildMaxHeap(result,result.size());
            while (last > 0) {
                swap(result, 0, last-1);
                last--;
                maxHeapify(result,0, last);
            }
        }
        return result;
    }

    /** * swaps the two elements at index a and index b values in the given list. *
     *
     * @param input
     * @param a
     * @param b
     */
    private void swap (List <T> input, int a, int b){
        T buffer = input.get(a);
        input.set(a, input.get(b));
        input.set(b, buffer);
    }

    /**
     * Restore a max heap after the index rootIndex.
     *
     * @param heap the List to be heapified
     * @param rootIndex the ndex of the future heap's root
     * @param heapSize the limitation on size of the heap
     */
    private void maxHeapify (List<T> heap, int rootIndex, int heapSize){

        int l = left(rootIndex);
        int r = right(rootIndex);
        int iOfLargest;
        if(l<heapSize && heap.get(l).compareTo(heap.get(rootIndex))>0){
            iOfLargest = l;
        }else{
            iOfLargest = rootIndex;
        }
        if(r<heapSize && heap.get(r).compareTo(heap.get(iOfLargest))>0){
            iOfLargest = r;
        }
        if (iOfLargest!= rootIndex) {
            swap(heap, rootIndex, iOfLargest);
            maxHeapify(heap, iOfLargest, heapSize);
        }

    }

    /**
     * Builds a max heap in place. in O(n) time
     *
     * @param from what to build the heap from
     * @param size what is the size of the desired heap
     *
     *
     */
    private void buildMaxHeap (List<T> from, int size){
        for (int i = size/2 ; i >0 ; i--) {
            maxHeapify(from,i,size);
        }
        maxHeapify(from, 0, size);
    }


    /**
     Following functions provided for readability
     */
    private int parent(int i){
        return Math.floorDiv(i,2);
    }

    private int left (int i){
        return 2*i+1;
    }

    private int right (int i){
        return 2*i+2;
    }

    /**
     * Main method to test the program, aside from the JUnit Tests.
     * @param args
     */
    public static void main(String args[]){
        List <Integer>  i = new ArrayList<Integer>();
        java.util.Random rGen = new java.util.Random();
        for(int j=0;j<10 ;j++){
            i.add(rGen.nextInt(9));
        }
        HeapSort<Integer> hs = new HeapSort<Integer>();
        List<Integer> o = hs.sort(i);
        for (Integer element : o) {
            System.out.print(element+" ");
        }
    }
}
