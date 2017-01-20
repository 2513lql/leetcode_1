package com.lql.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/5/6.
 */
public class PrimeFactor {

    public static void decomposePrimeFactor(int n){

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2 ; i < Math.sqrt(n) ; i++){

            if (n % i == 0){
                list.add(i);
                n = n / i;
                i--;
            }
        }
        list.add(n);

        for (Integer i : list){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        decomposePrimeFactor(90);
    }
}
