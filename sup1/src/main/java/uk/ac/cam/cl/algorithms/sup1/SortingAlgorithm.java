package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;

/**
 * Created by oliverchick on 24/12/2015.
 *
 * modified by ap886 at 25/01/2016
 *
 */


public interface SortingAlgorithm<T extends Comparable<? super T>> {

   List<T> sort(List<T> input);

}
