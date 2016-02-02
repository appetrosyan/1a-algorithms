package uk.ac.cam.cl.algorithms.sup2.maxheap;

public class MaxHeap implements MaxHeapInterface {

    // TODO: Pick a sensible number here.
    private static final int MAX_ELEMENTS_IN_HEAP = 1;

    private char[] heap;

    /**
     * Constructor
     * @param s a string, each character of which is added to the
     *          max heap.
     * @throws HeapSizeExceededException if there are
     */
    public MaxHeap(String s) throws HeapSizeExceededException {
        heap = new char[MAX_ELEMENTS_IN_HEAP];
        // TODO: Implement this
    }

    @Override
    public char getMax() throws EmptyHeapException {
        // TODO: implement this
        return 0;
    }

    @Override
    public void insert(char i) throws HeapSizeExceededException {

    }
}
