package com.lql.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LQL on 2016/5/9.
 */
public class StackUsingQueue {

    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.size() == 0){
            return;
        }
        while (queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        while (queue2.size() > 0){
            queue1.offer(queue2.poll());
        }
    }

    // Get the top element.
    public int top() {



        while (queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        int tmp = queue1.peek();
        queue2.offer(queue1.poll());
        while (queue2.size() > 0){
            queue1.offer(queue2.poll());
        }
        return tmp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }



}
