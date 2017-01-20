package com.lql.algorithm.sort;

import java.util.Random;

/**
 * Created by LQL on 2016/7/1.
 */
public class PriorityQueue{


    private static int MAX_SIZE = 101;
    private static int heapSize = 0;
    private static int[] A = new int[MAX_SIZE];

    private static int heaPMaxMum(PriorityQueue priorityQueue){
        if (priorityQueue.heapSize == 0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return priorityQueue.A[1];
    }

    private static int heapExtractMax(PriorityQueue priorityQueue){
        if (priorityQueue.heapSize == 0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int max = priorityQueue.A[1];
        priorityQueue.A[1] = priorityQueue.A[priorityQueue.heapSize];
        priorityQueue.heapSize--;
        maxHeap(priorityQueue,1);
        return max;
    }

    private static void maxHeap(PriorityQueue priorityQueue,int i) {

        int left = 2 * i;
        int right = 2 * i + 1;
        int change = i;
        if (left <= priorityQueue.heapSize && priorityQueue.A[left] > A[i]){
            change = left;
        }

        if (right <= priorityQueue.heapSize && priorityQueue.A[right] > priorityQueue.A[change]){
            change = right;
        }
        if (change != i){
            swap(priorityQueue,i,change);
            maxHeap(priorityQueue,change);
        }
    }

    private static void swap(PriorityQueue priorityQueue, int i, int change) {

        int tmp = priorityQueue.A[i];
        priorityQueue.A[i] = priorityQueue.A[change];
        priorityQueue.A[change] = tmp;
    }

    private static void heapIncreaseKey(PriorityQueue priorityQueue , int i , int key){
        if (priorityQueue.A[i] > key){
            try {
                throw new Exception("new key is smaller than current key");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        priorityQueue.A[i] = key;
        int parent = i / 2;
        while (i > 1 && priorityQueue.A[parent] < priorityQueue.A[i]){
            swap(priorityQueue,i,parent);
            i = parent;
            parent = i / 2;
        }
    }

    private static void maxHeapInsert(PriorityQueue priorityQueue,int key){

        priorityQueue.heapSize = priorityQueue.heapSize + 1;
        priorityQueue.A[heapSize] = Integer.MIN_VALUE;
        heapIncreaseKey(priorityQueue,priorityQueue.heapSize,key);
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        for (int i = 0 ; i < 7 ; i++){
            Random random = new Random();
            int key = random.nextInt(50);
            System.out.println(key);
            maxHeapInsert(priorityQueue, key);
        }
        System.out.println("***********");
        System.out.println(heapExtractMax(priorityQueue));
        System.out.println(heaPMaxMum(priorityQueue));

    }


}




