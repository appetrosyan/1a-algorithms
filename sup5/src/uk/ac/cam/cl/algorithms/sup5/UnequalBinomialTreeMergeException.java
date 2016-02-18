package uk.ac.cam.cl.algorithms.sup5;

/**
 * Created by app on 18/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class UnequalBinomialTreeMergeException extends Exception {
    UnequalBinomialTreeMergeException(String msg){
        super (msg);//TODO add a descriptive message
    }

    UnequalBinomialTreeMergeException(BinomialTree a, BinomialTree b){
        super ("Trees "+a +" and "+b+" are not of the same size. Error in function call");
    }
}
