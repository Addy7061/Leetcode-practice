/*
Problem: N-Queens II
Problem No: 52
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Backtracking
- Recursion
- Array
- Constraint Optimization

----------------------------------
Problem Statement:
----------------------------------
The n-queens puzzle requires placing n queens on an n x n chessboard
such that no two queens attack each other.

Given an integer n, return the number of distinct valid solutions.

Unlike N-Queens I, you only need to count the solutions,
not return the board configurations.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Backtracking row by row.
2. For each row, try placing a queen in every column.
3. Maintain three boolean arrays to mark attacks:
   - cols[col]   → column occupied
   - diag1[row - col + n - 1] → main diagonal
   - diag2[row + col]         → anti-diagonal
4. If a position is safe, place the queen and recurse to next row.
5. When row == n, one valid solution is found → return 1.
6. Backtrack by unmarking the column and diagonals.
7. Sum all valid possibilities.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(N!)
Space Complexity: O(N)
  (recursion stack + constraint arrays)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int totalNQueens(int n) {

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row - col + n - 1
        boolean[] diag2 = new boolean[2 * n - 1]; // row + col

        return backtrack(0, n, cols, diag1, diag2);
    }

    private int backtrack(int row, int n,
                          boolean[] cols, boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            return 1; // one valid solution found
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            cols[col] = diag1[d1] = diag2[d2] = true;
            count += backtrack(row + 1, n, cols, diag1, diag2);
            cols[col] = diag1[d1] = diag2[d2] = false;
        }

        return count;
    }
}
