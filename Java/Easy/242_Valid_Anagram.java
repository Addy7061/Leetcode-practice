/*
Problem: Valid Anagram
Problem No: 242
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Hash Table
- String

----------------------------------
Problem Statement:
----------------------------------
Given two strings s and t, return true if t is an anagram of s,
and false otherwise.

An anagram is formed by rearranging the letters of a word using
all the original letters exactly once.

----------------------------------
Approach / Explanation:
----------------------------------
1. If the lengths of the two strings are different, they cannot be anagrams.
2. Use a frequency array of size 26 to count characters.
3. Increment frequency for characters in string s.
4. Decrement frequency for characters in string t.
5. If all frequency values are zero, the strings are anagrams.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
