package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/24.
 */
public class GameSchedule {

    private static int[][] schedule = new int[100][100];

    public static void gameSchedule(int k){

        int tmp;
        int n = 2; // k = 1，两个参赛选手的日程可以直接求得
        schedule[1][1] = 1;schedule[1][2] = 2;
        schedule[2][1] = 2;schedule[2][2] = 1;
        for (int t = 2; t <= k; t++){
            tmp = n;
            n = n * 2;
            for (int i = tmp + 1 ; i <= n ;i++){ //使用左上角元素填充填充左下角
                for (int j = 1; j <= tmp;j++){
                    schedule[i][j] = schedule[i - tmp][j] + tmp; //根据左上角元素与左下角元素关系
                }
            }
            for (int i = 1 ; i <= tmp; i++){ //将左下角元素抄到右上角
                for (int j = tmp + 1 ; j <= n ;j++){
                    schedule[i][j] = schedule[i + tmp][j - tmp];
                }
            }

            for (int i = tmp + 1 ; i <= n;i++){
                for (int j = tmp + 1 ; j <= n ;j++){
                    schedule[i][j] = schedule[i - tmp][j - tmp];
                }
            }
        }

        for (int i = 1 ;i <= n ;i++){
            for (int j = 1 ; j <= n;j++){
                System.out.print(schedule[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        gameSchedule(3);
    }

}
