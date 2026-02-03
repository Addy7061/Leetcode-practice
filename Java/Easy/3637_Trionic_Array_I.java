/*
Problem: Trionic Array I
Problem No: 3637
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Two Pointers
- Simulation

----------------------------------
Problem Statement:
----------------------------------
You are given an integer array nums of length n.

An array is called trionic if there exist indices
0 < p < q < n - 1 such that:

1) nums[0...p] is strictly increasing
2) nums[p...q] is strictly decreasing
3) nums[q...n - 1] is strictly increasing

Return true if nums is trionic, otherwise return false.

----------------------------------
Approach / Explanation:
----------------------------------
We simulate the three phases using a pointer:

1) Move forward while elements are strictly increasing.
2) Then move forward while elements are strictly decreasing.
3) Finally, move forward while elements are strictly increasing again.

To be valid:
- All three phases must exist (non-empty).
- The pointer must reach exactly the end of the array.

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
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 1;

        // 1️⃣ strictly increasing
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }
        if (i == 1 || i == n) return false;

        // 2️⃣ strictly decreasing
        int decStart = i;
        while (i < n && nums[i] < nums[i - 1]) {
            i++;
        }
        if (i == decStart || i == n) return false;

        // 3️⃣ strictly increasing again
        while (i < n && nums[i] > nums[i - 1]) {
            i++;
        }

        return i == n;
    }
}
