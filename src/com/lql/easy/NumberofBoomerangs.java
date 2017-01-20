package com.lql.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LQL on 2016/12/18.
 */
public class NumberofBoomerangs {

    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> resSet = new HashMap<>();
        int count = 0;
        for (int i = 0 ; i < points.length;i++){
            for (int j = 0;j < points.length;j++){
                if (i == j){
                    continue;
                }
                int d = getDistance(points[i],points[j]);
                resSet.put(d,resSet.getOrDefault(d,0) + 1);
            }
            for (int val : resSet.values()){
                count += val * (val - 1);
            }
            resSet.clear();
        }
        return count;
    }



    public static int getDistance(int[] a,int[] b){
        return (int)(Math.pow(a[1] - b[1],2) + Math.pow(a[0] - b[0],2));
    }


    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));


    }
}
