package com.lql.tree;


/**
 * Created by LQL on 2016/7/9.
 */
public class BinaryTree {

    public int x;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int x){
        this.x = x;
        this.left = null;
        this.right = null;
    }

    public static BinaryTree generateBinaryTree(){

        BinaryTree root = new BinaryTree(1);
        BinaryTree left = new BinaryTree(2);
        BinaryTree right = new BinaryTree(3);
        root.left = left;
        root.right = right;
        BinaryTree left2 = new BinaryTree(4);
//		TreeNode right2 = new TreeNode(5);
        BinaryTree left3 = new BinaryTree(5);
//		TreeNode right3 = new TreeNode(4);
        root.left.left = left2;
//		root.left.right = right2;
        root.right.left = left3;
//		root.right.right = right3;
        return root;
    }

    
}
