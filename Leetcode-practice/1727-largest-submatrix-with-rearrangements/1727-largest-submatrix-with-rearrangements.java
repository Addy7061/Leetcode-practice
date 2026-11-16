import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        int[][] height = new int[m][n];

        // Step 1: build heights
        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] == 1)
                    height[i][j] = height[i - 1][j] + 1;
                else
                    height[i][j] = 0;
            }
        }

        int maxArea = 0;

        // Step 2: process each row
        for (int i = 0; i < m; i++) {

            int[] row = Arrays.copyOf(height[i], n);

            // sort descending
            Arrays.sort(row);

            for (int j = n - 1; j >= 0; j--) {
                int h = row[j];
                int width = n - j;
                maxArea = Math.max(maxArea, h * width);
            }
        }

        return maxArea;
    }
}