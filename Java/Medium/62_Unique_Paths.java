/*
Problem: Unique Paths
Problem No: 62
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Dynamic Programming
- Combinatorics
- Grid DP

----------------------------------
Problem Statement:
----------------------------------
A robot is placed on an m x n grid.
It starts at the top-left corner
and wants to reach the bottom-right
corner.

The robot can only move:
- Right
- Down

Return the total number of unique
paths to reach the destination.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Dynamic Programming.
2. Let dp[i][j] represent the number
   of unique paths to reach cell (i, j).
3. Base case:
   - First row and first column can
     only be reached in one way.
4. Transition:
      dp[i][j] = dp[i-1][j] + dp[i][j-1]
5. Final answer is dp[m-1][n-1].

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m * n)
Space Complexity: O(m * n)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // Initialize first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Initialize first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
