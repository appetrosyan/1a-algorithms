package uk.ac.cam.cl.algorithms.sup3;

import java.util.LinkedList;


/**
 * Created by oliverchick on 2016-02-01.
 * 
 * Modified by ap886 at Feb 3 2016
 */
public class Benchmark {
    private static long timeWhenCreated;
    private static long timeWhenTerminated;

    /**
     * Calculated the time taken to create a linked list with n items and then
     * read every value.
     *
     * @param numItems the number of items to include in a linked list.
     * @return The time taken to create and walk a linked list
     */
    public static int benchmarkList(int numItems) {
        timeWhenCreated = System.nanoTime();
        //Create List
        LinkedList<Integer> trial = new LinkedList<Integer>();
        for (int i = 0; i < numItems; i++) {
            trial.add(i, i);
        }//To demonstrate the inefficiency of setting values
        //Walk List
        for (int i = 0; i < numItems; i++) {
            trial.get(i);
        }
        long timeWhenTerminated = System.nanoTime();
        return (int) (timeWhenTerminated - timeWhenCreated);
    }


    /**
     * Showcases the difference between different types of list treatment.
     *
     * @param numItems number of items in Lists. 
     * @return
     */
    public static int benchmarkListSmart(int numItems) {
        timeWhenCreated = System.nanoTime();
        //Create List;
        LinkedList<Integer> trial = new LinkedList<Integer>();
        for (int i = 0; i < numItems; i++) {
            trial.add(i);
        }//The right way to construct a list
        //Walk List
        for (Integer element : trial) {//"Syntactic Sugar has its benefits
            //E.g. behold the power of caching.
            if (element == null) {
                //Do nothing
            } else {
                //Contemplate existence
            }
        }
        timeWhenTerminated = System.nanoTime();
        return (int) (timeWhenTerminated - timeWhenCreated);
    }

    /**
     * Same for an array
     */
    public static int benchmarkArray(int numItems) {
        timeWhenCreated = System.nanoTime();
        //Create List
        Integer[] trial = new Integer[numItems];
        for (int i = 0; i < numItems; i++) {
            trial[i] = i;
        }
        //walk List
        for (int i = 0; i < numItems; i++) {
            if (trial[i] == null) {
                //Do nothing
            } else {
                //See comment in BenchmarkList
            }
        }
        timeWhenTerminated = System.nanoTime();
        return (int) (timeWhenTerminated - timeWhenCreated);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println("Linked list 10^" + i + " items: " +
                    benchmarkList((int) Math.pow(10, i)));
            System.out.println("Array 10^" + i + " items: " +
                    benchmarkListSmart((int) Math.pow(10, i)));
            System.out.println("Proper List 10^" + i + " items: " +
                    benchmarkArray((int) Math.pow(10, i)));
            System.out.println();
        }
    }

}

