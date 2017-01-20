package com.lql.easy;

/**
 * Created by LQL on 2016/4/26.
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int len = nums.length;
        int tmp = 0;
        for (int i = 0 ; i < len ;i++){
           if (nums[i] != val){
               nums[tmp] = nums[i];
               tmp++;
           }
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1}, 1));
    }

}
