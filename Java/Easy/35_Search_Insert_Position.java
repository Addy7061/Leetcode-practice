/*
Problem: Search Insert Position
Problem No: 35
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Binary Search

----------------------------------
Problem Statement:
----------------------------------
Given a sorted array of distinct integers and a target value,
return the index if the target is found.

If not found, return the index where it would be inserted
in order.

The algorithm must run in O(log n) time.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use binary search on the sorted array.
2. If target is found, return its index.
3. If target is not found, the position where the search ends
   (left pointer) is the correct insert position.
4. Return left after the loop ends.

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
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        // left is the correct insert position
        return left;
    }
}
