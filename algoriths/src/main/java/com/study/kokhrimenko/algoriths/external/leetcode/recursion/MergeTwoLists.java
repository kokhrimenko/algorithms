package com.study.kokhrimenko.algoriths.external.leetcode.recursion;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 * @author kostic
 *
 */
public class MergeTwoLists {
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode list11 = new ListNode(2);
		head1.next = list11;
		ListNode list12 = new ListNode(4);
		list11.next = list12;
		
		ListNode head2 = new ListNode(1);
		ListNode list21 = new ListNode(3);
		head2.next = list21;
		ListNode list22 = new ListNode(4);
		list21.next = list22;
		ListNode list23 = new ListNode(7);
		list22.next = list23;
		
		MergeTwoLists executor = new MergeTwoLists();
		ListNode resultedList = executor.mergeTwoLists(head1, head2);
		ListNode node = resultedList;
		if (resultedList != null) {
			while (node != null) {
				System.out.print(node.val + "-->");
				node = node.next;
			}
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 != null && l2 == null) {
			return l1;
		}

		if (l2 != null && l1 == null) {
			return l2;
		}

		ListNode result;
		if(l1.val <= l2.val) {
			result = new ListNode(l1.val);
			l1 = l1.next;
		} else {
			result = new ListNode(l2.val);
			l2 = l2.next;
		}
		result.next = mergeTwoLists(l1, l2);
		return result;
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
