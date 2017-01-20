package com.lql.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/4/10.
 */
public class HappyNumber {

    public static boolean isHappy(int n) {


        List<Integer> nums = new ArrayList<Integer>();

        int num = 0;
        while(n != 1){
            num = getNewNum(n);
            if(nums.contains(num)){
                return false;
            }
            nums.add(num);
            n = num;
        }

        return true;
    }

    public static int getNewNum(int n){
        int result = 0;

        String str = String.valueOf(n);
        int length = str.length();
        int[] num = new int[length];
        int tmp = 0;
        for(int i = 0 ; i < length; i++){
            tmp = Integer.parseInt(String.valueOf(str.charAt(i)));
            result += Math.pow(tmp,2);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(253));
    }
}
