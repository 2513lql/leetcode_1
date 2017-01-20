package com.lql.algorithm.sort;

/**
 * Created by LQL on 2016/6/25.
 */
public class HeapSort {


    public static void maxHeap(int[] A , int i , int heapSize){

        int l = 2 * i;
        int r = 2 * i + 1;
        int largest;
        if (l <= heapSize && A[l] > A[i]){
            largest = l;
        }else{
            largest = i;
        }
        if (r <= heapSize && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i){
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            maxHeap(A,largest,heapSize);
        }
    }

    public static void buildHeap(int[] A , int heapSize){
        for (int i = A.length / 2 ; i >= 1 ; i--){
            maxHeap(A,i,heapSize);
        }
    }

    public static void heapSort(int []A ,int heapSize){

        buildHeap(A,heapSize);

        int i = heapSize;
        while(i >= 2){
            swap(A,1,i);
            i--;
            maxHeap(A,1,i);
        }
    }

    private static void swap(int[] A, int i, int heapSize) {
        int tmp = A[i];
        A[i] = A[heapSize];
        A[heapSize] = tmp;
    }


    public static void main(String[] args) {
        int[] A = new int[]{-1,2,4,8,6,5};
        heapSort(A,5);
        for (int i = 1 ; i <= 5;i++){
            System.out.print(A[i] + " ");
        }
    }
}
