package uk.ac.cam.cl.algorithms.sup2;

import uk.ac.cam.cl.algorithms.sup1.SortingAlgorithm;

import java.util.List;
import java.util.ArrayList;

public class HeapSort<T extends Comparable> implements SortingAlgorithm<T> {

    private List<T> heap;
    private int end;

    public List<T> sort(List<T> input) {
        heap = input;
        maxCharHeap(input);

        //since calling getMax repeatedly ends up actually sorting the list there is no need for a new list
        while (getLength() > 0) {
            try {
                getMax();
            } catch (EmptyHeapException e) {
                break;
            }
        }
        return heap;
    }

    public void maxCharHeap(List<T> s) {
        int END = s.size();
        end = END - 1;

        for (int k = end/2; k >= 0; k--) {
            heapify(k);
        }
    }

    private void heapify(int iRoot) {
        int j;
        if ((2*iRoot) + 1 > end) {
            return;
        } else if ((2*iRoot) + 2 > end) {
            if (heap.get(iRoot).compareTo(heap.get((2*iRoot) + 1)) > 0) {
                return;
            } else {
                j = (2*iRoot) + 1;
            }
        } else {
            if (heap.get(iRoot).compareTo(heap.get((2*iRoot) + 1)) > 0 &&
                    heap.get(iRoot).compareTo(heap.get((2*iRoot) + 2)) > 0) {
                return;
            }
            else if (heap.get((2*iRoot) + 1).compareTo(heap.get((2*iRoot) + 2)) > 0) {
                j = (2*iRoot) + 1;
            }
            else {
                j = (2*iRoot) + 2;
            }
        }
        swap(iRoot, j);
        heapify(j);
    }

    private void swap(int p1, int p2) {
        T temp = heap.get(p1);
        heap.set(p1, heap.get(p2));
        heap.set(p2, temp);
    }

    public T getMax() throws EmptyHeapException {
        T res;
        if (end < 0) {
            throw new EmptyHeapException();
        }

        try {
            res = heap.get(0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyHeapException();
        }

        swap(0,end);
        end --;
        heapify(0);

        return res;
    }

    public int getLength() {
        return end + 1;
    }

}
