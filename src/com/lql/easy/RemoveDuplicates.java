package com.lql.easy;

/**
 * Created by LQL on 2016/4/28.
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int res = 1;

        for (int i = 1 ; i < nums.length ;i++){

            if (nums[i] != nums[i - 1]){
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
