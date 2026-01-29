/*
Problem: Search in Rotated Sorted Array II
Problem No: 81
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Search
- Array
- Divide and Conquer

----------------------------------
Problem Statement:
----------------------------------
You are given a sorted array `nums` that has been rotated at an
unknown pivot. The array may contain duplicate elements.

Given a target value, return true if the target exists in the array,
otherwise return false.

You should try to minimize the total number of operations.

----------------------------------
Approach / Explanation:
----------------------------------
Key Challenge:
- Unlike Problem 33, this array can contain duplicates.
- Duplicates can make it ambiguous to decide which half is sorted.

Approach:
1. Use modified Binary Search.
2. If `nums[mid] == target`, return true.
3. If `nums[left] == nums[mid] == nums[right]`:
   - We cannot determine the sorted half.
   - Shrink the search space by incrementing `left` and decrementing `right`.
4. Otherwise:
   - If left half is sorted:
       - Check if target lies in left half.
   - Else right half must be sorted:
       - Check if target lies in right half.
5. Adjust pointers accordingly.

----------------------------------
Why Runtime Can Degrade:
----------------------------------
- In the worst case (e.g. all elements are same),
  binary search degrades to linear search.
- Worst-case Time Complexity becomes O(n).

----------------------------------
Time & Space Complexity:
----------------------------------
Average Time Complexity: O(log n)
Worst-case Time Complexity: O(n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;

            // Case: duplicates on both ends
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
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

        return false;
    }
}
