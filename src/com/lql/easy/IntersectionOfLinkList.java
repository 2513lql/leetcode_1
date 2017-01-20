package com.lql.easy;


/**
 * Created by LQL on 2016/5/9.
 *
 * 两个单链表交汇节点
 *
 */
public class IntersectionOfLinkList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }

        ListNode p = headA;
        ListNode q = headB;
        int alen = 0;
        int blen = 0;
        while (p != null || q != null){
            if (p != null) {
                alen++;
                p = p.next;
            }
            if (q != null){
                blen++;
                q = q.next;
            }
        }
        System.out.println(alen);
        System.out.println(blen);
        p = headA;
        q = headB;

        if (alen > blen){
            for (int i = 0 ; i < alen - blen;i++){
                p = p.next;
            }
        }else {
            for (int i = 0 ; i < blen - alen ;i++){
                q = q.next;
            }
        }

        while (p != null && q != null){
            if (p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(getIntersectionNode(ListNode.generateList2(),ListNode.generateList2()));
    }
}
