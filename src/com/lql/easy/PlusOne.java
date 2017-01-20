package com.lql.easy;

/**
 * Created by LQL on 2016/4/28.
 */
public class PlusOne {


    public static int[] plusOne(int[] digits) {


        int carry = 1;
        for (int i = digits.length - 1 ; i >= 0 ;i--) {

            digits[i] += carry;
            if (digits[i] <= 9){
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }


}
