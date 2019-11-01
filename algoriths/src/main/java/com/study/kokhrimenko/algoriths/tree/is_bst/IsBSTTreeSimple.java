package com.study.kokhrimenko.algoriths.tree.is_bst;

/**
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:
 *  - The left subtree of a node contains only nodes with keys lesser than the node’s key.
 *  - The right subtree of a node contains only nodes with keys greater than the node’s key.
 *  - The left and right subtree each must also be a binary search tree.
 * 
 * Algorithm: 
 *    For each node, check if max value in left subtree is smaller than the node and min value in right 
 *    subtree greater than the node.
 * 
 * @author k.okhrimenko
 *
 */
public class IsBSTTreeSimple {

    private static boolean isBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.getLeft() != null && TreeNode.getMax(node.getLeft()) > node.getData()) {
            return false;
        }

        if (node.getRight() != null && TreeNode.getMin(node.getRight()) < node.getData()) {
            return false;
        }

        return isBST(node.getLeft()) && isBST(node.getRight());
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        
        TreeNode leftLeaf1 = new TreeNode(3);
        TreeNode leftLeaf1Left2 = new TreeNode(1);
        TreeNode leftLeaf1Right2 = new TreeNode(6);
        TreeNode leftLeaf1Right2Left3 = new TreeNode(4);
        TreeNode leftLeaf1Right2Right3 = new TreeNode(7);
        leftLeaf1Right2.setLeft(leftLeaf1Right2Left3);
        leftLeaf1Right2.setRight(leftLeaf1Right2Right3);
        
        leftLeaf1.setLeft(leftLeaf1Left2);
        leftLeaf1.setRight(leftLeaf1Right2);
        
        TreeNode rightLeaf1 = new TreeNode(10);
        TreeNode rightLeaf1Right2 = new TreeNode(14);        
        TreeNode rightLeaf1Right2Left3 = new TreeNode(13);
        rightLeaf1Right2.setLeft(rightLeaf1Right2Left3);

        rightLeaf1.setRight(rightLeaf1Right2);

        root.setLeft(leftLeaf1);
        root.setRight(rightLeaf1);
        
        System.out.println("Is binary Tree: " + isBST(root));
    }
    
}
