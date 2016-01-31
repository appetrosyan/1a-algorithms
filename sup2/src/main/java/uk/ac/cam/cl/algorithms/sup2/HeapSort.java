package uk.ac.cam.cl.algorithms.sup2;

import uk.ac.cam.cl.algorithms.sup1.SortingAlgorithm;

import java.util.List;
import java.lang.Math;
import java.util.Collections;

public class HeapSort<T extends Comparable<? super T>> implements SortingAlgorithm<T> {
    /**
     * Creates a copy of the original list and sorts it in n (Log n) time using Hcreates
     * a max heap from the given array in place. From rootIndex to endIndex.
     * The 0-th element is the root of the binary tree.
     *
     * @param input - the list to be sorted.
     * @return a sorted copy of the initial List.
     */
    public List<T> sort(List<T> input) {
        int last = input.size();
        buildMaxHeap (input,last);
        if (input.isEmpty() || input.size() <= 1) {
            return input;
        } else {
            //buildMaxHeap(input,result.size());
            while (last > 0) {
                Collections.swap(input, 0, last-1);
                last--;
                maxHeapify(input,0, last);
            }
        }
        return input;
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
            Collections.swap(heap, rootIndex, iOfLargest);
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


}
