package com.lql.easy;

/**
 * Created by LQL on 2016/5/10.
 */
public class MergeSortedArray {


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int len = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0){

            if (nums1[m] > nums2[n]){
                nums1[len] = nums1[m];
                len--;
                m--;
            }else {
                nums1[len] = nums2[n];
                len--;
                n--;
            }
        }
        while (n>=0){
            nums1[len--] = nums2[n--];
        }


    }

    public static void main(String[] args) {
        int[] nums1 = new int[7];
        nums1[0] = 1;
        nums1[1] = 2 ;
        nums1[2] = 3;
        nums1[4] = 4;
        merge(nums1,4,new int[]{2,3,4},3);
    }
}
