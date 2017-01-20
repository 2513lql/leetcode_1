package com.lql.algorithm.sort;

import java.util.Random;

/**
 * Created by LQL on 2016/7/1.
 */
public class QuickSort {



    public static int randomPartition(int[] A , int p ,int r){
        Random random = new Random();
        int tmp = random.nextInt(r) % (r - p + 1) + p;
        swap(A,tmp,r);
        return partition(A,p,r);
    }

    public static int partition(int[] A ,int p , int r){

        int i = p - 1;
        int key = A[r];
        int j = p;
        for (;j <= r - 1; j++){
            if (A[j] < key){
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i + 1,r);
        return i + 1;
    }

    public static void quickSort(int[] A,int p ,int r){

        if (p < r){
            int q = randomPartition(A,p,r);
            quickSort(A,p,q - 1);
            quickSort(A,q + 1,r);
        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }




    public static void main(String[] args) {
        int[] A = new int[]{2,5,2,6,9,5,3,7,12,56};
        quickSort(A,0,9);
        for (int i = 0 ; i < A.length;i++){
            System.out.println(A[i]);
        }
    }
}
