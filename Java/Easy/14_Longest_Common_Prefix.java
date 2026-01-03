/*
Problem: Longest Common Prefix
Problem No: 14
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String

----------------------------------
Problem Statement:
----------------------------------
Write a function to find the longest common prefix string among an array
of strings.

If there is no common prefix, return an empty string "".

----------------------------------
Approach / Explanation:
----------------------------------
1. Assume the first string as the initial prefix.
2. Compare this prefix with each subsequent string.
3. While the current string does not start with the prefix,
   reduce the prefix by removing its last character.
4. If the prefix becomes empty, return an empty string.
5. After checking all strings, return the final prefix.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * m)
Space Complexity: O(1)

(where n = number of strings, m = length of the prefix)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
