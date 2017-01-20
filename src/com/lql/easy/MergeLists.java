package com.lql.easy;

/**
 * Created by LQL on 2016/4/19.
 * 将两个有序列表合并成一个
 */
public class MergeLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode l3 = null;
        if(p1.val < p2.val){
            l3 = p1;
            p1 = p1.next;
        }
        else {
            l3 = p2;
            p2 = p2.next;
        }
        ListNode p3 = l3;

        while (p1 != null && p2 !=null){
            if(p1.val <= p2.val){
                p3.next = p1;
                p3 = p3.next;
                p1 = p1.next;

            }
            else  {
                p3.next = p2;
                p3 = p3.next;
                p2 = p2.next;
            }
        }
        if(p1 != null){
            p3.next = p1;
        }else {
            p3.next = p2;
        }
        return l3;

    }

    public static void main(String[] args) {


       ListNode listNode = mergeTwoLists(ListNode.generateList(),ListNode.generateList2());
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
