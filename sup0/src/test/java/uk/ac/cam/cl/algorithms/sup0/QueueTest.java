package uk.ac.cam.cl.algorithms.sup0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QueueTest extends junit.framework.TestCase {

    Queue queue;

    public void assertQueueEmpty() {
        try {
            queue.pop();
        } catch (QueueEmptyException e) {
            return;
        }
        fail();
    }

    @Test
    public void testPushPop() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        queue.push(a);
        queue.push(b);
        assertEquals(queue.pop(), a);
        assertEquals(queue.pop(), b);
        assertQueueEmpty();
        queue.push(c);
        assertEquals(queue.pop(), c);
        assertQueueEmpty();
    }


    public QueueTest(Queue queue) {
        this.queue = queue;
        assertQueueEmpty();
    }

    @Parameterized.Parameters
    public static Collection<Queue[]> instancesToTest() {
        Queue[][] queues = {{new TwoStackQueue()}};
        return Arrays.asList(queues);
    }

}
