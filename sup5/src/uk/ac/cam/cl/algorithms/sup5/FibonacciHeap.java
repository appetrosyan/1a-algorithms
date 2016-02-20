package uk.ac.cam.cl.algorithms.sup5;

/**
 * Created by app on 16/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public interface FibonacciHeap <T> {

    /**
     * To be Done By Dhruv
     *
     * Non-destructively retrieve the minimum value in the Fibonacci Heap.
     * @return The  minimum value in the FibHeap
     */
    FibonacciNode<T> getMin ();

    /**
     * To be done by Dhruv
     *
     * Insert the value into the fibHeap
     * @param newValue the value to be inserted into the FibHeap
     */
    void insert (T newValue);

    /**
     * Should Perform the merge of the two fibHeaps. By reducing the amount of binomial trees in the \
     * heap to one tree per degree.
     *
     * @param a heap to be merged into
     * @param b heap to be merged with
     * @return a heap that contains all the elements a and b. Satisfies the properties of the Fibonacci heaps,
     * and only contains one tree of each size.
     */
    FibonacciHeap<T> merge (FibonacciHeap a, FibonacciHeap b);

    /**
     * Done by Aleksandr.
     *
     * Destructively retrieve the minimum value in the Fibonacci heap. Performing the Tidy-Up procedure.
     * @return The minimum value that is no longer in the heap.
     */
    T extractMin();

    /**
     * Done by Aleksandr
     *
     * Increase the priority of the element of the heap by reference.
     * @param element The element whose priority is to be changed.
     * @param priority the new priority of the element (prefereably the priority should only be decreased,
     *
     */
    void decreaseKey (FibonacciNode<T> element, int priority) throws TriedToIncreaseKeyException;

    /**
     * Done by Aleksandr
     *
     * Highly optional. Wrap to decrease key to minus infinity and extract min.
     * @param element
     */
    void delete(FibonacciNode<T> element);
}
