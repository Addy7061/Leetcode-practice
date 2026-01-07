/*
Problem: Remove Duplicates from Sorted Array
Problem No: 26
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
Given an integer array nums sorted in non-decreasing order, remove the
duplicates in-place such that each unique element appears only once.

Return the number of unique elements k.
The first k elements of nums should contain the unique elements
in sorted order.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a two-pointer approach.
2. Pointer k keeps track of the position for the next unique element.
3. Traverse the array from index 1.
4. Whenever a new unique element is found, place it at nums[k]
   and increment k.
5. Return k as the number of unique elements.

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
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
