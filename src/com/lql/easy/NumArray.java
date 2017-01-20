package com.lql.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LQL on 2016/5/30.
 */
public class NumArray {

    Map<Integer,Integer> map = new HashMap<Integer,Integer>();


    public NumArray(int[] nums) {
        map.put(-1,0);
        int sum = 0;
        for (int i = 0 , len = nums.length; i < len;i++){
            sum += nums[i];
            map.put(i,sum);
        }
    }

    public int sumRange(int i, int j) {

        return map.get(j) - map.get(i - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,5));
    }


}
