package uk.ac.cam.cl.algorithms.sup3;

import java.util.HashMap;
/**
 * Created by appetrosyan on 03/02/16.
 *
 *
 */
public class Memo <T1,T2,T3>{
    private HashMap<String, T3> storage = new HashMap <String,T3>() ;
    private boolean symmetric = false;

    public void store (T1 arg1, T2 arg2, T3 result){
        if(!arg1.getClass().equals(arg2.getClass())){
            symmetric = false;
            //can't have symmetric if the arguments aren't symmetric
        }else{
            storage.put(arg1.toString() +":"+ arg2.toString(), result);
            //Could add twice to reduce lookup overhead, but this is more space efficient
        }
    }

    public T3 recall (T1 arg1, T2 arg2){
        String seekValue = arg1.toString() + ":"+arg2.toString();

        if(storage.containsKey(seekValue)){
            return storage.get(seekValue);
        }else if(storage.containsKey(seekValue) && symmetric) {
            String reverseSeekValue = arg2.toString() + ":" + arg1.toString();
            return storage.get(reverseSeekValue);
        }else{
            return null;
        }
    }

    public void setSymmetric(){
        symmetric  =true;
    }

    public void setAsymmetric(){
        symmetric = false;
    }
}
