package uk.ac.cam.cl.algorithms.sup1;

import java.util.List;



/**
 * Created by oliverchick on 24/12/2015.
 *
 * Modified by ap886 on Thursday 21/1/2016.
 */
public class MergeSort<T extends Comparable<? super T>> implements SortingAlgorithm<T> {

    /*
     * Implement merge sort here
     */
    public  List<T> sort(List<T> arg) {

        int length=arg.size();
        if(length <=1) {
            return arg;
            //Sorting an empty list is an empty list,
            //a singleton sorts to a singleton.
        } else {
            return merge (
                    sort(arg.subList(0,length/2)),
                    sort(arg.subList(length/2+1,length))
            );
        }
    }



    private List<T> merge (List<T> left, List<T> right){
        List<T> result = new java.util.ArrayList<T>(left.size() + right.size());
        int i=0, lsz = left.size();
        int j=0, rsz = right.size();

        for(;;){
            if(i==lsz && j == rsz){
                return result;
            }else if (i==lsz){
                result.addAll(j,right);
                //Add all elements remaining in the right array
            }else if (j==rsz){
                result.addAll(i,left);
            }else {
                //assert (i!=lsz && j!=rsz);
                if(left.get(i).compareTo(right.get(j))>0){
                    result.add(left.get(i));
                    i++;
                }else{
                    result.add(right.get(j));
                    j++;
                }
            }
        }

    }
}