package com.lql.algorithm.sort;

import sun.java2d.cmm.kcms.KcmsServiceProvider;

/**
 * Created by LQL on 2016/6/16.
 */
public class MergeSort {


    public static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        int k = 0;
        for (int i = p; i <= q; i++) {
            L[k++] = a[i];
        }
        L[n1] = Integer.MAX_VALUE;
        k = 0;
        for (int j = q + 1; j <= r; j++) {
            R[k++] = a[j];
        }
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        k = p;
        while (k <= r) {
            if (L[i] < R[j]) {
                a[k++] = L[i];
                i++;
            } else {
                a[k++] = R[j];
                j++;
            }
        }
    }

    public static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 7, 1, 3, 2, 6};
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
