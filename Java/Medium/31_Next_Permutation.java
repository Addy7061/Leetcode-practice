/*
Problem: Next Permutation
Problem No: 31
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
Given an array of integers nums, find the next lexicographically
greater permutation of nums.

If such permutation is not possible, rearrange nums into the
lowest possible order (ascending order).

The replacement must be done in-place with constant extra memory.

----------------------------------
Approach / Explanation:
----------------------------------
1. Traverse from right to left to find the first index i such that
   nums[i] < nums[i + 1]. This is the break point.
2. If such index exists:
   - Find the smallest element on the right side of i that is greater
     than nums[i].
   - Swap these two elements.
3. Reverse the subarray to the right of index i to get the next
   smallest lexicographical permutation.
4. If no such index exists, reverse the entire array.

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
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n - 2;

        // 1. Find first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. Swap with just larger element on the right
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
