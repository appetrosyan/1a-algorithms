package uk.ac.cam.cl.algorithms.sup3;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by oliverchick on 2016-02-01.
 *
 * Modified by appetrosyan on 2016-02-03
 */
public class Permutations {
    /**
     * @return true if s1 is a permutation of s2
     */
    public static boolean arePermuations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else if(s1.length()>=2<<16){//Could occur, but thanks to UTF -16 impossible
            int [] occurrences = new int[1<<16]; //Chars are 16 bit

            char[] a1 = s1.toCharArray();
            char[] a2 = s2.toCharArray();

            for (int i = 0; i < a1.length; i++) {
                occurrences[a1[i]]++;
                occurrences[a2[i]]--;
            }

            for(int i =0;i<occurrences.length;i++){
                if(occurrences[i]!=0){
                    return false;
                }
            }
            return true;
        }else{//E.g. for small strings and big charsets.
            ArrayList<Character> c1 = new ArrayList<Character>();
            ArrayList<Character> c2 = new ArrayList<Character>();
            for(Character element: s1.toCharArray()){
                c1.add(element);
            }
            Collections.sort(c1);
            for(Character element: s2.toCharArray()){
                c2.add(element);
            }
            Collections.sort(c2);
            return c1.equals(c2);
        }

    }
}
