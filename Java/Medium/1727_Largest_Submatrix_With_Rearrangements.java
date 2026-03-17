/*
Problem: Largest Submatrix With Rearrangements
Problem No: 1727
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Matrix
- Greedy
- Sorting

----------------------------------
Problem Statement:
----------------------------------
You are given a binary matrix.

You can rearrange columns in any order.

Return the maximum area of a submatrix
consisting only of 1s.

----------------------------------
Key Idea:
----------------------------------
Instead of thinking about rearranging columns,
we compute heights of consecutive 1s column-wise.

Then for each row:
- Treat it like a histogram
- Sort heights in descending order
- Try to form max area

----------------------------------
Step-by-Step Approach:
----------------------------------

1. Build height matrix:

height[i][j] = number of consecutive 1s
ending at (i, j)

2. For each row:
   - Copy heights
   - Sort in ascending order
   - Traverse from right (largest heights)

3. Calculate area:

area = height × width

----------------------------------
Example:
----------------------------------

Row heights: [3,1,2]

After sorting:
[1,2,3]

Try:
3 × 1 = 3
2 × 2 = 4
1 × 3 = 3

Max = 4

----------------------------------
Time Complexity:
----------------------------------

Building heights → O(m × n)
Sorting each row → O(m × n log n)

Total → O(m × n log n)

----------------------------------
Space Complexity:
----------------------------------
O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] height = new int[m][n];

        // Step 1: Build heights
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

        // Step 2: Process each row
        for (int i = 0; i < m; i++) {

            int[] row = Arrays.copyOf(height[i], n);

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
