/*
Problem: Max Dot Product of Two Subsequences
Problem No: 1458
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Dynamic Programming
- Array

----------------------------------
Problem Statement:
----------------------------------
Given two arrays nums1 and nums2, return the maximum dot product
between non-empty subsequences of nums1 and nums2 having the same length.

A subsequence is formed by deleting some elements without changing
the order of remaining elements.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Dynamic Programming (2D DP table).
2. dp[i][j] represents the maximum dot product using subsequences
   from nums1[i:] and nums2[j:].
3. At each step:
   - Either skip an element from nums1
   - Or skip an element from nums2
   - Or take both nums1[i] and nums2[j] and include their product
4. Handle negative values carefully by initializing DP with
   Integer.MIN_VALUE.
5. Ensure at least one pair is selected (non-empty subsequence).

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * m)
Space Complexity: O(n * m)

(where n = nums1.length, m = nums2.length)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        // Initialize DP with very small values
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int prod = nums1[i] * nums2[j];

                int takeBoth = prod;
                if (dp[i + 1][j + 1] != Integer.MIN_VALUE) {
                    takeBoth = Math.max(takeBoth, prod + dp[i + 1][j + 1]);
                }

                dp[i][j] = Math.max(
                        Math.max(dp[i + 1][j], dp[i][j + 1]),
                        takeBoth
                );
            }
        }

        return dp[0][0];
    }
}
