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

            hanoi(n - 1,source , tmp , dest); //把 n - 1 个盘子从A通过 B 移动到C
            move(source,dest); //将第n个盘子 从A 移动到 B
            hanoi(n - 1,tmp , dest, source);  //最后把C上的n-1个盘子从C通过A移动到B
        }
    }


    public static void main(String[] args) {
        hanoi(2,'A','B','C');
    }

}
