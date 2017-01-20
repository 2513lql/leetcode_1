package com.lql.easy.com.lql.easy.btree;

import java.util.Stack;

/**
 * Created by LQL on 2016/7/9.
 */
public class BinaryTreeTravel {

    /*二叉树非递归中序遍历*/
    public static void btTravelUnrecursion(TreeNode root){

        if(root == null){
            return;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (p != null || !stack.isEmpty()){
            if (p != null) {
                stack.push(p);
                p = p.left;
            }
            while (p == null && !stack.isEmpty()){
                p = stack.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }

    /*二叉树先序非递归遍历*/
    public static void preOrder(TreeNode root){

        if (root == null);
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (p != null || !stack.isEmpty()){
            if (p != null){
                System.out.print(p.val + " ");
                stack.push(p);
                p = p.left;
            }
            while (p == null && !stack.isEmpty()){
                p = stack.pop();
                p = p.right;
            }
        }
    }

    /*二叉树后序非递归遍历
    * 借助两个栈可以用很简单的方式实现二叉树的后序非递归遍历
    * */
    public static void postOrder(TreeNode root){

        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                output.push(p);
                p = p.right;
            }else{
                p = stack.pop();
                p = p.left;
            }
        }
        while (!output.isEmpty()){
            System.out.println(output.pop().val + " ");
        }
    }


    public static void main(String[] args) {
//        btTravelUnrecursion(BinaryTreeUtil.generateBinaryTree());
//        preOrder(BinaryTreeUtil.generateBinaryTree());
        postOrder(BinaryTreeUtil.generateBinaryTree());
    }

}
