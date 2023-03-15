package com.purple.leetcode.medium;

import java.util.HashSet;

/**
 * Problem:
 * <a href = "https://leetcode.com/problems/linked-list-cycle-ii/">Linked List
 * Cycle II</a>
 */
public class LinkedListCycleTwo {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            if(visitedNodes.contains(temp.next))
                return temp.next;
            visitedNodes.add(temp);
            temp = temp.next;
        }
        return null;
    }

}
