package com.lql.easy.com.lql.easy.btree;

/**
 * Created by LQL on 2016/4/20.
 */
public class BalanceTree {

    public static boolean isBalanced(TreeNode root) {

        if (root == null){
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int a = Math.abs(left - right);
        if (a > 1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public static int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(BinaryTreeUtil.generateBinaryTree()));
    }
}
