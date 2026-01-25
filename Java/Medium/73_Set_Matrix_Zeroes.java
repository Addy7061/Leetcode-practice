/*
Problem: Set Matrix Zeroes
Problem No: 73
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Arrays
- Matrix
- In-place Algorithm

----------------------------------
Problem Statement:
----------------------------------
Given an m x n integer matrix, if an element is 0,
set its entire row and column to 0.

You must perform the operation in-place.

----------------------------------
Approach / Explanation:
----------------------------------
We use the first row and first column as markers.

Steps:
1. Check if the first row contains any zero.
2. Check if the first column contains any zero.
3. For the rest of the matrix:
   - If matrix[i][j] == 0, mark:
       matrix[i][0] = 0
       matrix[0][j] = 0
4. Traverse again and set matrix[i][j] = 0
   if its row or column is marked.
5. Finally, zero out the first row and/or first column
   if they were initially marked.

Why it works:
- First row & column act as O(1) extra space markers.
- Avoids using extra arrays.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m × n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row & column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set cells to zero based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
