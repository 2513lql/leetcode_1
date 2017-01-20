package com.lql.easy.com.lql.easy.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/5/6.
 */
public class BinaryTreeLevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();


        getLevelNodes(result , root , 0);

        return result;

    }

    public static void getLevelNodes(List<List<Integer>> result,TreeNode node , int level){

        if (node == null){
            return;
        }
        if (level + 1 > result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);

        getLevelNodes(result, node.left, level + 1);
        getLevelNodes(result,node.right,level + 1);

    }

    public static void main(String[] args) {
//        System.out.println(levelOrderBottom(BinaryTreeUtil.generateBinaryTree()));

        List<List<Integer>> results = levelOrder(BinaryTreeUtil.generateBinaryTree());

        System.out.println(results.get(1));
    }

}
