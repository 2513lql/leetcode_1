package com.lql.easy;

/**
 * Created by LQL on 2016/4/9.
 */
public class UglyNumber {

    public static boolean isUgly(int num) {


        if(num <= 0){
            return false;
        }

        if(num <= 5){
            return true;
        }
        boolean flag = false;
        while(num > 5){
            flag = false;
            if(num % 2 ==0){
                num = num / 2;
                flag = true;
            }
            if(num % 3 == 0){
                num = num / 3;
                flag = true;
            }
            if(num % 5 == 0){
                num = num / 5;
                flag = true;
            }
            if (flag == false){
                break;
            }
        }

        if (num > 5){
            return false;
        }

        return true;
    }
}
