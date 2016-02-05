package uk.ac.cam.cl.algorithms.sup3;

/**
 * Created by app on 05/02/16.
 *
 * BAsed on COde based upon James Weller
 */


import java.util.*;

public class RandomStringGenerator
{
    private final char[] alphanumeric=alphanumeric();
    private final Random rand;

    public RandomStringGenerator(){this(null);}

    public RandomStringGenerator(Random rand){
        this.rand=(rand!=null) ? rand : new Random();
    }

    public String get(int length){
        StringBuffer out=new StringBuffer();

        while(out.length() < length){
            int idx=Math.abs(( rand.nextInt() % alphanumeric.length ));
            out.append(alphanumeric[idx]);
        }
        return out.toString();
    }

    private char[] alphanumeric(){
        StringBuffer buf=new StringBuffer(128);
        for(int i=97; i<=102;i++)buf.append((char)i); // a-f
        return buf.toString().toCharArray();
    }



    public static void main(String[] args){
        RandomStringGenerator rand=new RandomStringGenerator();
        System.out.println(
                "10 chars random string="+rand.get(10)
        );
        System.out.println(
                "128 chars random string="+rand.get(128)
        );

    }
}

