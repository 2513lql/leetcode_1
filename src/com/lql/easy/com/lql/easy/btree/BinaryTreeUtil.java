package com.lql.easy.com.lql.easy.btree;

public class BinaryTreeUtil {

	public static TreeNode generateBinaryTree(){

		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(5);
		root.left.left = left2;
		root.left.right = right2;
		TreeNode left3 = new TreeNode(6);
		TreeNode right3 = new TreeNode(7);
		root.right.left = left3;
		root.right.right = right3;
//		root.left.left = left2;
////		root.left.right = right2;
//		root.right.left = left3;
//		root.right.right = right3;
		return root;
	}

	public static TreeNode generateBinaryTree2(){

		TreeNode root = new TreeNode(15);
		TreeNode left = new TreeNode(6);
		TreeNode right = new TreeNode(18);
		root.parent = null;
		left.parent = root;
		right.parent = root;
		root.left = left;
		root.right = right;
		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(7);
		left2.parent = left;
		right2.parent = left;
		root.left.left = left2;
		root.left.right = right2;
		TreeNode left3 = new TreeNode(17);
		TreeNode right3 = new TreeNode(20);
		left3.parent = right;
		right3.parent = right;
		root.right.left = left3;
		root.right.right = right3;
//		root.left.left = left2;
////		root.left.right = right2;
//		root.right.left = left3;
//		root.right.right = right3;
		return root;
	}

	public static TreeNode generateBinaryTree3(){

		TreeNode root = new TreeNode(10);
		TreeNode left1 = new TreeNode(5);
		TreeNode right1 = new TreeNode(-3);
		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(2);
		TreeNode right3 = new TreeNode(11);
		TreeNode left4 = new TreeNode(3);
		TreeNode right4 = new TreeNode(-2);
		TreeNode right5 = new TreeNode(1);
		root.left = left1;
		root.right = right1;
		left1.left = left2;
		left1.right = right2;
		right1.right = right3;
		left2.left = left4;
		left2.right = right4;
		right2.right = right5;
		return root;
	}
	
}
