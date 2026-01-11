/*
Problem: Maximal Rectangle
Problem No: 85
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Stack
- Dynamic Programming
- Matrix
- Histogram

----------------------------------
Problem Statement:
----------------------------------
Given a binary matrix filled with '0's and '1's,
find the largest rectangle containing only '1's
and return its area.

----------------------------------
Approach / Explanation:
----------------------------------
1. Treat each row of the matrix as the base of a histogram.
2. Maintain an array `heights[]` where:
   - heights[j] represents the number of consecutive '1's
     in column j up to the current row.
3. For each row:
   - Update the heights array.
   - Compute the largest rectangle area in the histogram
     using a monotonic stack.
4. Keep track of the maximum area found.

This reduces the 2D problem into multiple
"Largest Rectangle in Histogram" problems.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(rows * cols)
Space Complexity: O(cols)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate max area for this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
