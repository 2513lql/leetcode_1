package com.lql.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LQL on 2016/5/15.
 */
public class BullsAndCows {

    public static String getHint(String secret, String guess) {

        int bull = 0;
        int cow = 0;

        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        for (int i = 0 ; i < secretChars.length ;i++){
            if (secretChars[i] == guessChars[i]){
                bull++;
                secretChars[i] = '#';
                guessChars[i] = '*';
            }
        }

        Map<Character,Integer> maps = new HashMap<Character,Integer>();
        Map<Character,Integer> mapg = new HashMap<Character,Integer>();
        for (int i = 0 ; i <= 9 ;i++){
            Character tmp =(char)(i + 48);
            maps.put(tmp,0);
            mapg.put(tmp,0);
        }

        for (int i = 0 ; i < secretChars.length ;i++){
            if (secretChars[i] <= '9' && secretChars[i] >= '0'){
               int tmp = maps.get(secretChars[i]);
                tmp++;
                maps.put(secretChars[i],tmp);
            }
            if (guessChars[i] <= '9' && guessChars[i] >= '0'){
                int tmp = mapg.get(guessChars[i]);
                tmp++;
                mapg.put(guessChars[i],tmp);
            }
        }

        for (int i = 0 ; i <= 9 ;i++){
            Character ch =(char)(i + 48);
            int tmp = maps.get(ch);
            if (tmp > 0){
                int num = mapg.get(ch);
                int res = tmp < num ? tmp : num;
                cow += res;
            }
        }


        String result = bull + "A" + cow + "B";

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getHint("1123","0111"));
    }


}
