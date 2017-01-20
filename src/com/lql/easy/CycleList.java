package com.lql.easy;

/**
 * Created by LQL on 2016/5/4.
 */
public class CycleList {

    public static boolean hasCycle(ListNode head) {


        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head,fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }

        return false;
    }
}
