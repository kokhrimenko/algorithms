package com.study.external.leetcode;

import java.math.BigInteger;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(1);
		ListNode l111 = new ListNode(1);
		ListNode l1111 = new ListNode(1);
		ListNode l11111 = new ListNode(1);
		ListNode l111111 = new ListNode(1);
		ListNode l1111111 = new ListNode(1);
		ListNode l11111111 = new ListNode(1);
		ListNode l111111111 = new ListNode(1);
		ListNode l1111111111 = new ListNode(1);
		ListNode l11111111111 = new ListNode(1);
		l1.next = l11;
		l11.next = l111;
		l111.next = l1111;
		l1111.next = l11111;
		l11111.next = l111111;
		l111111.next = l1111111;
		l1111111.next = l11111111;
		l11111111.next = l111111111;
		l111111111.next = l1111111111;
		l1111111111.next = l11111111111;
		
		ListNode l2 = new ListNode(1);
		ListNode l21 = new ListNode(1);
		ListNode l211 = new ListNode(1);
		ListNode l2111 = new ListNode(1);
		ListNode l21111 = new ListNode(1);
		ListNode l211111 = new ListNode(1);
		ListNode l2111111 = new ListNode(1);
		ListNode l21111111 = new ListNode(1);
		ListNode l211111111 = new ListNode(1);
		ListNode l2111111111 = new ListNode(1);
		ListNode l21111111111 = new ListNode(1);
		l2.next = l21;
		l21.next = l211;
		l211.next = l2111;
		l2111.next = l21111;
		l21111.next = l211111;
		l211111.next = l2111111;
		l2111111.next = l21111111;
		l21111111.next = l211111111;
		l211111111.next = l2111111111;
		l2111111111.next = l21111111111;
		
		
		ListNode resultedNode = AddTwoNumbers.addTwoNumbers(l1, l2);
		ListNode currNode = resultedNode;
		System.out.println(currNode.val);
		while((currNode = currNode.next) != null) {
			System.out.println(currNode.val);
			currNode = currNode.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) {
			return null;
		}
		BigInteger l1AsNumber = new BigInteger(convertListNodeToString(l1));
		BigInteger l2AsNumber = new BigInteger(convertListNodeToString(l2));
		BigInteger resultedNumber = l1AsNumber.add(l2AsNumber);
		ListNode node = null,
				rootNode = null,
				prevNode = null;
		BigInteger ten = new BigInteger("10");
		while(resultedNumber.divide(ten).signum() == 1) {
			int digit = resultedNumber.mod(ten).intValue();
			node = new ListNode(digit);
			if(rootNode == null) {
				rootNode = node;
			}
			if(prevNode != null) {				
				prevNode.next = node;
			}
			prevNode = node;
			resultedNumber = resultedNumber.divide(ten);
		}
		int digit = resultedNumber.mod(ten).intValue();
		node = new ListNode(digit);
		if(rootNode == null) {
			rootNode = node;
		}
		if(prevNode != null) {
			prevNode.next = node;
		}
		return rootNode;
	}
	
	private static String convertListNodeToString(ListNode l) {
		StringBuilder lAsString = new StringBuilder();
		lAsString.insert(0, l.val);
		ListNode node = l;
		while((node = node.next) != null) {
			lAsString.insert(0, node.val);
		}
		
		return lAsString.toString();
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) {
			super();
			this.val = x;
		}
	}
}	
