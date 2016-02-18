package uk.ac.cam.cl.algorithms.sup5;

import java.util.List;

/**
 * Created by app on 17/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public interface FibonacciNode<T> {
    void addChild(FibonacciNode<T> newChild);//TODO remember to increment the degree of the child
    void addSibling(FibonacciNode<T> brother); //TODO add to the left of this
    void setParent(FibonacciNode<T> newParent);

    FibonacciNode<T> getRight();
    FibonacciNode<T> getLeft();
    FibonacciNode<T> getParent();
    FibonacciNode<T> getChild();

    int getKey();
    void setKey(int newKey);

    boolean isMarked();
    int getDegree();
    void incrementDegree();//this.degree ++
    void decrementDegree();//this.degree --
    void setMarked(boolean newState);
    T getPayload();

    /**
     * Add the root of the BinomialTree provided it has the right size.
     *
     * //TODO increment degree of all parents.
     *
     * @param newChild a binomial tree with root of the same degree as this.getDegree()
     */
    void insertChild (BinomialTree<T> newChild);


    void removeFromChildren(FibonacciNode son);

    Iterable<? extends FibonacciNode<T>> getChildren();
}
