package com.study.kokhrimenko.algoriths.tree.is_bst;

import java.util.function.IntBinaryOperator;

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

    public static int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return getValueFromLeafs(root, root.getData(), (arg1, arg2) -> arg1 < arg2 ? arg1 : arg2);
    }

    private static int getValueFromLeafs(TreeNode node, int currentValue, IntBinaryOperator compare) {
        if (node == null) {
            return currentValue;
        }
        if (node.getRight() != null) {
            int min = getValueFromLeafs(node.getRight(), node.getRight().getData(), compare);
            currentValue = compare.applyAsInt(currentValue, min);
        }

        if (node.getLeft() != null) {
            int min = getValueFromLeafs(node.getLeft(), node.getLeft().getData(), compare);
            currentValue = compare.applyAsInt(currentValue, min);
        }
        return currentValue;
    }

    public static int getMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return getValueFromLeafs(root, root.getData(), (arg1, arg2) -> arg1 > arg2 ? arg1 : arg2);
    }
}
