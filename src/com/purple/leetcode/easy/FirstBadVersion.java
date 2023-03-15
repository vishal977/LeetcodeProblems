package com.purple.leetcode.easy;

/**
 * Problem:
 * <a href = "https://leetcode.com/problems/linked-list-cycle-ii/">First Bad
 * Version</a>
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(isBadVersion(mid) && ( mid == 0 || !isBadVersion(mid-1) )) {
                return mid;
            }

            if(isBadVersion(mid)) {
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return 0;
    }

	private boolean isBadVersion(int mid) {
		//API call to other component. No implementation needed for this problem.
		return false;
	}
}
