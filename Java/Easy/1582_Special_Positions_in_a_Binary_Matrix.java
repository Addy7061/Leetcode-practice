/*
Problem: Special Positions in a Binary Matrix
Problem No: 1582
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Matrix

----------------------------------
Problem Statement:
----------------------------------
Given an m x n binary matrix mat, return the number of special positions.

A position (i, j) is called special if:
mat[i][j] == 1
and all other elements in row i and column j are 0.

----------------------------------
Approach:
----------------------------------
1. Count number of 1s in each row.
2. Count number of 1s in each column.
3. Traverse the matrix again.
4. If mat[i][j] == 1 AND
   row[i] == 1 AND
   col[j] == 1
   then it is a special position.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m * n)

Space Complexity: O(m + n)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int numSpecial(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        // Count 1s in rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;

        // Check special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
