package com.lql.easy;

/**
 * Created by LQL on 2016/3/30.
 *
 * 单链表数据节点
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x){
        this.val = x;
        next = null;
    }

    public static ListNode generateList(){

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(1);
        head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
//        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(3);
//        ListNode fourth = new ListNode(4);
//        ListNode five = new ListNode(5);
//        head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = five;
        return head;
    }
    public static ListNode generateList2(){

        ListNode head = new ListNode(2);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(11);
        head.next = second;
        second.next = third;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = generateList2();
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
