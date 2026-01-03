/*
Problem: Median of Two Sorted Arrays
Problem No: 4
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Binary Search
- Array
- Divide and Conquer

----------------------------------
Problem Statement:
----------------------------------
Given two sorted arrays nums1 and nums2 of sizes m and n respectively,
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m + n)).

----------------------------------
Approach / Explanation:
----------------------------------
1. Always perform binary search on the smaller array.
2. Partition both arrays such that the left half contains
   half of the total elements.
3. Ensure the partition condition:
   max(leftA, leftB) <= min(rightA, rightB)
4. If total length is even, median is the average of two middle values.
5. If total length is odd, median is the maximum of left partition.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(log(min(m, n)))
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) +
                            Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } 
            else if (maxLeftA > minRightB) {
                high = i - 1;
            } 
            else {
                low = i + 1;
            }
        }

        return 0.0; // unreachable
    }
}
