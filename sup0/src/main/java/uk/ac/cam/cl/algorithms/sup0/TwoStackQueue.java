package uk.ac.cam.cl.algorithms.sup0;

import java.util.Stack;

public class TwoStackQueue<T> implements Queue<T> {
    private Stack<T> frontReversed = new Stack<>();
    private Stack<T> backOrdered = new Stack<>();

    @Override
    public T pop() {
        if (frontReversed.size() == 0) {
            if (backOrdered.size() == 0) {
                throw new QueueEmptyException("Queue is empty, cannot pop");
            }
            // Store the size of the stack in an integer because it changes when we pop off items!
            int itemsToMove = backOrdered.size();
            for (int i=0; i < itemsToMove; i++) {
                T item = backOrdered.pop();
                frontReversed.push(item);
            }
        }
        T popped = frontReversed.pop();
        return popped;
    }

    @Override
    public void push(T item) {
        backOrdered.push(item);
    }

}
