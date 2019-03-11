package com.study.kokhrimenko.algoriths.external.leetcode.retursion;

/**
 * Reverse a singly linked list.
 * 
 * Time complexity : O(n)O(n). Assume that nn is the list's length, the time
 * complexity is O(n)O(n).
 * 
 * Space complexity : O(n)O(n). The extra space comes from implicit stack space
 * due to recursion. The recursion could go up to nn levels deep.
 * 
 * @author kostic
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode first = new ListNode(2);
		head.next = first;

		ListNode second = new ListNode(3);
		first.next = second;

		ListNode thirth = new ListNode(4);
		second.next = thirth;

		ListNode fourth = new ListNode(5);
		thirth.next = fourth;

		ReverseLinkedList executor = new ReverseLinkedList();
		head = executor.reverseList(head);
		ListNode node = head;
		if (head != null) {
			while (node != null) {
				System.out.print(node.val + "-->");
				node = node.next;
			}
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
