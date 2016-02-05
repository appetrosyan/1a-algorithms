package uk.ac.cam.cl.algorithms.sup2;

import uk.ac.cam.cl.algorithms.sup1.SortingAlgorithm;

import java.util.List;

public class HeapSort<T extends Comparable> implements SortingAlgorithm<T> {

    private List<T> heap;
    private int end;

    public List<T> sort(List<T> input) {
        heap = input;
        maxCharHeap(input);

        while (getLength() > 0) {
            swapMax();
        }
        return heap;
    }

    private void maxCharHeap(List<T> s) {
        int END = s.size();
        end = END - 1;

        for (int k = end/2; k >= 0; k--) {
            heapify(k);
        }
    }

    private void heapify(int iRoot) {
        int j;
        int leftPointer = (2*iRoot) + 1;
        int rightPointer = (2*iRoot) + 2;

        if (leftPointer > end) {
            return;
        } else if (rightPointer > end) {
            if (greaterThan(iRoot, leftPointer)) {
                return;
            } else {
                j = leftPointer;
            }
        } else {
            if (greaterThan(iRoot, leftPointer) && greaterThan(iRoot, rightPointer)) {
                return;
            }
            else if (greaterThan(leftPointer, rightPointer)) {
                j = leftPointer;
            }
            else {
                j = rightPointer;
            }
        }
        swap(iRoot, j);
        heapify(j);
    }

    private boolean greaterThan(int i1, int i2) {
        if (heap.get(i1).compareTo(heap.get(i2)) > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void swap(int p1, int p2) {
        T temp = heap.get(p1);
        heap.set(p1, heap.get(p2));
        heap.set(p2, temp);
    }

    private void swapMax() {
        swap(0,end);
        end --;
        heapify(0);
        return;
    }

    private int getLength() {
        return end + 1;
    }

}
