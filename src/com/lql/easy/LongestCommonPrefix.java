package com.lql.easy;

/**
 * Created by LQL on 2016/5/29.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {


        StringBuffer commonPrefix = new StringBuffer("");

        if (strs.length == 0){
            return commonPrefix.toString();
        }
        String first = strs[0];
        int lenFirst = first.length();
        int len = strs.length;
        if (len == 1){
            return first;
        }
        for (int i = 0 ; i < lenFirst;i++){
            char c = first.charAt(i);
            for (int j = 1 ; j < len;j++){
                String tmp = strs[j];
                if (tmp.length() - 1 < i){
                    return commonPrefix.toString();
                }
                else if (tmp.charAt(i) != c){
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(c);
        }
        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"12346","123","12","12"};
        System.out.println(longestCommonPrefix(strs));
    }
}
