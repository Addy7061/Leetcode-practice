/*
Problem: Search a 2D Matrix
Problem No: 74
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Search
- Matrix
- Array Index Mapping

----------------------------------
Problem Statement:
----------------------------------
You are given an m x n integer matrix with the following properties:
1. Each row is sorted in non-decreasing order.
2. The first integer of each row is greater than the last integer
   of the previous row.

Given an integer target, return true if target exists in the matrix,
otherwise return false.

You must achieve O(log(m * n)) time complexity.

----------------------------------
Approach / Explanation:
----------------------------------
Treat the 2D matrix as a single sorted 1D array.

Index Mapping:
- Total elements = m * n
- For a 1D index `mid`:
    row = mid / n
    col = mid % n

Steps:
1. Apply binary search on range [0, m*n - 1].
2. Convert mid index into (row, col).
3. Compare matrix[row][col] with target.
4. Adjust search boundaries accordingly.

Why it works:
- Given matrix properties guarantee global sorted order.
- Binary search ensures logarithmic time complexity.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(log(m × n))
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } 
            else if (matrix[row][col] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}
