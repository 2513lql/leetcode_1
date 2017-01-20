package com.lql.easy;

/**
 * Created by LQL on 2016/4/11.
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {

        int profit = 0;

        if(prices == null || prices.length <= 1){
            return profit;
        }

        int bought = prices[0];
        for(int i = 1 ; i < prices.length ;i++){

            if(prices[i] < bought){
                bought = prices[i];
                continue;
            }
            if (prices[i] - bought > profit){
                profit = prices[i] - bought;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{4,2,3,1}));
    }
}
