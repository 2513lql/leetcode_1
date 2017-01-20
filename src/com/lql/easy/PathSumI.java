package com.lql.easy;

import com.lql.easy.com.lql.easy.btree.BinaryTreeUtil;
import com.lql.easy.com.lql.easy.btree.TreeNode;

/**
 * Created by LQL on 2016/12/30.
 */
public class PathSumI {


    public static boolean hasPathSum(TreeNode root, int sum) {


        if (root == null){
            return false;
        }
        if (root.left == null && root.right==null && root.val == sum){
            return true;
        }

        return hasPathSum(root.left , sum - root.val) || hasPathSum(root.right , sum - root.val);
    }

    public static void main(String[] args) {
        System.out.println(hasPathSum(BinaryTreeUtil.generateBinaryTree(),3));
    }

}
