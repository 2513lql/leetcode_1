package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/23.
 */
public class MatrixMultiply {


    public static int[][] matrixMultiple(int[][] A , int[][] B){


        int[][] C = new int[A.length][B[0].length];

        for (int i = 0 ; i < A.length; i++){
            for (int j = 0 ; j < B[i].length ; j++){

                int tmp = 0;
                for (int k = 0 ; k < B.length;k++){
                    tmp += A[i][k] * B[k][j];
                }
                C[i][j] = tmp;
            }
        }
        return C;
    }


    /**
     * 使用分治法进行矩阵乘法
     * @param A
     * @param B
     * @return
     */
    public static int[][] strassenMatrixMultiple(int[][] A , int[][] B){

        int[][] C = new int[A.length][B[0].length];
        if (A.length == 1){
            C[0][0] = A[0][0] * B[0][0];
        }else{
            int n = A.length / 2;
            int[][] A11 = new int[n][n];
            int[][] A12 = new int[n][n];
            int[][] A21 = new int[n][n];
            int[][] A22 = new int[n][n];

            for (int i = 0 ; i < n ; i++){
                for (int j =0;j < n ; j++){
                    A11[i][j] = A[i][j];
                }
                for (int j = n , k = 0; j < A.length;k++,j++){
                    A12[i][k] = A[i][j];
                }
            }
            for (int i = 0 ,k = n; k < A.length ; k++,i++){
                for (int j =0;j < n ; j++){
                    A21[i][j] = A[k][j];
                }
                for (int j = n , m = 0; j < A.length;m++,j++){
                    A22[i][m] = A[k][j];
                }
            }

            int[][] B11 = new int[n][n];
            int[][] B12 = new int[n][n];
            int[][] B21 = new int[n][n];
            int[][] B22 = new int[n][n];

            int[][] C11 = new int[n][n];
            int[][] C12 = new int[n][n];
            int[][] C21 = new int[n][n];
            int[][] C22 = new int[n][n];


        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3,4},{3,4,5,6},{3,4,5,6},{7,8,9,4}};
//        int[][] B = {{1,2},{3,4}};
//        int[][] C = matrixMultiple(A,B);
//        for (int i = 0 ; i < C.length ; i++){
//            for (int j = 0 ; j < C[i].length ;j++){
//                System.out.print(C[i][j] + " ");
//            }
//            System.out.println();
//        }
        int n = A.length / 2;
        int[][] A11 = new int[n][n];
        int[][] A12 = new int[n][n];
        int[][] A21 = new int[n][n];
        int[][] A22 = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            for (int j =0;j < n ; j++){
                A11[i][j] = A[i][j];
            }
            for (int j = n , k = 0; j < A.length;k++,j++){
                A12[i][k] = A[i][j];
            }
        }
        for (int i = 0 ,k = n; k < A.length ; k++,i++){
            for (int j =0;j < n ; j++){
                A21[i][j] = A[k][j];
            }
            for (int j = n , m = 0; j < A.length;m++,j++){
                A22[i][m] = A[k][j];
            }
        }

        for (int i = 0 ; i < A11.length ; i++){
            for (int j = 0 ; j < A11[i].length ; j++){
                System.out.print(A22[i][j] + " ");
            }
            System.out.println();
        }

    }
}
