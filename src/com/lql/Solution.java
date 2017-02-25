package com.lql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LQL on 2017/2/23.
 */
public class Solution {

    //集合中保存已经出现过的字符串
    public static Set<String> used = new HashSet<>();

    public static List<List<String>> jieLong(String start,String end,List<String> dict){

        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        current.add(start);
        find(start.toCharArray(),end,dict,0,result,current);
        return result;
    }

    //current表示当前找到的字符串序列的集合
    private static void find(char[] start, String end, List<String> dict, int positionToChange, List<List<String>> result, List<String> current) {

            //如果当前字符串集合长度大于结果集中的某个序列的长度，则当前的肯定不是
            if (!result.isEmpty() && current.size() > result.size()){
                return;
            }

            for (int pos = positionToChange;pos < start.length;pos++){
                char beforeChange = ' ';
                for (int i = 'a';i <='z';i++){
                    //防止同字母被替换
                    if (start[pos] == i){
                        continue;
                    }
                    beforeChange = start[pos];
                    start[pos] = (char) i;

                    //如果字符串在集合中已经出现过就跳过本次循环
                    if (!used.isEmpty() && used.contains(start.toString())){
                        start[pos] = beforeChange;
                        continue;
                    }

                    if (start.toString() == end){
                        current.add(start.toString());
                        if (!result.isEmpty()){

                            //如果本次循环得到的字符串集合的size小于结果集中的第一个，则之前的结果集肯定不符合最短的要求，清空之前的结果集，并把current放入结果集
                            if (current.size() < result.get(0).size()){
                                result.clear();
                                result.add(current);
                            }else if (current.size() == result.get(0).size()){
                                result.add(current);
                            }
                        }else{ //之前的结果集是空，则将current保存到结果集
                                result.add(current);
                        }
                        //完成一个序列，把前面的end弹出
                        if (current.size() - 1 >= 0) {
                            current.remove(current.size() - 1);
                        }
                        return;
                    }
                    if (dict.contains(start.toString()) && start.toString() != end){
                        current.add(start.toString());
                        used.add(start.toString());
                        find(start,end,dict,0,result,current);
                        if (current.size() - 1 >= 0) {
                            used.remove(current.get(current.size() - 1));
                            current.remove(current.size() - 1);
                        }
                        if (!current.isEmpty()){
                            start = current.get(current.size() - 1).toCharArray();
                        }else{
                            start[pos] = beforeChange;
                        }
                    }else {
                        start[pos] = beforeChange;
                    }
                }

            }
        return;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        List<List<String>> res = jieLong(start,end,dict);
        for (List<String> cur : res){
            System.out.println(cur.toString());
        }
    }
}
