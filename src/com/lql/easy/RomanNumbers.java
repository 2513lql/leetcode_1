package com.lql.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LQL on 2016/4/1.
 *
 * 罗马数字转为Integer
 * 第13题
 */
public class RomanNumbers {

    public static int romanToInt(String s) {


        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        int sum = 0;
        int i = 0;
        for(; i < s.length() - 1 ; i++){

            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            int c1Num = map.get(String.valueOf(c1));
            int c2Num = map.get(String.valueOf(c2));

            if(c1Num >= c2Num){
                sum += c1Num;
            }else{
                sum -= c1Num;
            }
        }
        char c = s.charAt(i);
        int cNum = map.get(String.valueOf(c));
        sum += cNum;
        return sum;
    }

}
