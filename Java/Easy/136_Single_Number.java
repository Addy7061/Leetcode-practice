/*
Problem: Single Number
Problem No: 136
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation
- Array

----------------------------------
Problem Statement:
----------------------------------
Given a non-empty array of integers nums, every element appears twice
except for one. Find that single one.

You must implement a solution with linear runtime complexity and
constant extra space.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use the XOR (^) operator.
2. XOR of a number with itself is 0.
3. XOR of a number with 0 is the number itself.
4. XOR all elements of the array.
5. All duplicate numbers cancel out, leaving the single number.

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
    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
