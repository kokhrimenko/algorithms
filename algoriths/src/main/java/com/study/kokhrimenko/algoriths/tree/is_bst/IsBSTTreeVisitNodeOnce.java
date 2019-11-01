package com.study.kokhrimenko.algoriths.tree.is_bst;

/**
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:
 *  - The left subtree of a node contains only nodes with keys lesser than the node’s key.
 *  - The right subtree of a node contains only nodes with keys greater than the node’s key.
 *  - The left and right subtree each must also be a binary search tree.
 * 
 * Algorithm: 
 *     A better solution looks at each node only once. The trick is to write a utility helper function 
 *     isBSTUtil(struct node* node, int min, int max) that traverses down the tree keeping track of the 
 *     narrowing min and max allowed values as it goes, looking at each node only once.
 *     The initial values for min and max should be INT_MIN and INT_MAX — they narrow from there.
 *
 * Time Complexity: O(n)
 * Auxiliary Space : O(1),
 *      if Function Call Stack size is not considered, otherwise O(n)
 *
 * @author k.okhrimenko
 *
 */
public class IsBSTTreeVisitNodeOnce {

    private static boolean isBSTUtil(TreeNode node, int min, int max) { 
        if (node == null) {
            return true; 
        }
  
        if (node.getData() < min || node.getData() > max) { 
            return false; 
        }
   
        return (isBSTUtil(node.getLeft(), min, node.getData() - 1)
                && isBSTUtil(node.getRight(), node.getData() + 1, max)); 
    } 
    
    private static boolean isBST(TreeNode node) {
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
