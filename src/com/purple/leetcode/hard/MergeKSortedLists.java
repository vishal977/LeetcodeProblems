package com.purple.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.purple.leetcode.ds.ListNode;

/**
 * Problem:
 * <a href = "https://leetcode.com/problems/merge-k-sorted-lists/">Merge k
 * Sorted Lists </a>
 */
public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new SortByValues());

		for (ListNode head : lists) {
			if (null != head)
				minHeap.add(head);
		}

		ListNode mergedList = new ListNode(-1);
		ListNode temp = mergedList;

		while (!minHeap.isEmpty()) {
			ListNode minNode = minHeap.poll();
			temp.next = minNode;
			temp = temp.next;

			if (minNode.next != null)
				minHeap.add(minNode.next);
		}

		return mergedList.next;
	}

}

class SortByValues implements Comparator<ListNode> {

	@Override
	public int compare(ListNode o1, ListNode o2) {
		return o1.val - o2.val;
	}

}
