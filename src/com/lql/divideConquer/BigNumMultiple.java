package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/23.
 */
public class BigNumMultiple {


    public static int[] bigNumMutiple(String a , String b){

        int len = a.length() + b.length();
        int[] res = new int[len];
        int m = a.length();
        int n = b.length();
        char[] a_chars = a.toCharArray();
        char[] b_chars = b.toCharArray();
        int k = -1;
        int carry = 0;
        for (int i = m - 1 ; i >= 0 ; i--){

            int cur_a = a_chars[i] - '0';
            k = m - 1 - i;
            int carry2 = 0;
            carry = 0;
            for (int j = n - 1; j >= 0 ;j--){
                k = (m - 1 - i) + (n - 1 - j);
                int cur_b = b_chars[j] - '0';
                int tmp = (cur_a * cur_b + carry);
                int mol = tmp % 10;
                int tmp2 = mol + carry2 + res[k];
                res[k] = tmp2 % 10;
                carry2 = tmp2 / 10;
                carry = tmp / 10;
            }
            res[k + 1] = carry + carry2;
        }
        int count = 0;
        for (int i = res.length - 1; i >= 0&& res[i] == 0;i--){
            count++;
        }
        if (res.length - count == 0){
            return new int[]{0};
        }
        int[] res2 = new int[res.length - count];

        k = 0;
        for (int i = res.length - 1 - count ; i >= 0;i--){
            res2[k++] = res[i];
        }
        return res2;
    }

    public static void main(String[] args) {
       int[] res = bigNumMutiple("10","10");
        for (int i = 0 ; i < res.length;i++){
            System.out.print(res[i]);
        }
    }
}
