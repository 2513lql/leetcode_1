package com.lql.easy;

import java.util.*;

/**
 * Created by LQL on 2016/3/29.
 * µÚ217Ìâ
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length;i++){
            if(map.get(nums[i]) != null){
                return true;
            }
            map.put(nums[i],nums[i]);

        }
            return false;
    }

    public static boolean containsDuplicate2(int[] nums){

        if(nums == null || nums.length <= 1){

            return false;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1 ;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;

    }
}
