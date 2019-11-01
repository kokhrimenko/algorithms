package com.study.kokhrimenko.algoriths.array.linkedlist.circled;

import com.study.kokhrimenko.algoriths.array.linkedlist.LinkedNode;

/**
 * Floyd’s Cycle-Finding Algorithm: This is the fastest method and has been described below:
 * 
 * Traverse linked list using two pointers. 
 * Move one pointer(slow_p) by one and another pointer(fast_p) by two. 
 * If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.
 *
 * Time complexity  - O(n)
 * Space complexity - O(1)
 * 
 * 
 * Algorithm by itself:
 * 
 * 1) When slow pointer enters the loop, the fast pointer must be inside the loop. Let fast pointer be distance k from slow.
 * 2) Now if consider movements of slow and fast pointers, we can notice that distance between them (from slow to fast) increase 
 *    by one after every iteration. After one iteration (of slow = next of slow and fast = next of next of fast), distance between 
 *    slow and fast becomes k+1, after two iterations, k+2, and so on. When distance becomes n, they meet because they are moving 
 *    in a cycle of length n.
 *
 * @author k.okhrimenko
 *
 */
public class LinkedListFloyd {

    private static boolean detectLoop(LinkedNode head) {
        LinkedNode slowNode = head, fastNode = head;
        while (slowNode != null && fastNode != null && fastNode.getNext() != null) {
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedNode head = null;

        head = LinkedNode.push(head, 20);
        head = LinkedNode.push(head, 4);
        head = LinkedNode.push(head, 15);
        head = LinkedNode.push(head, 10);

        /* Create loop for testing */
        head.getNext().getNext().getNext().setNext(head);

        if (detectLoop(head)) {
            System.out.println("Loop found");
        } else {
            System.out.println("No Loop");
        }
    }
}
