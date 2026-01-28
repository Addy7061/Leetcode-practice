/*
Problem: Word Search
Problem No: 79
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Backtracking
- Depth First Search (DFS)
- Matrix Traversal
- Recursion

----------------------------------
Problem Statement:
----------------------------------
Given an m x n grid of characters and a word,
check whether the word exists in the grid.

The word can be formed using sequentially adjacent
cells (horizontally or vertically).
The same cell cannot be used more than once.

----------------------------------
Approach / Explanation:
----------------------------------
We use DFS + Backtracking.

Steps:
1. Traverse every cell in the grid.
2. If the current cell matches the first character
   of the word, start DFS from there.
3. From each cell, try moving:
   - up
   - down
   - left
   - right
4. Mark the current cell as visited to avoid reuse.
5. If all characters are matched → return true.
6. Backtrack by restoring the cell value.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m * n * 4^L)
  where L = length of the word

Space Complexity: O(L) for recursion stack

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // try starting DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int i, int j, int index) {

        // all characters matched
        if (index == word.length()) return true;

        // boundary check + character mismatch
        if (i < 0 || j < 0 ||
            i >= board.length || j >= board[0].length ||
            board[i][j] != word.charAt(index)) {
            return false;
        }

        // mark current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';

        boolean found =
                dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);

        // backtrack
        board[i][j] = temp;

        return found;
    }
}
