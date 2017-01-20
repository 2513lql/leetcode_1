package com.lql.easy;

/**
 * Created by LQL on 2016/5/16.
 */
public class RemoveNodeNFromEnd {


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;
        int len = 0;
        if (n <= 0){
            return head;
        }
        if (head == null){
            return head;
        }
        while (cur != null){
            len++;
            cur = cur.next;
        }
        if (n > len){
            return head;
        }
        int m = len - n + 1;
        if (m == 1){
            head = head.next;
            return head;
        }
        ListNode pre = head;
        cur = pre.next;
        int count = 2;
        while (cur != null){
            if (count == m){
                pre.next = cur.next;
                return head;
            }
            count++;
            pre = cur;
            cur = cur.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = removeNthFromEnd(ListNode.generateList(), 0);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
