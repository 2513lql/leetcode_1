package com.lql.easy;

import com.lql.easy.com.lql.easy.btree.BinaryTreeUtil;
import com.lql.easy.com.lql.easy.btree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LQL on 2016/5/20.
 */
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<String>();
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        List<Integer> buffer = new ArrayList<Integer>();
        generatePath(root,buffer,tmp);
        for (List<Integer> list : tmp){
            StringBuffer buffer1 = new StringBuffer("");
            int size = list.size();
            for (int i = 0 ; i < size - 1; i++){
                buffer1.append(list.get(i));
                buffer1.append("->");
            }
            buffer1.append(list.get(size - 1));
            result.add(buffer1.toString());
        }
        return result;
    }
    public static void generatePath(TreeNode root ,List<Integer> buffer,List<List<Integer>> list){

        if (root == null){
            return;
        }
        else if (root.left == null && root.right==null){
            buffer.add(root.val);
            list.add(buffer);
            return;
        }
        else if (root.left != null && root.right == null){
            buffer.add(root.val);
            generatePath(root.left,buffer,list);
        }else if (root.right != null && root.left == null){
            buffer.add(root.val);
            generatePath(root.right,buffer,list);
        }else{
            List<Integer> left = new ArrayList<Integer>(buffer);
            left.add(root.val);
            generatePath(root.left,left,list);
            List<Integer> right = new ArrayList<Integer>(buffer);
            right.add(root.val);
            generatePath(root.right, right, list);
        }
    }
    public static void main(String[] args) {
       List<String> strings = binaryTreePaths(BinaryTreeUtil.generateBinaryTree());
        for (String s : strings){
            System.out.println(s);
        }
    }
}
