package com.lql.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LQL on 2016/8/2.
 */
public class LCS {


    public static Map<String,Object> LCS_Length(int[] X,int[] Y){

        Map<String,Object> map = new HashMap<String,Object>();

        int m = X.length;
        int n = Y.length;
        int c[][] = new int[m + 1][n + 1];
        int b[][] = new int[m + 1][n + 1];
        for (int i = 0;i < m ;i++){
            for (int j = 0 ; j < n ;j++){
                if (X[i] == Y[j]){
                    c[i + 1][j + 1] = c[i][j]+1;
                    b[i + 1][j + 1] = 2;
                }else if(c[i][j + 1] >= c[i + 1][j]){
                    c[i + 1][j + 1] = c[i][j + 1];
                    b[i + 1][j + 1] = 1;
                }else{
                    c[i + 1][j + 1] = c[i + 1][j];
                    b[i + 1][j + 1] = 3;
                }
            }
        }
        map.put("c",c);
        map.put("b",b);
        return map;
    }

   public static void LCS_Print(int[] X , int[][] b,int m,int n){
       if (m == 0 || n == 0){
           return;
       }
       if (b[m][n] == 2){
           LCS_Print(X,b,m - 1, n - 1);
           System.out.print(X[m - 1] + ",");
       }else if (b[m][n] == 1){
           LCS_Print(X,b, m - 1,n);
       }else{
           LCS_Print(X,b,m,n - 1);
       }
    }

    public static void main(String[] args) {
        int[] X = {2,3,4,2,5};
        int[] Y = {3,1,3,5,6,8};
        Map<String,Object>map = LCS_Length(X,Y);
        int [][]c =(int[][]) map.get("c");
        int max = 0;
        for (int i = 1;i < c.length;i++){
            for(int j = 1 ; j < c[i].length;j++){
                if (c[i][j]  > max){
                    max =  c[i][j];
                }
            }
        }
        int [][]b =(int[][]) map.get("b");
        LCS_Print(X,b,X.length,Y.length);

    }

}
