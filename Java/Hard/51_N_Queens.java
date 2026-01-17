/*
Problem: N-Queens
Problem No: 51
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Backtracking
- Recursion
- Array
- Bitmasking (conceptual)

----------------------------------
Problem Statement:
----------------------------------
The n-queens puzzle is the problem of placing n queens on an n x n chessboard
such that no two queens attack each other.

Return all distinct solutions, where:
- 'Q' represents a queen
- '.' represents an empty cell

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Backtracking row by row.
2. For each row, try placing a queen in every column.
3. Track attacked positions using:
   - cols[]   → columns
   - diag1[]  → main diagonals (row - col)
   - diag2[]  → anti-diagonals (row + col)
4. If a position is safe, place the queen and move to next row.
5. If row == n, a valid board configuration is found.
6. Backtrack by removing the queen and unmarking constraints.

Diagonal indexing:
- diag1 index = row - col + (n - 1)
- diag2 index = row + col

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(N!)
Space Complexity: O(N²)
  (board + recursion stack)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // row - col + n - 1
        boolean[] diag2 = new boolean[2 * n - 1]; // row + col

        backtrack(0, n, board, cols, diag1, diag2, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board,
                           boolean[] cols, boolean[] diag1, boolean[] diag2,
                           List<List<String>> result) {

        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}
