package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * @author kostic
 *
 */
public class MaxTreeDepth {

	public static void main(String[] args) {
		TreeNode head = new TreeNode(3);
		TreeNode left1 = new TreeNode(9);
		TreeNode right1 = new TreeNode(20);
		head.left = left1;
		head.right = right1;
		TreeNode r_left_1 = new TreeNode(15);
		TreeNode r_right1 = new TreeNode(7);
		right1.left = r_left_1;
		right1.right = r_right1;
		TreeNode r_r_right1 = new TreeNode(8);
		r_right1.right = r_r_right1;
		MaxTreeDepth executor = new MaxTreeDepth();
		System.out.println(executor.maxDepth(head));

	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return maxDepth(root, 1);
	}

	private int maxDepth(TreeNode root, int curLevel) {
		if (root.left == null && root.right == null) {
			return curLevel;
		}
		int leftDepth = 0;
		if (root.left != null) {
			leftDepth = maxDepth(root.left, curLevel + 1);
		}

		int rightDepth = 0;
		if (root.right != null) {
			rightDepth = maxDepth(root.right, curLevel + 1);
		}

		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
