package com.lql.easy;

import com.lql.easy.com.lql.util.BoardUtil;

import java.util.Map;

/**
 * Created by LQL on 2016/5/9.
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {


        int[] num = new int[10];

        for (int i = 0 ; i < 9 ;i++){
            for (int j = 0 ; j < 9 ;j++){
                if (board[i][j]!='.') {
                    int cur = board[i][j] - 48;
                    num[cur]++;
                }
            }
            for (int k = 1 ; k < 10 ;k++){
                if (num[k] > 1){
                    return false;
                }
                num[k] = 0;
            }
        }

        for (int i = 0 ; i < 9 ;i++){
            for (int j = 0 ; j < 9 ;j++){
                if (board[j][i]!='.')  {
                    int cur = board[j][i] - 48;
                    num[cur]++;
                }
            }
            for (int k = 1 ; k < 10 ;k++){
                if (num[k] > 1){
                    return false;
                }
                num[k] = 0;
            }
        }

        for (int i = 0 ; i < 7 ;i += 3){

            for (int j = 0 ; j < 7; j += 3){

                for (int m = i; m < i + 3 ;m++){
                    for (int n = j ; n < j + 3 ; n++){

                        if (board[m][n]!='.') {
                            int cur = board[m][n] - 48;
                            num[cur]++;
                        }
                    }

                }
                for (int k = 1 ; k < 10 ;k++){
                    if (num[k] > 1){
                        return false;
                    }
                    num[k] = 0;
                }
            }

        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isValidSudoku(BoardUtil.getBoard()));
    }

}
