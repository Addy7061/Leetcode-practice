/*
Problem: Minimum Difference Between Highest and Lowest of K Scores
Problem No: 1984
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Sorting
- Sliding Window
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given an array nums where nums[i] represents
the score of the i-th student.

You are also given an integer k.

Pick scores of any k students such that the difference
between the highest and the lowest score is minimized.

Return the minimum possible difference.

----------------------------------
Approach / Explanation:
----------------------------------
1. If k == 1, answer is 0 because max = min.
2. Sort the array.
3. Use a sliding window of size k.
4. For every window, compute:
      nums[i + k - 1] - nums[i]
5. Take the minimum difference among all windows.

Why it works:
- After sorting, the minimum range of k elements
  must appear as a contiguous subarray.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring sort space)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int minimumDifference(int[] nums, int k) {

        if (k == 1) return 0;

        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < n; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }

        return minDiff;
    }
}
