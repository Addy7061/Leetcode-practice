/*
Problem: Merge Sorted Array
Problem No: 88
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
You are given two sorted arrays nums1 and nums2 with sizes m and n.
Merge nums2 into nums1 as one sorted array.

Note:
- nums1 has size m + n
- First m elements are valid
- Last n elements are empty (0s)
- Do the merge in-place

----------------------------------
Approach / Explanation:
----------------------------------
Key Idea:
- Merge from the END to avoid overwriting elements in nums1.

Steps:
1. Use three pointers:
   - i → last valid element of nums1 (m - 1)
   - j → last element of nums2 (n - 1)
   - k → last position of nums1 (m + n - 1)
2. Compare nums1[i] and nums2[j]
3. Place the larger value at nums1[k]
4. Move pointers accordingly
5. If nums2 still has elements, copy them

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m + n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;        // last valid index in nums1
        int j = n - 1;        // last index in nums2
        int k = m + n - 1;    // last index in nums1

        // merge from back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // copy remaining nums2 elements if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
