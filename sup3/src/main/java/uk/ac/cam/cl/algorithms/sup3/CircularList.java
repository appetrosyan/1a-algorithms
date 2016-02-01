package uk.ac.cam.cl.algorithms.sup3;

/**
 * Created by oliverchick on 2016-02-01.
 */
public class CircularList<T> {

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
        return  null;
    }
}
