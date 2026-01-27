/*
Problem: Minimum Window Substring
Problem No: 76
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Sliding Window
- Two Pointers
- Hashing
- String

----------------------------------
Problem Statement:
----------------------------------
Given two strings s and t, find the minimum window substring of s
such that every character in t (including duplicates) is present
in the window.

If no such window exists, return an empty string "".

----------------------------------
Approach / Explanation:
----------------------------------
We use the Sliding Window technique.

Steps:
1. Store the frequency of characters of string t in an array.
2. Use two pointers (left & right) to expand and shrink the window.
3. Expand the right pointer until all characters of t are included.
4. Once valid, try shrinking from the left to get the minimum window.
5. Keep track of the smallest valid window.

This approach runs in linear time.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m + n)
Space Complexity: O(1)  (fixed size array for ASCII characters)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] freq = new int[128]; // ASCII frequency
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0;
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char rc = s.charAt(right);

            if (freq[rc] > 0) {
                required--;
            }
            freq[rc]--;
            right++;

            // when window is valid
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);
                freq[lc]++;
                if (freq[lc] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
