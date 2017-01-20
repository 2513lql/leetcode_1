package com.lql.easy;

/**
 * Created by LQL on 2016/3/29.
 *
 * µÚ171
 *
 */
public class ExcelNumber {

    public static int titleToNumber(String s){


        int len = s.length();

        int sum = 0;

        for(int i = 0 ; i < len ;i++){

            char c = s.charAt(i);
            int cNum = c - '@';
            double tmp =cNum * Math.pow(26,(len - 1 - i));
            int res = (int) tmp;
            sum += res;
        }
        return sum;


    }

}
