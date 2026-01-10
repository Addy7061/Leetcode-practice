/*
Problem: Valid Sudoku
Problem No: 36
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Hashing / Boolean Matrix

----------------------------------
Problem Statement:
----------------------------------
Determine if a 9x9 Sudoku board is valid.

Rules:
1. Each row must contain digits 1-9 without repetition.
2. Each column must contain digits 1-9 without repetition.
3. Each 3x3 sub-box must contain digits 1-9 without repetition.

Only filled cells need to be validated.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use three boolean matrices:
   - rows[9][9]   → track digits in each row
   - cols[9][9]   → track digits in each column
   - boxes[9][9]  → track digits in each 3x3 sub-box
2. Traverse each cell:
   - Skip empty cells ('.')
   - Convert digit character to index (0–8)
   - Calculate box index using:
       (row / 3) * 3 + (col / 3)
3. If digit already exists in row, column, or box → invalid Sudoku.
4. Otherwise, mark digit as seen.
5. If traversal completes, board is valid.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(81) ≈ O(1)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];
                if (c == '.') continue;

                int num = c - '1'; // map '1'-'9' → 0-8
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}
