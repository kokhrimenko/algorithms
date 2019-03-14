package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 *  
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author kostic
 *
 */
public class SwapNodesInPair {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode list1 = new ListNode(2);
		head.next = list1;
		ListNode list2 = new ListNode(3);
		list1.next = list2;
		ListNode list3 = new ListNode(4);
		list2.next = list3;

		SwapNodesInPair executor = new SwapNodesInPair();
		head = executor.swapPairs(head);
		ListNode node = head;
		if (head != null) {
			while (node != null) {
				System.out.print(node.val + "-->");
				node = node.next;
			}
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nextNode = head;
		head = head.next;
		nextNode.next = head.next;
		head.next = nextNode;
		nextNode.next = swapPairs(nextNode.next);
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
