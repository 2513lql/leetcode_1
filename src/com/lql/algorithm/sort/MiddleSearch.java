package com.lql.algorithm.sort;

/**
 * Created by LQL on 2016/6/22.
 */
public class MiddleSearch {

    public static int middleSearch(int[] A,int left,int right,int value){

        if (left <= right){
            int middle = (left + right) / 2;
            if (A[middle] == value){
                return middle;
            }else if (A[middle] > value){
                return middleSearch(A,left,middle - 1,value);
            }else {
                return middleSearch(A, middle + 1, right, value);
            }
        }else{
            return - 1;
        }

    }


    public static int search(int[] A , int p , int r,int value){
        for (int i = p ; i <= r; i++){
            if (A[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static int binary(int[] A , int p,int r, int value){

//        if (p == r && A[p] == value){
//            return p;
//        }
        if (p <= r){
            int q = (p + r) / 2;
            if (A[q] == value){
                return q;
            }
            else if (A[q] > value){
                binary(A,p,q - 1,value);
                return search(A,p,q,value);
            }else{
                binary(A,q + 1,r,value);
                return search(A , q + 1 , r , value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,5};
        System.out.println(binary(A,0,3,5));
    }

}
