package uk.ac.cam.cl.algorithms.sup5;

/**
 * Created by app on 18/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class TriedToIncreaseKeyException extends Exception{

    TriedToIncreaseKeyException(String msg){
        super (msg);
    }

    TriedToIncreaseKeyException(int newKey, int previousKey){
        super("Tried to increase priority: "+newKey+" > " + previousKey);
    }

}
