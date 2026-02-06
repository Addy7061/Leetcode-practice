/*
Problem: Minimum Removals to Balance Array
Problem No: 3634
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Sorting
- Two Pointers / Sliding Window

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given an integer array nums and an integer k.

An array is considered balanced if:
    max_element <= min_element * k

You may remove any number of elements (array must not be empty).

Return the minimum number of elements to remove so that
the remaining array is balanced.

------------------------------------------------
Key Observation:
------------------------------------------------
- After sorting, for any valid balanced subarray:
      nums[right] <= nums[left] * k
- We want to KEEP the largest possible subarray that satisfies this.
- Answer = total elements - size of largest valid subarray

------------------------------------------------
Approach:
------------------------------------------------
1. Sort the array.
2. Use two pointers (sliding window).
3. Expand right pointer.
4. If condition breaks, move left pointer.
5. Track the maximum window size that is balanced.
6. Return n - maxWindow.

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring sort space)

------------------------------------------------
Solution:
------------------------------------------------
*/
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int maxWindow = 1;

        for (int right = 0; right < n; right++) {
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}
