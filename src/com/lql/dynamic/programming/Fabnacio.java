package com.lql.dynamic.programming;

/**
 * Created by LQL on 2016/7/14.
 */
public class Fabnacio {

    public static int fabnacio(int n){
        int dp[] = new int[n + 1];
        if (n == 1 || n == 2){
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int  i = 1; i <= n; i++){
            if (dp[i] > 0) continue;
            for (int j = 3 ; j <= i ; j++){
                dp[j] = dp[j - 1] + dp[j - 2];
             }
        }
        return dp[n];
    }


    public static int memo_fab(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return fabnacio2(n , dp);
    }

    public static int fabnacio2(int n , int[] dp){

        if (n == 1 || n == 2){
            return dp[n];
        }
        if (dp[n] > 0){
            return dp[n];
        }
        dp[n] = fabnacio2(n - 1 , dp) + fabnacio2(n - 2,dp);
        return dp[n];
    }


    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
//        System.out.println(fabnacio(50));
        System.out.println(memo_fab(30));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
