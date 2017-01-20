package com.lql.easy.com.lql.easy.btree;

/**
 * Created by LQL on 2016/7/10.
 */
public class BSearchTree {

    public static TreeNode minimum(TreeNode root){

        if (root == null){
            return null;
        }

        TreeNode p = root;
        while (p.left != null){
            p = p.left;
        }
        return p;
    }

    public static TreeNode recursionMinimum(TreeNode root){
        if (root == null){
            return null;
        }
        if (root.left == null){
            return root;
        }
        return recursionMinimum(root.left);
    }

    public static TreeNode maximum(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }
        return p;
    }

    /**
     * ·µ»Øtreeºó¼Ì
     * @param tree
     * @return
     */
    public static TreeNode successor(TreeNode tree){
        if (tree == null){
            return null;
        }
        if (tree.right != null){
            return minimum(tree.right);
        }
        TreeNode p = tree.parent;
        while (p != null && p.right == tree){
            tree = p;
            p = p.parent;
        }
        return p;
    }
    public static TreeNode predecessor(TreeNode tree){

        if (tree == null){
            return null;
        }
        if (tree.left != null){
            return maximum(tree.left);
        }
        TreeNode p = tree.parent;
        while (p != null && p.left == tree){
            tree = p;
            p = p.parent;
        }
        return p;
    }

    public static void insertNode(TreeNode root , TreeNode node){

        TreeNode y = null;
        TreeNode x = root;
        while (x != null){
            y = x;
            if (node.val < x.val){
                x = x.left;
            }else{
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null){
            root = node;
            return;
        }
        if (node.val < y.val){
            y.left = node;
        }else {
            y.right = node;
        }
    }

    public static void transplant(TreeNode tree , TreeNode u ,TreeNode v){
        if (u.parent == null){
            tree = v;
        }
        else if(u.parent.left == u){
            u.parent.left = v;
        }
        else{
            u.parent.right = v;
        }
        if (v != null){
            v.parent = u.parent;
        }
    }

    public static void deleteNode(TreeNode tree,TreeNode z){
        if (z.left == null){
            transplant(tree,z , z.right);
        }
        else if (z.right == null){
            transplant(tree,z,z.left);
        }
        else{
            TreeNode y = minimum(z.right);
            if (z.right != y){
                transplant(tree,y,y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(tree,z,y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtil.generateBinaryTree2();
        System.out.println(minimum(root).val);
        System.out.println(maximum(root).val);
        System.out.println(successor(root).val);
        System.out.println(predecessor(root).val);
    }

}
