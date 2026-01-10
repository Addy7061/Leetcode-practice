/*
Problem: Sudoku Solver
Problem No: 37
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Backtracking
- Recursion
- Matrix

----------------------------------
Problem Statement:
----------------------------------
Given a partially filled 9x9 Sudoku board, fill the empty cells
so that the board becomes a valid Sudoku solution.

Rules:
1. Each digit 1–9 appears exactly once in each row.
2. Each digit 1–9 appears exactly once in each column.
3. Each digit 1–9 appears exactly once in each 3x3 sub-box.

The '.' character indicates an empty cell.
The input board has exactly one valid solution.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Backtracking to try all possible valid digits ('1' to '9')
   in empty cells.
2. Traverse the board to find the first empty cell.
3. For each empty cell:
   - Try placing digits from '1' to '9'.
   - Check if placing the digit is valid (row, column, sub-box).
4. If valid, place the digit and recursively solve the board.
5. If no digit leads to a solution, backtrack by resetting the cell.
6. Once the board is completely filled, return true.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(9^(n)) in worst case (n = empty cells)
Space Complexity: O(n) due to recursion stack

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            // Check row
            if (board[row][i] == c) return false;

            // Check column
            if (board[i][col] == c) return false;

            // Check 3x3 sub-box
            int r = 3 * (row / 3) + i / 3;
            int d = 3 * (col / 3) + i % 3;
            if (board[r][d] == c) return false;
        }
        return true;
    }
}
