package uk.ac.cam.cl.algorithms.sup5;

import java.util.List;

/**
 * Created by app on 18/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class LinkListNode<T> implements FibonacciNode<T>{

    public LinkListNode (T newValue){
        //TODO implement this
    }

    @Override
    public void addChild(FibonacciNode<T> newChild) {
        //TODO
    }

    @Override
    public void addSibling(FibonacciNode<T> brother) {
        //TODO
    }

    @Override
    public void setParent(FibonacciNode<T> newParent) {
        //TODO
    }

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
    public FibonacciNode<T> getParent(){
     //TODO
        return null;
    }

    @Override
    public FibonacciNode<T> getChild(){
        //TODO
        return null;
    }

    @Override
    public int getKey() {
        //TODO
        return 0;
    }

    @Override
    public void setKey(int newKey){
        //TODO
    }

    @Override
    public boolean isMarked() {
        //TODO
        return false;
    }

    @Override
    public int getDegree() {
        //TODO
        return 0;
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
    public void setMarked(boolean newState) {
        //TODO
    }

    @Override
    public T getPayload() {
        //TODO
        return null;
    }

    /**
     * Add the root of the BinomialTree provided it has the right size.
     * <p>
     * //TODO increment degree of the root node.
     *
     * @param newChild a binomial tree with root of the same degree as this.getDegree()
     */
    @Override
    public void insertChild(BinomialTree<T> newChild) {

    }

    @Override
    public void removeFromChildren(FibonacciNode son) {
        //TODO implement this.
    }

    @Override
    public Iterable<? extends FibonacciNode<T>> getChildren() {
        //TODO implement this.
        return null;
    }
}
