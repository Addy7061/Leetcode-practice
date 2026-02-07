/*
Problem: Minimum Deletions to Make String Balanced
Problem No: 1653
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- Greedy
- Dynamic Programming

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given a string s consisting only of characters 'a' and 'b'.

A string is considered balanced if there is no pair (i, j) such that:
    i < j AND s[i] = 'b' AND s[j] = 'a'

You can delete any number of characters.
Return the minimum number of deletions needed to make the string balanced.

------------------------------------------------
Key Observation:
------------------------------------------------
- All 'a' characters should appear BEFORE any 'b'.
- When we encounter an 'a' after some 'b's:
    • Either delete this 'a'
    • Or delete all previous 'b's
- We choose the minimum of both options.

------------------------------------------------
Approach:
------------------------------------------------
1. Traverse the string character by character.
2. Maintain:
    - bCount → number of 'b' seen so far
    - deletions → minimum deletions required
3. If current character is:
    - 'b' → increment bCount
    - 'a' → deletions = min(deletions + 1, bCount)
4. Return deletions.

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------
Solution:
------------------------------------------------
*/

class Solution {
    public int minimumDeletions(String s) {

        int bCount = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else { // c == 'a'
                deletions = Math.min(deletions + 1, bCount);
            }
        }

        return deletions;
    }
}
