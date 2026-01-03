/*
Problem: 3Sum Closest
Problem No: 16
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Two Pointers
- Sorting

----------------------------------
Problem Statement:
----------------------------------
Given an integer array nums and an integer target, find three integers
in nums such that the sum is closest to the target.

Return the sum of the three integers.
You may assume that exactly one solution exists.

----------------------------------
Approach / Explanation:
----------------------------------
1. Sort the array to efficiently use the two-pointer technique.
2. Fix one element and use two pointers to find the best possible sum.
3. Compare the current sum with the closest sum found so far.
4. Move pointers based on whether the sum is smaller or larger than the target.
5. If an exact match is found, return immediately.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n²)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum; // exact match
                }
            }
        }

        return closestSum;
    }
}
