package com.purple.leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.purple.leetcode.ds.TreeNode;

/**
 * Problem: <a href =
 * "https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary
 * Tree Level Order Traversal</a>
 */
public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode lastNode = root;

		List<Integer> nodesInLevel = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			nodesInLevel.add(current.val);

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);

			if (current == lastNode) {
				result.add(nodesInLevel);
				lastNode = queue.peekLast();
				nodesInLevel = new ArrayList<>();
			}
		}

		return result;
	}

}
