package com.lql.easy.com.lql.easy.btree;

/**
 * Created by LQL on 2016/5/8.
 */

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {



        return hasPathSum(root, sum, 0);

    }

    public static boolean hasPathSum(TreeNode root, int sum, int tmp) {

        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val + tmp) {
            return true;
        }
        if (root.left == null && root.right == null && sum != root.val + tmp) {
            return false;
        }
        return hasPathSum(root.left, sum, tmp + root.val) || hasPathSum(root.right, sum, tmp + root.val);
    }
}
