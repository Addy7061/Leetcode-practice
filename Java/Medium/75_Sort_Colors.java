/*
Problem: Sort Colors
Problem No: 75
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Two Pointers
- Array
- In-place Sorting
- Dutch National Flag Algorithm

----------------------------------
Problem Statement:
----------------------------------
Given an array nums containing only 0s, 1s, and 2s,
sort the array in-place so that all 0s come first,
then all 1s, and then all 2s.

You must solve the problem without using any
library sort function.

----------------------------------
Approach / Explanation:
----------------------------------
This problem is a classic application of the
Dutch National Flag Algorithm.

We maintain three pointers:
- low  : boundary for 0s
- mid  : current element under consideration
- high : boundary for 2s

Rules:
- If nums[mid] == 0 → swap with low, move low & mid
- If nums[mid] == 1 → just move mid
- If nums[mid] == 2 → swap with high, move high only

This ensures:
- [0 .. low-1]   → all 0s
- [low .. mid-1] → all 1s
- [high+1 .. n-1]→ all 2s

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

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                mid++;
            } 
            else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
