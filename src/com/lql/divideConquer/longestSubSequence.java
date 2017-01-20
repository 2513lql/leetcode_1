package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/23.
 */
public class longestSubSequence {



    public static int[] findCrossLongestSequence(int[] A , int low , int mid ,int high){

        int left = mid;
        int right = mid;
        int[] res = new int[2];
        if (low == high){
            res[0] = left;
            res[1] = right;
            return res;
        }
        if (A[mid] < A[mid + 1]){
            for (int i = mid - 1;i >= low ; i--){
                if (A[i] <= A[i + 1]){
                    left = i;
                }else{
                    break;
                }
            }
            for (int i = mid + 1; i <= high;i++){
                if (A[i] >= A[i - 1]){
                    right = i;
                }else{
                    break;
                }
            }
        }
        res[0] = left;
        res[1] = right;
        return res;
    }


    public static int[] findLongestSubSequence(int[] A , int low ,int high){

        if (low == high){
            return new int[]{low,high};
        }else{
            int mid = (low + high) / 2;

            int[] left =  findLongestSubSequence(A , low ,mid);
            int[] right = findLongestSubSequence(A,mid + 1 ,high);
            int[] cross = findCrossLongestSequence(A , low , mid , high);
            int leftLength = left[1] - left[0] + 1;
            int rightLength = right[1] - right[0] + 1;
            int crossLength = cross[1] - cross[0] + 1;
            if (leftLength >= rightLength && leftLength >= crossLength){
                return left;
            }else if (rightLength >= leftLength && rightLength >= crossLength){
                return right;
            }else{
                return cross;
            }

        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{8,3,1,5,6,8,9,4,9,7,3,9,0,4,7,8,9};
        int[] res = findLongestSubSequence(A,0,A.length - 1);
        for (int i = res[0] ; i <= res[1] ; i++){
            System.out.println(A[i]);
        }
    }

}
