package com.lql.easy;

/**
 * Created by LQL on 2016/4/3.
 * 83题
 * 从有序单链表中删除重复元素
 */
public class RemoveDuplicateFromList {

    public static ListNode deleteDuplicates(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            if (curNode.val > p.val) {
                p.next = curNode;
                p = curNode;
            }
            curNode = curNode.next;
        }
        p.next = null;
        return head;
    }

}
