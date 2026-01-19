/*
Problem: Maximum Side Length of a Square with Sum Less than or Equal to Threshold
Problem No: 1292
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Prefix Sum
- Binary Search
- Matrix

----------------------------------
Problem Statement:
----------------------------------
You are given an m x n matrix mat and
an integer threshold.

Find the maximum side length of a
square sub-matrix such that the sum
of all its elements is less than or
equal to threshold.

Return 0 if no such square exists.

----------------------------------
Approach / Explanation:
----------------------------------
1. Build a 2D prefix sum matrix where:
      prefix[i][j] = sum of elements
      from (0,0) to (i-1,j-1).
2. Use Binary Search on possible
   square side lengths (0 → min(m, n)).
3. For a given side length k:
      - Check all k x k sub-squares
      - Compute sum in O(1) using
        prefix sum formula.
4. If any square has sum ≤ threshold,
   try a larger size.
5. Otherwise, reduce the size.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m * n * log(min(m, n)))
Space Complexity: O(m * n)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // Step 1: Build prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 0;
        int right = Math.min(m, n);
        int ans = 0;

        // Step 2: Binary search on side length
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (existsSquare(prefix, mid, threshold)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // Check if any square of given size exists with sum ≤ threshold
    private boolean existsSquare(int[][] prefix, int size, int threshold) {
        if (size == 0) return true;

        int m = prefix.length - 1;
        int n = prefix[0].length - 1;

        for (int i = size; i <= m; i++) {
            for (int j = size; j <= n; j++) {
                int sum = prefix[i][j]
                        - prefix[i - size][j]
                        - prefix[i][j - size]
                        + prefix[i - size][j - size];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
