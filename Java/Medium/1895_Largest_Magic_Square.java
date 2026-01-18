/*
Problem: Largest Magic Square
Problem No: 1895
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Matrix
- Prefix Sum
- Brute Force Optimization

----------------------------------
Problem Statement:
----------------------------------
A k x k magic square is a grid where:
- All row sums are equal
- All column sums are equal
- Both diagonal sums are equal

Given an m x n grid, find the size (side length k)
of the largest magic square that exists in the grid.
Every 1 x 1 grid is trivially a magic square.

----------------------------------
Approach / Explanation:
----------------------------------
1. Precompute prefix sums:
   - rowPrefix[i][j] → sum of row i from column 0 to j-1
   - colPrefix[i][j] → sum of column j from row 0 to i-1

2. Try all possible square sizes from 2 to min(m, n):
   - For each top-left corner (r, c):
     - Check if the square of given size is magic.

3. To verify a magic square:
   - Compute target sum using first row.
   - Check all rows using rowPrefix.
   - Check all columns using colPrefix.
   - Check both diagonals directly.

4. Track the maximum valid size found.
5. Default answer is 1 since every single cell is magic.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m * n * min(m, n))
Space Complexity: O(m * n)  (for prefix sums)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int largestMagicSquare(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Prefix sum for rows
        int[][] rowPrefix = new int[m][n + 1];
        // Prefix sum for columns
        int[][] colPrefix = new int[m + 1][n];

        // Build prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }
        }

        int maxSize = 1; // Every 1x1 grid is magic

        for (int size = 2; size <= Math.min(m, n); size++) {
            for (int r = 0; r + size <= m; r++) {
                for (int c = 0; c + size <= n; c++) {
                    if (isMagic(grid, rowPrefix, colPrefix, r, c, size)) {
                        maxSize = Math.max(maxSize, size);
                    }
                }
            }
        }

        return maxSize;
    }

    private boolean isMagic(int[][] grid,
                            int[][] rowPrefix,
                            int[][] colPrefix,
                            int r, int c, int size) {

        int target = rowPrefix[r][c + size] - rowPrefix[r][c];

        // Check rows
        for (int i = r; i < r + size; i++) {
            int sum = rowPrefix[i][c + size] - rowPrefix[i][c];
            if (sum != target) return false;
        }

        // Check columns
        for (int j = c; j < c + size; j++) {
            int sum = colPrefix[r + size][j] - colPrefix[r][j];
            if (sum != target) return false;
        }

        // Check main diagonal
        int diag1 = 0;
        for (int i = 0; i < size; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != target) return false;

        // Check anti-diagonal
        int diag2 = 0;
        for (int i = 0; i < size; i++) {
            diag2 += grid[r + i][c + size - 1 - i];
        }
        if (diag2 != target) return false;

        return true;
    }
}
