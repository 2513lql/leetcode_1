package com.lql.easy.com.lql.easy.btree;


import java.util.*;

/**
 * Created by LQL on 2016/4/1.
 */
public class LowestCommonAncestor {

    /**
     * 递归实现
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
                return root;
        if(p.val > q.val)
           return lowestCommonAncestor2(root,q,p);
        if(root.val >= p.val && root.val <= q.val){
            return root;
        }
        return lowestCommonAncestor2(root.val > p.val ? root.left : root.right , p ,q);

    }


    /**
     * 非递归实现
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        List<TreeNode> orderTreeNode = inOrderTravel(root);
        int pre = 0;
        int post = 0;
        for (int i = 0; i < orderTreeNode.size(); i++) {
            if (p == orderTreeNode.get(i)) {
                pre = i;
            }
            if (q == orderTreeNode.get(i)) {
                post = i;
            }
        }
        if(pre > post){
            int tmp = pre;
            pre = post;
            post = tmp;
        }
        boolean isAncestor = false;
        TreeNode lowestAncestor = null;
        for (int i = pre; i <= post; i++) {
            isAncestor = isAncestor(orderTreeNode.get(i), p, q);
            if (isAncestor == true) {
                lowestAncestor = orderTreeNode.get(i);
                break;
            }
        }


        return lowestAncestor;
    }



    public static List<TreeNode> inOrderTravel(TreeNode root) {

        List<TreeNode> orderTreeNode = new ArrayList<TreeNode>();
        Stack<TreeNode> treeNodes = new Stack<TreeNode>();

        if (root == null) {
            return null;
        }

        TreeNode currentNode = root;
        while (!treeNodes.isEmpty() || currentNode != null) {

            while (currentNode != null) {
                treeNodes.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = treeNodes.pop();

            orderTreeNode.add(currentNode);
            currentNode = currentNode.right;
        }

        return orderTreeNode;
    }

    public static boolean isAncestor(TreeNode root, TreeNode p, TreeNode q) {


        Queue<TreeNode> remindNodes = new LinkedList<TreeNode>();
        TreeNode currentNode = root;
        boolean pFlag = false;
        boolean qFlag = false;
        remindNodes.add(currentNode);
        while (!remindNodes.isEmpty()) {
            currentNode = remindNodes.poll();
            if (currentNode.val == p.val) {
                pFlag = true;
            }
            if (currentNode.val == q.val) {
                qFlag = true;
            }
            if(pFlag == true && qFlag == true){
                return true;
            }
            if(currentNode.left != null){
                remindNodes.add(currentNode.left);
            }
            if(currentNode.right != null){
                remindNodes.add(currentNode.right);
            }

        }
        return false;
    }


}
