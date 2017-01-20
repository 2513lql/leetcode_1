package com.lql.easy.com.lql.easy.btree;

import java.util.Stack;

/**
 * Created by LQL on 2016/7/9.
 */
public class BinaryTreeTravel {

    /*�������ǵݹ��������*/
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

    /*����������ǵݹ����*/
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

    /*����������ǵݹ����
    * ��������ջ�����úܼ򵥵ķ�ʽʵ�ֶ������ĺ���ǵݹ����
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
