package com.lql.easy;

/**
 * Created by LQL on 2016/4/20.
 */
public class HouseRobber {

    public static int rob(int[] nums) {

        int len = nums.length;
        if (nums == null) {
            return 0;
        }
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return max(nums[0] , nums[1]);
        }
        if (len == 3){
            return max(nums[0] + nums[2] , nums[1]);
        }
        nums[2] += nums[0];
        for (int i = 3 ; i < len ;i++){
            if (nums[i - 2] > nums[i - 3]){
                nums[i] += nums[i - 2];
            }
            else {
                nums[i] += nums[i - 3];
            }
        }

        return max(nums[len - 1] , nums[len - 2]);
    }

    public static int max(int a , int b){

        return a > b ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 4, 5, 1,3,6,1,7,8}));
    }

}
