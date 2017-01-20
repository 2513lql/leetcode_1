package com.lql.datastructure;

/**
 * Created by LQL on 2016/7/7.
 */
public class MyStack {

    private  int top = 0;
    private  int SIZE =100;
    private  int[] stack = new int[SIZE];

    private boolean isEmpty(){
        if (top == 0){
            return true;
        }
        return false;
    }

    private boolean push(int x){
        if (top == 99){
            return false;
        }
        stack[++top] = x;
        return true;
    }

    private int pop(){
        if (isEmpty()){
            return -1;
        }
        return stack[top--];
    }



    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(2);
        myStack.push(5);
        System.out.println(myStack.pop());
    }
}
