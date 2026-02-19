/*
Problem: Count Binary Substrings
Problem No: 696
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String
- Counting
- Sliding Window Concept

------------------------------------------------
Problem Statement:
------------------------------------------------
Given a binary string s, return the number of non-empty 
substrings that:

1) Have equal number of 0's and 1's
2) All 0's and 1's in the substring are grouped consecutively

Example:
Input:  "00110011"
Output: 6

------------------------------------------------
Key Idea:
------------------------------------------------
Instead of checking all substrings (which would be O(n²)),
we count consecutive groups of 0's and 1's.

Example:
"00110011"
Groups: 2,2,2,2

Valid substrings between adjacent groups =
min(group1, group2)

So total = 
min(2,2) + min(2,2) + min(2,2)

------------------------------------------------
Approach:
------------------------------------------------
1. Count consecutive characters.
2. Keep track of:
   - previous group length
   - current group length
3. Whenever character changes:
   Add min(previousGroup, currentGroup) to result.
4. At the end, add one last min().

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n)

------------------------------------------------
Space Complexity:
------------------------------------------------
O(1)

------------------------------------------------
*/

class Solution {

    public int countBinarySubstrings(String s) {

        int previousGroupLength = 0;
        int currentGroupLength = 1;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                currentGroupLength++;
            } else {
                result += Math.min(previousGroupLength, currentGroupLength);
                previousGroupLength = currentGroupLength;
                currentGroupLength = 1;
            }
        }

        // Add last group comparison
        result += Math.min(previousGroupLength, currentGroupLength);

        return result;
    }
}
