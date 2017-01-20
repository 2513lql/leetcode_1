package com.lql.tree;

/**
 * Created by LQL on 2016/7/9.
 */
public class BinaryTreeTravel {

    public static void binaryTreeTravel(BinaryTree root){
        if (root == null){
            return;
        }
        System.out.println(root.x +" ");
        binaryTreeTravel(root.left);
        binaryTreeTravel(root.right);
    }

    public static void main(String[] args) {
        binaryTreeTravel(BinaryTree.generateBinaryTree());
    }
}
