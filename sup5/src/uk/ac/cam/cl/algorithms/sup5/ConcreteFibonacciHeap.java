package uk.ac.cam.cl.algorithms.sup5;

import java.util.ArrayList;


/**
 * Created by app on 17/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class ConcreteFibonacciHeap <T> implements FibonacciHeap<T> {

    private final static double GOLDEN_RATIO = (1+Math.sqrt(5))/2;
    private FibonacciNode<T> minRoot;
    private int nodes; //Amount of Nodes currently present in the FibHeap, will need this

    /**
     * To be Done By ddt
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
     * To be done by ddt
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
     * To be completed by ddt
     *
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
     * To be Done by ap886
     * <p>
     * Destructively retrieve the minimum value in the Fibonacci heap. Perfroming the Tidy-Up procedure.
     *
     * @return The minimum value that is no longer in the heap.
     */
    @Override
    public T extractMin() {
        for(FibonacciNode<T> x : minRoot.getChild().getSiblings()){
            minRoot.addSibling(x);
            x.setParent(null);
        }
        if(minRoot.getNumberOfSiblings() == 1){
            minRoot = null;
        }else{
            FibonacciNode<T> oldMin =minRoot;
            minRoot = minRoot.getRight();
            minRoot.removeSibling(oldMin);
            consolidate();
            nodes--;
        }

        return minRoot != null ? minRoot.getPayload() : null;
    }

    /**
     * Performs Consolidate as specified in the CLRS. page 516
     */
    private void consolidate () {
        ArrayList<FibonacciNode<T>> array = new ArrayList<>(getMaxDegree());
        //Merge the trees in the Root List.
        for (FibonacciNode<T> x : minRoot.getSiblings()) {
            int d = x.getDegree();
            while (array.get(d) != null) {
                FibonacciNode<T> y = array.get(d);
                if (x.getKey() > y.getKey()) {
                    y.swapWith(x);
                }
                minRoot.removeSibling(y);
                x.addChild(y);
                y.setMarked(false);
                array.set(d, null);
                d++;
            }
            array.set(d, x);
        }
        minRoot = null;

        //Find the new MinRoot
        for (int i = 0; i < getMaxDegree(); i++) {
            if(array.get(i)!=null){
                if(minRoot==null){
                    minRoot = array.get(i).asOnlyChild();
                    minRoot.setParent(null);
                }else{
                    minRoot.addSibling(array.get(i));
                    if(array.get(i).getKey() < minRoot.getKey()){
                        minRoot = array.get(i);
                    }
                }
            }
        }
    }

    /**
     *
     * @return an upper bound on the current FibHeap's subtrees' maximal degree.
     */
    private int getMaxDegree() {
        //See CLRS Section 19.4 for a derivation.
        return (int) Math.floor(Math.log(nodes)/Math.log(GOLDEN_RATIO));
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

    /**
     *
     * @param son Node to be removed
     * @param dad Node's parent (optional, could've just called getParent(), here provided for readability of above code
     */
    public void cut(FibonacciNode<T> son, FibonacciNode<T> dad){
        dad.getChild().removeSibling(son);
        dad.decrementDegree();
        minRoot.addSibling(son);
        son.setMarked(false);
    }

    /**
     *
     * @param parent perform cascading cut from the current node.
     */
    public void cascadingCut(FibonacciNode<T> parent){
        FibonacciNode<T> grandParent = parent.getParent();
        if(grandParent!=null){
            if(!parent.isMarked()) parent.setMarked(true);
            else{
                cut(parent,grandParent);
                cascadingCut(grandParent);
            }
        }
    }

    /**
     * Wrap to decrease key to minus infinity and extract min.
     *
     * @param element element to be removed from the heap.
     */
    @Override
    public void delete(FibonacciNode<T> element)  {
        try {
            decreaseKey(element, 1<<31); //Assume we're dealing with a two's complement, make very negative
        }catch (TriedToIncreaseKeyException error){
            error.printStackTrace();
        }
        extractMin();
    }
}
