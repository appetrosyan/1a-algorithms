package uk.ac.cam.cl.algorithms.sup0;

import java.util.NoSuchElementException;

/**
 * Created by Henry on 19/01/2016.
 */
public class QueueEmptyException extends NoSuchElementException {
    public QueueEmptyException(String message) {
        super(message);
    }
}
