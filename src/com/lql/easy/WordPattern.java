package com.lql.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LQL on 2016/5/16.
 */
public class WordPattern {


    public static boolean wordPattern(String pattern, String str) {

        char[] patterns = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (patterns.length != strings.length){
            return false;
        }
        Map<Character , Integer> mapPattern = new HashMap<Character,Integer>();
        Map<String , Integer> mapStr = new HashMap<String,Integer>();
        for (int i = 0 ; i < patterns.length ; i++){
            if (mapPattern.get(patterns[i]) == null && mapStr.get(strings[i]) == null){
                mapPattern.put(patterns[i],i);
                mapStr.put(strings[i],i);
            }else if (mapPattern.get(patterns[i]) != null && mapStr.get(strings[i]) != null){
                int pindex = mapPattern.get(patterns[i]);
                int sindex = mapStr.get(strings[i]);
                if (pindex != sindex){
                    return false;
                }else {
                    mapPattern.put(patterns[i], i);
                    mapStr.put(strings[i], i);
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("caa","cat dog dog"));
    }

}
