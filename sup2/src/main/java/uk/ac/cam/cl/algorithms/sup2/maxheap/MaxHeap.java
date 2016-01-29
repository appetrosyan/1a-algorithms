package uk.ac.cam.cl.algorithms.sup2.maxheap;

public class MaxHeap implements MaxHeapInterface {

    private int heapSize;
    private char[] heapElements;

    /**
     * Constructor
     * @param s a string, each character of which is added to the
     *          max heap. 
     */
    public MaxHeap (String s){
        char[] elements = s.toLowerCase().toCharArray();
        heapElements = new char[s.length()];
        for (char x :elements){
            this.insert(x);
        }
    }


    /**Insert
     * Adds the given character into the maxheap, performing neessary corrections to maintain
     * the heap property.
     * @param input
     */
    @Override
    public void insert(char input) {
        if(heapSize>= heapElements.length){
            char[] buffer = new char[heapElements.length*2];
            for( int i=0;i<heapSize;i++){
                buffer[i] = heapElements[i];
            }
            heapElements = buffer;

        }
        heapElements[heapSize]=input;
        int index = heapSize;
        heapSize++;
        while(index >=0 && heapElements[index]>heapElements[parent(index)]){
            swap (heapElements,index,parent(index));
            index = parent(index);
        }




    }

    /**
     *
     * @return returns the length of the allocated units, not related to the size of the internal storage
     * unit.
     */
    public int getLength() {
        return heapSize;
    }

    /**
     * Swaps two elements at given indexes in the given array.
     * @param input
     * @param a
     * @param b
     */
    private void swap (char[] input, int a, int b){
        char buffer = input[a];
        input[a] = input[b];
        input[b] = buffer;
    }

    /**
     * returns the index of parent of the heap
     * @param i
     * @return
     */
    private int parent(int i){
        return (int) Math.floor(i/2);
    }


    /**
     * Returns the index of the element's left child
     * @param i
     * @return
     */
    private int left (int i){
        return 2*i+1;
    }


    /**
     * returns the index of the element's right child
     * @param i
     * @return
     */
    private int right (int i){
        return 2*i+2;
    }

    /**
     * Restores the heap property of the heap from rootIndex down
     * @param heap
     * @param rootIndex
     */
    private void maxHeapify (char[] heap, int rootIndex){
        int iOfLargest;
        while(true){
            int l = left(rootIndex);
            int r = right(rootIndex);
            if(l<heapSize && heap[l]>heap[rootIndex]){
                iOfLargest = l;
            }else{
                iOfLargest = rootIndex;
            }
            if(r<heapSize && heap[r]>heap[iOfLargest]){
                iOfLargest = r;
            }
            if(iOfLargest == rootIndex)
                break;
            else{
                swap (heap, rootIndex, iOfLargest);
                rootIndex = iOfLargest;
            }
        }
    }

    /**
     * Retrieves the largest element (root) of the heap.
     * @return
     * @throws EmptyHeapException
     */
    @Override
    public char getMax() throws EmptyHeapException {
        if(heapSize==0){
            throw new EmptyHeapException();
        }
        else{
            char result= heapElements[0];
            heapSize--;
            swap (heapElements,0,heapSize);
            maxHeapify(heapElements, 0);

            return result;
        }
    }


}
