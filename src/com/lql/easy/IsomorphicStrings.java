package com.lql.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by LQL on 2016/5/12.
 *
 * ×Ö·û´®Í¬¹¹
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {


        if (s.length() != t.length()){
            return false;
        }

        Set<Character> sets = new HashSet<Character>();
        Set<Character> sett = new HashSet<Character>();
        Map<Character , Integer> maps = new HashMap<Character,Integer>();
        Map<Character , Integer> mapt = new HashMap<Character,Integer>();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0 ; i < chars.length;i++){
            char tmps = chars[i];
            char tmpt = chart[i];
            boolean bs = sets.add(tmps);
            boolean bt = sett.add(tmpt);
            if (bs != bt){
                return false;
            }
            if (bs == false){
                Integer is = maps.get(tmps);
                Integer it = mapt.get(tmpt);
                if (is != it){
                    return false;
                }
            }
            maps.put(tmps,i);
            mapt.put(tmpt,i);
        }
        return true;
    }


    public static boolean isIsomorphic2(String s, String t) {

        if(s.length() != t.length()){
            return  false;
        }

        char[] sArr = s.toCharArray();
        char[] tAtt = t.toCharArray();

        char[] chars = new char[256];
        char[] chart = new char[256];
        for (int i = 0 ;i < s.length();i++){
            char cs = sArr[i];
            char ct = tAtt[i];
            if (chars[cs] == 0 && chart[ct] == 0){
                chars[cs] = ct;
                chart[ct] = cs;
            }else{
                if (chars[cs] != ct || chart[ct] != cs){
                    return false;
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic2("asa","asa"));
    }


}
