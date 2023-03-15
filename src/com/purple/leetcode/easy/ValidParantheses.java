package com.purple.leetcode.easy;

import java.util.Stack;

/**
 * Problem: <a href = "https://leetcode.com/problems/valid-parentheses/">Valid Parantheses </a>
 */
public class ValidParantheses {
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            Character c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            
            if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            }

            if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
            }

            if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
