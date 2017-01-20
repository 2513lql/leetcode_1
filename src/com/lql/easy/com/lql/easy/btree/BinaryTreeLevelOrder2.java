package com.lql.easy.com.lql.easy.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by LQL on 2016/4/25.
 *
 *
 * ¶þ²æÊ÷²ã´Î±éÀú
 *
 */
public class BinaryTreeLevelOrder2 {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        List<TreeNode> queue2 = new LinkedList<TreeNode>();
        Queue<Integer> queueLevel1 = new LinkedList<Integer>();
        List<Integer> queueLevel2 = new LinkedList<Integer>();

        if (root == null){
            return result;
        }
        int hight = 1;
        queue1.offer(root);
        queueLevel1.offer(1);
        TreeNode p = null;
        while(!queue1.isEmpty()) {
            p = queue1.poll();
            queue2.add(p);
            hight = queueLevel1.poll();
            queueLevel2.add(hight);
            if(p.left != null){
                queue1.offer(p.left);
                queueLevel1.offer(hight + 1);
            }
            if (p.right != null){
                queue1.offer(p.right);
                queueLevel1.offer(hight + 1);
            }
        }

        for (int i = 0 ; i < queueLevel2.size() ; i++){
            List<Integer> list = new ArrayList<Integer>();
            Integer tmp = queueLevel2.get(i);
            for (int j = i ; j < queueLevel2.size();j++){
                Integer cur = queueLevel2.get(j);
                if (cur != tmp){
                    i = j - 1;
                    break;
                }
                list.add(queue2.get(j).val);
                if (j == queueLevel2.size() - 1){
                    i = j + 1;
                }
            }
            result.add(list);
        }

        List<List<Integer>> result2 = new ArrayList<List<Integer>>();
        for (int i = result.size() - 1; i >= 0;i--){
            result2.add(result.get(i));
        }
        return result2;
    }

    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        visits(root , results , 0);

        return results;
    }

    public static void visits(TreeNode node , List<List<Integer>> counts , int level){

        if(node == null){
            return;
        }

        if (counts.size() < level + 1){
            counts.add(new ArrayList<Integer>());
        }
        counts.get(level).add(node.val);

        visits(node.left,counts,level+1);
        visits(node.right,counts,level+1);
    }


    public static void main(String[] args) {
//        System.out.println(levelOrderBottom(BinaryTreeUtil.generateBinaryTree()));

        List<List<Integer>> results = levelOrderBottom2(BinaryTreeUtil.generateBinaryTree());

        System.out.println(results.get(0));
    }
}
