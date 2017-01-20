package com.lql.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  找到数组中的值为K的子数组
 * Created by LQL on 2016/12/30.
 */
public class SubArrayOfK {

    public static void findSubArray(int[] arr, int sum){

        int start = 0,i=0;
        int cur_sum = 0;
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (; i < arr.length;i++){
            while (cur_sum > sum && start < i){
                cur_sum = cur_sum - arr[start];
                start++;
            }
            if (cur_sum == sum){
                System.out.println("sub arrat : ("+start + " , " + (i - 1) + ")");
                cur_sum -= arr[start];
                starts.add(start);
                ends.add(i);
                start++;
            }
            if (cur_sum < sum){
                cur_sum += arr[i];
            }
        }

    }

    public static void main(String[] args) {
        int[] INPUT = {5, 6, 1, -2, -4, 3, 1, 5};
        printSubarrays(INPUT, 5);
    }

    private static void printSubarrays(int[] input, int k) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<Integer> initial = new ArrayList<Integer>();
        initial.add(-1);
        map.put(0, initial);
        int preSum = 0;

        // Loop across all elements of the array
        for(int i=0; i< input.length; i++) {
            preSum += input[i];
            // If point where sum = (preSum - k) is present, it means that between that
            // point and this, the sum has to equal k
            if(map.containsKey(preSum - k)) {   // Subarray found
                List<Integer> startIndices = map.get(preSum - k);
                for(int start : startIndices) {
                    System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
                }
            }

            List<Integer> newStart = new ArrayList<Integer>();
            if(map.containsKey(preSum)) {
                newStart = map.get(preSum);
            }
            newStart.add(i);
            map.put(preSum, newStart);
        }
    }

//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8,9};
//        findSubArray(arr,10);
//    }

}
