package com.lql.easy;

import java.util.Arrays;

/**
 * Created by LQL on 2016/3/28.
 *
 * 将字母顺序颠倒后仍是一个单词
 * 第242题
 */
public class ValidAnagram {

    public static boolean isAnagram(String s,String t){

        if(s == null || t == null){
            return  false;
        }
        if(s.length() != t.length()){
            return false;
        }


        String stmp = s.toLowerCase();
        String ttmp = t.toLowerCase();

        int[] Sarr = new int[128];
        int[] Tarr = new int[128];

        for(int i = 0 ; i < stmp.length() ;i++){
            char c = s.charAt(i);
            Sarr[c]++;
            char c2 = t.charAt(i);
            Tarr[c2]++;
        }

        return Arrays.equals(Sarr , Tarr);

    }

}
