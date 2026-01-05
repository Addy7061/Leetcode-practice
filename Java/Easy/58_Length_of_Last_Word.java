/*
Problem: Length of Last Word
Problem No: 58
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String

----------------------------------
Problem Statement:
----------------------------------
Given a string s consisting of words and spaces, return the length
of the last word in the string.

A word is defined as a maximal substring consisting of non-space
characters only.

----------------------------------
Approach / Explanation:
----------------------------------
1. Start from the end of the string.
2. Skip all trailing spaces.
3. Count characters until a space or start of the string is reached.
4. The count represents the length of the last word.

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
    public int lengthOfLastWord(String s) {

        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
