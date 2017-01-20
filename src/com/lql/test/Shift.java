package com.lql.test;

/**
 * Created by LQL on 2016/4/2.
 */
public class Shift {

    public static void main(String[] args) {

        int num = 11;
        System.out.println(Integer.toBinaryString(num));
        int num2 = num << 1;
        System.out.println(Integer.toBinaryString(num2));

        int num3 = num & num2;
        System.out.println(Integer.toBinaryString(num3));


        int num4 = num | num2; //或运算
        System.out.println(Integer.toBinaryString(num4));

        int num5 = num ^ num2; //异或运算
        System.out.println(Integer.toBinaryString(num5));
        System.out.println(~num5);

        System.out.println("*******************");
        System.out.println(Integer.toBinaryString(11 & 10));
    }

}
