/*
Problem: Find First and Last Position of Element in Sorted Array
Problem No: 34
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Binary Search

----------------------------------
Problem Statement:
----------------------------------
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.

If target is not found, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use binary search to find the first occurrence of the target.
2. Use binary search again to find the last occurrence of the target.
3. If the first occurrence is not found, return [-1, -1].
4. Otherwise, return both indices.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(log n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[]{-1, -1};

        ans[0] = findFirst(nums, target);
        if (ans[0] == -1) return ans;

        ans[1] = findLast(nums, target);
        return ans;
    }

    // Find first occurrence of target
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    // Find last occurrence of target
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }
}
