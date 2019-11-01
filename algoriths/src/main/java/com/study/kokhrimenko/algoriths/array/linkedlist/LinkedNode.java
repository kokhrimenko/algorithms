package com.study.kokhrimenko.algoriths.array.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
public class LinkedNode {
    private int data;
    @Setter
    private LinkedNode next;

    public LinkedNode() {
        super();
    }

    public LinkedNode(int d) {
        super();

        data = d;
        next = null;
    }

    public static LinkedNode push(LinkedNode head, int value) {
        LinkedNode newNode = new LinkedNode(value);
        newNode.setNext(head);
        return newNode;
    } 
    
    public static void print(LinkedNode head) {
        LinkedNode tmp = head;
        while(tmp != null) {
            System.out.print(tmp.getData() + ";");
            tmp = tmp.getNext();
        }
        System.out.println(" ");
    }
}
