package com.study.kokhrimenko.algoriths.array.linkedlist.circled;

import com.study.kokhrimenko.algoriths.array.linkedlist.LinkedNode;

/**
 * This algorithm MODIFYING original List!
 *
 * In this method, a temporary node is created.
 * The next pointer of each node that is traversed is made to point to this temporary node.
 * This way we are using the next pointer of a node as a flag to indicate whether the node has been traversed or not.
 * Every node is checked to see if the next is pointing to a temporary node or not.
 * In the case of the first node of the loop, the second time we traverse it this condition will be true, hence we find that loop exists.
 * If we come across a node that points to null then loop doesn’t exist.
 *
 * Time complexity  - O(n)
 * Space complexity - O(1)
 *
 * @author k.okhrimenko
 *
 */
public class LinkedListWithTMPNode {

    private static boolean detectLoop(final LinkedNode head) {
     // Create a temporary node 
        LinkedNode temp = new LinkedNode();
        LinkedNode node = head;
        while (node != null) {    
            if (node.getNext() == null) { 
                return false; 
            } 
 
            if (node.getNext() == temp) { 
                return true; 
            } 
   
            LinkedNode tmp = node.getNext();  
            node.setNext(temp);  
            node = tmp; 
        } 
  
        return false; 
    }
    
    public static void main(String[] args) {
        LinkedNode head = null;

        head = LinkedNode.push(head, 20);
        head = LinkedNode.push(head, 4);
        head = LinkedNode.push(head, 15);
        head = LinkedNode.push(head, 10);
        LinkedNode.print(head);

        /* Create loop for testing */
        head.getNext().getNext().getNext().setNext(head);

        if (detectLoop(head)) {
            System.out.println("Loop found");
        } else {
            System.out.println("No Loop");
        }
        LinkedNode.print(head);
    }
}
