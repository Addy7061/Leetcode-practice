/*
Problem: Check if Binary String Has at Most One Segment of Ones
Problem No: 1784
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String

----------------------------------
Problem Statement:
----------------------------------
You are given a binary string s without leading zeros.

Return true if the string contains at most one contiguous segment of '1's.
Otherwise, return false.

Example:
"111000" ✓ (one segment of 1s)
"110011" ✗ (two segments of 1s)

----------------------------------
Key Observation:
----------------------------------
If a string has more than one segment of '1's,
then the pattern "01" must appear.

Example:
1001 → contains "01" → new segment starts

So if "01" exists → return false.

----------------------------------
Approach:
----------------------------------
Simply check if the substring "01" exists.

If it exists → more than one segment of 1s.
If it does not exist → valid.

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

    public boolean checkOnesSegment(String s) {

        // If "01" appears, it means a new segment of 1s starts again
        return !s.contains("01");
    }
}
