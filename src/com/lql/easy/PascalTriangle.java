package com.lql.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/5/4.
 *
 * Ñî»ÔÈı½Ç
 *
 */
public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {




        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0){
            return result;
        }
        if (numRows == 1){
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            result.add(cur);
            return result;
        }

        if (numRows == 2){
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            result.add(cur);
            List<Integer> cur2 = new ArrayList<Integer>();
            cur2.add(1);
            cur2.add(1);
            result.add(cur2);
            return result;
        }

        if (numRows >= 3) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            result.add(cur);
            List<Integer> cur2 = new ArrayList<Integer>();
            cur2.add(1);
            cur2.add(1);
            result.add(cur2);
            for (int i = 2; i < numRows ;i++){
                List<Integer> tmp = generateList(result.get(i - 1),i);
                result.add(tmp);
            }
        }
        return result;

    }

    public static List<Integer> generateList(List<Integer> last , int num){

        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i = 0 ; i < last.size() - 1 ;i++){
            int tmp = last.get(i) + last.get(i + 1);
            res.add(tmp);
        }
        res.add(1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
