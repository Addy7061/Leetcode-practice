/*
Problem: Minimum Changes To Make Alternating Binary String
Problem No: 1758
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given a binary string s consisting of characters '0' and '1'.

In one operation, you can flip any character:
0 → 1
1 → 0

A string is called alternating if no two adjacent characters are equal.

Example:
"0101" ✓
"1010" ✓
"0100" ✗

Return the minimum number of operations required to make the string alternating.

----------------------------------
Approach:
----------------------------------
There are only two possible alternating patterns:

Pattern 1 → "010101..."
Pattern 2 → "101010..."

We calculate:
1. Changes required if string starts with '0'
2. Changes required if string starts with '1'

The answer is the minimum of these two.

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

    public int minOperations(String s) {

        int n = s.length();

        int startWith0 = 0;
        int startWith1 = 0;

        for (int i = 0; i < n; i++) {

            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0)
                startWith0++;

            if (s.charAt(i) != expected1)
                startWith1++;
        }

        return Math.min(startWith0, startWith1);
    }
}
