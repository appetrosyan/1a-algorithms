package uk.ac.cam.cl.algorithms.sup5;

import java.util.Iterator;

/**
 * Created by app on 18/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class LinkListNode<T> implements FibonacciNode<T>{

    @Override
    public FibonacciNode<T> getRight() {
        //TODO
        return null;
    }

    @Override
    public FibonacciNode<T> getLeft() {
        //TODO
        return null;
    }

    @Override
    public FibonacciNode<T> getParent() {
        //TODO
        return null;
    }

    @Override
    public FibonacciNode<T> getChild() {
        //TODO
        return null;
    }

    @Override
    public T getPayload() {
        //TODO
        return null;
    }

    @Override
    public int getDegree() {
        //TODO
        return 0;
    }

    @Override
    public int getNumberOfSiblings() {
        //TODO
        return 0;
    }

    @Override
    public int getKey() {
        //TODO
        return 0;
    }

    @Override
    public boolean isMarked() {
        //TODO
        return false;
    }

    @Override
    public void setParent(FibonacciNode<T> newParent) {
        //TODO
    }

    @Override
    public void setMarked(boolean newState) {
        //TODO
    }

    @Override
    public void incrementDegree() {
        //TODO
    }

    @Override
    public void decrementDegree() {
       //TODO
    }

    @Override
    public void setKey(int newKey) {
        //TODO
    }

    /**
     * Add the current node to the Sibling List of the Child, increment the currentNode's degree.
     *
     * @param newChild
     */
    @Override
    public void addChild(FibonacciNode<T> newChild) {
        //TODO
    }

    /**
     * Add the given FibonacciNode to the siblings list of the current Node, from the left.
     * remember not to increase the parent's degree by mistake.
     *
     * Also make sure that the {@Code brother}'s both right and left nodes don't point to the
     * old left and right siblings, but the new ones.
     *
     * @param brother node to be inserted
     */
    @Override
    public void addSibling(FibonacciNode<T> brother) {
        //TODO
    }

    /**
     * remove {@Code x} from the siblings list of {@Code this}, if {@Code this == x} just set the parent to point
     * to next sibling, and dereference this from left and right.
     *
     * @param x sibling to be removed from this.
     */
    @Override
    public void removeSibling(FibonacciNode<T> x) {
        //TODO
    }

    /**
     * Swap {@Code this} and {@Code x}'s positions in the circular linked list by doing this.right = x.right
     * and this.left = x.left
     *
     * @param x
     */
    @Override
    public void swapWith(FibonacciNode<T> x) {
        //TODO
    }


    /**
     * return {@Code} this with its' bot right and left siblings equal to itself. i.e. this is a root of a
     * tree with no siblings.
     * @return
     */
    @Override
    public FibonacciNode<T> asOnlyChild() {
        return null;
    }

    //----------------------------------------------------------------------

    /**
     * Neat feature to simplify ConcreteFibonacciHeap and make it more readable
     *
     * @return
     */
    public Iterable<? extends FibonacciNode<T>> getSiblings() {
        return new Iterable<FibonacciNode<T>>() {
            @Override
            public Iterator<FibonacciNode<T>> iterator() {
                return new NodeIterator<T> (LinkListNode.this);
            }
        };
    }



}
