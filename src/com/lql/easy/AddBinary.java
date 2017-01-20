package com.lql.easy;

/**
 * Created by LQL on 2016/5/29.
 */
public class AddBinary {

    public static String addBinary(String a, String b) {

        StringBuffer tmp = new StringBuffer("");
        int carry = 0;
        int lena = a.length();
        int lenb = b.length();
        if (lena == 0){
            return b;
        }
        if(lenb == 0){
            return a;
        }
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int indexa = lena - 1;
        int indexb =  lenb - 1;
        for (;indexa >= 0&& indexb >= 0;indexa--,indexb--){
            int c1 = charsa[indexa] - '0';
            int c2 = charsb[indexb] - '0';
            int t = c1 + c2 + carry;
            if (t < 2){
                tmp.append(t);
                carry = 0;
            }else if (t == 2){
                tmp.append(0);
                carry = 1;
            }else {
                tmp.append(1);
                carry = 1;
            }
        }
        while (indexa >= 0){
            int c1 = charsa[indexa] - '0';
            int t = c1 + carry;
            if (t < 2){
                tmp.append(t);
                carry = 0;
            }else{
                tmp.append(0);
                carry = 1;
            }
            indexa--;
        }
        while (indexb >= 0){
            int c2 = charsb[indexb] - '0';
            int t = c2 + carry;
            if (t < 2){
                tmp.append(t);
                carry = 0;
            }else {
                tmp.append(0);
                carry = 1;
            }
            indexb--;
        }
        if (carry == 1){
            tmp.append(carry);
        }
        StringBuffer result = new StringBuffer("");

        int len = tmp.length();
        for (int i = len - 1 ; i >= 0;i--){
            char c = tmp.charAt(i);
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }

}
