package uk.ac.cam.cl.algorithms.sup3;

/**
 * Created by oliverchick on 2016-02-01.
 */
public class Benchmark {

    /**
     * Calculated the time taken to create a linked list with n items and then
     * read every value.
     * @param numItems the number of items to include in a linked list.
     * @return The time taken to create and walk a linked list
     */
    public static int benchmarkList(int numItems) {
        return 0;
    }

    /**
     * Same for an array
     */
    public static int benchmarkArray(int numItems) {
        return 0;
    }

    public static void main(String[] args) {
        // Feel free to change the bounds if your computer can/can't cope.
        for (int i = 0; i < 7; i++) {
            System.out.println("Linked list 10^" + i + " items: " +
                    benchmarkList((int)Math.pow(10, i)));
            System.out.println("Array 10^" + i + " items: " +
                    benchmarkArray((int)Math.pow(10,i)));
        }
    }

}

