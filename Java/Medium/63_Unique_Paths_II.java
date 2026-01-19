/*
Problem: Unique Paths II
Problem No: 63
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Dynamic Programming
- Grid DP
- Matrix Traversal

----------------------------------
Problem Statement:
----------------------------------
A robot is placed on an m x n grid.
Some cells contain obstacles (marked as 1),
while empty cells are marked as 0.

The robot starts at the top-left corner
and wants to reach the bottom-right corner.

The robot can only move:
- Right
- Down

The robot cannot move through obstacles.

Return the number of unique paths
to reach the destination.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Dynamic Programming.
2. Let dp[i][j] represent the number
   of ways to reach cell (i, j).
3. If a cell contains an obstacle,
   dp[i][j] = 0.
4. Base cases:
   - If start or end cell is blocked,
     return 0.
   - dp[0][0] = 1 if no obstacle.
5. Transition:
      dp[i][j] = dp[i-1][j] + dp[i][j-1]
6. Final answer is dp[m-1][n-1].

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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start or end is blocked
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // Starting cell
        dp[0][0] = 1;

        // Fill first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Fill first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill remaining grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
