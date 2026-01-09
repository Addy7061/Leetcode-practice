/*
Problem: Search in Rotated Sorted Array
Problem No: 33
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Binary Search

----------------------------------
Problem Statement:
----------------------------------
Given an array nums that was originally sorted in ascending order
and then rotated at an unknown pivot, find the index of a given
target value.

If the target does not exist in the array, return -1.

The algorithm must run in O(log n) time.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use modified binary search.
2. At each step, determine which half of the array is sorted.
3. Check whether the target lies in the sorted half:
   - If yes, narrow the search to that half.
   - Otherwise, search in the other half.
4. Repeat until the target is found or search space is exhausted.

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
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
