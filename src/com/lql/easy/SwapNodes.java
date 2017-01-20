package com.lql.easy;

/**
 * Created by LQL on 2016/4/20.
 *
 * 成对交换链表中的节点
 *
 */
public class SwapNodes {


    public static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode post = head.next;

        int tmp = 0 ;
        while (pre != null && post != null){
            tmp = pre.val;
            pre.val = post.val;
            post.val = tmp;
            pre = post.next;
            if (pre == null){
                break;
            }
            post = pre.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = swapPairs(ListNode.generateList2());
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
