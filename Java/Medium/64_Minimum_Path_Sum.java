/*
Problem: Minimum Path Sum
Problem No: 64
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Dynamic Programming
- Matrix DP
- Greedy Transition

----------------------------------
Problem Statement:
----------------------------------
You are given an m x n grid filled with
non-negative numbers.

Find a path from the top-left corner
to the bottom-right corner such that
the sum of all numbers along the path
is minimized.

Rules:
- You can only move either DOWN or RIGHT.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Dynamic Programming.
2. Modify the grid in-place to store
   the minimum path sum to reach each cell.
3. Initialization:
   - First column: can only come from top.
   - First row: can only come from left.
4. For each cell (i, j):
   grid[i][j] += min(
       grid[i - 1][j],   // from top
       grid[i][j - 1]    // from left
   )
5. The bottom-right cell will contain
   the minimum path sum.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m × n)
Space Complexity: O(1) (in-place DP)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Fill first column
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // Fill first row
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Fill remaining cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(
                        grid[i - 1][j],
                        grid[i][j - 1]
                );
            }
        }

        return grid[m - 1][n - 1];
    }
}
