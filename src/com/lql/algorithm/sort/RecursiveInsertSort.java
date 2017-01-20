package com.lql.algorithm.sort;

/**
 * Created by LQL on 2016/6/21.
 */
public class RecursiveInsertSort {




    public static void insertSort(int[] A , int q , int r){

        for (int i = q ; i <= r; i++){
            int key = A[i];
            int j = i - 1;
            for (; j >= 0 && A[j] > key;j--){
                A[j + 1] = A[j];
            }
            A[j + 1] = key;
        }
    }

    public static void recursiveInsert(int A[],int q,int r){

        if (q < r){
            r--;
            recursiveInsert(A,q,r);
            insertSort(A,q,r);
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{3,2,4,1,6};
        recursiveInsert(A,0,A.length);
        for (int i = 0 ; i < A.length;i++){
            System.out.println(A[i]);
        }
    }



}
