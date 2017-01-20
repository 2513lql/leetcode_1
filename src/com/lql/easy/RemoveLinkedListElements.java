package com.lql.easy;

/**
 * Created by LQL on 2016/5/20.
 *
 * Remove all elements from a linked list of integers that have value val.
 */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {


        if (head == null){
            return head;
        }
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }else{

                pre = cur;
                cur = cur.next;

            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = removeElements(ListNode.generateList(), 1);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
