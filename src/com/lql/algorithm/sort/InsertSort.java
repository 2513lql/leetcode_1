package com.lql.algorithm.sort;

/**
 * Created by LQL on 2016/6/14.
 */
public class InsertSort {

    public static int[] insertSort(int[] a) {

        if (a.length <= 1) {
            return a;
        }
        int len = a.length, key, i;
        for (int j = 1; j < len; j++) {//逐个遍历数组上的元素
            key = a[j];
            i = j - 1;
            while (i >= 0 && a[i] < key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
        return a;
    }

    


    public static void insertSortBinary(int[] A, int p, int r) {

        for (int i = 1; i <= r; i++) {

            int key = A[i];
            int j = i - 1;
            int pos = binarySearch(A, 0 , j, key);
            if (pos != -1) {
                for (int k = j ; k >= pos; k--) {
                    A[k + 1] = A[k];
                }
                A[pos] = key;
            }
        }
    }


    public static int search(int[] A, int p, int r, int value) {
        for (int i = p; i <= r; i++) {
            if (A[i] > value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] A, int p, int r, int value) {

        if (p == r && A[p] > value) {
            return p;
        }

        if (p < r) {
            int q = (p + r) / 2;
            if (A[q] >= value) {
                binarySearch(A, p, q, value);
                return search(A, p, q, value);
            } else {
                binarySearch(A, q + 1, r, value);
                return search(A,q + 1,r,value);
            }
        }

        return -1;
    }

    public static int[] add(int a[], int b[]) {

        int carry = 0;
        int[] c = new int[a.length + 1];
        int len = c.length;
        for (int i = len - 1; i > 0; i--) {
            int tmp = a[i - 1] + b[i - 1] + carry;
            if (tmp >= 2) {
                carry = 1;
                c[i] = tmp - 2;
            } else {
                carry = 0;
                c[i] = tmp;
            }
        }
        c[0] = carry;
        return c;
    }


    public static void main(String[] args) {

//       int[] a = insertSort(new int[]{1,2,3,4});
//        for (int i = 0 ; i < a.length;i++){
//            System.out.println(a[i]);
//        }
        int[] A = new int[]{3,3,2,1};

         insertSortBinary(A,0,A.length - 1);
        for (int i = 0 ; i < A.length;i++){
            System.out.println(A[i]);
        }
//        int[] a = new int[]{1, 1, 1};
//        int[] b = new int[]{1, 0, 1};
//        int[] c = add(a, b);
//        for (int i = 0; i < c.length; i++) {
//            System.out.print(c[i]);
//        }
    }

}
