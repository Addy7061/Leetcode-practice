/*
Problem: Count Negative Numbers in a Sorted Matrix
Problem No: 1351
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Matrix
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
Given an m x n matrix grid sorted in non-increasing order
both row-wise and column-wise, return the number of negative
numbers in the matrix.

----------------------------------
Approach / Explanation:
----------------------------------
1. Start from the bottom-left corner of the matrix.
2. If the current element is negative:
   - All elements to the right are also negative.
   - Add (n - col) to the count and move one row up.
3. If the current element is non-negative:
   - Move right to the next column.
4. Continue until all rows or columns are processed.

This approach works in O(m + n) time.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m + n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int countNegatives(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int row = m - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                count += (n - col);
                row--;
            } else {
                col++;
            }
        }

        return count;
    }
}
