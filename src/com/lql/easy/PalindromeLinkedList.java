package com.lql.easy;

import java.util.List;

/**
 * Created by LQL on 2016/5/29.
 */
public class PalindromeLinkedList {


    public static boolean isPalindrome(ListNode head) {

        ListNode fast = head,slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode node = null;
        while (slow != null){
            ListNode next = slow.next;
            slow.next = node;
            node = slow;
            slow = next;
        }
        while (node != null){
            if (head.val != node.val){
                return false;
            }
            head = head.next;
            node = node.next;
        }
        return true;
    }



}
