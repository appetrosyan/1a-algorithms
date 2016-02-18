package uk.ac.cam.cl.algorithms.sup5;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Created by app on 17/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class ConcreteFibonacciHeap <T> implements FibonacciHeap<T> {

    List<FibonacciNode<T>> roots = new ArrayList<>(); //TODO reimplement this in pointers
    FibonacciNode<T> minRoot;
    int nodes = 0;  //TODO replace with roots.getSize()

    //TODO redistribute work.



    /**
     * To be Done By ***
     * <p>
     * Non-destructively retrieve the minimum value in the Fibonacci Heap.
     *
     * @return The  minimum value in the FibHeap
     */
    @Override
    public FibonacciNode<T> getMin() {
        return minRoot;
    }

    /**
     * To be done by ***
     * <p>
     * Insert the value into the fibHeap
     *
     * @param newValue the value to be inserted into the FibHeap
     */
    @Override
    public void insert(T newValue) {
            //TODO
    }

    /**
     * Should Perform the merge of the two fibHeaps. By reducing the amount of binomial trees in the \
     * heap to one tree per type.
     *
     * @param a heap to be merged into
     * @param b heap to be merged with
     * @return a heap that contains all the elements a and b. Satisfies the properties of the Fibonacci heaps,
     * and only contains one tree of each size.
     */
    @Override
    public FibonacciHeap<T> merge(FibonacciHeap a, FibonacciHeap b) {
        return null;
        //TODO implement this.
    }

    //-------------------------------------------------------------------------------------------------

    /**
     * To be Done by ***
     * <p>
     * Destructively retrieve the minimum value in the Fibonacci heap. Perfroming the Tidy-Up procedure.
     *
     * @return The minimum value that is no longer in the heap.
     */
    @Override
    public T extractMin() {
        if(this.minRoot != null){
            for(FibonacciNode<T> x : minRoot.getChildren()){ //TODO implement iterator
                roots.add(x);
                x.setParent(null);
            }
            if(roots.size() == 1){//E.g. completely traversed the cycle.
                minRoot = null;
            }else{
                minRoot = minRoot.getRight();//TODO find new Min inside Consolidate()
                nodes--;
            }
            T result = minRoot.getPayload();
            return result;
        }else{
            return null;
        }

    }

    /**
     * Perform Consolidate as specified in the CLRS. page 516
     */
    private void consolidate () {
        ArrayList<FibonacciNode<T>> array = new ArrayList<>(getMaxDegree());
        for (FibonacciNode<T> x : roots) {
            int d = x.getDegree();
            while(array.get(d)!=null){
                FibonacciNode y = array.get(d);
                if(x.getKey() > y.getKey()){
                    Collections.swap(
                            roots, roots.indexOf(x), roots.indexOf(y)
                    );
                    roots.remove(y);
                    x.addChild(y);
                    y.setMarked(false);
                    array.set(d, null);
                    d++;
                }
                array.set(d,x);
                minRoot = null;
            }
        }
        for (int i = 0; i < getMaxDegree(); i++) {
            if(array.get(i)!=null){
                if(minRoot==null){
                    roots = new ArrayList<> ();
                    roots.add(array.get(i));
                }else{
                    roots.add(array.get(i));
                    if(array.get(i).getKey() < minRoot.getKey()){
                        minRoot = array.get(i);
                    }
                }
            }
        }
    }

    private int getMaxDegree() {
        return nodes;//TODO calculate a tighter upper bound
    }


    /**
     * Increase the priority of the element of the heap by reference.
     *
     * @param element  The element whose priority is to be changed.
     * @param priority the new priority of the element (prefereably the priority should only be decreased,
     */
    @Override
    public void decreaseKey(FibonacciNode<T> element, int priority) throws TriedToIncreaseKeyException {
        if(priority > element.getKey()){
            throw new TriedToIncreaseKeyException(priority, element.getKey());
        }
        element.setKey(priority);
        FibonacciNode <T> parent = element.getParent();
        if(parent !=null && element.getKey()<parent.getKey()){
            cut(element,parent);
            cascadingCut(parent);
        }if(element.getKey() < getMin().getKey()){
            minRoot = element;
        }
    }

    public void cut(FibonacciNode son, FibonacciNode dad){
        dad.removeFromChildren(son);
        dad.decrementDegree();
        roots.add(son);
        son.setMarked(false);
    }

    public void cascadingCut(FibonacciNode<T> parent){
        FibonacciNode<T> grandParent = parent.getParent();
        if(grandParent!=null){
            if(!parent.isMarked()) parent.setMarked(true);
            else{
                cut(parent,grandParent);
                cascadingCut(grandParent);
            }
        }//else do nothing, the root node cannot be cut even if it's marked.
    }

    /**
     * Highly optional. Wrap to decrease key to minus infinity and extract min.
     *
     * @param element
     */
    @Override
    public void delete(FibonacciNode<T> element)  {
        try {
            decreaseKey(element, 1<<31); //Assuem we're dealing with a two's complement, make very negative
        }catch (TriedToIncreaseKeyException error){
            error.printStackTrace();
        }
        extractMin();
    }
}
