package com.lql.easy;

/**
 * Created by LQL on 2016/5/30.
 */
public class ImplementstrStr {

    public static int strStr(String haystack, String needle) {

        int index = -1;

        int lenh = haystack.length();
        int lenn = needle.length();
        if (lenn == 0){
            return 0;
        }
        char[] charsh = haystack.toCharArray();
        char[] charsn = needle.toCharArray();
        int i ,j;
        for (i = 0 ,j =0 ; i < lenh && j < lenn; i++){

            char c1 = charsh[i];
            char c2= charsn[j];
            if (c1 == c2 && j == 0){
                index = i;
                j++;
            }else if (c1 == c2){
                j++;
            }else{
                j = 0;
                if (index != -1) {
                    i = index;
                }
                index = -1;
            }
        }
        if (j < lenn){
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(strStr("ppi","pi"));
    }
}
