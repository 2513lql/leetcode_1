package com.lql.easy;

/**
 * Created by LQL on 2016/5/8.
 * 回文数
 * 数字倒序后与原来一样
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {


        if (x < 0){
            return false;
        }

        int len = String.valueOf(x).length();

        int highTmp = x;
        int lowTmp = x;
        for (int i = 1 ; i <= len / 2;i++){

            int highPow = (int)Math.pow(10,len-i);
            int pre = highTmp / highPow;
            highTmp = highTmp % highPow;

            int post = lowTmp % 10;
            lowTmp = lowTmp / 10;

            if (pre != post){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(3));
    }

}
