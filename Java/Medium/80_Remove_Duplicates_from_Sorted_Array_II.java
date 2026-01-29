/*
Problem: Remove Duplicates from Sorted Array II
Problem No: 80
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Two Pointers
- Array
- In-place Algorithms

----------------------------------
Problem Statement:
----------------------------------
Given a sorted integer array `nums`, remove duplicates in-place
such that each unique element appears at most twice.

The relative order of elements must be maintained.
Return the number of valid elements `k` such that
the first `k` elements of the array contain the result.

----------------------------------
Approach / Explanation:
----------------------------------
Key Observations:
- The array is already sorted.
- Each number can appear at most **twice**.
- We must modify the array **in-place** with O(1) extra space.

Approach:
1. If array length ≤ 2, all elements are allowed.
2. Maintain a write pointer `idx` starting from index 2
   (because first two elements are always valid).
3. Traverse from index 2 onward:
   - If current element is NOT equal to `nums[idx - 2]`,
     it means it has appeared less than twice → keep it.
4. Place valid elements at `nums[idx]` and increment `idx`.

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
        int n = nums.length;

        // If array has 2 or fewer elements, all are allowed
        if (n <= 2) return n;

        int idx = 2; // write index

        for (int i = 2; i < n; i++) {
            // allow element only if it does not exceed twice
            if (nums[i] != nums[idx - 2]) {
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }
}
