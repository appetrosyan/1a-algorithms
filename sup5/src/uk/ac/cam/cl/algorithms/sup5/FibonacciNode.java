package uk.ac.cam.cl.algorithms.sup5;

import java.util.Iterator;

/**
 * Created by app on 17/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public interface FibonacciNode<T> {

    //--------------------------------
    //Getters
    FibonacciNode<T>    getRight();
    FibonacciNode<T>    getLeft();
    FibonacciNode<T>    getParent();
    FibonacciNode<T>    getChild();
    T getPayload();
    int getDegree();
    int getNumberOfSiblings();
    int getKey();
    boolean isMarked();


    //--------------------------------
    //Setters
    void setParent(FibonacciNode<T> newParent);
    void setMarked(boolean newState);
    void incrementDegree();//this.degree ++
    void decrementDegree();//this.degree --void setKey(int newKey);
    void setKey(int newKey);
    /**
     * Add the current node to the Sibling List of the Child, increment the currentNode's degree.
     *
     * @param newChild
     */
    void addChild(FibonacciNode<T> newChild);

    /**
     * Add the given FibonacciNode to the siblings list of the current Node, from the left.
     * remember not to increase the parent's degree by mistake.
     *
     * @param brother node to be inserted
     */
    void addSibling(FibonacciNode<T> brother);


    /**
     * remove {@Code x} from the siblings list of {@Code this}, if {@Code this == x} just set the parent to point
     * to next sibling, and dereference this from left and right. 
     * @param x sibling to be removed from this.
     */
    void removeSibling(FibonacciNode<T> x);

    /**
     * Swap {@Code this} and {@Code x}'s positions in the circular linked list by doing this.right = x.right
     * and this.left = x.left 
     * 
     * @param x
     */
    void swapWith(FibonacciNode<T> x);

    FibonacciNode<T> asOnlyChild();

    Iterable<? extends FibonacciNode<T>> getSiblings();


}
