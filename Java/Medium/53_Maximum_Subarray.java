/*
Problem: Maximum Subarray
Problem No: 53
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Dynamic Programming
- Greedy

----------------------------------
Problem Statement:
----------------------------------
Given an integer array `nums`, find the contiguous subarray
(containing at least one number) which has the largest sum
and return its sum.

----------------------------------
Approach / Explanation:
----------------------------------
Kadane’s Algorithm (O(n)):

1. Maintain two variables:
   - currentSum → maximum subarray sum ending at current index
   - maxSum     → global maximum subarray sum
2. For each element:
   - Either start a new subarray at current element
     OR extend the previous subarray.
   - currentSum = max(nums[i], currentSum + nums[i])
3. Update maxSum at every step.
4. At the end, maxSum contains the answer.

This works because a negative prefix never helps in maximizing sum.

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

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
