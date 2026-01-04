/*
Problem: Sign of the Product of an Array
Problem No: 1822
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Math

----------------------------------
Problem Statement:
----------------------------------
Implement a function signFunc(x) that returns:
1 if x is positive,
-1 if x is negative,
0 if x is equal to 0.

Given an integer array nums, let product be the product of all values
in the array. Return signFunc(product).

----------------------------------
Approach / Explanation:
----------------------------------
1. Initialize sign as 1.
2. Traverse the array:
   - If any element is 0, return 0 immediately.
   - If an element is negative, flip the sign.
3. Return the final sign.

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
    public int arraySign(int[] nums) {

        int sign = 1;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign = -sign;
            }
        }

        return sign;
    }
}
