package uk.ac.cam.cl.algorithms.sup5;

/**
 * Created by app on 17/02/16.
 * <p>
 * Project ${PROJECT-NAME}
 */
public class BinomialTree<T> {
    FibonacciNode <T> root;

    public BinomialTree (T newRoot){
        root = new LinkListNode<> (newRoot);
    }


    public int getDegree(){
        return root.getDegree();
    }

    public BinomialTree<T> merge ( BinomialTree<T> b) throws UnequalBinomialTreeMergeException {

        if(this.getDegree()!= b.getDegree()){
            throw new UnequalBinomialTreeMergeException(this,b);
        }else{
            this.root.insertChild(b);
        }
        return this;
    }

    public void cut(T elenent){

    }

    public void cascadeCut(){

    }



}
