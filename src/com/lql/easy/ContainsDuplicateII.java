package com.lql.easy;

import java.util.HashSet;

/**
 * Created by LQL on 2016/5/9.
 */
public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums , int k){


        if (nums == null || nums.length ==0){
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length ; i++){
            if (!set.add(nums[i])){

                if (i < k){
                    return true;
                }
                for (int j = i - k;j < i;j++){
                    if (nums[j] == nums[i]){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{3,2,1,3},2));
    }
}
