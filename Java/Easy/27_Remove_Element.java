/*
Problem: Remove Element
Problem No: 27
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
Given an integer array nums and an integer val, remove all occurrences
of val in-place.

Return the number of elements k that are not equal to val.
The first k elements of nums should contain the remaining elements.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a pointer k to track the position of valid elements.
2. Traverse the array.
3. If the current element is not equal to val, place it at nums[k]
   and increment k.
4. Ignore elements beyond index k - 1.
5. Return k.

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
    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int num : nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }

        return k;
    }
}
