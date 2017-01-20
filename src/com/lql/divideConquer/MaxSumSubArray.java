package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/22.
 */
public class MaxSumSubArray {


    public static int[] findMaxSumCrossMid(int[] A, int left, int mid, int right) {

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int low = mid;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                low = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int high = mid + 1;
        for (int i = mid + 1; i <= right; i++) {
            sum += A[i];
            if (sum > rightSum) {
                rightSum = sum;
                high = i;
            }
        }
        int[] max = new int[3];
        max[0] = low;
        max[1] = high;
        max[2] = leftSum + rightSum;
        return max;
    }


    public static int[] findMaxSubArray(int[] A, int low, int high) {

        if (low == high) {
            return new int[]{low, high, A[low]};
        } else {
            int mid = (low + high) / 2;
            int[] left = findMaxSubArray(A, low, mid);
            int[] right = findMaxSubArray(A, mid + 1, high);
            int[] cross = findMaxSumCrossMid(A, low, mid, high);
            if (left[2] > right[2] && left[2] > cross[2]) {
                return left;
            }
            else if (right[2] > left[2] && right[2] > cross[2])
                return right;
            else
            return cross;
        }
    }

    /**
     * Ëã·¨µ¼ÂÛ p42  4.1-5
     * @param A
     * @param low
     * @param high
     * @return
     */
    public static int[] findMaxSubArray2(int[] A , int low ,int high){

        int max = 0 ,sum = 0;
        int left = low , right = low , curLow = low;
        for (int i = low ; i < high; i++){
            sum += A[i];
            if (sum > max){
                right = i;
                left = curLow;
                max = sum;
            }else if (sum < 0){
                curLow = i + 1;
                sum = 0;
            }
        }
        if (max > 0){
            return new int[]{left,right,max};
        }
        return null;
    }

    public static void main(String[] args) {
        long beign = System.currentTimeMillis();
        int[] A = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,-15,-4,7};
        int[] res = findMaxSubArray2(A,0,A.length - 1);
        long end = System.currentTimeMillis();
        for (int i = 0 ; i < res.length ;i++){
            System.out.println(res[i]);
        }
    }

}
