package com.purple.leetcode.easy;

import com.purple.leetcode.ds.TreeNode;

/**
 * Problem: <a href =
 * "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Convert
 * Sorted Array to Binary Search Tree</a>
 */
public class ArrayToBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		return createBST(nums, 0, nums.length - 1);
	}

	private TreeNode createBST(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode localRoot = new TreeNode(nums[mid]);

		localRoot.left = createBST(nums, start, mid - 1);
		localRoot.right = createBST(nums, mid + 1, end);

		return localRoot;
	}

}
