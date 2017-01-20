package com.lql.easy;

/**
 * 10 进制转 16 进制
 * Created by LQL on 2016/12/29.
 */
public class ToHex {


    public static String toHex(int num) {


        String res = "";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        if (num == 0) return "0";

        while (num != 0){
            int index = num & 15;
            res = map[index] + res;
            num = (num >>> 4);
        }
        return res;
    }

    /**
     * 转七进制
     * @param num
     * @return
     */
    public static String to2(int num){
        String res = "";
        if (num == 0) return "0";
        while (num != 0){
            res = (num & 1) + res;
            num = num >>> 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(to2(10));
    }
}

