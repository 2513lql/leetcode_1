package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/24.
 */
public class GameSchedule {

    private static int[][] schedule = new int[100][100];

    public static void gameSchedule(int k){

        int tmp;
        int n = 2; // k = 1����������ѡ�ֵ��ճ̿���ֱ�����
        schedule[1][1] = 1;schedule[1][2] = 2;
        schedule[2][1] = 2;schedule[2][2] = 1;
        for (int t = 2; t <= k; t++){
            tmp = n;
            n = n * 2;
            for (int i = tmp + 1 ; i <= n ;i++){ //ʹ�����Ͻ�Ԫ�����������½�
                for (int j = 1; j <= tmp;j++){
                    schedule[i][j] = schedule[i - tmp][j] + tmp; //�������Ͻ�Ԫ�������½�Ԫ�ع�ϵ
                }
            }
            for (int i = 1 ; i <= tmp; i++){ //�����½�Ԫ�س������Ͻ�
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
