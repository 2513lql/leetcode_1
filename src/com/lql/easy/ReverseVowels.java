package com.lql.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/4/27.\
 *
 *
 * 将一个字符串中的原音字符串逆序
 *
 */
public class ReverseVowels {


    public static String reverseVowels(String s) {

        List<Character> list = new ArrayList<Character>();
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');

        int len = s.length();

        char[] chars = s.toCharArray();

        for (int i = 0 , j = len - 1 ; i < j ;){

            char pre = chars[i];
            char post = chars[j];
            if (!list.contains(pre)){
                i++;
            }
            if (!list.contains(post)){
                j--;
            }
            if (list.contains(pre) && list.contains(post)) {
                char tmp = pre;
                chars[i] = post;
                chars[j] = tmp;
                i++;
                j--;
            }
        }

        StringBuffer string = new StringBuffer();
        for (char c : chars){
            string.append(c);
        }


        return string.toString();
    }


    public static void main(String[] args) {
        String str = "AEIOUaeiou";


        reverseVowels("hello");
    }

}
