package com.lql.easy;

/**
 * Created by LQL on 2016/3/31.
 *
 *
 */
public class ReverseLinkList {


    public static ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode currentHead = head;
        ListNode currentNode = head.next;
        ListNode tmp = new ListNode(head.next.val);
        while(currentNode != null){

            tmp.next = currentHead;
            currentHead = tmp;
            currentNode = currentNode.next;
            if(currentNode == null){
                break;
            }
            tmp = new ListNode(currentNode.val);
        }
        head.next = null;
        head = currentHead;
        return head;
    }
}
