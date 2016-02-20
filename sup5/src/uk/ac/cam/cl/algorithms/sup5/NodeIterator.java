package uk.ac.cam.cl.algorithms.sup5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by app on 20/02/16.
 * Serves the purpose of simplifying the traversal of a FibHeap's rootList.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class NodeIterator<T> implements Iterator<FibonacciNode<T>> {
    private boolean haveStarted;
    private final FibonacciNode<T> startNode;
    private FibonacciNode<T> currentNode;

    public NodeIterator (FibonacciNode<T> initialNode){
        haveStarted = false;
        startNode   = initialNode;
        currentNode = initialNode;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        if(haveStarted)
            return currentNode == startNode;
        else
            return true;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public FibonacciNode<T> next() {
        if(haveStarted && currentNode==startNode){
            throw new NoSuchElementException();
        }
        else{
            haveStarted = true;
            FibonacciNode<T> result = currentNode;
            currentNode = currentNode.getRight();
            return result;
        }
    }


}
