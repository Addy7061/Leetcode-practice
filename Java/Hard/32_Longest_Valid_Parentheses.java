/*
Problem: Longest Valid Parentheses
Problem No: 32
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Stack
- String
- Dynamic Programming (Conceptual)

----------------------------------
Problem Statement:
----------------------------------
Given a string containing only '(' and ')',
return the length of the longest valid (well-formed)
parentheses substring.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a stack to store indices.
2. Push -1 initially to act as a base index.
3. Traverse the string:
   - If '(' is found, push its index.
   - If ')' is found:
       a) Pop from stack.
       b) If stack becomes empty, push current index as base.
       c) Otherwise, calculate valid length as:
          current index - stack.peek().
4. Keep track of the maximum length found.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {
    public int longestValidParentheses(String s) {

        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();

        // Base index for valid substring calculation
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}
