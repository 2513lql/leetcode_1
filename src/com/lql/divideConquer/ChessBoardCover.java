package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/24.
 */
public class ChessBoardCover {

    private static int SIZE = 4;
    private static int[][] chessBoard = new int[SIZE][SIZE];
    private static int type = 1;

    /**
     * @param tr   : 棋盘左上角行号
     * @param tc   : 棋盘左上角列号
     * @param dr   : 特殊方格行号
     * @param dc   : 特殊方格列号
     * @param size : 棋盘规模
     */
    public static void chessBoardCover(int tr, int tc, int dr, int dc, int size) {

        if (size == 1) {
            return;
        }
        int t = type++; // L型骨牌
        int s = size / 2; //分割棋盘

        //特殊方格在左上角子棋盘
        if (dr < tr + s && dc < tc + s) {
            //递归覆盖左上角棋盘
            chessBoardCover(tr, tc, dr, dc, s);
        } else { //特殊方格不在左上角子棋盘中
            chessBoard[tr + s - 1][tc + s - 1] = t; //用t号L骨牌覆盖其右下角
            chessBoardCover(tr, tc, tr + s - 1, tc + s - 1, s);//覆盖其余方格
        }

        //特殊方格在右上角子棋盘
        if (dr < tr + s && dc >= tc + s) {
            chessBoardCover(tr, tc + s, dr, dc, s);
        }else{
            chessBoard[tr + s - 1][tc + s] = t; //用t号L骨牌覆盖其左下角
            chessBoardCover(tr,tc + s,tr + s - 1,tc + s ,s);
        }

        //特殊方格在左下角棋盘
        if (dr >= tr + s && dc < tc + s){
            chessBoardCover(tr + s,tc,dr,dc,s);
        }else{
            chessBoard[tr + s][tc + s - 1] = t;
            chessBoardCover(tr + s,tc,tr + s ,tc + s - 1,s);
        }

        if (dr >= tr + s && dc >= tc + s){
            chessBoardCover(tr + s,tc + s,dr,dc , s);
        }else{
            chessBoard[tr + s][tc + s] = t;
            chessBoardCover(tr + s,tc + s,tr + s,tc + s, s);
        }
    }

    public static void printChessBoard(){
        for (int i = 0 ; i < chessBoard.length;i++){
            for (int j = 0 ; j < chessBoard[i].length;j++){
                System.out.print(chessBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        chessBoardCover(0,0,2,2,SIZE);
        printChessBoard();
    }
}
