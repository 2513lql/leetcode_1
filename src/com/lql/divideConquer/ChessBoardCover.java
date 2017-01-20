package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/24.
 */
public class ChessBoardCover {

    private static int SIZE = 4;
    private static int[][] chessBoard = new int[SIZE][SIZE];
    private static int type = 1;

    /**
     * @param tr   : �������Ͻ��к�
     * @param tc   : �������Ͻ��к�
     * @param dr   : ���ⷽ���к�
     * @param dc   : ���ⷽ���к�
     * @param size : ���̹�ģ
     */
    public static void chessBoardCover(int tr, int tc, int dr, int dc, int size) {

        if (size == 1) {
            return;
        }
        int t = type++; // L�͹���
        int s = size / 2; //�ָ�����

        //���ⷽ�������Ͻ�������
        if (dr < tr + s && dc < tc + s) {
            //�ݹ鸲�����Ͻ�����
            chessBoardCover(tr, tc, dr, dc, s);
        } else { //���ⷽ�������Ͻ���������
            chessBoard[tr + s - 1][tc + s - 1] = t; //��t��L���Ƹ��������½�
            chessBoardCover(tr, tc, tr + s - 1, tc + s - 1, s);//�������෽��
        }

        //���ⷽ�������Ͻ�������
        if (dr < tr + s && dc >= tc + s) {
            chessBoardCover(tr, tc + s, dr, dc, s);
        }else{
            chessBoard[tr + s - 1][tc + s] = t; //��t��L���Ƹ��������½�
            chessBoardCover(tr,tc + s,tr + s - 1,tc + s ,s);
        }

        //���ⷽ�������½�����
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
