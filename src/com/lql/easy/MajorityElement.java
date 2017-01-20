package com.lql.easy;

import java.util.Arrays;

/**
 * Created by LQL on 2016/3/30.
 *
 * 169Ã‚
 *
 */
public class MajorityElement {

    public static int majorityElement(int[] nums){

        Arrays.sort(nums);
        int n = nums.length;
        int i = 0 ;
        for(; i < n / 2 ; i++){

            if(nums[i] == nums[ i + n / 2]){

                return nums[i];
            }
        }
        return nums[i];

    }
}
