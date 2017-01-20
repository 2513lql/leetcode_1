package com.lql.easy.com.lql.easy.btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by LQL on 2016/4/21.
 * <p>
 * ¶Ô³Æ¶þ²æÊ÷
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {

        Stack<Integer> stackLeft = new Stack<Integer>();
        Stack<Integer> stackRight = new Stack<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null || !stack.isEmpty()) {
            while (left != null) {
                stack.push(left);
                left = left.left;
            }
            left = stack.pop();
            stackLeft.push(left.val);
            left = left.right;
        }

        while (right != null || !stack.isEmpty()) {
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
            right = stack.pop();
            stackRight.push(right.val);
            right = right.right;
        }

        if (stackLeft.size() != stackRight.size()) {
            return false;
        }

        Stack<Integer> tmp = new Stack<Integer>();
        while (!stackRight.isEmpty()) {
            tmp.push(stackRight.pop());
        }

        while (!stackLeft.isEmpty() && !tmp.isEmpty()) {
            int x = stackLeft.pop();
            int y = tmp.pop();
            if (x != y) {
                return false;
            }
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueLeft = new LinkedList<Integer>();
        Queue<Integer> queueRight = new LinkedList<Integer>();
        left = root.left;
        right = root.right;
        if (left != null) {
            queue.add(left);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            queueLeft.add(cur.val);
            TreeNode leftNode = cur.left;
            TreeNode rightNode = cur.right;
            if (leftNode != null) {
                queue.add(leftNode);
            }
            if (rightNode != null) {
                queue.add(rightNode);
            }
        }
        queue.clear();
        if (right != null) {
            queue.add(right);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            queueRight.add(cur.val);
            TreeNode rightNode = cur.right;
            TreeNode leftNode = cur.left;
            if (rightNode != null) {
                queue.add(rightNode);
            }
            if (leftNode != null) {
                queue.add(leftNode);
            }
        }

        if (queueLeft.size() != queueRight.size()) {
            return false;
        }
        while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
            int x = queueLeft.poll();
            int y = queueRight.poll();
            if (x != y) {
                return false;
            }
        }

        return true;
    }


    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric3(root.left, root.right);
    }

    public static boolean isSymmetric3(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val == right.val) {
            return isSymmetric3(left.left, right.right) && isSymmetric3(left.right, right.left);
        } else {
            return false;
        }
    }

    public static boolean isSymmetric3Iter(TreeNode left,TreeNode right) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        TreeNode p = left;
        TreeNode q = right;

        while ((p != null || !s1.isEmpty() && (q != null || !s2.isEmpty()))){
            if (p != null && q != null){
                s1.push(p);
                p = p.left;
                s2.push(q);
                q = q.right;
            }
            else if (p != null || q != null){
                return false;
            }else {
                TreeNode pTmp = s1.pop();
                TreeNode qTmp = s2.pop();
                if (pTmp.val != qTmp.val){
                    return false;
                }else {
                    s1.push(pTmp.right);
                    s2.push(qTmp.left);
                }
            }
        }
        if ((p == null && q == null) && (s1.isEmpty() && s2.isEmpty())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(BinaryTreeUtil.generateBinaryTree()));
        System.out.println(isSymmetric2(BinaryTreeUtil.generateBinaryTree()));
    }

}
