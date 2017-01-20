package com.lql.easy;

/**
 * Created by LQL on 2016/4/20.
 */
public class PowerOfFour {

    public static boolean isPowerOfFour(int num) {

        String tmp = Integer.toBinaryString(num);
        char c = tmp.charAt(0);
        if(c != '1'){
            return false;
        }
        tmp = tmp.substring(1);

        if (tmp.contains("1")){
            return false;
        }
        if (tmp.length() % 2 != 0){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(2));
    }
}
