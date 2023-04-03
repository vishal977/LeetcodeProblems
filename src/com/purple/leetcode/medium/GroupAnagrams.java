package com.purple.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: <a href = "https://leetcode.com/problems/group-anagrams/">Group
 * Anagrams</a>
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hm = new HashMap<>();

		for (String s : strs) {
			String sign = getSign(s);
			if (hm.containsKey(sign)) {
				hm.get(sign).add(s);
			} else {
				List<String> group = new ArrayList<>();
				group.add(s);
				hm.put(sign, group);
			}
		}

		List<List<String>> out = new ArrayList<>();

		for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
			List<String> vals = entry.getValue();
			out.add(vals);
		}

		return out;
	}

	private String getSign(String s) {
		char[] arr = new char[26];

		for (Character c : s.toCharArray()) {
			arr[c - 'a']++;
		}

		return String.valueOf(arr);
	}

}
