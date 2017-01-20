package com.lql.easy;

import java.math.BigInteger;
import java.util.DoubleSummaryStatistics;

/**
 * Created by LQL on 2016/5/17.
 */
public class ReverseBits {

    public static int reverseBits(int n) {

        String str = Integer.toBinaryString(n);
        StringBuffer str2 = new StringBuffer("");
        for (int i = 0 ; i < 32 - str.length() ; i++){
            str2.append("0");
        }
        str = str2 + str;
        str2 = new StringBuffer("");

        for (int i = str.length() - 1 ; i >= 0 ; i--){
            str2.append(str.charAt(i));
        }
        int result = 0;
        for (int i = 0 ; i < str2.length() ;i++){

            if (str2.charAt(i) == '1'){
                result += (1 << 31 - i);
            }
        }
        return result;
    }

    public static int reverseBits2(int n) {
        StringBuffer sb = new StringBuffer();
        String s = Integer.toBinaryString(n);
        for(int i = 0; i < 32-s.length(); i++)
            sb.append('0');
        s = sb.toString() + s;
        char[]  c = s.toCharArray();
        int r = 0;
        for(int i = 0; i < 32; i++){
            if(c[i] == '1')
                r += (1 << i);
        }
        return r;
    }

    public static int reverseBits3(int n){

        if (n == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0 ; i < 32 ; i++){
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits3(1));
//        System.out.println();
    }

}
