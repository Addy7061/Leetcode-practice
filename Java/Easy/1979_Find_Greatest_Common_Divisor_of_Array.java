/*
Problem: Find Greatest Common Divisor of Array
Problem No: 1979
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Math
- GCD

----------------------------------
Problem Statement:
----------------------------------
Given an integer array nums, return the greatest common divisor (GCD)
of the smallest number and the largest number in the array.

----------------------------------
Approach / Explanation:
----------------------------------
1. Traverse the array to find:
   - Minimum value
   - Maximum value
2. Compute the GCD of min and max using
   Euclidean Algorithm.
3. Return the computed GCD.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n + log(min, max))
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int findGCD(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max in array
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Compute GCD of min and max
        return gcd(min, max);
    }

    // Euclidean Algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
