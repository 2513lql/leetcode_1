package com.lql.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/4/1.
 */
public class NumberOf1Bits{

    public static int hammingWeight(int n) {


            int count = 0;
            while(n != 0){
                n = n & n-1;
                count++;
            }

            return count;



        }

    public static int hammingWeight2(int n) {


        if (n == 0) return 0;

        int count = 0;
        while (n != 0){

            if ((n & 1) == 1) count++;
            n >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight2(11));
    }
}