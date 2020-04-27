package com.study.kokhrimenko.algoriths.external.coursera.table.impl;

import java.util.Iterator;

import com.study.kokhrimenko.algoriths.external.coursera.table.Table;

import edu.princeton.cs.algs4.Queue;

/**
 * Definition:
 *          - BST is a binary tree in symmetric order;
 *          - Each node has a key and every node's key is:
 *              larger than all keys in its left sub-tree;
 *              smaller than all keys in its right sub-tree.
 *
 * Complexity:
 *           search - ~ ln N;
 *           insert - ~ ln N;
 *           iteration - N;
 *           deletion - square N
 *
 * @author kostic
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements Table<Key, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        //private int size;

        public Node(Key key, Value value) {
            super();
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        //node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            Node tmpNode = node;
            node = min(tmpNode.right);
            node.right = deleteMin(tmpNode.right);
            node.left = tmpNode.left;
        }
        // node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        // node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public Iterator<Key> iterator() {
        return keys().iterator();
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }

        if (cmp < 0) {
            return floor(node.left, key);
        }

        Node tmpNode = floor(node.right, key);
        if (tmpNode != null) {
            return tmpNode;
        }
        return node;
    }
/*
    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }
*/

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node node, Queue<Key> queue) {
        if (node == null) {
            return;
        }
        inorder(node.left, queue);
        queue.enqueue(node.key);
        inorder(node.right, queue);
    }
}
