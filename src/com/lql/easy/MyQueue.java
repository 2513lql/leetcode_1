package com.lql.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by LQL on 2016/4/21.
 */
public class MyQueue {


    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> tmp = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (!stack.isEmpty()){
            Integer x = stack.pop();
            tmp.push(x);
        }
        tmp.pop();
        while (!tmp.isEmpty()){
            Integer x = tmp.pop();
            stack.push(x);
        }
    }

    // Get the front element.
    public int peek() {
        while (!stack.isEmpty()){
            Integer x = stack.pop();
            tmp.push(x);
        }
        int y = tmp.peek();
        while (!tmp.isEmpty()){
            Integer x = tmp.pop();
            stack.push(x);
        }
        return y;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }

}
