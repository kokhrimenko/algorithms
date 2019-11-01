package com.study.kokhrimenko.algoriths.array.linkedlist.circled;

import java.util.HashSet;
import java.util.Set;

import com.study.kokhrimenko.algoriths.array.linkedlist.LinkedNode;

/**
 * Given a linked list, check if the linked list has loop or not.
 * 
 * Traverse the list one by one and keep putting the node addresses in a Hash Table. 
 * At any point, if NULL is reached then return false and if next of current node points to any of the previously stored nodes in Hash then return true.
 * 
 * Time complexity  - O(n)
 * Space complexity - O(n)
 *
 * @author k.okhrimenko
 *
 */
public class LinkedListSimple {

    private static boolean detectLoop(LinkedNode h) {
        Set<LinkedNode> s = new HashSet<>();
        while (h != null) {
            if (s.contains(h)) {
                return true;
            }

            s.add(h);

            h = h.getNext();
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
