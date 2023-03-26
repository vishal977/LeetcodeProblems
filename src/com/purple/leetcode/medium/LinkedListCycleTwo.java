package com.purple.leetcode.medium;

import java.util.HashSet;

import com.purple.leetcode.ds.ListNode;

/**
 * Problem:
 * <a href = "https://leetcode.com/problems/linked-list-cycle-ii/">Linked List
 * Cycle II</a>
 */
public class LinkedListCycleTwo {

	public ListNode detectCycle(ListNode head) {
		HashSet<ListNode> visitedNodes = new HashSet<>();
		ListNode temp = head;
		while (temp != null && temp.next != null) {
			if (visitedNodes.contains(temp.next))
				return temp.next;
			visitedNodes.add(temp);
			temp = temp.next;
		}
		return null;
	}

}
