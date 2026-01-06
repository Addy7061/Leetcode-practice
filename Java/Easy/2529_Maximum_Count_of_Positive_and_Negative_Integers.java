/*
Problem: Maximum Count of Positive Integer and Negative Integer
Problem No: 2529
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Counting

----------------------------------
Problem Statement:
----------------------------------
Given an array nums sorted in non-decreasing order, return the maximum
between the number of positive integers and the number of negative integers.

Note:
- 0 is neither positive nor negative.

----------------------------------
Approach / Explanation:
----------------------------------
1. Initialize counters for negative and positive numbers.
2. Traverse the array once:
   - Increment negative counter if the element is < 0.
   - Increment positive counter if the element is > 0.
3. Return the maximum of the two counters.

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
    public int maximumCount(int[] nums) {

        int neg = 0;
        int pos = 0;

        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num > 0) {
                pos++;
            }
        }

        return Math.max(neg, pos);
    }
}
