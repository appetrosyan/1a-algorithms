package uk.ac.cam.cl.algorithms.sup3;

import java.util.ArrayList;

/**
 * Created by oliverchick on 2016-02-01.
 *
 */
public class CircularList<T> {

    private ArrayList<Node<T>> traversedNodes = new ArrayList<Node<T>>();

    private class Node<T> {
        T val;
        Node<T> next;

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<T> head;

    /**
     * Circular list lists you build a linked list that is circular. That is,
     * by following pointers you go back to a previous element. Note that this
     * need not be the first element. Eg A-B-C-D-E-C-D-E.
     *
     * This method finds the element that is at the start of the circle. For
     * the above string it should return C.
     */
    public T findStartOfCircle() {
        /*
        Traverse list adding each node to the other ArrayList
        Before adding check for duplicates in the ArrayList
        If reached null pointer, return null
        if found duplicate return it's value
        */
        Node<T> current = head;
        while(true){
            if(current.next == null){
                return null;
            }else if(traversedNodes.contains(current.next)){
                return current.next.val;
            }else{//if the node isn't contained and the list hasn't terminated
                current = current.next;
                traversedNodes.add(current);
            }
        }
    }
}
