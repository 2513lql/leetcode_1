package com.lql.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/5/8.
 */
public class PascalTriangle2 {

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex == 0){
            result.add(1);
            return result;
        }
        if (rowIndex == 1){
            result.add(1);
            result.add(1);
            return result;
        }
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        last.add(1);
        int i = 0;
        for (i = 1 ; i < rowIndex;i++){
            result.add(1);
            for (int j = 0; j < last.size() - 1 ;j++){
                int tmp = last.get(j) + last.get(j + 1);
                result.add(tmp);
            }
            result.add(1);
            last.clear();
            last.addAll(result);
            result.clear();
        }
        return last;
    }


    public static void main(String[] args) {
        List<Integer> res = getRow(5);
        System.out.println(res);
    }
}
