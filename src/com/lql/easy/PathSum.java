package com.lql.easy;

import com.lql.easy.com.lql.easy.btree.BinaryTreeUtil;
import com.lql.easy.com.lql.easy.btree.TreeNode;

import java.util.Stack;

/**
 * Created by LQL on 2016/12/29.
 */
public class PathSum {

    public static int pathSum(TreeNode root, int sum) {


        int count = 0;
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode q = root;
        int cur = 0;
        while (q != null || stack.isEmpty() == false){

            if (q != null){
                cur += q.val;
                if (cur == sum) count++;
                stack.push(q);
                q = q.left;
            }else{
                q = stack.pop();
                cur = cur - q.val;
                q = q.right;
            }
        }
        return count + pathSum(root.left,sum) + pathSum(root.right,sum);
    }


    public static int preTravel(TreeNode root , int sum,int cur){

        if (root != null){
            if (cur == sum) return 1;


            preTravel(root.left,sum , cur);
            preTravel(root.right,sum , cur);
        }
        return 0;
    }

//    public static int getPathLength(TreeNode root,int ){
//
//    }

    public static void main(String[] args) {

//        System.out.println(pathSum(BinaryTreeUtil.generateBinaryTree3(),8));
    }
}
