package com.lql.divideConquer;

/**
 * Created by LQL on 2016/6/25.
 */
public class Hanoi {


    private static void move(char source , char dest){
        System.out.println(source + "------>"+ dest);
    }

    public static void hanoi(int n , char source , char dest,char tmp){


        if (n == 1){
            move(source,dest);
        }else{

            hanoi(n - 1,source , tmp , dest); //�� n - 1 �����Ӵ�Aͨ�� B �ƶ���C
            move(source,dest); //����n������ ��A �ƶ��� B
            hanoi(n - 1,tmp , dest, source);  //����C�ϵ�n-1�����Ӵ�Cͨ��A�ƶ���B
        }
    }


    public static void main(String[] args) {
        hanoi(2,'A','B','C');
    }

}
