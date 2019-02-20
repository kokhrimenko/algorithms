package com.study.kokhrimenko.algoriths.external.leetcode;

import java.math.BigInteger;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
	
	private String convertListNodeToString(ListNode l) {
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + val;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ListNode other = (ListNode) obj;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (val != other.val)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + (next != null ? next.toString() : "'null'") + "]";
		}
	}
}	
