package com.lql.easy.com.lql.util;

/**
 * Created by LQL on 2016/5/9.
 */
public class BoardUtil {

    public static char[][] getBoard(){

        char[][] board = new char[9][9];
        for (int i = 0 ; i < 9 ;i++){
            for (int j = 0 ; j < 9;j++){
                    board[i][j] = '.';
            }

        }
        board[2][8]='1';
        board[1][1]='4';
        board[1][3]='3';
        board[0][4]='5';
        board[0][7]='1';
        board[2][5]='3';
        for (int i = 0 ; i < 9;i++){
            for (int j = 0 ; j < 9 ;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        return board;
    }

    public static void main(String[] args) {
        getBoard();
        System.out.println((char)(5 + 48));
    }
}
