package uk.ac.cam.cl.algorithms.sup1;


import java.util.List;
import java.util.ArrayList;
/**
 * Created by app on 05/02/16.
 */
public class IntegerListGenerator{
    /**
     *
     * @param stage an integer specifying which of the output sample lists to generate.
     * @return One of well known List types.
     */
    public List<Integer> generateDisordered (int stage){
        List <Integer>result = new ArrayList<>();
        switch(stage){
            case 1:
                result.add(2);
                result.add(1);
                result.add(3);
                result.add(3);
                result.add(4);
                result.add(5);
                result.add(1);
                result.add(1);
                break;
            case 2:
                result.add(3);
                result.add(2);
                result.add(3);
                result.add(7);
                result.add(6);
                result.add(-12);
                result.add(0);
                result.add(-5);
                result.add(-7);
                result.add(-8);
                result.add(-9);
                result.add(3);
                result.add(-5);
                break;
            case 3:
                result.add(2);
                result.add(8);
                result.add(6);
                result.add(7);
                result.add(0);
                result.add(-356);
                result.add(123123);
                result.add(2323);
                result.add(232343445);
                break;
            case 4:
                result.add(231);
                result.add(123213);
                result.add(2323213);
                result.add(123232);
                result.add(23232);
                result.add(3);
                result.add(77657);
                result.add(-567567);
                result.add(-45674);
                result.add(-4567546);
                break;
            case 5:
                result.add(1<<22);
                result.add(1<<3);
                result.add(1<<5);
                result.add(7<<3);
                result.add(8<<2);
                result.add(9<<2);
                result.add(101<<1);
                result.add(123<<1);
                result.add(2020);
                result.add(23123);
                result.add(2323);
                break;
            case 6:
                result.add(-1>>1);
                result.add(23<<2);
                result.add(23);
                result.add(2323213);
                result.add(45345);
                result.add(123123);
                result.add(-1231);
                result.add(868695);
                result.add(42);
                break;
            case 7:
                result.add(71);
                result.add(71);
                result.add(72);
                result.add(72);
                result.add(72);
                result.add(72);
                result.add(72);
                result.add(72);
                break;
            default:
                result.add(2);
                result.add(-2);
                result.add(-3);
                result.add(-532);
                result.add(231);
                result.add(0);
        }
        return result;

    }
}
