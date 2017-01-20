package com.lql.easy.com.lql.easy.btree;

/**
 * Created by LQL on 2016/5/9.
 */
public class MinimumDepthBinaryTree {

    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        else if (root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        }else if (root.right != null && root.left == null){
            return minDepth(root.right) + 1;
        }
        else {
            int left = minDepth(root.left) + 1;
            int right = minDepth(root.right) + 1;
            return left < right ? left : right;
        }



    }

    public static int getMinDepth(TreeNode root , int depth){
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        int left = getMinDepth(root.left,depth + 1);
        int right = getMinDepth(root.right , depth + 1);
        return left < right ? left : right;
    }

}
