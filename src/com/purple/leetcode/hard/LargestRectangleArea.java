package com.purple.leetcode.hard;

import java.util.Stack;

/**
 * Problem: <a href =
 * "https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest
 * Rectangle in Histogram</a>
 */
public class LargestRectangleArea {

	public int largestRectangleArea(int[] A) {
		int n = A.length;

		if (n == 1)
			return A[0];

		// Pre-computing nearest smaller or equal element to the left of each i
		Stack<Integer> stackL = new Stack<>();
		int[] left = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stackL.isEmpty() && A[stackL.peek()] >= A[i])
				stackL.pop();

			if (stackL.isEmpty())
				left[i] = -1;
			else
				left[i] = stackL.peek();

			stackL.push(i);
		}

		// Pre-computing nearest smaller or equal element to the right of each i
		Stack<Integer> stackR = new Stack<>();
		int[] right = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stackR.isEmpty() && A[stackR.peek()] >= A[i])
				stackR.pop();

			if (stackR.isEmpty())
				right[i] = n;
			else
				right[i] = stackR.peek();

			stackR.push(i);
		}

		int largestArea = Integer.MIN_VALUE;

		/*
		 * For every A[i], we have nearest smaller/equal element to its left and right
		 * available at left[i] and right[i] respectively.
		 * 
		 * Width of the rectangle will extend from (left[i] + 1) to (right[i] - 1),
		 * since these two elements will be smaller/equal than A[i] and cannot be
		 * included. Width from index l to r is given by (r - l + 1). Substituting our
		 * values here, we get ( (right[i] - 1) - (left[i] + 1) + 1) = (right[i] -
		 * left[i] - 1)
		 * 
		 * So, area = A[i] * (right[i] - left[i] - 1)
		 * 
		 */
		for (int i = 0; i < n; i++) {
			int area = A[i] * (right[i] - left[i] - 1);
			largestArea = Math.max(largestArea, area);
		}

		return largestArea;
	}
}
