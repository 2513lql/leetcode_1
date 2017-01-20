package com.lql;

/**
 * Created by LQL on 2016/4/10.
 */
public class PowerOf2 {

    public static boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(-5));

        System.out.println(Integer.toBinaryString((-5 >> 1)));
    }
}
