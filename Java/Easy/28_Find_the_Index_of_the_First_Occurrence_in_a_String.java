/*
Problem: Find the Index of the First Occurrence in a String
Problem No: 28
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String

----------------------------------
Problem Statement:
----------------------------------
Given two strings haystack and needle, return the index of the first
occurrence of needle in haystack, or -1 if needle is not part of haystack.

----------------------------------
Approach / Explanation:
----------------------------------
1. Let n be the length of haystack and m be the length of needle.
2. If m > n, needle cannot be present, so return -1.
3. Iterate through haystack from index 0 to (n - m).
4. For each index, check if the substring of length m equals needle.
5. If found, return the current index.
6. If no match is found, return -1.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * m)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
