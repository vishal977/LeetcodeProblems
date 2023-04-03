package com.purple.leetcode.medium;

import com.purple.leetcode.ds.ListNode;

/**
 * Problem: <a href =
 * "https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/">Delete
 * the Middle Node of a Linked List </a>
 */
public class DeleteMiddle {

	public ListNode deleteMiddle(ListNode head) {
		ListNode middleNode = middleNode(head);
		ListNode temp = head;
		while (temp.next != null) {
			if (temp.next == middleNode)
				break;
			temp = temp.next;
		}
		if (temp.next != null)
			temp.next = temp.next.next;
		else
			head = null;
		return head;
	}

	// Finds the middle node of a Linked list using fast & slow pointer approach.
	private ListNode middleNode(ListNode head) {
		ListNode fastPointer = head;
		ListNode slowPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}

		return slowPointer;
	}

}
