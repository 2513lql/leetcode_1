package com.lql.easy;

/**
 * Created by LQL on 2016/5/6.
 */
public class Factorial {

    public static int trailingZeroes(int n) {


        int count = 0;
        while (n != 0){

            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(trailingZeroes(10));
    }
}
