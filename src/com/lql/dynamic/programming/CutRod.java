package com.lql.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LQL on 2016/7/12.
 */
public class CutRod {

    public static int cutRod(int[] p ,int n){

        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1 ;i <= n ;i++){
            q = max(q,p[i - 1] + cutRod(p,n - i));
        }
        return q;
    }


    /**
     * 自顶向下法
     * @param p
     * @param n
     * @return
     */
    private static int memoizedCutRod(int[] p , int n){

        int[] r = new int[n + 1];
        for (int i = 0 ; i < n + 1; i++){
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedCutRodAux(p, n, r);
    }

    private static int memoizedCutRodAux(int[] p, int n, int[] r) {

        if (r[n] >= 0){
            return r[n];
        }
        int q = Integer.MIN_VALUE;
        if (n == 0){
            return 0;
        }else{
            for (int i = 1 ; i <= n ;i++){
                q = max(q , p[i - 1] + memoizedCutRodAux(p, n - i,r));
            }
        }
        r[n] = q;
        return q;
    }

    private static int max(int q, int i) {
        return q > i ? q : i;
    }


    /**
     * 自底向上法
     * @param p
     * @param n
     * @return
     */
    public static int bottomUpCutRod(int[] p , int n){

        int[] r = new int[n + 1];
        r[0] = 0;
        for (int i = 1 ; i <= n ;i++){
            int q = Integer.MIN_VALUE;
            for (int j = 1 ; j <= i ; j++){
                q = max(q , p[j] + r[i - j]);
            }
            r[i] = q;
        }
        return r[n];
    }

    public static Map<String,Integer[]> extendBottomCutRod(int[] p , int n){
        Integer []r = new Integer[n + 1];
        Integer []s = new Integer[n + 1];
        r[0] = 0;
        for (int  i = 1 ;i < n + 1;i++){
            r[i] = Integer.MIN_VALUE;
        }
        for (int i = 1 ; i <= n ; i++){
            int q = Integer.MIN_VALUE;
            for (int j = 1 ; j <= i;j++){
                if (q < p[j] + r[j - i]){
                    q = p[j] + r[j - i];
                    s[i] = j;
                }
            }
            r[i] = q;
        }
        Map<String , Integer[]> map = new HashMap<String,Integer[]>();
        map.put("r",r);
        map.put("s",s);
        return map;
    }

    public static void main(String[] args) {
        int[] p = {1,5,8,9,10,17,17,20,24,30};
//        System.out.println(cutRod(p , 10));
        System.out.println(memoizedCutRod(p , 4));
    }
}
