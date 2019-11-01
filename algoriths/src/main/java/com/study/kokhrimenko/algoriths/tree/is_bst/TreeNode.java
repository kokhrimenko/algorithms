package com.study.kokhrimenko.algoriths.tree.is_bst;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TreeNode {

    private int data;
    @Setter
    private TreeNode left;
    @Setter
    private TreeNode right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
    
    public static int getMinFromLeft(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return getMinFromLeft(root, root.getData());
    }

    private static int getMinFromLeft(TreeNode root, int currentMin) {
        if (root == null) {
            return currentMin;
        }
        int min = currentMin > root.getData() ? root.getData() : currentMin;
        return getMinFromLeft(root.getRight(), min);
    }
    
    public static int getMaxFromRight(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return getMaxFromRight(root, root.getData());
    }

    private static int getMaxFromRight(TreeNode root, int currentMax) {
        if (root == null) {
            return currentMax;
        }
        int max = currentMax < root.getData() ? root.getData() : currentMax;
        return getMaxFromRight(root.getRight(), max);
    }
}
