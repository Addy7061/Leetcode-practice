/*
Problem: Spiral Matrix II
Problem No: 59
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Matrix
- Simulation
- Array Traversal

----------------------------------
Problem Statement:
----------------------------------
Given a positive integer n, generate an n x n matrix
filled with elements from 1 to n^2 in spiral order.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use four boundaries:
   - top, bottom → row boundaries
   - left, right → column boundaries

2. Fill the matrix layer by layer in spiral order:
   - Left to Right (top row)
   - Top to Bottom (right column)
   - Right to Left (bottom row)
   - Bottom to Top (left column)

3. After completing one direction, shrink the
   corresponding boundary.

4. Continue until all numbers from 1 to n^2 are placed.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n^2)
Space Complexity: O(1) extra space (excluding output matrix)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {

            // left → right
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;

            // top → bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // right → left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }

            // bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}
